import java.util.Scanner;
public class aqui
{
  public static void main(String[]args){
      Scanner input= new Scanner(System.in);
      System.out.println("What? Rcck = 1, papeL = 2, sCISORS = 3");
      int what = input.nextInt();
      
      int x = (int)(Math.random()*3)+1;
      
      if(what == 1)
      System.out.println("P=ROCK");
      else if(what==2)
      System.out.println("P=PAPER");
      else if(what==3)
      System.out.println("p=SCISOER");
      else
      System.out.println("no mames");
      
      if(x == 1)
      System.out.println("CP=ROCK");
      else if(x==2)
      System.out.println("CP=PAPER");
      else
      System.out.println("CP=SCISOER");
      
      if(what ==1 && x==1)
      System.out.println("tied");
      else if(what == 2 && x==2)
      System.out.println("tied ");
      else if(what==3 && x==3)
      System.out.println("tied");
      
      if(what==1 && x==2)
      System.out.println("CP WINS");
      else if(what==1&&x==3)
      System.out.println("P WINS");
      
      if(what==2&&x==1)
      System.out.println("P WINS");
      else if(what==2&&x==3)
      System.out.println("CP WINS");
      
      if(what==3&&x==1)
      System.out.println("CP WINS");
      else if(what==3&&x==2)
      System.out.println("P WINS");
    }
}

      
      
      
