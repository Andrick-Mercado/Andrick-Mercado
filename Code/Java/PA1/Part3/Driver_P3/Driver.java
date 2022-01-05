package Part3.Driver_P3;
import Part3.Manager_P3.LinkedList;
import Part3.Data_P3.Process;
import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String [] args)
    {
        LinkedList test = new LinkedList<Process>();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the Time Quantum");
        int timeQuantum = userInput.nextInt();
        int option = -1;
        while(option != 0)
        {
            MainUserMenu();
            option = userInput.nextInt();
            if(option == 1)
            {
                runOption1(userInput, test);
                test.sortLinkedList();
                //test.Display();
            }
            if(option == 2)
            {
                test.startExecution(timeQuantum, test);
            }
        }
    }

    static void MainUserMenu()
    {
        System.out.println("0. Exit"); 
        System.out.println("1. Enter a process");
        System.out.println("2. Start execution");
    }

    static void runOption1(Scanner input, LinkedList test)
    {
        System.out.println("Enter Process Name"); 
        String name = input.next();
        input.nextLine();
        System.out.println("Enter Process Time");
        int time = input.nextInt();
        System.out.println("Enter Process Priority");
        int priority = input.nextInt();
        
        test.insert(new Process(name, time, priority) );
    }

}

