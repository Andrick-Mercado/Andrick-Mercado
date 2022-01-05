/**
 * we use a really slow sorting
 * alforithm
 * @author (Andrick Mercado)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
import java.lang.RuntimeException;
public class BogoSort
{
    public ArrayList<Integer> input = new ArrayList<Integer>();//input of type inputayList<Integer> with public access
    public long randomSeed;//randomSeed of type long with public access
    public int noOfRuns;//noOfRuns of type int with public access
    /**
     * BogoSort
     * constructor:  It calls the readFromFile method 
     * with the given fileName, prints the initial 
     * list of integers using the printList function, 
     * calls the sort function which would sort the list 
     * with the implemented BogoSort and prints out 
     * the sorted list by again calling the printList function.
     * @param [int length]
     */
    public BogoSort(String fileName)
    {
        readFromFile(fileName);
        System.out.print("Initial List: ");
        printList();
        sort();
        System.out.print ("\nSorted List in " + noOfRuns + " attempt(s): ");
        printList();
    }

    /**
     * readFromFile
     * Accepts the fileName of the file to be opened to get 
     * in the randomSeed and the list of integers to sort. 
     * Using File I/O learned in previous programs, the function 
     * should read in the values which would be in the following format,
     * where the first line is the randomSeed to be used and the second line
     * is the list of the integers to sort.
     * @param [String fileName]
     */
    private void readFromFile(String fileName)
    {
        try
        {
            Scanner scnr = new Scanner(new File(fileName) );//new File(fileName) ) ;
            //this.randomSeed = scnr.nextLong();
            String numbers = scnr.nextLine();
            this.randomSeed = Integer.parseInt(numbers);//long if this. doesnt work
            numbers = scnr.nextLine();
            String [] nums = numbers.split(",");//best way to separate them "s"
            for(int x=0; x<nums.length; x++)
            {
                int num = Integer.parseInt(nums[x].trim());
                input.add(num);
            }
            scnr.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File does not exist!");
        }
        catch(Exception e)
        {
            System.out.println("Error in reading from file! ");
        }
        finally
        {
            System.exit(0);   
        }
    }

    /**
     * sort
     * While the inputay is not sorted
    Loop to check if inputay is sorted or not.
    if not, loop i from 0...n (exclusive)
    Using the Random object, generate a random int between 0 to n (exclusive)
    Swap the inputay element at index i with the random index generated.
    Also, increment the number of runs i.e. the number of times you have 
    created a new random list to see if it was sorted.
     */

    private void sort()
    {
        Random seed = new Random(this.randomSeed);
        boolean isSorted = false;
        this.noOfRuns = 0;
        while(!isSorted)//is sorted or not
        {
            for(int y=0; y<input.size()-1; y++)
            {
                if(input.get(y)>input.get(y+1))
                {
                    break;      
                }
            }
            for(int x = 0; x<input.size(); x++)
            {
                int temp1 = seed.nextInt(input.size());
                int temp2 = input.get(x);
                input.set(x, input.get(temp1));
                input.set(temp1, temp2);
            }
            noOfRuns++;//after code runs it adds one to num of runs
        }
    }

    /**
     * printList
     * prints the Integer inputay separated by commas
     */
    private void printList()
    {
        String data = "";
        for(Integer x : input)
        {
            data = data + x + ", " ;
        }
        if(input.size() > 3)//in case few numbers are given in the array
        {
            System.out.print( data.substring(0,data.length()-2) ); 
        }
        else
        {//to prevent an error
            System.out.print("few numbers");   
        }
    }

    public static void main(String [] args)
    {
        String fileName = "testFile.txt";
        BogoSort obj = new BogoSort(fileName); 
    }
}
