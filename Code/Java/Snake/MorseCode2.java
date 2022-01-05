/**
 * The gaol of this program is to convert 
 * normal text with spaces to morse code
 * @author (Andrick Mercado)
 * @version (9/6/2019)
 */
import java.util.Scanner;
public class MorseCode2
{
    public static void main (String [] args) {  
        Scanner input = new Scanner(System.in); //accepts user input
        String sentence = input.nextLine();//saves user input to sentence
        sentenceChecker(sentence); //the method accepts strings thus executing
    } 
    static void sentenceChecker(String s)  //this checks the length of the string in order to determine
     {  for (int i = 0;i<s.length(); i++) // how many characters will be checked  
         {System.out.print(morseDecoder(Character.toLowerCase(s.charAt(i)))+" ");} 
    }// calls morseDecoder with only one Characted which is taken with charAt and before that it is converted to lower case
    static String morseDecoder(char x)  //the input is only one character which is apart of the String
    { 
        switch (x)  // checks every letter of the alphabet and spaces
        { 
            case 'a':return ".-"; 
            case 'b':return "-..."; 
            case 'c':return "-.-."; 
            case 'd':return "-.."; 
            case 'e':return "."; 
            case 'f':return "..-."; 
            case 'g':return "--."; 
            case 'h':return "...."; 
            case 'i':return ".."; 
            case 'j':return ".---"; 
            case 'k':return "-.-"; 
            case 'l':return ".-.."; 
            case 'm':return "--"; 
            case 'n':return "-."; 
            case 'o':return "---"; 
            case 'p':return ".--."; 
            case 'q':return "--.-"; 
            case 'r':return ".-."; 
            case 's':return "..."; 
            case 't':return "-"; 
            case 'u':return "..-"; 
            case 'v':return "...-"; 
            case 'w':return ".--"; 
            case 'x':return "-..-"; 
            case 'y':return "-.--";  
            case 'z':return "--..";
            case ' ':return "/";
        } 
        return "Letters please";/*if the switch method is not used, the method still needs to return something
        as it needs to return a string, and since the current char is not part of the alphabet nor space, it tells the user "Letters please*/
    }   
}
