#include <stdio.h>
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <cstdlib>
#include <vector>
#include <iomanip>
#include <bitset>

using namespace std;

/**  Holds the size of the current SIC_XE_TABLE  **/
#define SIC_XE_TABLE_SIZE 54


ifstream obj_ifstream;//.obj file input stream
ifstream sym_ifstream;//.sym file input stream
ofstream lst_ofstream;//.lst file output stream

vector<string> obj_lines;//saves all lines into this vector from the .obj file
vector<string> sym_lines;//saves all lines into this vector from the .sym file
vector<string> lit_Const;//saves the lit constants 
vector<string> lit_Names;//saves the lit names
vector<int> lit_Length_Address;//saves the lit lengths
vector<int> lit_Mentions;//in order to see if we have referenced it before assingment (THE LIT)
vector<unsigned int> lit_Addresses;//holds the lit addresses
vector<string> sym_Symbol_Names;//holds symbol names of .sym file
vector<unsigned int> sym_Adresses;//holds symbol addresses of .sym file
unsigned int program_Length;//holds the program length given by the header record
unsigned int current_Address;//will always hold the current address of each line or object code
unsigned int current_Base_Address;//will always hold the value given by ldb

//this two functions are to extract information
void file_manager(char *objFile);
void dissem();

//this three functions disasemble each object code depending on record type
void header_record(int line);
void text_record(int line);
void end_record();

//this will be called by text_record and will return address length
int instruction_disasembler(int line, int current_index);

//this two functions extract the object code from current index of a given line and print out results
void format_2( int opCode, int line, int current_index);
int format_3_and_4( int opCode, int line, int current_index);


/**********************
 * Struct opCode 
 * Similar to making a class here we have three
 * variables memonic, Opcode, and format
 * as well as a constant variable SIC_XE_INSTRUCTION_SET
 * (String) mnemonic: holds the sic/xe Mnemonic
 * (int) Opcode: holds the opcode value
 * (int) format: holds either format 2 or 3 and 4 is not included since ]
 *          we compute it similarly to format 3 (same method called format_3_and_4)
 * ******************/
struct SIC_XE_INSTRUCTION_SET {
    string mnemonic;
    int Opcode;
    int format; 
};

const struct SIC_XE_INSTRUCTION_SET SIC_XE_TABLE [] = {
    {"ADD", 0x18, 3},  {"ADDF", 0x58, 3}, {"ADDR", 0x90, 2},  {"AND", 0x40, 3},  {"CLEAR", 0xB4, 2},
    {"COMP", 0x28, 3}, {"COMPF", 0x88, 3},{"COMPR", 0xA0, 2}, {"DIV", 0x24, 3},  {"DIVF", 0x64, 3},
    {"DIVR", 0x9C, 2}, {"HIO", 0xF4, 1},  {"J", 0x3C, 3},     {"JEQ", 0x30, 3},  {"JGT", 0x34, 3},  
    {"JLT", 0x38, 3},  {"JSUB", 0x48, 3}, {"LDA", 0x00, 3},   {"LDB", 0x68, 3},  {"LDCH", 0x50, 3}, 
    {"LDF", 0x70, 3},  {"LDL", 0x08, 3},  {"LDS", 0x6C, 3},   {"LDT", 0x74, 3},  {"LDX", 0x04, 3},  
    {"LPS", 0xD0, 3},  {"MUL", 0x20, 3},  {"MULF", 0x60, 3},  {"MULR", 0x98, 2}, {"OR", 0x44, 3},
    {"RD", 0xD8, 3},   {"RMO", 0xAC, 2},  {"RSUB", 0x4C, 3},  {"SHIFTL", 0xA4, 2},{"SHIFTR", 0xA8, 2},
    {"SSK", 0xEC, 3},  {"STA", 0x0C, 3},  {"STB", 0x78, 3},   {"STCH", 0x54, 3},  {"STF", 0x80, 3},
    {"STI", 0xD4, 3},  {"STL", 0x14, 3},  {"STS", 0x7C, 3},   {"STSW", 0xE8, 3},  {"STT", 0x84, 3}, 
    {"STX", 0x10, 3},  {"SUB", 0x1C, 3},  {"SUBF", 0x5C, 3},  {"SUBR", 0x94, 2},  {"SVC", 0xB0, 2},
    {"TD", 0xE0, 3},   {"TIX", 0x2C, 3},  {"TIXR", 0xB8, 2},  {"WD", 0xDC, 3}
};
