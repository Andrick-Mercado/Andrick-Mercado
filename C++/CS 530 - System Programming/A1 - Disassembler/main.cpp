/**
 * Main: Disasemble object code
 * @ Andrick Mercado 
 * @ 10/29/2021
 * CS 530 Section 1
 */

#include "main.h"


/*************************************
 * This is the first function called
 * it essentially securely opens
 * both the .obj and . sym files
 * once opened creates the out.lst
 * finally calls the dissem which
 * as the name implies it is were the
 * disasembling occures
 * ************************************/
void file_manager(char *obj_file, char *sym_file) {
    obj_ifstream.open(obj_file);
    if (!obj_ifstream.is_open())//check obj file exist
    {
        cout << "'.obj' file not found." << endl;
        exit(EXIT_FAILURE);
    }
    
    sym_ifstream.open(sym_file);
    if (!sym_ifstream.is_open())//check sym file exist
    {
        cout << "'.sym' file not found." << endl;
        exit(EXIT_FAILURE);
    }

    lst_ofstream.open ("out.lst");//make a new file
    
    string cur_line;
    while (getline(obj_ifstream, cur_line)) //push obj lines into vector
    {
        obj_lines.push_back(cur_line);
    }
    while (getline(sym_ifstream, cur_line))//push sym lines into vector
    {
        sym_lines.push_back(cur_line);
    }

    int i = 2;//ignore first two rows
    for (i = 2; i < sym_lines.size(); i++) 
    {
        if (sym_lines[i][0] != (char)NULL) //if first character of each line is not empty
        {// push symbol names and addresses
            sym_Symbol_Names.push_back(sym_lines[i].substr(0, 6));
            sym_Adresses.push_back((unsigned int)strtol(sym_lines[i].substr(8, 6).c_str(), NULL, 16));
        }
        else 
        {//if we reaCH HERE we have made it to the end of the first table
            i += 3;
            break;
        }
    }

    for (int j = i; j<sym_lines.size(); j++) 
    {//now we push the lit table
        lit_Names.push_back(sym_lines[j].substr(0,4));
        lit_Const.push_back(sym_lines[j].substr(8,10));
        lit_Length_Address.push_back((int)strtol(sym_lines[j].substr(20,1).c_str(), NULL, 16));
        lit_Addresses.push_back((unsigned int)strtol(sym_lines[j].substr(24, 6).c_str(), NULL, 16));
        lit_Mentions.push_back(0);
    }
    
    obj_ifstream.close();
    sym_ifstream.close();

    dissem();//if everything is good we continue we extraction of object code
}


/******************************************
 * dissem() No parameters
 * uses global variables
 * traverses all lines in the
 * obj_lines vector and checks if 
 * the first char is one of this
 * 'H','T', 'E' and calls the corresponding
 * function that extracts the info
 * *****************************************/
void dissem() 
{
    for (int i = 0; i < obj_lines.size(); i++) 
    {
        if (obj_lines[i][0] == 'H')
            header_record(i);
        else if(obj_lines[i][0] == 'T')
            text_record(i);
        else if(obj_lines[i][0] == 'E')
            end_record();
    }
}


/*************************************************************
 * Saves the program length in a variable
 * as well as current address the given adress im the header
 * finally print it out in the out.lst file with lst_ofstream
 * ***********************************************************/
void header_record(int line) 
{
    unsigned int progStartAddress =  (unsigned int)strtol(obj_lines[line].substr(7, 6).c_str(), NULL, 16);
    current_Address = progStartAddress;
    program_Length = (unsigned int)strtol(obj_lines[line].substr(13, 6).c_str(), NULL, 16);
    lst_ofstream << setbase(16) << uppercase << setw(4) << setfill('0') << current_Address << setfill(' ') << " ";
    lst_ofstream << setw(9) << left << obj_lines[line].substr(1, 6) << "START   " << current_Address <<endl;
}


/* *******************************************************************
 * (void) text_record(int line)
 * (int) line: current line we are extracting the object code from
 * This function loops through every object code based on the 
 * given text_lenth from the text record, we iterate throught
 * every object code and call the function instruction_disasembler
 * according to each object code, this function returns the number
 * that corresponds to the length of given object code.
 * After finishing the while loop we check if RESB should be used,
 * given that the next line is a text record, if its not a text record
 * it calculates the RESB to be added based on the public variable
 * program_Length.
 * 
 * ********************************************************************/
void text_record(int line) {
    int text_Length = (int)strtol(obj_lines[line].substr(7, 2).c_str(), NULL, 16);
    int current_index = 9;//starting point

    while (current_index < (2 * text_Length + 9))
    {//based on the text length we see how many times we loop to get each object code
        int objSize = instruction_disasembler(line, current_index);
        current_Address += (objSize/2);
        current_index += objSize;
    }

    
    if (line+1 < obj_lines.size() ) //check if we can look forward
    {
        if(obj_lines[line+1][0] == 'T')// if next record is Text we continue
        {
            //stores the value where we stop
            unsigned int startAdd =  (int)strtol(obj_lines[line+1].substr(1, 6).c_str(), NULL, 16); 
          
            for (int i = 0; i < sym_Adresses.size(); i++) 
            {
                if(current_Address < startAdd && current_Address <= sym_Adresses[i])
                {
                    if (i+1 < sym_Adresses.size() && current_Address+ (sym_Adresses[i+1]-current_Address) <=startAdd) 
                    {
                        lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
                        lst_ofstream << setw(8) << left << sym_Symbol_Names[i] << " RESB    ";
                        lst_ofstream << setbase(10) << setw(8) << left << (sym_Adresses[i+1]-current_Address) << setbase(16) << endl;
                        current_Address += (sym_Adresses[i+1]-current_Address);
                    }
                    else
                    {
                        lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
                        lst_ofstream << setw(8) << left << sym_Symbol_Names[i] << " RESB    ";
                        lst_ofstream << setbase(10) << setw(8) << left << (startAdd-current_Address) << setbase(16) << endl;
                        current_Address += (startAdd-current_Address); 
                        break;
                    }
                }
            }

            
        }
        
        else if(obj_lines[line+1][0] != 'T') //if its anything else we continue
        {
            //stores the value where we stop
            unsigned int startAdd =  program_Length;

            for (int i = 0; i < sym_Adresses.size(); i++) 
            {
                if(current_Address < startAdd && current_Address <= sym_Adresses[i])
                {
                    if (i+1 < sym_Adresses.size() && current_Address+ (sym_Adresses[i+1]-current_Address) <= startAdd) 
                    {
                        lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
                        lst_ofstream << setw(8) << left << sym_Symbol_Names[i] << " RESB    ";
                        lst_ofstream << setbase(10) << setw(8) << left << (sym_Adresses[i+1]-current_Address) << setbase(16) << endl;
                        current_Address += (sym_Adresses[i+1]-current_Address);
                    }
                    else
                    {
                        lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
                        lst_ofstream << setw(8) << left << sym_Symbol_Names[i] << " RESB    ";
                        lst_ofstream << setbase(10) << setw(8) << left << (startAdd-current_Address) << setbase(16) << endl;
                        current_Address += (startAdd-current_Address); 
                        break;
                    }
                }
            }

        }
    
    } 

}


/*****************************
 * prints the end as well as
 * the first program name
 * ***************************/
void end_record() 
{   //professor said this was flexible so I did it this way
    lst_ofstream << "              " << setw(8) << left << "END" << obj_lines[0].substr(1, 6) << endl;   
}


/* *****************************************************************************
 * (int) text_record(int line, int current_index): return length of object code
 * (int) line: current line we are extracting the object code from
 * (int) current_index: pointer or index of current object code start point
 * This function initially checks if a lit should be added on the current 
 * line or address, if it does find a match of current_address and lit_addresses
 * and lit_mentions is true (only true when previously reference without yet being
 * implemented) we proceed to add a new lit with ltorg procedure.
 * The next for loop is to check if lit should be inserted using the byte procedure
 * only if the current address mathces the lit_addresses.
 * Lastly we check the opcode of the instruction and retrieve its format, after 
 * we call the corresponding function based on the format.
 * (returns type int) this case it will be the length of the object code.
 * *****************************************************************************/
int instruction_disasembler(int line, int current_index)
{
    for (int i = 0; i<lit_Addresses.size();i++)
    {//here we just check if literal should be inserted based on if it has appeared or not
         if (current_Address == lit_Addresses[i] && lit_Mentions[i] )
        {
            lst_ofstream << "              LTORG"<<endl;
            lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
            lst_ofstream << setw(4) << right <<  lit_Names[i];
            lst_ofstream << "     *       "  ;
            lst_ofstream <<lit_Const[i] <<"    ";

            string str = lit_Const[i];
            unsigned int firstLim = str.find("X");

            lst_ofstream << str.substr(firstLim+2, lit_Length_Address[i])   << endl;
            return ( lit_Length_Address[i] );
        }
    }


    for (int i = 0; i<lit_Addresses.size();i++)
    {//if its the first instance of the lit we added with byte procedure
        if (current_Address == lit_Addresses[i])
        {
            lit_Mentions[i] = -1;
            lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
            lst_ofstream << setw(4) << right <<  lit_Names[i];
            lst_ofstream << "     BYTE"  ;
            lst_ofstream << "   "<<lit_Const[i] <<"     ";

            string str = lit_Const[i];
            unsigned int firstLim = str.find("X");

            lst_ofstream << right << setfill('0') << setw(lit_Length_Address[i]) << str.substr(firstLim+2, lit_Length_Address[i])  << setfill(' ') << endl;
            //lst_ofstream << str.substr(firstLim+2, lit_Length_Address[i])   << endl;
            return ( lit_Length_Address[i] );
        }        
    }

    //get the corresponding format either 3 or 2, formats 4's are calculated inside format_3_and_4
    int opCode = (int)strtol(obj_lines[line].substr(current_index, 2).c_str(), NULL, 16);
    int instructionLength = 0;
    int opCodeCopy = opCode & 0xFC;  
    for (int i = 0; i < SIC_XE_TABLE_SIZE; i++)
        if (SIC_XE_TABLE[i].Opcode == opCodeCopy)
            instructionLength  = SIC_XE_TABLE[i].format;

    if (instructionLength == 2)
    {
        lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";
        format_2( opCode, line, current_index);
    }
    else if (instructionLength == 3)
    {
        lst_ofstream << setfill('0') << setw(4) << right << current_Address << setfill(' ') << " ";    
        instructionLength = format_3_and_4( opCode, line, current_index);
    }
    return (instructionLength * 2);
}


/* *******************************************************************
 * (void) format_2(int opCode, int line, int current) 
 * (int) opCpde: holds the opcode value
 * (int) line: current line we are extracting the object code from
 * (int) current_index: holds the indice of the current object code
 * This function initially fins the opcode name based on the given
 * value from the paramter,  after we loop the addresses we either
 * print the label and the opcode or just the opcode.
 * finally we print the register and its correspionding address.
 * ********************************************************************/
void format_2( int opCode, int line, int current_index) {
    string opName = "";
    
    int copyopCode = opCode & 0xFC;  
    for (int i = 0; i < SIC_XE_TABLE_SIZE; i++)
    {//find the opcode name or mnemonic
        if (SIC_XE_TABLE[i].Opcode == copyopCode)
        {
            opName =  SIC_XE_TABLE[i].mnemonic;
        }
    }
      
    for (int i = 0; i < sym_Adresses.size()-1; i++) 
    { //find either lit_addresses or sym_addresses to print label
        if (current_Address == sym_Adresses[i]) 
        {
            lst_ofstream << setw(9) << left << sym_Symbol_Names[i]<< setw(7) << left << opName;
            break;
        }
        if (i+1 >= sym_Adresses.size()-1) 
        {
            lst_ofstream << "         " << setw(7) << left << opName;
        }
        if (i<lit_Addresses.size())
        {
            if (current_Address == lit_Addresses[i])
            {
                lst_ofstream << setw(9) << left << lit_Names[i]<< setw(7) << left << opName;
                break;
            }
        }
    }

    //get the register number
    unsigned int cur_register = (int)strtol(obj_lines[line].substr(current_index+2, 1).c_str(), NULL, 16);

    switch (cur_register) 
    {           //print correspinding register info
        case 0:
            lst_ofstream << " A             B400" << endl;
            break;
        case 1:
            lst_ofstream << " X             B410" << endl;
            break;
        case 2:
            lst_ofstream << " L             B420" << endl;
            break;
        case 3:
            lst_ofstream << " B             B430" << endl;
            break;
        case 4:
            lst_ofstream << " S             B440" << endl;
            break;
        case 5:
            lst_ofstream << " T             B450" << endl;
            break;
        case 6:
            lst_ofstream << " F             B460" << endl;
            break;
        case 8:
            lst_ofstream << " PC           B480" << endl;
            break;
        case 9:
            lst_ofstream << " SW           B490" << endl;
            break;
    }
}


/* *******************************************************************
 * (int) format_3_and_4(int opCode, int line, int current_index) 
 * (int) opCpde: holds the opcode value
 * (int) line: current line we are extracting the object code from
 * (int) current_index: holds the indice of the current object code
 * @returns int which corresponds to the length of the object code 3 or 4
 * This function initially finds the mnemonic given the opcode value,
 * after we get the nixbpe from the object code, next we see if a label
 * needs to be placed or not (can be from lit or sym), next we get
 * the corresponding displacement chekc if its in twos complement
 * if not we keep the regular value.
 * Everything after that has its corresponding comments essentially
 * were we determing the addressing mode in order to print out the 
 * the correct mnemonic and operand.
 * ********************************************************************/
int format_3_and_4( int opCode, int line, int current_index) {
    
    string opName = "";
    int isActual = 0;//for determining if a object code was in twos complement

    int copyopCode = opCode & 0xFC;  
    for (int i = 0; i < SIC_XE_TABLE_SIZE; i++)
    {//find the opcode name or mnemonic
        if (SIC_XE_TABLE[i].Opcode == copyopCode)
        {
            opName =  SIC_XE_TABLE[i].mnemonic;
        }
    }

    bool nixbpe[6];
    int nixbpe_to_decimal = (int)strtol(obj_lines[line].substr(current_index+1, 2).c_str(), NULL, 16);
    for (int i = 0; i < 6; i++)
    {// here we use bit shifting and bolean logic to determine if its 0 or 1 for the corresponding nixbpe
        nixbpe[i] = ((nixbpe_to_decimal >> 5-i) & 1);
    }

    for (int i = 0; i < sym_Adresses.size()-1; i++) 
    { // check if current_address is the same as sym and lit addresses and print label if yes
        if (current_Address == sym_Adresses[i]) 
        {
            lst_ofstream << setw(8) << left << sym_Symbol_Names[i];
            break;
        }
        else if (i+1 >= sym_Adresses.size()-1) 
        {
            lst_ofstream << "        ";
        }
        if (i<lit_Addresses.size())
            {
                if (current_Address == lit_Addresses[i])
                {
                    lst_ofstream << setw(8) << left << lit_Names[i];
                    break;
                }
            }
    }

    if (nixbpe[5])
    {//we outpt a "+" if its in extended format blank space otherwise
        lst_ofstream <<"+";
    }
    else
    {
        lst_ofstream << " ";
    }
    
    unsigned int target_Address = 0;
    if (nixbpe[5]) 
    {//check for extended format and put displacement field into target_Address
        target_Address = (unsigned int)strtol(obj_lines[line].substr(current_index, 8).c_str(), NULL, 16);
        target_Address &= 0x000FFFFF; //if its ecxtended we want the last 5 hex numbers or 20 bits
        
        bitset <16> binary(target_Address);
        if(binary[15]==1)// if its a negative number we convert to negative decimal
        {
            binary.flip();
            for (int i = 0; i<binary.size(); i++)
            {
                if (binary[i])
                    binary[i] = 0;
                else 
                {
                    binary[i] = true;
                    break;
                }
            }
            int decimal = -bitset<16>(binary).to_ulong();
            target_Address = decimal;
            isActual++;//we have converted 2s complement hence we update
        }
    }
    else 
    { // we reach here if e is 0 or not in extended format
        target_Address = (unsigned int)strtol(obj_lines[line].substr(current_index, 6).c_str(), NULL, 16);
        target_Address &= 0x000FFF; // get the last 3 hex values or last 12 bits for displacement

        bitset <12> binary(target_Address);
        if(binary[11]==1)
        {// if its a negative number we convert to negative decimal
            binary.flip();
            for (int i = 0; i<binary.size(); i++)
            {
                if (binary[i])
                    binary[i] = 0;
                else 
                {
                    binary[i] = true;
                    break;
                }
            }
            int decimal = -bitset<12>(binary).to_ulong();
            target_Address = decimal;
            isActual++;//we have converted 2s complement hence we update
        }

    } 
    
    if (nixbpe[3]) // if b = 1 it is base relative
    {//we add current_Base_Address to the ta_address calculations
        target_Address += current_Base_Address;//current_Base_Address given by the instance of ldb and its address
    }
    else if (nixbpe[4]) // if pc = 1 we have pc relative
    {   //we add the next address to ta_address calculations
        target_Address += (current_Address + 3);//get the next location
    }
    
    if (nixbpe[0] == nixbpe[1]) // simple addressing type if ni are the same (11 or 00)
    {   
        lst_ofstream << setw(8) << left << opName;
        
        for (int i = 0; i < sym_Adresses.size(); i++) 
        { // here we add the label if adress is the same to lit or sym address
            if (target_Address == sym_Adresses[i] && opName != "RSUB") 
            {
                lst_ofstream << setw(14) << left << sym_Symbol_Names[i] + (nixbpe[2] ? ",X":"");
                break;
            }
            if (i<lit_Addresses.size())
            {
                if (target_Address == lit_Addresses[i] && opName != "RSUB" && isActual == 0)
                {
                    lst_ofstream << setw(14) << left << lit_Const[i] + (nixbpe[2] ? ",X":"");
                    lit_Mentions[i] = 1;
                    break;
                }
                else if (target_Address == lit_Addresses[i] && opName != "RSUB" && isActual)
                {
                    lst_ofstream << setw(14) << left << lit_Names[i] + (nixbpe[2] ? ",X":"");
                    break; 
                }
            }
        }
        if (opName == "RSUB")
        {
            lst_ofstream << "         ";
        }
    }
    else if (nixbpe[0])// here it would be indirect addressing were ni is (10)
    {   
        lst_ofstream << setw(7) << left << opName << "@";
        for (int i = 0; i < sym_Adresses.size(); i++) 
        { //insert symbol or lit name if addresses are the same
            if (target_Address == sym_Adresses[i] && opName != "RSUB") 
            {
                if (nixbpe[2])
                {
                    lst_ofstream << setw(14) << left << sym_Symbol_Names[i] + ",X";
                }
                else
                {
                    lst_ofstream << setw(14) << left << sym_Symbol_Names[i];
                }
                break;
            }
            if (i<lit_Addresses.size())
            {
                if (target_Address == lit_Addresses[i] && opName != "RSUB" && isActual == 0 )
                {
                    if (nixbpe[2])
                    {
                        lst_ofstream << setw(14) << left << lit_Const[i] + ",X";
                    }
                    else
                    {
                        lst_ofstream << setw(14) << left << lit_Const[i];
                    }
                    lit_Mentions[i] = 1;
                    break;
                }
                else if(target_Address == lit_Addresses[i] && opName != "RSUB" && isActual )
                {
                    if (nixbpe[2])
                    {
                        lst_ofstream << setw(14) << left << lit_Names[i] + ",X";
                    }
                    else
                    {
                        lst_ofstream << setw(14) << left << lit_Names[i];
                    }
                    break;
                }
            }
        }
    }
    else if( nixbpe[1])// here it would be immediate addressing were ni is (01)
    {                 
        lst_ofstream << setw(7) << left << opName << "#";
        if (nixbpe[5] == 0) //if its not in extended format
        {
            lst_ofstream << setw(14) << target_Address;
        }
    }

    unsigned int object_code = (unsigned int)strtol(obj_lines[line].substr(current_index, 2*(3+nixbpe[5])).c_str(), NULL, 16);
    //holds the object code of current_index
    if (opName == "LDB") //here we do procedure to save base value given by ldb
    {
        current_Base_Address = target_Address;
        for (int i = 0; i < sym_Adresses.size(); i++) 
        { //check if sym or lit shoudl be printed as label
            if (target_Address == sym_Adresses[i]) 
            {
                lst_ofstream << setw(14) << left << sym_Symbol_Names[i];
                lst_ofstream << setw(2*(3+nixbpe[5])) << setfill('0') << object_code << setfill(' ') << endl;
                lst_ofstream << setw(22) << right << "BASE    " << sym_Symbol_Names[i] << endl;
                if(nixbpe[5])
                    return 4;
                return 3;
            }
            if (i<lit_Addresses.size())
            {
                if (target_Address == lit_Addresses[i] && isActual == 0)
                {
                    lst_ofstream << setw(14) << left << lit_Const[i];
                    lst_ofstream << setw(2*(3+nixbpe[5])) << setfill('0') << object_code << setfill(' ') << endl;
                    lst_ofstream << setw(22) << right << "BASE    " << lit_Const[i] << endl;
                    lit_Mentions[i] = 1;
                    if(nixbpe[5])
                        return 4;
                    return 3;
                }
                else if(target_Address == lit_Addresses[i] && isActual)
                {
                    lst_ofstream << setw(14) << left << lit_Names[i];
                    lst_ofstream << setw(2*(3+nixbpe[5])) << setfill('0') << object_code << setfill(' ') << endl;
                    lst_ofstream << setw(22) << right << "BASE    " << lit_Names[i] << endl;
                    if(nixbpe[5])
                        return 4;
                    return 3;
                }
            }
        }
    }
    //print out object code here at the end if its normal procedure or opcode
    lst_ofstream << right << setfill('0') << setw(2*(3+nixbpe[5])) << object_code << setfill(' ') << endl;//instruction
    if(nixbpe[5])
        return 4;
    return 3;
}


/* ********************
 * main class
 * makes sure we get exaCLTY 3 inputs
 * then we call file_manager 
 * ********************/
int main(int argc, char **argv) 
{
    if (argc != 3) 
    {
        cout << "need to give two files a .obj and .sym" << endl;
        exit(EXIT_FAILURE);
    }
    file_manager(*(argv+1), *(argv+2));    
    return 0;
}

