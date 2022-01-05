package CS108;

/**
 * Abstract Class: Deposit
 * Instiantiate deposit class and implm=ements account, creates setters and getters for useful deposit methods
 * creates holder information and holders
 * based of first and second
 * @ Andrick Mercado
 * @ 3/20/2020
 * CS 108 Section 1
 */

public abstract class Deposit implements Account
{
    int accountID;
    Customer firstHolder;
    Customer secondHolder;
    int accountBalance;
    int numWithdrawals;
    int minFees;
   Deposit()//constructor for the class
    { 
       accountID = Bank.AccountsNum++;
       firstHolder = checkCustomer();
       accountBalance = 0;
       numWithdrawals = 0;
       //print the following upon successful completion of the above
        System.out.println("A new account was created with account ID: "+accountID);
        System.out.println("The first holder is: "+firstHolder);
    }
    // MinimumFees Setters and getters
   void setMinimumFees(int min)
   {
       minFees = min;
   }
   int getMinimumFees() 
   {
       return minFees;
   }
    // ccountID setters and getters
   void setAccountID(int accountiD)
   {
       accountID = accountiD;
   }  
   int getAccountID() 
    {
       return accountID;
    }
    // AccounBalance setters and getters
   void setaccountBalance(int amount)
   {
       accountBalance = amount;
   } 
   int getaccountBalance() 
   {
       return accountBalance;
   }
   // Withdrawals setters and getters
   void setWithdrawals(int withdrawals)
   {
       numWithdrawals = withdrawals;
   }
   int getWithdrawals() 
   {
       return numWithdrawals;
   }
   // FirstHolder setters and getters
   Customer getFirstHolder()
   {
       return firstHolder;
   }
   void setFirstHolder(Customer first)
   {
       firstHolder = first;
   } 
   // SecondHolder setters and getters
   void setSecondHolder(Customer second)
   {
       secondHolder = second;
   }   
   Customer getSecondHolder() 
   {
       return secondHolder;
   }
   /**
 * depositMoney
 * if deposit is greater then 0, proceeds to deposit and returns true
 * else false
 * @param [int moeney] money to depositedd
 * @return boolean
 */
   boolean depositMoney(int money)
   {
       if(money > 0) 
       {
           accountBalance = accountBalance + money;
           return true;
       }
       else
       {
           return false;
       }
   }
 /**
 * checkCustomer
 * if existing customers prompts for customer id, if its true returns customer object with information
 * if non-existent asks for name and creates a new customer object and adds it tothe arraylsit
 * 
 * @return [Customer]
 */ 
   Customer checkCustomer()
   {
       System.out.println("Are you an existing customer? [Y: Yes; N: No]");
       String r = BankApp.scanner.nextLine().substring(0,1);
       if(r.equals("Y") || r.equals("y") )
       {
           System.out.println("Enter Customer ID: ");
           int curiD = BankApp.scanner.nextInt();
           BankApp.scanner.nextLine();
           for(int x=0; x<BankApp.BANK_CUSTOMER.size(); x++) 
           {
               if(BankApp.BANK_CUSTOMER.get(x).getCustomerID() == curiD) 
               {
                   return BankApp.BANK_CUSTOMER.get(x);
               }
           }
           r = "N";
           System.out.println("There was no record of the ID. A new ID will be created");
       }
       else if(r.equals("N") || r.equals("n") )
       {
           System.out.println("Enter your name: ");
           String n = BankApp.scanner.nextLine();
           Customer c;
           if(n.length() == 0) 
           {
               c = new Customer();
           }
           else 
           {
               c = new Customer(n);
           }
           BankApp.BANK_CUSTOMER.add(c);
           return c;
       }
       //in case an asnwer is invalid plus wont let me compile :/
       return null;       
   }      
   /**
 * addAccountHolder 
 * if second holder is empty it creates a new holderand returns true
 * if second holder already exist it returns false
 * @return [boolean]
 */
   public boolean addAccountHolder() 
   {
       if(secondHolder == null) 
       {//if empty proceed
           secondHolder = checkCustomer();
           return true;
       }
       return false;
   }
   /**
 * updateAccount
 * if customer object empty returns false
 * else instiantiates firstholder with given parameter and returns true
 * @param [Customer typ object] 
 * @return [boolean]
 */
   public boolean updateAccount(Customer c)
   {
       if(c == null)
       {
           return false;
       }
       firstHolder = c;
       return true;
   } 
   /**
 * updateAccount
 * replaces c type customer according to the option to the firstholder or secondholder
 * else returns false, if option 1 or 2 is called then returns true
 * @param [Customer type object] 
 * @param [int with a num representing an option]
 * @return [boolean]
 */
   public boolean updateAccount(Customer c, int num) 
   {
       if(num == 1) 
       {
           firstHolder = c;
       }
       else if(num == 2) 
       {
           secondHolder = c;
       }
       else 
       {
           return false;
       }
       return true;
    }
  /**
 * deleteAccount 
 * prompts user with yes or no to delete account, if yes prompts for customer id
 * if corrrect gives information about the customers id and promps user for confirmation of deletion, if the user doesnt want to delete the account
 * prints out No account were deleted, at end returns null if no accounts were deleted
  * @return [Account]
 */
   public Account deleteAccount() 
   {
       System.out.println("Are you sure you want to delete your account?");
       String r = BankApp.scanner.nextLine().substring(0,1);//less string manipulation
       if(r.equals("Y") || r.equals("y") )
       {
           System.out.println("Enter your Customer ID: ");           
           int customerid = BankApp.scanner.nextInt();
           BankApp.scanner.nextLine();
           // check if the first holder of any account matches the given customer id
           for(int x=0; x<BankApp.BANK_DEPOSIT.size(); x++) 
           {
               if(BankApp.BANK_DEPOSIT.get(x).getFirstHolder().getCustomerID() == customerid)
               {
                   System.out.println("Do you want to delete your savings account with AccID: "+ BankApp.BANK_DEPOSIT.get(x).accountID+" ?");
                   r = BankApp.scanner.nextLine().substring(0,1);
                   if(r.equals("Y") || r.equals("y") )
                   {
                       return BankApp.BANK_DEPOSIT.remove(x);
                   }
               }
           }
           System.out.println("Customer ID invalid");
           r = "n";
       }
       if(r.equals("N") || r.equals("n") ) 
       {
           System.out.println("No accounts were deleted");
       }
       return null;//if no accounts deleted
   }     
   /**
 * resetWithdrawals
 * numWithdrawals is set to 0
   **/
   void resetWithdrawals() 
    {
        numWithdrawals = 0;
    }
   /** abstract methods **/
    public abstract boolean withdrawMoney(int amount); //returns boolean
    public abstract int calcInterest(); //retuns int
    public abstract boolean addInterest(); //returns boolean  
}

