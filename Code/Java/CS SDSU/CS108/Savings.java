package CS108;

/** Savings
 * createss savings object whencalled with no parameters, calculates interest of savings, extends deposit,
 * has withdrawmethod which limits three withdraws per day, and updates balance if amount is valid
 * @ Andrick Mercado
 * @ 3/20/2020
 */
public class Savings extends Deposit{
 private final int interestRate = 4;
 Savings() 
   {//uses deposits info alllll! well not all its a child
       super();
   }
   /**
 * withdrawMoney
 * if money to be withdrawed is negative it prints invalid amount
 * else it verifies sufficient funds if not prints not enought balacnce or if withdraws are equal to 3
 * then prints withdrawals limit exceeded as only 3 are permitted, else prints upadated balance and remaining withdrawals
 * returns true if withdrawal is dne if not then returns false
 * @param [int amount of money to be withdrawed]
 * @return [boolean]
 */
   public boolean withdrawMoney(int amount)
   {
       if(amount < 0) 
       {
           System.out.println("Invalid Amount");
       }
       else 
       {
           if(getWithdrawals() == 3)
           {
               System.out.println("Withdrawals Limit Exceeded");
           }
           else if(getaccountBalance() - amount < 0) 
           {
               System.out.println("Not Enough Balance");
           }
           else
           {
               setaccountBalance(getaccountBalance() - amount);
               System.out.println("Updated Balance: " + getaccountBalance() );
               setWithdrawals(getWithdrawals() + 1);
               System.out.println("Remaining Withdrawals: " +  (3-getWithdrawals()) );//3- used withdrawals to get total
               return true;
           }
       }
       return false;
   }    
     /**
 * calcInterest
 * calculates based on nums given by instructions ;/
 * @return int basically interest of savings
 */
   public int calcInterest() 
   {
       return (int) ((getaccountBalance()*interestRate)/(100.0*12.0));
   }     
     /**
 * addInterest
 * if its not end of month then returns false else sets accoutn balance and returns true
 * @return boolean
 */
   public boolean addInterest()
   {
       if(!BankApp.BANK.isMonthEnd)
       {
           return false;
           }
           else
           {
           setaccountBalance(getaccountBalance() + calcInterest());
           return true; 
            }
   }     
   //prints out savings info
   public String toString() 
   {
       return "Savings | Balance: "+getaccountBalance()+" | Withdrawals: "+getWithdrawals()+" | Potential Interest: "+calcInterest();
   }
   //getter for account ID
   public int getAccountID(Account account)
   {
       return getAccountID();
   }
}
