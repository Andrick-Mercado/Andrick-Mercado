package CS108;

/**
 *  Program # 3a Cipher
 *  The purpose is to decode or encode a message
 *  CS108-3
 *  Date 2/26/2020
 *  @author Andrick Mercado
  */
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Cipher {
    public static final int NUM_LETTERS = 26;
    public static final int ENCODE = 1;
    public static final int DECODE = 2;
    public static void main(String[] args)throws IOException 
   {
     // letters
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
       //prevents error in option and outputs corrrectly
       int actionTest =  Integer.parseInt(args[2]);
      if(actionTest==0)
      {
         System.out.println("Option "+actionTest+" is not valid"); 
         System.exit(1);//exits the program
        }
      // Check args length, if error, print usage message and exit 
      if (args.length!=3)
      {
         System.exit(0);//throw FileNotFoundException;
        }
      else
      {
        
       // Extract input args to variables
        String inputFilename = new String(args[0]);
        String key = new String(args[1]);
        int action =  Integer.parseInt(args[2]);
     
        String outputFilename = getOutputFilename(inputFilename, action);
        Scanner input = openInput(inputFilename);
        PrintWriter output =  openOutput(outputFilename);
      
       // Read in data and output to file 
       if(action==1)//checks for option 1
       {    
         while(input.hasNextLine())//verifies thats there more to read, prevets error
         {
         String temp1 = input.nextLine().toLowerCase(); //makes the string lower case to prevent M error
          for(int x = 0, k = 0;x<temp1.length();x++, k++)//each word is iterated and coded
          {// x keeps track of index of output while k  keeps track of words char
              if(k==key.length())
              {k=0;}//clears k, to prevent code from not printing
              output.print(shiftUpByK( temp1.charAt(x), alphabet.indexOf(key.toLowerCase().charAt(k)) )); //fix 
         }  //prints it in the new class, calls shift class with each char being iterated, gets the index of the key and uses alphabet to get distance
          output.println();//makes new line in the end
        }
        }
       else if(action==2) //check for option 2 
       {   
           while(input.hasNextLine())
           {
          String temp2 = input.nextLine().toLowerCase();//stores next word and makes it lower case
          for(int y=0, c=0;y<temp2.length();y++,c++)// y keeps track of index of output while c keeps track of words char
          {
              if(c==key.length())
              {c=0;}//clears c, to prevent code from not printing
              output.print(shiftDownByK( temp2.charAt(y), alphabet.indexOf(key.toLowerCase().charAt(c)) )); //fix
         }
         output.println();//makes new line
        }
        }
       /* else
        { // no need for this, done at the beggining
         System.out.println("Option "+action+" is not valid"); 
         System.exit(1);
        }*/
       // Close streams
       input.close();
       output.flush();
       output.close();/** need to be closed in order for printing to work and file to be closed**/
     }
    }

    /**
     * Open input for reading
     * 
     * @param filename
     * @return Scanner
     * @throws FileNotFoundException
     */
   public static Scanner openInput(String filename)throws FileNotFoundException
   {
       return new Scanner(new File(filename)); 
    }
    
    /**
     * Open output for writing
     * 
     * @param filename
     * @return PrintWriter
     * @throws FileNotFoundException
     */
   public static PrintWriter openOutput(String filename) throws FileNotFoundException 
   {
       return new PrintWriter(new File(filename));
    }

   /**
    * Encode letter by some offset d
    * 
    * @param c  input character
    * @param offset  amount to shift character value
    * @return char  encoded character
    */
    public static char shiftUpByK(char c, int distance) 
    {
        
        if ('a' <= c && c <= 'z')
            return (char) ('a' + (c - 'a' + distance) % NUM_LETTERS);
        if ('A' <= c && c <= 'Z')
            return (char) ('A' + (c - 'A' + distance) % NUM_LETTERS);
        return c; // don't encrypt if not an ic character
    }
    
    /**
    * Decode letter by some offset d
    * 
    * @param c  input character
    * @param offset  amount to shift character value
    * @return char  decoded character
    */public static char shiftDownByK(char c , int distance)
    {
        return shiftUpByK(c, NUM_LETTERS -distance);
      /*  if ('a' <= c && c <= 'z')
            return (char) ('a' - (c - 'a' + distance) % NUM_LETTERS);
        if ('A' <= c && c <= 'Z')
            return (char) ('A' - (c - 'A' + distance) % NUM_LETTERS);
        return c; // don't decrypt if not an ic character */
    }
    /**
     * Changes file extension to ".coded" or ".decoded"
     * 
     * @param filename
     * @return String new filename or null if action is illegal
     */
    public static String getOutputFilename(String filename , int action)
    {
       if(action==ENCODE)
        {return filename+".coded";}
        else if(action==DECODE)
        {return filename+".decoded";}
        else
        {return null;}
    }
    public String getInfo() {
        return "Program 3, Andrick Mercado";
    }
}

