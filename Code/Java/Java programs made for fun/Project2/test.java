import java.util.Scanner;
public class test
{
    public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    //random questions
    int form = 1;
      if(form==1){
      //object
      Project2 a = new Project2();
      //NAME OF USER
      System.out.println("FORM A\nNAME: " );
      String id = input.nextLine();
      a.setName(id);
      System.out.println("GOOD LUCK " + a.getName());
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
      System.out.println("5. When getting the anti-derivative do you need to add C at the end? \nA. True\nB. False");
      String response5 = input.nextLine();
      a.setAnswer5(response5);
      //SCORE
      double x = a.toInt();
      x = (x/5)*100;
      System.out.println("SCORE: "+x+"% or "+a.toInt()+"/5 "+a.toString());
      //RETAKE?
      if(a.toInt() <5){
      System.out.println("Want to re-take ?");
      String retake = input.nextLine();
      a.setRetake(retake);
    }
    //IF RETAKE YES THEN USE FORM B
    if(a.getRetake().equals("yes")||a.getRetake().equals("YES")){
       form = form+1;
    }
    //SECOND VERSION OF QUIZ FOR RETAKE
    }
    if(form==2){
      //object
      Project2 a = new Project2();
      //NAME OF USER
      System.out.println("FORM B\nNAME: "+a.getName() );
      System.out.println("GOOD LUCK " + a.getName());
      //SECOND B
      System.out.println("1. What is the anti-derivative of 9x ? \nA. 9x\nB. 9x^2/2 + c\nC. 9x + c\nD. Not enought information");
      String response2 = input.nextLine();
      a.setAnswer2(response2);
      //FIRST 9X+C
      System.out.println("2. What is the anti-derivative of 9 ? (write answer)");
      String response1 = input.nextLine();
      a.setAnswer1(response1);
      //FOURTH C
      System.out.println("3. What is the anti-derivative of x^2 - 4x + 6 ? \nA. 2x^2 - 2x +6x + c\nB. 3x^3/12 + 6x^2/2 + 2x + c\nC. x^3/3 - 2x + 6x + c\nD. Not enought information");
      String response4 = input.nextLine();
      a.setAnswer4(response4);
      //THIRD B
      System.out.println("4. What is the anti-derivative of 3x^2/4 + 6x + 2 ? \nA. 6x^2/2 + 3x + c\nB. x^3/4 + 3x^2 + 2x + c \nC. 3x^2/12 + 2x + c\nD. Not enought information");
      String response3 = input.nextLine();
      a.setAnswer3(response3);
      //FIFTH B
      System.out.println("5. Was this quiz hard? \nA. True\nB. False");
      String response5 = input.nextLine();
      a.setAnswer5(response5);
      //SCORE
      double x = a.toInt();
      x = (x/5)*100;
      System.out.println("SCORE: "+x+"% or "+a.toInt()+"/5 "+a.toString());
      System.out.println("NO MORE RE-TAKES");
    }
  }
}
