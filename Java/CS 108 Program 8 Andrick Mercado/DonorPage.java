/**
 * This is supposed to simulate a website, where a donor selects or
 * is told the hospital in most need according to the data stored
 * this data is randomly generated, as its just a preview of
 * what the idea is for the full program, this program is just about
 * donating supplies to hospitals that need equipment 
 * against the current pandemic
 * @author (Andrick Mercado)
 * @version (5/3/2020)
 */
import java.util.*;
import java.text.ParseException;
public class DonorPage extends Donor
{
    public static HashMap<String, newDonor> hospitalInfo = new HashMap<String, newDonor>();
    private static newDonor info1 = new newDonor();
    private static newDonor info2 = new newDonor();
    private static newDonor info3 = new newDonor();
    private static newDonor info4 = new newDonor();
    private static newDonor info5 = new newDonor();
    private static newDonor info6 = new newDonor();
    /** 
     * main
     * setup the user interface, or the input from the user, collects it
     * and sends it to other methods that run the information
     */
    public static void main(String[]args)
    {
        randomGeneratedData();//retrieves the information
        Scanner input = new Scanner(System.in);
        int option = -1;

        while(option != 0)
        {
            try{
                printMenu();
                option = input.nextInt();
                switch(option)
                {
                    case 0: 
                    thanks();
                    break;

                    case 1:
                    printDonorMenu();
                    option = input.nextInt();
                    if(option==0)
                    {
                        option = -1;
                        break;
                    }
                    else
                    {
                        runOption(option, input);
                    }
                    break;

                    case 2:
                    printCustomerSupport();
                    break;

                    case 3:
                    runOption6(input);
                    break;

                    default:
                    invalid();
                    break;
                }
            }
            catch(Exception e)
            {
                invalid();
                option = -1;
                input.nextLine();//prevents infinite loop
            }
        }
    }

    /**
     * hospitalNeedMost
     * basically looks for the item, and 
     * executes the loop that will find the 
     * hospital that most needs that item
     * @param [Scanner input: brings the same scanner from the main method] 
     * @param [String needOf: the item that is being donated]
     */
    public static void hospitalNeedMost(Scanner input, String needOf)
    {
        System.out.println("The Hospital in most need of "+needOf);
        int numOfProduct = Integer.MAX_VALUE;
        String nameHospital = "";
        if(needOf.equals("mask") )
        {
            for (HashMap.Entry<String,newDonor> entry : hospitalInfo.entrySet() )  
            {
                if(numOfProduct>=entry.getValue().getnumberOfMasks() )
                {
                    numOfProduct = entry.getValue().getnumberOfMasks();
                    nameHospital = entry.getKey();
                }
            }
            System.out.println(nameHospital + " is in most need of Masks, they have " + numOfProduct ); 
            needMostMenu();
            runOption5(input, needOf, hospitalInfo.get(nameHospital) ,  nameHospital);
        }
        else if(needOf.equals("sanitizer") )
        {
            for (HashMap.Entry<String,newDonor> entry : hospitalInfo.entrySet() )  
            {
                if(numOfProduct>=entry.getValue().getnumberOfSanitizer() )
                {
                    numOfProduct = entry.getValue().getnumberOfSanitizer();
                    nameHospital = entry.getKey();
                }
            }
            System.out.println( nameHospital + " is in most need of Sanitizers, they have " + numOfProduct ); 
            needMostMenu();
            runOption5(input, needOf, hospitalInfo.get(nameHospital) ,  nameHospital);
        }
        else if(needOf.equals("respirator") )
        {
            for (HashMap.Entry<String,newDonor> entry : hospitalInfo.entrySet() )  
            {
                if(numOfProduct>=entry.getValue().getnumberOfRespirators() )
                {
                    numOfProduct = entry.getValue().getnumberOfRespirators();
                    nameHospital = entry.getKey();
                }
            }
            System.out.println(nameHospital + " is in most need of Respirators, they have " + numOfProduct  ); 
            needMostMenu();
            runOption5(input, needOf, hospitalInfo.get(nameHospital) ,  nameHospital);
        }
        else if(needOf.equals("shield") )
        {
            for (HashMap.Entry<String,newDonor> entry : hospitalInfo.entrySet() )  
            {
                if(numOfProduct>=entry.getValue().getnumberOfShields() )
                {
                    numOfProduct = entry.getValue().getnumberOfShields();
                    nameHospital = entry.getKey();
                }
            }
            System.out.println(nameHospital + " is in most need of Shields, they have " + numOfProduct ); 
            needMostMenu();
            runOption5(input, needOf, hospitalInfo.get(nameHospital) ,  nameHospital);
        }
        else 
        {
            for (HashMap.Entry<String,newDonor> entry : hospitalInfo.entrySet() )  
            {
                if(numOfProduct>=entry.getValue().getnumberOfGloves() )
                {
                    numOfProduct = entry.getValue().getnumberOfGloves();
                    nameHospital = entry.getKey();
                }
            }
            System.out.println(nameHospital + " is in most need of Gloves, they have " + numOfProduct ); 
            needMostMenu();
            runOption5(input, needOf, hospitalInfo.get(nameHospital) ,  nameHospital);
        }
    }

    /**
     * runOption
     * takes user input and runs runOption2
     * with valid information about the users input
     * @param [int option: is from main method determines what is being to be donated] 
     * @param [the parameter it takes second and so on]
     */
    public static void runOption(int option, Scanner input)
    {
        String needOf = null;
        int option2 = 0;
        if(option ==1)
        {
            needOf = "mask";
            runOption2(input, option2, needOf);
        }
        else if(option == 2)
        {
            needOf = "sanitizer";
            runOption2(input, option2, needOf);
        }
        else if(option == 3)
        {
            needOf = "respirator";
            runOption2(input, option2, needOf);
        }
        else if(option == 4)
        {
            needOf = "shield";
            runOption2(input, option2, needOf);
        }
        else if(option == 5)
        {
            needOf = "gloves";
            runOption2(input, option2, needOf);
        }
        else
        {
            invalid();
        }
    }

    /**
     * runOption2
     * executes both options 
     * calls according methods
     * @param [Scanner input: takes the scanner from main] 
     * @param [int option2: currently 0]
     * @param [String needOf: what is going to be donated]
     */
    public static void runOption2(Scanner input, int option2, String needOf)
    {
        printInfo(hospitalInfo);
        printDonorMenu2();
        option2 = input.nextInt();

        if(option2==1)
        {
            printHospitals(hospitalInfo);
            input.nextLine();
            String option3 = input.nextLine();
            runOption3(option3, input, needOf);
            thanks();
        }
        else if(option2==2)
        {
            hospitalNeedMost(input,needOf);
        } 
        else if(option2==0)
        {
            return;
        }
        else
        {
            invalid();
        }
    }

    /**
     * runOption3
     * if hospital that is given is not found in the hashmap
     * it doesnt change any hashmap values
     * @param [String hospitalName: hospital name] 
     * @param [Scanner input: from main method]
     * @param [String needOf: whats going to be donated]
     */
    public static void runOption3(String hospitalName, Scanner input, String needOf)
    {
        System.out.println("How many " + needOf +" do you wish to donate");
        int numOfItem = input.nextInt();
        for (HashMap.Entry<String,newDonor> entry : hospitalInfo.entrySet())  
        {
            if(hospitalName.equals(entry.getKey() ) )
            {
                runOption4(needOf, entry.getValue(), numOfItem, hospitalName);
            }
        }
    }

    /**
     * runOption4
     * finds what is going to be donated, and proceeds
     * to add that infoarmation to the hashmap
     * @param [String needOf: what is going to be donated] 
     * @param [newDonor curInfo: all the info relating that hospital]
     * @param [int numOfItem: how many items to be donated]
     * @param [String hospitalName: hospital name]
     */
    public static void runOption4(String needOf, newDonor curInfo, int numOfItem, String hospitalName)
    {
        if(needOf.equals("mask") )
        {
            curInfo.setnumberOfMasks(numOfItem);
            hospitalInfo.put(hospitalName , curInfo );
        }
        else if(needOf.equals("sanitizer") )
        {
            curInfo.setnumberOfSanitizer(numOfItem);
            hospitalInfo.put(hospitalName , curInfo );
        }
        else if(needOf.equals("respirator") )
        {
            curInfo.setnumberOfRespirators(numOfItem);
            hospitalInfo.put(hospitalName , curInfo );
        }
        else if(needOf.equals("shield") )
        {
            curInfo.setnumberOfShields(numOfItem);
            hospitalInfo.put(hospitalName , curInfo );
        }
        else 
        {
            curInfo.setnumberOfGloves(numOfItem);
            hospitalInfo.put(hospitalName , curInfo );
        }
    }

    /**
     * runOption5 
     * prompts user if he wants to donate to
     * the hospital that most needs it
     * @param [Scanner input: from main] 
     * @param [String needOf: whats is going to be donated]
     * @param [newDonor curInfo: current object that is going to be change]
     * @param [String hospitalName: hospital name]
     */
    public static void runOption5(Scanner input, String needOf, newDonor curInfo, String hospitalName )
    {
        int option5 = input.nextInt();
        if(option5 == 0)//exit
        {
            System.exit(0);
        }
        else if(option5 == 1)//yes
        {
            System.out.println("How many " + needOf +" do you wish to donate");
            int numOfItem = input.nextInt();
            runOption4(needOf, curInfo, numOfItem, hospitalName);
            thanks();
        }
        else if(option5 == 2)//no
        {
            return;
        }
        else//none
        {
            invalid();
        }
    }

    /**
     * runOption6
     * prompts user, what display they want, either none '
     * sorted or none sorted information
     * @param [Scanner input: scanner from main]
     */
    public static void runOption6(Scanner input)
    {
        printDisplayMenu();
        int option6 = input.nextInt();
        if(option6 == 0)
        {
            return; 
        }
        else if(option6 == 1)
        {
            printInfo(hospitalInfo);
        }
        else if(option6 == 2)
        {
            recursionDisplay(hospitalInfo);
        }
        else
        {
            invalid();   
        }
    }

    /**
     * randomGeneratedData()
     * for this casse data is random, thus we dont have real information,
     * if real information was going to be implemented, could be with more methods 
     * potentially reading from a file that has the information
     * but for this case information is made up
     */
    public static void randomGeneratedData()
    {
        hospitalInfo.put("hospital 1" , info1 );
        hospitalInfo.put("hospital 9" , info2 );
        hospitalInfo.put("hospital 8" , info3 );
        hospitalInfo.put("hospital 7" , info4 );
        hospitalInfo.put("hospital 6" , info5 );
        hospitalInfo.put("hospital 5" , info6 );
    }  
}