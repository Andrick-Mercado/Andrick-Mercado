/*
*  This program has all exercises
*  in one single file from Standard Input and Output (C) 
*  @Andrick Mercado 3/4/2021 
*  CS320 section 2
*/
#include <stdio.h>

/** problem 1: checks the amount of caps in a string **/
static void numCaps()
{
    int countCaps = 0;
    char userPhrase [256];// anything bigger than 256 characters can break the code
    printf("Type in a phrase to be counted for caps: \n");
    gets(userPhrase);//, 256, stdin);
    int cur = 0;
    while(userPhrase[cur] != NULL )//not empty
    {
        if(userPhrase[cur] >='A' && userPhrase[cur]<='Z')
        {
            countCaps++;
        }
        cur++;
    }
    printf("The Phrase \"%s\" has %d caps in total \n", userPhrase, countCaps);
}
/** problem 2: compares if two strings are the same **/
static void isSame()
{
    char firstWord [256];// anything bigger than 256 characters can break the code
    char secondWord [256];
    printf("Type in the first word to be compared: ");
    gets(firstWord);
    printf("Type in the second word to be compared: ");
    gets(secondWord);
    int isSame = 1;// we assume its same
    int cur = 0;
    while(firstWord[cur] != NULL || secondWord[cur] != NULL )//not empty
    {
        if(firstWord[cur] != secondWord[cur])
        {
            isSame = 0;
        }
        cur++;
    }
    if(isSame == 0)
    {
        printf("The two words are not the same");
    }
    if(isSame == 1)
    {
        printf("The two words are the same");
    }
}
/** problem 3: makes an intenger to roman **/
static void numRom()
{
    int userNum = -1;
 char userNumRom[256];
 printf("Type a Number to be given Roman representation: \n");
 scanf("%d", &userNum);

 if(userNum == -1 || userNum ==0)//cases where user doesnt give int
 {
     printf("please enter a positive number that is greater than or equal to 1"); 
 }
 else /* solves by process of remainders and division */
 {
     int remainder = userNum;
     int numCur;// stores the divisible amounts
     int i;// used for index of for loops
     printf("your number is %d in Roman representation is ",userNum);
     if(remainder/1000 >=1 )
     {
        numCur = remainder/1000;
        remainder = remainder%1000;
        for(i= 0; i<numCur;i++)
        {
            printf("M");
        }
     }
     if(remainder/900 >=1 )
     {
        numCur = remainder/900;
        remainder = remainder%900;
        for(i= 0; i<numCur;i++)
        {
            printf("CM");
        }
     }
     if(remainder/500 >=1 )
     {
        numCur = remainder/500;
        remainder = remainder%500;
        for(i= 0; i<numCur;i++)
        {
            printf("D");
        }
     }
     if(remainder/400 >=1 )
     {
        numCur = remainder/400;
        remainder = remainder%400;
        for(i= 0; i<numCur;i++)
        {
            printf("CD");
        }
     }
     if(remainder/100 >=1 )
     {
        numCur = remainder/100;
        remainder = remainder%100;
        for(i= 0; i<numCur;i++)
        {
            printf("C");
        }
     }
     if(remainder/90 >=1 )
     {
        numCur = remainder/90;
        remainder = remainder%90;
        for(i= 0; i<numCur;i++)
        {
            printf("XC");
        }
     }
     if(remainder/50 >=1 )
     {
        numCur = remainder/50;
        remainder = remainder%50;
        for(i= 0; i<numCur;i++)
        {
            printf("L");
        }
     }
     if(remainder/40 >=1 )
     {
        numCur = remainder/40;
        remainder = remainder%40;
        for(i= 0; i<numCur;i++)
        {
            printf("XL");
        }
     }
     if(remainder/10 >=1 )
     {
        numCur = remainder/10;
        remainder = remainder%10;
        for(i= 0; i<numCur;i++)
        {
            printf("X");
        }
     }
     if(remainder/9 >=1 )
     {
        numCur = remainder/9;
        remainder = remainder%9;
        for(i= 0; i<numCur;i++)
        {
            printf("IX");
        }
     }
     if(remainder/5 >=1 )
     {
        numCur = remainder/5;
        remainder = remainder%5;
        for(i= 0; i<numCur;i++)
        {
            printf("V");
        }
     }
     if(remainder/4 >=1 )
     {
        numCur = remainder/4;
        remainder = remainder%4;
        for(i= 0; i<numCur;i++)
        {
            printf("IV");
        }
     }
     if(remainder/1 >=1 )
     {
        numCur = remainder/1;
        remainder = remainder%1;
        for(i= 0; i<numCur;i++)
        {
            printf("I");
        }
     }
 }
}
/** problem 4: checks if two chars are different by one bit **/
static void differBit()
{
    char firstWord[256];
    char secondWord[256];

    printf("Type in the first word to be compared: \n");
    scanf(" %s", &firstWord);//gets(firstWord);
    printf("Type in the second word to be compared: \n");
    scanf(" %s", &secondWord); //gets(secondWord);
  
    int count = 0; 
    // one char is only 2^8 meaning 8 positions
    for (int i = 0; i < 8; i++) 
    {        
        // checks each individual bit to see if not same
        if (((firstWord[0] >> i) & 1) != ((secondWord[0] >> i) & 1)) 
        { 
            count++; 
        } 
    }
    if(count == 1)//count will be one if theres only a bit difference
    {
       printf("first char is %c second is %c \n",firstWord[0], secondWord[0]);
        printf("The given two characters differ by a single bit"); 
    }
    else if(count == 0)//count will equal 0 is the two chars are the same
    {
        printf("first char is %c second is %c \n",firstWord[0], secondWord[0]);
        printf("The given two characters have the same number of bits");
    }
    else//count is assume to be bigger than 1 hence differing by more than two bits
    {
        printf("first char is %c second is %c \n",firstWord[0], secondWord[0]);
        printf("The given two characters differ by more than one single bit");
    }
}
/** MAIN METHOD **/
int main()
{
    int keepGoing = -1;
    char option[1];
    while(keepGoing == -1)//couldnt find a way to keep looping without breaking code
    {                     // so the user has to re run after using a function call
        printf("\nType in \"A\" to know how many capitals in a given string: \n");
        printf("Type in \"B\" to know if two given strings are the same: \n");
        printf("Type in \"C\" to know the roman representation of a positive integer: \n");
        printf("Type in \"D\" to know if two given chars differ by one bit: \n");
        gets(option);//scanf("%d *[^\n]", &option);//*[^\n]
        if(option[0] == 'A'||option[0] == 'a')
        {
            numCaps();
        }
        else if(option[0] == 'B' ||option[0] == 'b')
        {
            isSame();
        }
        else if(option[0] == 'C'|| option[0] == 'c')
        {
            numRom();
        }
        else if(option[0] == 'D' || option[0] == 'd')
        {
            differBit();
        }
        else
        {
            printf("Error only type in a letter A,B,C,D\n");
            keepGoing = -1; 
        }
        //keepGoing = 0;

    }
    //printf("\nPress ENTER key to continue\n");
    //getchar();   ALTERNATIVE
    system("pause");//just in case program is ran in .exe
    return 0;
}