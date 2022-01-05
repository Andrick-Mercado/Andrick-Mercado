/*
*  
* 
* Andrick Mercado 3/3/2021 
*/
#include <stdio.h>

int isDiffer(char a, char b) 
{ 
    int count = 0; 
    // one char is only 2^8 meaning 8 positions
    for (int i = 0; i < 8; i++) 
    {        
        // checks each individual bit to see if not same
        if (((a >> i) & 1) != ((b >> i) & 1)) 
        { 
            count++; 
        } 
    }
    if(count == 1)
    {
        return 2;
    }
    else if(count == 0)
    {
        return 1;
    }
    return 0;
} 

int main() 
{
    char firstWord[256];
    char secondWord[256];

    printf("Type in the first word to be compared: \n");
    scanf(" %s", &firstWord);//gets(firstWord);
    printf("Type in the second word to be compared: \n");
    scanf(" %s", &secondWord); //gets(secondWord);
  
     if(isDiffer(firstWord[0],secondWord[0]) == 2) 
    {
        printf("first char is %c second is %c \n",firstWord[0], secondWord[0]);
        printf("The given two characters differ by a single bit");
    }
    else if(isDiffer(firstWord[0],secondWord[0]) == 1)
    {
        printf("first char is %c second is %c \n",firstWord[0], secondWord[0]);
        printf("The given two characters have the same number of bits");
    }
     else
    {
        printf("first char is %c second is %c \n",firstWord[0], secondWord[0]);
        printf("The given two characters differ by more than one single bit");
    } 
    
   return 0; 
}