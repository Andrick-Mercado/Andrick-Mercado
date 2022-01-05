/*
 * alphabetcount.c - this file implements the alphabetlettercount function.
 */

#include <stdio.h> 
#include "count.h"
#include <ctype.h>
#include <dirent.h>
#include <string.h>
/**
  The alphabggggtlettercount function counts the frequency of each alphabet letter (a-z, case insensitive) in all the .txt files under
  directory of the given path and write the results to a file named as filetowrite.

  Input: 
      path - a pointer to a char string [a character array] specifying the path of the directory; and
      filetowrite - a pointer to a char string [a character array] specifying the file where results should be written in.
      alphabetfreq - a pointer to a long array storing the frequency of each alphabet letter from a - z:
      alphabetfreq[0]: the frequency of 'a'
  output: a new file named as filetowrite with the frequency of each alphabet letter written in

  Steps recommended to finish the function:
  1) Find all the files ending with .txt and store in filelist.
  2) Read all files in the filelist one by one and count the frequency of each alphabet letter only (a - z). The array 
  long alphabetfreq[] always has the up-to-date frequencies of alphabet letters counted so far. If the letter is upper case, convert
  it to lower case first. 
  3) Write the result in the output file: filetowrite in following format: 

     letter -> frequency

     example:
     a -> 200
     b -> 101
     ... ...

  Assumption:
  1) You can assume there is no sub-directory under the given path so you don't have to search the files 
  recursively.
  2) Only .txt files are counted and other types of files should be ignored.

/
/
 *  *  given a directory and an output file name
 *   *  the program counts the alphabet letters it sees
 *    * inside the given directory of all txt files only,
 *     * it counts all alphabet letter non and capitalized
 *      * and saves them for output on the filetowrite file.
 *       *  @Andrick Mercado 7/02/2021 
 *        *  CS570 section 2
 *         */

void alphabetlettercount(char *path, char *filetowrite, long alphabetfreq[])
{
   struct dirent *de;
   DIR *dr = opendir(path);
   long count [256] = {0};
   int c;

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

         FILE *fp = fopen(  copyP  , "r");
            while((c=fgetc(fp)))
            {
               if(c == EOF)//end of file
               {
                  break;
               }
               c = tolower(c);
               count[c]+=1;//uses the ascII table to save
            }
            fclose(fp);
      }
   }
   FILE *fp2 = fopen(filetowrite, "w");
   int alphabtlettr= 0;//0-26
   for(int k=97; k<123; k++,alphabtlettr++)//a through z
  {
      fprintf(fp2, "%c -> %Ld\n", k, count[k]);
      alphabetfreq[alphabtlettr] = count[k];
  }
   fclose(fp2);
   closedir(dr);
}