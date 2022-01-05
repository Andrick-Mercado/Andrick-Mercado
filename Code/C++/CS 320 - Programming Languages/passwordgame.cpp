#include <iostream>
#include <fstream>
#include <algorithm>
#include <list>

//using namespace std;
/*
 *  This program is meant to simulate a password game
 *  in which the user gives a file directory with random 
 *  words, and the code shrinks it to interpret the words
 *  easier, as well as it makes a random password out of 
 *  the given words from the file, and the same code
 *  attempts to bruteforce the right password 
 *  @Andrick Mercado 4/27/2021 
 *  CS320 section 2
 *  Only me no team
 */

//method descriptions are were the code is
std::list<std::string> wordArray(std::string);
int numWords(int);
void printList(std::list<std::string>);

/**  password constructor  **/
struct PasswordGenerator
{
    std::list<std::string> list;
    int uniqueTokens;
    int numWords;
    std::string passwrd;
/** initializes the list and numwords   **/
PasswordGenerator(std::list<std::string> list, int numWords)
{
    this->list = list;
    this->numWords  = numWords;
}
/** makes a random password with no reapeting indexes or strings  **/
std::string getRandomPassword(int numWords)
{
    int j = 0;
    //copy list to array for easier use
    std::string arrayCopyList[list.size()];
    for(std::list<std::string>::const_iterator i = list.begin(); i != list.end(); ++i)
        {       
                arrayCopyList[j]= *i;
                j++;
            
        }
    //we begin by copying the unique elements into other array than back to original
    std::string temp[list.size()];
    j = 0;

    for (int i=0; i<numWords-1; i++)
        if (arrayCopyList[i] != arrayCopyList[i+1])
            temp[j++] = arrayCopyList[i];

    temp[j++] = arrayCopyList[numWords-1];

    for (int i=0; i<j; i++)
        arrayCopyList[i] = temp[i];

    int rnd;
    numWords = j;
    int randIndex[numWords];
    j = 0;
    int temp2[numWords];
    //here we make sure all indexes are unique to avoid duplicates
    while(j!=numWords)
    {
        for (int i = 0; i<numWords;i++)
        {
            randIndex[i] = rand()%list.size();
        }
        
    
        j = 0;
        for (int i=0; i<numWords-1; i++)
        {
            if (randIndex[i] != randIndex[i+1] )
                temp2[j++] = randIndex[i];
        }
        temp2[j++] = randIndex[numWords-1];
  
        for (int i=0; i<j; i++)
        {
            randIndex[i] = temp2[i];
        }
  
    }
    //here we create the password
        std::string password ;
        for(int x = 0; x< j;x++)
        {
            password = password + arrayCopyList[randIndex[x]] + " ";
        }
    this->passwrd = format(password);
    return passwrd;    
}
/**  uses trim to take out spaces and format makes spacing between words equal  **/
std::string format(std::string str)
{
    std::string fill = " ";
    std::string whitespace = " \t";

    std::string result = trim(str);
    int start = result.find_first_of(whitespace);
    while (start != std::string::npos)
    {
        int endSpace = result.find_first_not_of(whitespace, start);
        int index = endSpace - start;
        result.replace(start, index, fill);
        int newStart = start + fill.length();
        start = result.find_first_of(whitespace, newStart);
    }
    return result;
}
/**  this method deletes all extra spaces  **/
std::string trim(std::string str)
{
    std::string whitespace = " \t";
    int start = str.find_first_not_of(whitespace);
    if (start == std::string::npos )
    {//empty
        return ""; 
    }
    int end = str.find_last_not_of(whitespace);
    int index = end - start + 1;
    return str.substr(start, index);
}
// pretty sure this is not the right way but this method attempts every possibility
//using for loops can only do 1-5 combinations
void setIterationLength()//int numWords
{
    int times = 0;
    
    if(numWords ==1)
    {
        for (std::string x : list) 
            if(format(x).compare(passwrd)==0)  
            {  
                std::cout<<"The Password ("<<passwrd<<") has been found using bruteforce"<<std::endl;
                std::cout<<"The Password took "<<times<<" attempts." <<std::endl;
                return;
            }
            else
            times++;
    }
    else if(numWords ==2)
    {
        for (std::string x : list)
        for (std::string y : list) 
            if(format(x+" "+y).compare(passwrd)==0)  
            {  
                std::cout<<"The Password ("<<passwrd<<") has been found using bruteforce"<<std::endl;
                std::cout<<"The Password took "<<times<<" attempts." <<std::endl;
                return;
            }
            else
            times++;
    }
    else if(numWords == 3)
    {
        for (std::string x : list)
        for (std::string y : list) 
        for (std::string z : list)
            if(format(x+" "+y+" "+z).compare(passwrd)==0)  
            {  
                std::cout<<"The Password ("<<passwrd<<") has been found using bruteforce"<<std::endl;
                std::cout<<"The Password took "<<times<<" attempts." <<std::endl;
                return;
            }
            else
            times++;
    }
    else if(numWords == 4)
    {
        for (std::string w : list)   
        for (std::string x : list)
        for (std::string y : list) 
        for (std::string z : list)
            if(format(w+" "+x+" "+y+" "+z).compare(passwrd)==0)  
            {  
                std::cout<<"The Password ("<<passwrd<<") has been found using bruteforce"<<std::endl;
                std::cout<<"The Password took "<<times<<" attempts." <<std::endl;
                return;
            }
            else
            times++;
    }
    else if(numWords == 5)
    {
        for (std::string w : list)   
        for (std::string x : list)
        for (std::string y : list) 
        for (std::string z : list)
        for (std::string q : list)
            if(format(w+" "+x+" "+y+" "+z+" "+q).compare(passwrd)==0)  
            {  
                std::cout<<"The Password ("<<passwrd<<") has been found using bruteforce"<<std::endl;
                std::cout<<"The Password took "<<times<<" attempts." <<std::endl;
                return;
            }
            else
            times++;
    }
}
std::string next()
{//couldnt find a way to implemented into my code
    return "false";
}
bool hasNext()
{//couldnt find a way to implemented into my code
    return false;
}
//prints list
void printList(std::list<std::string> list)
{
    std::string inFile2;
     for (std::string x : list) 
        {
		    inFile2 += x;
	    } 
     std::cout<<"Your file contains: "<<inFile2<<std::endl;
}
};

/***   MAIN METHOD HERE     ***/
int main()
{
    std::string fileName;
    std::cout<<"Enter the file directory of your file for the password game: "<<std::endl;
    std::cin>>fileName;
    //fileName = "C:\\Users\\Andrick\\Desktop\\mames.txt";
    std::ifstream getFile(fileName);

    if(getFile.is_open())
    {   
        std::list<std::string> copyOfWordArray = wordArray(fileName);
        int size =  wordArray(fileName).size();
        PasswordGenerator test = PasswordGenerator( copyOfWordArray , numWords(size) );
        
        if(test.numWords!=0)
        {
        test.printList(test.list);
        std::string passwrd = test.getRandomPassword(test.numWords );
        std::cout<<"\nPassword Created is: "<<passwrd<<std::endl;
        test.setIterationLength();
        }
        getFile.close();
    }
    else
        std::cout<<"The file indicated could not be found"<<std::endl;
    system("pause");//just in case program is ran in .exe
    return 0;
}

/**  Returns int whichis given by the user, determines how many words in password  
 *   as well as checks size to see validity
 **/
int numWords(int size)
{
    try
    {
        std::string option;//int
        do
        {
            std::cout<<"\nHow many combinations do you wish to see? (PLEASE ENTER A NUMBER THATS [1-5])"<<std::endl;
            std::cin>>option;
    }   while (!(stoi(option) >=1 && stoi(option) <=5) );//&& stoi(option)>size );
        int optionInt;
        if(stoi(option)<=size)
        optionInt = stoi(option);
        else 
        throw"...";
        return optionInt;
    }
    catch(...)
    {
        std::cout<<"Error only input a int range [1-5] or File is too Small"<<std::endl;
        std::cout<<"Please Try Again"<<std::endl;
        return 0;
    }
    
}

/**  gets the strings from the file and takes out (,) and (.) and lower caps  **/
std::list<std::string> wordArray(std::string fileName)
{
    std::ifstream getFile(fileName);
    std::string str;
    std::getline(getFile, str);
    str.erase(std::remove(str.begin(), str.end(), '.'), str.end());
    str.erase(std::remove(str.begin(), str.end(), ','), str.end());
    std::transform(str.begin(), str.end(), str.begin(),[](unsigned char c){ return std::tolower(c); });
    
    std::list<std::string> list;
    std::string temp2;
    for(int x = 0; x<str.length();x++)
    {
        if(isspace(str[x]))
        {
            temp2 = str.substr(0,x);
            list.push_back(temp2 ) ;
            str = str.substr(x);
            x=0;
        }
    }
    list.push_back(str);
    return list;   
}