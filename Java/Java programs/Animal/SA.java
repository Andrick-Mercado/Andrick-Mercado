import java.util.Scanner;
public class SA
{
   public static void main(String[]args){
     Scanner input = new Scanner(System.in);
     System.out.println("Enter the sound");
     String sound1 = input.nextLine(); //reads the next line of input
     System.out.println("Enter a Weight");
     double weight1= input.nextDouble();
     System.out.println("Birthdate?");
     int cumple = input.nextInt();
     System.out.println("Is it Wild?");
     boolean loco = input.nextBoolean();
     
     Animal a=new Animal(cumple,sound1,weight1,loco);  
     Animal b=new Animal(a.getBirthdate(),a.getSound(),a.getWeightPounds(),a.getIsWild());
     //Animal b = a; This is not a copy
     System.out.println("What is a?"+a.toString());
     System.out.println("What is b?"+b.toString());
     a.setWeightPounds(50);
     System.out.println("What is a?"+a.toString());
     System.out.println("What is b?"+b.toString());
     b=a;
     System.out.println("What is a?"+a.toString());
     System.out.println("What is b?"+b.toString());
    }
}
