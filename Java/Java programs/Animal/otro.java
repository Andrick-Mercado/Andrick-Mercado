import java.util.Scanner;
public class otro
{
    public static void main(String args[]) {
     Scanner input = new Scanner(System.in);
     System.out.println("Enter the sound");
     String sound1 = input.nextLine(); //reads the next line of input
        //x.equals("a")
      System.out.println("Enter a weight: ");
      double weight1 = input.nextDouble();
        // call the constructor to build an animal object
        Animal a = new Animal();
        System.out.println(a.getBirthdate());
        // call the other constructor to build a customized animal object 
        Animal b = new Animal();
        System.out.println(b.getSound());
        //change weight
        System.out.println(b.getWeightPounds());        
        b.setWeightPounds(55); 
        System.out.println(b.getWeightPounds());
    } // end main    
 
}
