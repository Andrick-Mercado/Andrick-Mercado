/**
 *  Program # 1b
 *  The purpose of this program is to perform different task
 *  that deal with student passwords
 *  CS108-3
 *  Date 2/4/2020
 *  @author Andrick Mercado
  */
import java.util.Arrays; // Can be used for sorting. See Java API
public class PasswordProg1 {//start of class
   // 2D class instance variable declaration here--just the data type and name
   /** 
    * Constructor
    */
   private int dimension1ForNumberStudents = 3;// # students
   private int dimesion2ForNumberPasswords = 4;// # of passwords per student
   private String [][] password_Storage = new String[dimension1ForNumberStudents][dimesion2ForNumberPasswords];// initializing the 2s array
   public PasswordProg1(String[] passwords) 
    {
        // Here's where you allocate storage for 2D array
        // your2DarrayName = new String[dimension1ForNumberStudents][dimesion2ForNumberPasswords];
        /** String [][] password_Storage = new String[dimension1ForNumberStudents][dimesion2ForNumberPasswords] CAUSED ERROR **/
        // Nested loops to fill array with COPIES of strings in passwords array.
        // In other words, use your2DarrayName = new String[ theStringInpasswordArray ];
        int positionIndex = 0; /**to separate student passwords from the 1d array**/
        for(int row = 0; row<dimension1ForNumberStudents  ;row++)
        {
            for(int colum = 0; colum<dimesion2ForNumberPasswords;colum++,positionIndex++)
         {
            password_Storage[row][colum] = passwords[positionIndex]; /**copying password to the 2d array**/
            } 
        }
     }
   // public non-static methods here...
   public Boolean hasWord(String password)/**checks if theres a duplicate of a certain password**/
   {
       int counter=0;//here to keep track of duplicates
       for(int row = 0; row<dimension1ForNumberStudents  ;row++)
        {
            for(int colum = 0; colum<dimesion2ForNumberPasswords;colum++)
         {
            if(password.equals(password_Storage[row][colum]))
             counter++;
            } 
        }
       return (counter>0);//more efficient then if else
    }
   public void unlockAll()/**changes all passwords to "unlock"**/
   {
       for(int row = 0; row<dimension1ForNumberStudents  ;row++)
        {
            for(int colum = 0; colum<dimesion2ForNumberPasswords;colum++)
         {
            password_Storage[row][colum]= "unlock";
            } 
        }
    }
   public String longest()/**finds and returns the longest first ocrring password**/
   {
       String longest="";
       int curLongest=0;//none yet 
       String curWord;//for later
       for(int row = 0; row<dimension1ForNumberStudents  ;row++)
        {
            for(int colum = 0; colum<dimesion2ForNumberPasswords;colum++)
         {
            curWord = password_Storage[row][colum];// here for the if statement
             if(curWord.length()>curLongest)//compares length
            {
            curLongest = curWord.length();
            longest = password_Storage[row][colum];
           }
            } 
        }
        return longest;
    }
   public int mostFrequent()
   {/** The method will return an int that is the index of the student that has changed the password most frequently. 
       If two or more students have the same number of changes (that is also the most), the index of student that comes earlier in the array will be returned. **/
       int count_Student1=0;
       int count_Student2=0;
       int count_Student3=0;
       for(int row = 0; row<dimension1ForNumberStudents  ;row++)//rows 0 to 2
        {
            for(int colum = 1; colum<dimesion2ForNumberPasswords;colum++)// colums 1 to 3
         {
             if(row==0)// student 1
             {
                 if(!(password_Storage[row][colum-1].equals(password_Storage[row][colum])))//if password is different it adds one to the count
                  count_Student1++;
            }
             else if(row==1) //student 2
             {
                 if(!(password_Storage[row][colum-1].equals(password_Storage[row][colum])))
                  count_Student2++;
            }
             else //student 3
             {
                 if(!(password_Storage[row][colum-1].equals(password_Storage[row][colum])))
                  count_Student3++;
            }
            }
        }
       if(count_Student1>=count_Student2&&count_Student1>=count_Student3)//check 1st student for most changes in password
         return 0;
       else if(count_Student2>=count_Student1&&count_Student2>=count_Student3)// second student
         return 1;
       else // 3rd student
         return 2;
    }
   public String getIdentificationString()//returns a string no parameters
   {
      return "Program 1, Andrick Mercado"; 
    }
   // main method here (your tester)
   /**  
   public static void main(String[]args)
    {
    String [] x = {"mames","hola","que","fe","fdewf","we","dewd","ewret","ewrf","wer","w2e","werggh"}; // random words
    PasswordProg1 test = new PasswordProg1(x);
    test.print(); // CORRECt for copying
    System.out.print(test.hasWord("nel")); //works
     } 
     **/
}

