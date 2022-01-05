/*
 This program will fork two child processes running the two programs generated in programming zero in parallel.
 Hint: You mant need to use fork(), exec() family, wait(), exit(), getpid() and etc ...
 
 Requirements:
 
 1) Exactly two child processes are created, one to run testspecial program and the other is to run testalphabet program;
 2) When a program starts to run, print a message to the output screen showing which process (with PID) is running which program, for example:
    "CHILD <16741> process is executing testalphabet program!"
    
 3) When a program is done, the process exits and at the same time, a message should be print to the output screen showing which  process (with PID) is done with the program, for example:
    "CHILD <16741> process has done with testalphabet program !"
    
 4) The messages should match the real execution orders, i.e. when the testspecial program starts/ends, the right message should be print out. So you need to figure out how to get the starting/ending time of each 
 process.
   
   
 The expected screen print out should be similar as follows:
 
 CHILD <16741> process is executing testalphabet program!
 CHILD <16742> process is executing testspecial program!
, -> 745668
. -> 798072
... ...

CHILD <16742> process has done with testspecial program !
a -> 2973036
b -> 556908
... ...

CHILD <16741> process has done with testalphabet program !
 */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define NUM_OF_CHILDREN 2


int main(void) 
{
	for(int i = 0; i <NUM_OF_CHILDREN; i++ )
   {
      pid_t pid = fork();
      if(pid < 0)
      {
         perror("fork failed.");
         exit(1);
      }
      else if(pid == 0 && i == 0)
      {//CHILD <16741> process is executing testalphabet program!
         printf("CHILD <%d> process is executing testalphabet program!\n", (int) getpid() );
         char* args[] = {"./testalphabet", NULL};
         //printf("CHILD <%d> process has done with testalphabet program !\n", (int) getpid()  );
         execv( args[0], args);
      }
      else if(pid == 0 && i == 1)
      {//CHILD <16742> process is executing testspecial program!
         printf("CHILD <%d> process is executing testspecial program!\n", (int) getpid() );
         char* args[] = {"./testspecial", NULL};
         //printf("CHILD <%d> process has done with testspecial program !\n", (int) getpid()  );
         execv( args[0], args);
      }
   }
		
	for(int i = 0; i <NUM_OF_CHILDREN; i++ )
   {
      wait(NULL);
   }
	return 0;
	
}
