package Part2.Driver_P2;
import Part2.Manager_P2.CircularQueue;
import Part2.Data_P2.Student;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.File;
public class Driver
{
    public static void main(String[] args) 
    { 
        Scanner userInput = new Scanner(System.in);
        CircularQueue WaitingQueue = new CircularQueue();
        int option = -1;
        try
        {
            Scanner fileInput = new Scanner(new File ("Records.txt") );
            //imputting files for my case was "C:\\Users\\andri\\OneDrive\\Desktop\\PA1\\TestFiles\\Part2_Tests\\Records.txt"
            System.out.println("Enter the number of open seats in this Class");
            int numStudents = userInput.nextInt();
            Student [] EnrolledArray = new Student [numStudents];
            String [] studentInfo;
            String tmp = "";
            int countStudentsEnrolled = 0;
            while(fileInput.hasNextLine() )
            {
                tmp = fileInput.nextLine();
                studentInfo = tmp.split(", ");
                if(countStudentsEnrolled != numStudents)
                {
                    EnrolledArray[countStudentsEnrolled] =  new Student(studentInfo[1] , studentInfo[0]);
                    countStudentsEnrolled++;
                }
                else 
                {
                    WaitingQueue.enQueue(new Student(studentInfo[1] , studentInfo[0]) );
                }
            } 

            while(option != 4)
            {

                System.out.println("User Menu");
                System.out.println("1. Insert Student");
                System.out.println("2. Delete by Student ID");
                System.out.println("3. Display All Students");
                System.out.println("4. Exit");

                option = userInput.nextInt();
                if(option == 1)
                {
                    System.out.println("Enter ID of Student");
                    String id = userInput.next();
                    System.out.println("Enter the name of Student:");
                    String name = userInput.next();
                    userInput.nextLine();
                    if(countStudentsEnrolled == numStudents)
                    {
                        WaitingQueue.enQueue(new Student( id, name ) );
                    }
                    else
                    {
                        countStudentsEnrolled++;
                        EnrolledArray[countStudentsEnrolled] = new Student(id,name)  ;
                    }
                }
                if(option == 2)
                {
                    System.out.println("Input Student ID to Delete:");
                    String option2 = userInput.next();
                    runOption1(EnrolledArray, option2, WaitingQueue);
                }

                if(option == 3)
                {
                    System.out.println("PEOPLE IN CLASS: ");
                    for(int x = 0; x<numStudents; x++)
                    {
                        System.out.println(EnrolledArray[x].toString() );
                    }
                    System.out.println("PEOPLE IN WAITING LIST: ");
                    WaitingQueue.display();
                }
            }

        }
        catch(Exception e)
        {
            System.out.println("INVALID INPUT");
            System.out.println(e);
        }
    } 

    public static void runOption1(Student[] enrolled, String redID, CircularQueue waiting)
    {
        for(int x = 0; x<enrolled.length;x++)
        {
            if((enrolled[x].getRedID() ).compareTo(redID) == 0 )
            {
                if( !(waiting.peek() == null ) )
                {
                    enrolled[x] = (Student) waiting.deQueue();
                }
                else
                {
                    System.out.println("Waiting list is empty"); 
                }
            }
        }
    }
}
