import java.util.Scanner;
public class test
{
    public static void main(String[]args){
      Scanner input = new Scanner(System.in);
      //NAME OF USER
      System.out.println("NAME: " );
      String id = input.nextLine();
      System.out.println("GOOD LUCK " + id);
      //object
      Project2 a = new Project2();
      //FIRST 9X+C
      System.out.println("1. What is the anti-derivative of 9 ? (write answer)");
      String response1 = input.nextLine();
      a.setAnswer1(response1);
      //SECOND B
      System.out.println("2. What is the anti-derivative of 9x ? \nA. 9x\nB. 9x^2/2 + c\nC. 9x + c\nD. Not enought information");
      String response2 = input.nextLine();
      a.setAnswer2(response2);
      //THIRD B
      System.out.println("3. What is the anti-derivative of 3x^2/4 + 6x + 2 ? \nA. 6x^2/2 + 3x + c\nB. x^3/4 + 3x^2 + 2x + c \nC. 3x^2/12 + 2x + c\nD. Not enought information");
      String response3 = input.nextLine();
      a.setAnswer3(response3);
      //FOURTH C
      System.out.println("4. What is the anti-derivative of x^2 - 4x + 6 ? \nA. 2x^2 - 2x +6x + c\nB. 3x^3/12 + 6x^2/2 + 2x + c\nC. x^3/3 - 2x + 6x + c\nD. Not enought information");
      String response4 = input.nextLine();
      a.setAnswer4(response4);
      //FIFTH B
      System.out.println("5. Was this quiz hard? \nA. True\nB. False");
      String response5 = input.nextLine();
      a.setAnswer5(response5);
      //SCORE
      System.out.println("SCORE: "+a.toInt()+"/5 "+a.toString());
      
    
    
    
    
    }
}
