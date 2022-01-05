/**
 * BankApp Class (Main File)
 * main class where all the user input for the bank is received
 * and calls different classes, basically simulates a real life bank
 * @ Andrick Mercado 
 * @ 3/20/2020 
 */
import java.util.ArrayList;
import java.util.Scanner;
public class BankApp {
   static Bank BANK = new Bank();
   static ArrayList <Customer> BANK_CUSTOMER = new ArrayList<Customer>();
   static ArrayList<Deposit> BANK_DEPOSIT = new ArrayList<Deposit>();   
   static Scanner scanner = new Scanner(System.in); 
     public static void main(String[] args) {
       System.out.println("The Local Union");
         int option = -1;//any none zero number is fine to start the while loop
       while(option != 0) {
           if(option!=-2)//this is to prevent menu from reprinting when inva;id input s given
           { printMenu();}
           option = scanner.nextInt();
           scanner.nextLine();
           switch (option) 
           {
            case 0:/** when its exitted **/
               System.out.println("Thanks for using the bank application");
               break;
            case 1:/** prints options and creates a cehcking/savings according ot the user input**/
               System.out.println();
               System.out.println("1. Deposit Account: Checking");
               System.out.println("2. Deposit Account: Savings");
               System.out.println("0. Return to the main menu");
               System.out.println("Enter the type of account you wish to open: ");
               option = scanner.nextInt();
               scanner.nextLine();
               if(option == 1) {
                   Checking account = new Checking();
                   BANK_DEPOSIT.add(account);
                   
               }
               else if(option == 2) {
                   Savings account = new Savings();
                   BANK_DEPOSIT.add(account);          
               }
               else
               {//so it keeps running in the while loop returnsn to main meanu
                   option = -1;
               }
               break;
            case 2:/** if account id correct prints first and second holder information from deposit arraylist**/
               System.out.println("Enter your account ID: ");
               int accountId = scanner.nextInt();
               scanner.nextLine();
               for(int x=0; x<BANK_DEPOSIT.size(); x++) {
                   if(BANK_DEPOSIT.get(x).getAccountID() == accountId) {
                       BANK_DEPOSIT.get(x).addAccountHolder();
                        System.out.println("For Account ID: "+accountId);
                        System.out.println("First Holder: " +BANK_DEPOSIT.get(x).getFirstHolder() );
                        System.out.println("Second Holder: "+BANK_DEPOSIT.get(x).getSecondHolder() );
                       break;
                   }
               }
               break;
            case 3:
               System.out.println("Enter your account ID: ");
               accountId = scanner.nextInt();
               scanner.nextLine();
               Deposit account = null;
               for(int x=0; x<BANK_DEPOSIT.size(); x++) 
               {
                   if(BANK_DEPOSIT.get(x).getAccountID() == accountId)
                   {
                       account = BANK_DEPOSIT.get(x);
                       break;
                   }
               }
               if(account != null) 
               {//if its not empty will proceed 
                   System.out.println("1. Deposit");
                   System.out.println("2. Withdraw");
                   System.out.println("0. Return to Main Menu");
                   option = scanner.nextInt();
                   scanner.nextLine();
                   if(option == 1) 
                   {//deposits
                       System.out.println("Enter the amount you wish to deposit: ");
                       int amount = scanner.nextInt();//used in option one not 2 or other else
                       scanner.nextLine();
                       boolean validAmount = account.depositMoney(amount);
                       if(validAmount)//if its a non negative amount while deposit
                       {
                          System.out.println("Updated Balance: "+amount);
                      }
                   }
                   else if(option == 2) 
                   {//withdraws
                       System.out.println("Enter the amount you wish to withdraw: ");                   
                       account.withdrawMoney(scanner.nextInt() );
                       scanner.nextLine();
                   }
                   else 
                   {
                       option = -1;  //so menu can be reprinted
                       System.out.println("Exiting to main menu");
                   }
               }
               else 
               {//if a non valid answer given -2 makes the menu to not print
                   option=-2;
               }      
               break;
            case 4:/** iterates deposit arraylist and if account id correct deletes account**/
               System.out.println("Enter your account ID: ");
               accountId = scanner.nextInt();
               scanner.nextLine();
               for(int x=0; x<BANK_DEPOSIT.size(); x++) 
               {    //iterates deposit arraylist
                   if(BANK_DEPOSIT.get(x).getAccountID() == accountId) 
                   {//if account id correct proceed 
                       BANK_DEPOSIT.get(0).deleteAccount();
                       break;
                   }
               }
               break;
            case 5:/** ieterates deposit arraylist and if acount id correct it proceeds to store account data**/
               System.out.println("Enter your account ID: ");
               accountId = scanner.nextInt();
               scanner.nextLine();
               account = null;//used later
               for(int x=0; x<BANK_DEPOSIT.size(); x++) 
               {    //iterates array of deposits        
                   if(BANK_DEPOSIT.get(x).getAccountID() == accountId) 
                   {//stores deposit
                       account = BANK_DEPOSIT.get(x);
                       break;
                   }
               }
               if(account != null)
               {//if its not an empty account print account
                   System.out.println(account);          
               }        //as we dont want an empty account type object to be printed as null
               break;
            case 6:/** prints customer information, if customer ID is correct**/
               System.out.println("Enter your customer ID: ");
               int customerId = scanner.nextInt();
               scanner.nextLine();
               for(int x=0; x<BANK_CUSTOMER.size(); x++)
               {//iterates thru customers array 
                   if(BANK_CUSTOMER.get(x).getCustomerID() == customerId)//gets customers id and compares it to useer input id
                   {
                       System.out.println(BANK_CUSTOMER.get(x) );
                       break;
                   }
               }
               break;
            case 7:/**finds if its month end, for loop iterates array adds interest and withdrawal**/
               BANK.endOfMonth();
               for(int x=0; x<BANK_DEPOSIT.size(); x++)
               {
                   BANK_DEPOSIT.get(x).addInterest();//adds interst to moeney
                   BANK_DEPOSIT.get(x).resetWithdrawals();//ressets withdrawals to 3
               }
               break;
            case 8:/**adds month to Bank object**/
               BANK.nextMonth();//as name implies
               break;
            case 9:/**prints month using wrapper class Integer to converrt string to int**/
               System.out.println("Current Month: " + BANK.getMonth() );//prints month
               System.out.println("Month End Flag: " + BANK.isMonthEnd);//returns boolean
               break;
            default:/**if an none 0 to 9 answer is given it prompts the user again and option -2 to prevent menu from re printing**/
               option=-2;//sp menu wont be reprinted when invalid answer is given on prints bottomo statement
               System.out.println("Enter a relevant option: ");
           }
       }
   }
   /**
 * printMenu 
 * basically prints out the menu so the user can
 * select a valid option
 */
   public static void printMenu() {
       System.out.println();
        System.out.println("1. Open a new account.");
        System.out.println("2. Add a second holder to an existing account.");
        System.out.println("3. Deposit/Withdraw");
        System.out.println("4. Delete a current account.");
        System.out.println("5. Print details about a account.");
        System.out.println("6. Print details about a customer.");
        System.out.println("7. Update to end month [reset withdrawals & add interest].");
        System.out.println("8. Update to next month.");
        System.out.println("9. Print details about month.");
        System.out.println("0. Exit");
        System.out.println();
       System.out.println("Enter a relevant option: ");  
   }
}