package Driver;
import Manager.*;
import java.util.Scanner;
import java.io.File;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String [] args) throws Exception
    {
        Map test = new Map();
        String option;
        Scanner userInput = new Scanner(System.in);
        String tmp;
        try 
        {
            Scanner fileInput = new Scanner(new File ("Records.txt") ); 
            String [] studentInfo;
            boolean isValid = true;
            while(fileInput.hasNextLine() )
            {
                tmp = fileInput.nextLine();
                studentInfo = tmp.split(", ");
                test.add(  studentInfo[1] , studentInfo[0]);
            }
            while(isValid)
            {
                printMenu();
                option = userInput.nextLine().toLowerCase();
                switch(option)
                {
                    case "a":
                    runOptionA(test, userInput );
                    break;
                    case "b":
                    runOptionB(test, userInput);
                    break;
                    case "c":
                    runOptionC(test, userInput);
                    break;
                    case "d":
                    isValid = false;
                    break;
                    default:
                    System.out.println("PLEASE ENTER VALID ANSWER IN ONE LETTER FORM");
                }
            }
            fileInput.close();
        }
        catch(Exception e)
        {
            System.out.println("INVALID INPUT/FILE NAME"); 
            System.out.println("Error message: "+e); 
        }
    }

    public static void runOptionA(Map test , Scanner input)
    {
        System.out.println("Enter a KEY to be deleted");
        String key = input.nextLine();
        test.delete(key);
        System.out.println("People in Database: ");
        System.out.println("------------------------------------");
        test.toString();
    }

    public static void runOptionB(Map test , Scanner input)
    {
        System.out.println("Enter a KEY to be searched");   
        String key = input.nextLine();
        System.out.println("Value: "+ test.getValue(key) );
    }

    public static void runOptionC(Map test , Scanner input)
    {
        System.out.println("Enter a VALUE to be searched");   
        String value = input.nextLine();
        System.out.println("Key: "+ test.getKey(value) );
    }

    public static void printMenu()
    {
        System.out.println("(a) Delete a student"); 
        System.out.println("(b) Search a student by KEY"); 
        System.out.println("(c) Search a student by VALUE"); 
        System.out.println("(d) EXIT"); 
    }
}
