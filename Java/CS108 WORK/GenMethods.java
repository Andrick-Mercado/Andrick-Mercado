/**
 * GenMethods(Main File)
 * experiment with generic data types
 * they vary could be 'E', 'T', 'K', 'V'
 * this case using 'E' and giving it Integers
 * @ Andrick Mercado 
 * @ 4/9/2020 
 */
import java.util.*; //has all libraries needed and more :(
public class GenMethods<E>
{
    /** removeDuplicates
     * returns a new ArrayList, the new list contains the nonduplicate
     * elements from the original list which is given as a parameter
     * @param [ArrayList of type E]
     * @return [ArrayList of type E]
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
    {
        // Create a new ArrayList 
        ArrayList<E> newList = new ArrayList<E>(); 
        //Collections.copy(newList, list);
        // Traverse through the first list 
        for (E element : list) { 

            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 

                newList.add(element); 
            } 
        } 

        // return the new list 
        return newList; 
    }

    /** shuffle
     * shuffles 30 times two elements in an arraylist randomly with a seed
     * @param [ArrayList of type E]
     */  
    public static <E> void shuffle(ArrayList<E> list)
    {
        Random rand = new Random(340L);//given 
        for (int x=0; x<30;x++) //the 30 testing purposes :/
        {
            int y = rand.nextInt(list.size() ) ;
            int z = rand.nextInt(list.size() ) ;
            E temp = list.get(y); //stores temporarly
            E temp1 = list.get(z);//stores temporarly
            list.set(y, temp1); //replaces y for z 
            list.set(z, temp);//replaces z with y
        } 

    }

    /** max
     * returns max object of type E
     * @param [ArrayList of type E]
     * @return [largest element in the arraylist]
     */
    public static <E extends Comparable<E> > E max(ArrayList<E> list) 
    {
        E max = list.get(0);
        for(E curE : list)//for each loop, traverses thru arraylsit :)
        {// curE is short for current objectn E 
            if (curE.compareTo(max) >= 1)// if compare to gives a bigger number then 1 its bigger
            {//then current max, if its smaller it gives negative number
                max = curE;
            }
        }
        return max;
    }

    /** linearSearch
     * returns the index of the obeject E in the array that is equal to key
     * if no object is equal returns -1
     * @param [Array of type E amd an obect E labeled key]
     * @return [index of key in the array if found, if not returns -1]
     */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
    {
        for (int x = 0; x<list.length; x++)
        {
            if (list[x].compareTo(key) == 0)// cant use .equals as it compares their memory adres and each has diferent
            {
                return x;//returns index of match
            }
        }
        return -1;  //no match to key was found
    }

    /** max (same as above but with diferent parameter
     * returns max object of type E from an array
     * @param [Array of type E]
     * @return [largest element in the array]
     */
    public static <E extends Comparable<E>> E max(E[] list)
    {
        E max = list[0];
        for(E curE : list)//for each loop, traverses thru arraylsit :)
        {// curE is short for current objectn E 
            if (curE.compareTo(max) >= 1)// if compare to gives a bigger number then 1 its bigger
            {//then current max, if its smaller it gives negative number
                max = curE;
            }
        }
        return max; 
    }

    /** max (same as above but with diferent parameter
     * returns max object of type E from an 2d array
     * @param [2d Array of type E]
     * @return [largest element in the 2d array]
     */
    public static <E extends Comparable<E>> E max(E[][] list)
    {
        E max = list[0][0];
        for(E[] lista : list)
        {
            for(E curE : lista)
            {
                if (curE.compareTo(max) >= 1)
                {
                    max = curE;
                }
            }
        }
        return max; 
    }

    /** main
     * main: here all text is outputed to the use while prompting user for input
     */  
    public static void main(String [] args)
    {
        //initializes scanner for input
        Scanner scnr = new Scanner(System.in);
        //Read in a number n that represents the number of elements in the lists.
        int n = scnr.nextInt();
        // creates the lists
        Integer[] list = new Integer[n];
        LinkedList<Integer> linked = new LinkedList<>();   
        //iterates thru every user inpput and stores it in array of Integers
        int num;//will store input
        for (int x = 0; x<n; x++){
            num = scnr.nextInt();
            list[x] = num;// adds to array
            linked.add(num);//adds to link list
        }
        //Prints both lists
        System.out.println(Arrays.toString(list));
        System.out.println(linked);
        //key is stored from user input
        int key = scnr.nextInt();
        //runs linearsearch returns a positive or negative answer
        int indexOfMax = linearSearch(list, key);
        if(indexOfMax>=0)
        {//if key matches an integer in the array
            System.out.println("Key "+key+" was found at position " + indexOfMax);
        }
        else 
        {//if no match is found
            System.out.println("Key "+key+" was not found");
        }
        //prints biggest number in the array
        indexOfMax = max(list);   
        System.out.println(indexOfMax+ " is the max element");
        //takes the dimensions or length of the 2d array
        int m = scnr.nextInt();//number of rows
        int p = scnr.nextInt();//number of columns
        Integer[][] list2 = new Integer[m][p];
        //stores user input in the 2d array
        for (int x = 0; x<m; x++)
        {//iterates rows
            for(int y =0; y<p; y++)
            {//iterates clolumns
                list2[x][y] = scnr.nextInt();
                System.out.print(list2[x][y]+" ");
            }
            System.out.println();//makes new line
        }
        System.out.println();//new line again
        //gets the max of the copy of the array and prints it
        indexOfMax = max(list2);    
        System.out.println(indexOfMax+" is the max element");

        //print row
        System.out.println(Arrays.toString(list));
        //remove doubles - below a arraylist is made that converts linked list to arraylist
        ArrayList<Integer> alist = new ArrayList<Integer>(linked);
        alist = removeDuplicates(alist);
        System.out.println(alist );
        //shuffle
        shuffle(alist);
        System.out.println( alist );
        //max of above
        indexOfMax = max(alist);
        System.out.println(indexOfMax+ " is the max element");
    }

    /** getIdentificationString
     * here we give back info idk why 
     */  
    public String getIdentificationString()
    {
        return "Program 6, Andrick Mercado";
    }
}
