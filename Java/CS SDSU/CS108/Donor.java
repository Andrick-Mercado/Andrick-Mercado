package CS108;

/**
 * abstrac is implemented by main
 * in DonorPage
 *
 * @author (Andrick Mercado)
 * @version (5/3/2020)
 */
import java.util.*;
public abstract class Donor
{
    /**
     * printMenu
     * prints the menu, the first one
     */
    public static void printMenu()
    {
        System.out.println("Welcome to this donor page");
        System.out.println("please select an option below");
        System.out.println("0. Exit page");
        System.out.println("1. Donate supplies");
        System.out.println("2. Contact support");
        System.out.println("3. information about local Hospitals");
    }

    /**
     * printDonorMenu
     * prints the menu for donations
     */
    public static void printDonorMenu()
    {
        System.out.println("Thanks for helping");
        System.out.println("please select an option below of item you wish to donate");
        System.out.println("0. GO BACK");
        System.out.println("1. Donate Masks");
        System.out.println("2. Donate Sanitizers");
        System.out.println("3. Donate Respirators");
        System.out.println("4. Donate Face/Eye Shields");
        System.out.println("5. Donate Gloves");        
    }

    /**
     * printDonorMenu2
     * prints the menu for part 2 of the menu
     */
    public static void printDonorMenu2()
    {
        System.out.println("0. GO BACK");
        System.out.println("1. Do you wish to pick a hospital");
        System.out.println("2. Donate to the most in need");
    }

    /**
     * needMostMenu
     * prints the menu 
     */
    public static void needMostMenu()
    {
        System.out.println("Would you like to donate to this hospital");
        System.out.println("0. exit application");
        System.out.println("1. YES");
        System.out.println("2. NO");
    }

    /**
     * printDisplayMenu
     * prints the menu for which display to print 
     */
    public static void printDisplayMenu()
    {
        System.out.println("0. GO BACK");
        System.out.println("1. print formated information");
        System.out.println("2. print using recursion (not formated)");
    }

    /**
     * printCustomerSupport
     * prints customer support info
     * currently none cause :|
     */
    public static void printCustomerSupport()
    {
        System.out.println();
        System.out.println("Do to current situation");
        System.out.println("we are unable to help at this moment");
        System.out.println();
    }

    /**
     * invalid
     * prints the invalid message
     */
    public static void invalid()
    {
        System.out.println("INVALID INPUT");
        System.out.println("PLEASE TRY AGAIN"); 
        System.out.println();
    }

    /**
     * thanks 
     * prints thanks
     */
    public static void thanks()
    {
        System.out.println("Thanks for visiting");
    }

    /**
     * printInfo
     * information of all the hashes in the hashmap
     * calls display to sort the information
     * @param [hashmap<String , newDonor> hospitlInfo: brings the hashmap from the main method]
     */
    public static void printInfo(HashMap<String, newDonor> hospitalInfo)
    {
        System.out.println("M: masks S: sanitizer R: respirators S: shields G: gloves");
        TreeMap<String, newDonor> sorted = new TreeMap<>(); 
        // Copy all data from hashMap into TreeMap 
        sorted.putAll(hospitalInfo); 
        for (HashMap.Entry<String, newDonor> entry : sorted.entrySet())  
        {
            System.out.println(entry.getKey() );
            System.out.println("M S R S G");
            System.out.println(hospitalInfo.get( entry.getKey() ).Display() +"\n");
        }
    }

    /** SORTING HERE
     * printHospitals
     * sorts them by implementing the hashmap keys of type string into an arraylist 
     * that sorts the hasmap of only the hospitals names
     * @param [hashmap<String , newDonor> hospitlInfo: brings the hashmap from the main method]
     */
    public static void printHospitals(HashMap<String, newDonor> hospitalInfo)
    {
        String temp;
        ArrayList<String> sortedKeys = new ArrayList<String>(hospitalInfo.keySet() );
        for (int x = 0; x < sortedKeys.size(); x++) 
        {
            for (int y = x + 1; y < sortedKeys.size(); y++) { 
                if (sortedKeys.get(x).compareTo(sortedKeys.get(y) )>0 ) 
                {
                    temp = sortedKeys.get(x);
                    sortedKeys.set(x , sortedKeys.get(y) );
                    sortedKeys.set(y, temp) ;
                }
            }
        }
        for (String x : sortedKeys)
        {
            System.out.println( x );   
        } 
    }

    /** RECURSION HERE
     * recursionDisplay
     * displays all information with recursion
     * calls it self with a truncated map, however it is not formatted
     * @param [hashmap<String , newDonor> currentData: brings the hashmap from the main method]
     */
    public static void recursionDisplay(HashMap<String, newDonor> currentData)
    {
        for (HashMap.Entry<String, newDonor> entry : currentData.entrySet() ) 
        {
            String key = entry.getKey();
            newDonor value = entry.getValue();
            if (value instanceof newDonor)
            {
                System.out.println(key);
                System.out.println("M S R S G");
                System.out.println(value.Display() );
                System.out.println();
            } 
            else if (value instanceof Map) 
            {
                HashMap<String, newDonor> subMap = new HashMap<String, newDonor>();
                recursionDisplay(subMap);
            }
        }
    }
}
