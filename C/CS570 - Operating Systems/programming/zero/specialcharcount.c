/*
 *  *  This program counts file special characters
 *   * inside the directory given, it will read all 
 *    * files of type txt, it would keep reading all 
 *     * files and save the results inside an array
 *      * which will be used to output the results '
 *       * into the file the user gives to the method.
 *        *  @Andrick Mercado 7/02/2021 
 *         *  CS570 section 2
 *          */
#include <stdio.h>
#include "count.h"
#include <ctype.h>
#include <dirent.h>
#include <string.h>
void specialcharcount(char *path, char *filetowrite, long charfreq[])
{ 
   struct dirent *de;  
   DIR *dr = opendir(path); 
   long count[256] = {0};
   int c;// c is used to save current char from the file

   if (dr == NULL) 
    {
        printf("Directory could not open" );
    }
   while ((de = readdir(dr)) != NULL)
   {
      if (strstr(de->d_name, ".txt") != NULL)
      {
            char copyP[80];
            int len = strlen(path);
                if(len>0 && path[len-1] == '/')//check if '/' is at the end
                {
                   strcpy(copyP, path);
                   strcat(copyP,de->d_name);
                }
                else
                {
                   strcpy(copyP, path);
                   strcat(copyP,"/");
                   strcat(copyP,de->d_name);
                }
            FILE *fp = fopen( copyP  , "r");
            while(c=fgetc(fp)) 
            {
               if(c == EOF)//end of file
               {   
                  break;
               } //no lower case required for symbols
                count[c]+=1;
               }
            
            fclose(fp);//close current file
            
      }
   }
   FILE *fp2 = fopen(filetowrite, "w");
      int k= 44;// the asccII vvalue of ,
      fprintf(fp2,"%c -> %Ld\n", k, count[k]);
      charfreq[0] = count[k];

      k= 46;// the asccII vvalue of .
      fprintf(fp2,"%c -> %Ld\n", k, count[k]);
      charfreq[1] = count[k]; 

      k= 58;// the asccII vvalue of :
      fprintf(fp2,"%c -> %Ld\n", k, count[k]);
      charfreq[2] = count[k];

      k= 59;// the asccII vvalue of ;
      fprintf(fp2,"%c -> %Ld\n", k, count[k]);
      charfreq[3] = count[k];

      k= 33;// the asccII vvalue of !
      fprintf(fp2,"%c -> %Ld\n", k, count[k]);
      charfreq[4] = count[k];

   fclose(fp2);//close the output file
   closedir(dr);//close the direcoty that was given
}

