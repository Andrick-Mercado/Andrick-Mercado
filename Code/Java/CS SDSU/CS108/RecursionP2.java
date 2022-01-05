package CS108;

/**
 *  Program # 2
 *  The purpose 
 *  CS108-3
 *  Date 2/10/2020
 *  @author Andrick Mercado
  */
import java.util.*;
import java.util.ArrayList;
import java.util.List; 
public class RecursionP2
{
    private ArrayList <Integer> Original = new ArrayList<Integer>();
    private ArrayList<Integer> oddsArray = new ArrayList<Integer>(); 
   /**  
  public static void main(String[]args)
    {
        int [] y =  {1,2,3,4,5,6};
        RecursionP2 c = new RecursionP2(y);
        ArrayList <Integer> v = new ArrayList<Integer>();
        v.add(684);
        v.add(72);
        v.add(516);   // TESTER 
        v.add(4);
        v.add(5);
        //v.add(6);
        //v.add(7);
         // System.out.println(c.reverseList(v) );  
         // System.out.println(c.reverseList());   
         // System.out.println(c.toOddList() );
          System.out.println(c.toOddList(v) );
    }         //  **/     
    public RecursionP2(int [] array)
    {
        for(int x = 0; x<array.length;x++)
        {/** copies array to arraylist **/
            Original.add(array[x]);   
        }
    }
    public ArrayList<Integer> reverseList(ArrayList<Integer> original)
       {  /** reverse the list, uses a copy of original, stops execution if theres only one Integer in the list**/
        ArrayList<Integer> copy =  copyArray(original);
        if (!(copy.size()<=1))  
        
             {
                 Integer num = copy.remove(0); // stores Integers that will be added in reverse to copu
                 copy = reverseList(copy); // recursion occurs here
                 copy.add(num);// after the last recursion, it starts adding
              }
             return copy; //return reverse arraylist 
            }
    public ArrayList<Integer> reverseList()
    {/** Calls the same class but with a parameter overloading**/
      return reverseList(Original); // calls the same method but with a parameter
    }
    public ArrayList<Integer> toOddList(ArrayList<Integer> original)
    {
            return original;
    }
    public ArrayList<Integer> toOddList()
    {
       return toOddList(Original); 
    }
    public ArrayList<Integer> toEvenRevList(ArrayList<Integer> original)
    {
            ArrayList<Integer> copy =  copyArray(original); 
            int even = copy.size();//this will store odds later on, in the code
            if(!(copy.size()<=1))//checks for one or none exits if true
            {// basically when the array is empty or has one element or all arraylist are removed to prevent error
                 if(copy.size()%2==0) //2 because its size is one bigger
                   { // checks for odds in size starts at the end and subtracts
                       even = copy.remove(copy.size()-2); // -1 to prevent out of bound error removes odds and stores them
                    }  // removes odd and stores it
                     copy.remove(copy.size()-1);// this is even therefor deleted
                     copy = toOddList(copy); //recursion here stores copy to prevent unchanged arraylist
                     if(even!=0)//we dont want evens and last size will not be changed thus odds!=0
                    {// adds from last to first but recursion makes it backwards 
                        copy.add(even);/** couldnt find error ocasionally add odss to arraylist**/
                    }  
            }
            return copy; 
    }
    public ArrayList<Integer> toEvenRevList()
    {
      return toEvenRevList(Original);  
    }
    public int retPenultimate(ArrayList<Integer> original)
    {/** Create a copy; not change Original, removes every Integer value in the list except for last **/
       ArrayList<Integer> copy =  copyArray(original);
        if (!(copy.size()<=1))//chekcs how many elements preventing infinite recursion
             {
                 copy.remove(0);
                 copy = reverseList(copy); //recursion here
              }
              return copy.get(0); // returns last 
    }
    public ArrayList<Integer> getList()
    {/** Since Original was never changed we can just return it **/
        return Original;
    }
    /**  METHOD HELPER to create copys - does not cause error**/
    public ArrayList<Integer> copyArray(ArrayList<Integer> original)
        {/** If copied inside their respective methods it would cause error **/
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (Integer x : original)// cannot be int as it is an object
           {//needs a wrapper class
               copy.add(x);//list.add(new Integer(i));
            }
           return copy;
                }
}
