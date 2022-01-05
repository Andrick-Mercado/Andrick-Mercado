package CS108;

 /**
 * Program 4 - DNAConverter
 * Program Description Line 1
 * Program Description Line 2
 * @Andrick Mercado
 * @3/3/2020 
 * CS 108 Section - 1 
 */
 
//import necessary libraries
import java.io.*;
import java.util.*;
import java.lang.RuntimeException;
public class DNAConverter {
    private final char ADENINE = 'A';
    private final char CYTOSINE = 'C';
    private final char GUANINE = 'G';
    private final char THYMINE = 'T';
    private Map<String,String> map = new HashMap<>();
    /**
    * @name DNA2RNA
    * @param Parameter 1 - file name given by DNAFile which is in .txt
    * @param Parameter 2 - new file name were the work would be printed in
    * @throws NoSuchElementException, IOException
    * Basically creates a scanner to read and and printwriter to write information 
    * from DNAFile to RNAFile
    */
   public void DNA2RNA(String DNAFile, String RNAFile)throws IOException
   {
       try
       {
           Scanner input = new Scanner(new File(DNAFile) );
           PrintWriter output =  new PrintWriter(new File(RNAFile) );
           String temp; // temp as it is temporary, will store next string in DNAFile
         while(input.hasNextLine()) //checks thats the another line to read
        { temp = input.nextLine(); //gets the next Line from DNAFile
         for(int x = 0; x<temp.length(); x++)//x iterates indices from 0 to length-1
        { /** Compares each character in the temp string to dna words **/
           if(temp.charAt(x) == ADENINE)
          {
             output.print("U");
            }
            else if(temp.charAt(x) == CYTOSINE)
            {
             output.print("G"); 
            }
            else if(temp.charAt(x) == GUANINE)
            {
             output.print("C");
            }
            else if(temp.charAt(x) == THYMINE )
            {
             output.print("A");
            }
            else
            {// if its none of the dna sequence then this is thrown 
              throw new NoSuchElementException("Not a DNA character");    
             }
        }    
         output.println();//creates new line
       }
        input.close();
        output.flush();
        output.close();
      }
       catch(IOException e)
       {// not sure why I need this but it wouldnt work without this :o
           throw new NoSuchElementException("Not a DNA character");
        }
   }    
    /**
    * @name RNA2Protein
    * @param Parameter 1 - this is were the converted DNA TO RNA file is with .txt
    * @param Parameter 2 - this is were the converted protein will be stored
    * @param Parameter 3 - this is given, a table with preset values that helps convert RNA to protein
    * @throws RuntimeException, IOException
    * Starts by creating the writer which would write on ProteinFile, then inputRNA will be use to
    * as a scanner were we will get our rna sequence and later call the method setUPmRNA_and_HashMap4comparison
    * which returns the string of the protein sequence, which is printed into the file ProteinFile
    */
   void RNA2Protein(String RNAFile,String ProteinFile, String RNA2ProteinTable) throws IOException
   {
       try
       {
        PrintWriter output =  new PrintWriter(new File(ProteinFile) );
        Scanner inputRNA = new Scanner(new File(RNAFile) );
        String temp; //temporary string useeed to store nextLine in the file
       while(inputRNA.hasNextLine() )
       {  temp = inputRNA.nextLine();         
          if(temp.length()%3==0)//checks that theres are 3s in length
           {
             output.print( setUPmRNA_and_HashMap4comparison(temp , RNA2ProteinTable) );
            }
            else
            {// if its not divisible by 3 then this is thrown
                throw new RuntimeException("Invalid RNA length");
            }    
            output.println();
        }
        inputRNA.close();
        output.flush();
        output.close();
    }
    catch(IOException e)
    {// not sure why I need this but it wouldnt work without this :o
        throw new RuntimeException("Invalid RNA length");
    }
    }
    /**
    * @name setUPmRNA_and_HashMap4comparison
    * @param Parameter 1 - this is the RNA sequence 
    * @param Parameter 2 - this is a given file were the protein sequences are
    * @throws RuntimeException, IOException
    * opens the file in order to read with scanner, then separates the information into a hashmap
    * were it makes it easir to separate the string with substring and compare to the hashmap
    */
    public String setUPmRNA_and_HashMap4comparison (String temp, String RNA2ProteinTable)throws IOException
   {
          try
          {
            Scanner inputProtein = new Scanner(new File(RNA2ProteinTable) );
            String temp4protein;// the whole line from the protein table is store
            while(inputProtein.hasNextLine() )
            {
                temp4protein= inputProtein.nextLine();
                String[] parts = temp4protein.split(" ");//here it is separated by when the split method finds " "
                 map.put(parts[0] ,parts[1] );// map is crated as a private variable in the class
            }
            inputProtein.close();// closes the reading
            String curProtein = ""; //here the protein sequence will be stored
              for(int x =0; x+2< temp.length();x+=3) // iterates by grouping of 3s
          {/** doesnt cause error because theirs a if statements that checks length prior to running**/
              curProtein = curProtein + map.get( temp.substring(x,x+3) ); // gets the second part of that array
            }
            return curProtein; // returns protein with all its letter from the protein table
        }
        catch(IOException e)
        {// not sure why I need this but it wouldnt work without this :o
           throw new RuntimeException("Invalid RNA length"); 
        }
    }
    
    // provide similar documentation for any helper method created
}