import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner; 
public class Timed {
    Timer timer;
 public Timed(int minutes) {
     timer = new Timer();
     timer.schedule(new RemindTask(), minutes*60000);
 }
 class RemindTask extends TimerTask {
  public void run() {
     System.out.println("Time's up!!!!!!!");
     timer.cancel();//Terminate the timer thread
     System.exit(0);//STOPS THE TEST, USER CANNOT INPUT ANYTHING
  }
  }
 //THE ACTUAL TEST
    public static void main(String[]args) {
     new Timed(5);
     Scanner input = new Scanner(System.in);
     //random questions
     int form = (int)(Math.random()*2)+1;
      if(form==1){
      //object
      Project2 a = new Project2();
      //NAME OF USER
      System.out.println("FORM A\nNAME: " );
      String id = input.nextLine();
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
      System.out.println("NO MORE RE-TAKES");
     }//SECOND VERSION OF QUIZ 
       if(form==2){
      //object
      Project2 a = new Project2();
      //NAME OF USER
      System.out.println("FORM B\nNAME: " );
      String id = input.nextLine();
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
      System.out.println("5. When getting the anti-derivative do you need to add C at the end? \nA. True\nB. False");
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