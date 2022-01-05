/*
*  
* 
* Andrick Mercado 3/2/2021 
*/
#include <stdio.h>
int main()
{
    char firstWord [256];// anything bigger than 256 characters can break the code
    char secondWord [256];
    printf("Type in the first word to be compared: ");
    gets(firstWord);
    printf("Type in the second word to be compared: ");
    gets(secondWord);
    int isSame = 1;// we assume its same
    int cur = 0;
    while(firstWord[cur] != NULL || secondWord[cur] != NULL )
    {
        if(firstWord[cur] != secondWord[cur])
        {
            isSame = 0;
        }
        cur++;
    }
    if(isSame == 0)
    {
        printf("Not the same");
    }
    if(isSame == 1)
    {
        printf("They are the same");
    }
}