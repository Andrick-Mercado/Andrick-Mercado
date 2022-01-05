/*
*  
* 
* Andrick Mercado 3/3/2021 
*/
#include <stdio.h>
int main()
{
 int userNum = -1;
 char userNumRom[256];
 printf("Type a Number to be given Roman representation: \n");
 scanf("%d", &userNum);

 if(userNum == -1 || userNum ==0)
 {
     printf("please enter a positive number that is greater than or equal to 1"); 
 }
 else
 {
     int remainder = userNum;
     int numCur;// stores the divisible amounts
     int i;// used for index of for loops
     printf("\nyour number is %d in Roman representation is ",userNum);
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