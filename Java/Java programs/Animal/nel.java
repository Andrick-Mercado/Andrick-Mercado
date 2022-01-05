import java.util.Scanner;
public class nel
{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sound");
        String sound1 = input.nextLine(); //reads the next line of input
        
        Animal nel = new Animal();
        System.out.println(nel.toString() );  
    }
}
