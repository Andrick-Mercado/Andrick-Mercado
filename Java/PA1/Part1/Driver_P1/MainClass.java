package Part1.Driver_P1;

import Part1.Manager_P1.StackArray;
import java.util.*;
import java.io.File;

/**
 * Write a description of class MainClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainClass
{
     public static void main (String [] args)
    {
        try 
        {
            StackArray test = new StackArray();
            Scanner input = new Scanner(new File("Test1.txt"));
            //my filepath is diferent thus error might occur
            // mine worked with "C:\\Users\\andri\\OneDrive\\Desktop\\PA1\\TestFiles\\Part1_Tests\\Test1.txt"
            String tmp = "";            
            while(input.hasNextLine())
            {
                tmp += input.nextLine();
            }
            char c;
            for(int i=0;i<tmp.length();i++) 
            { 
                c = tmp.charAt(i);
                test.balanceParentheses(c, test);
            }
            System.out.println("Parentheses () balanced: "+test.flagParentheses);
            //System.out.println( test.toString() );
            test.makeEmpty();
            for(int i=0;i<tmp.length();i++) 
            { 
                c = tmp.charAt(i);
                test.balanceBrackets(c, test);
            }
            System.out.println("Brackets [] balanced: "+test.flagBrackets);
            //System.out.println( test.toString() );
            test.makeEmpty();
            for(int i=0;i<tmp.length();i++) 
            { 
                c = tmp.charAt(i);
                test.balanceBraces(c, test);
            }
            System.out.println("Braces {} balanced: "+test.flagBraces);
            test.makeEmpty();        
            input.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            //
        }

    }
}
