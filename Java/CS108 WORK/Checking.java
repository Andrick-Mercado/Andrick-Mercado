/**
 * Concrete Class: Checking
 * crreated checking with no parameters has withdrawmoney which returns boolean,
 * calinterest calculates interest, addinterest which addsinteres plus account balance to account balance
 * @ Andrick Mercado
 * @ 3/20/2020
 * CS 108 Section 1
 */
public class Checking extends Deposit
{
   private final int interestRate = 1;
Checking()// calls the super class shares all methods of deposit
   {
       super();
   }
     /**
 * qithdrawMoney
 * if amount is greater then 0, and u have enought money to withdrawed then it subtracts it from your balnce and prints info of balance
 * and returns true else prints out not enought balance and returns false
 * @param [int amount ] money to withdrawd
 * @return boolean
 */
public boolean withdrawMoney(int amount) 
   {
       if(amount>=0)
       {
           if(getaccountBalance() - amount >= 0)
           {
               setaccountBalance(getaccountBalance() - amount);
               System.out.println("Updated Balance: " + Integer.toString(getaccountBalance()));
               return true;
           }
           else 
           {
               System.out.println("Not Enough Balance");
           }
       }
       return false;
   } 
     /**
 * calcInterest
 * calculates interest based on info given 
 * @return int basically interest or balance
 */
public int calcInterest() 
   {
       return (int) (getaccountBalance()*interestRate/(100.0/12)  );// not +.5  i think
   } 
     /**
 * addInterest
 * if its end of month adds ineterst to accoutn balance and returns true
 * else returns false
 * @return boolean
 */
public boolean addInterest() 
   {
       if(BankApp.BANK.isMonthEnd) 
       {
           setaccountBalance(calcInterest()+getaccountBalance());
           return true;
       }
       else
       {
       return false;
      }
   }   
   //prints out all essential info of checkings class
public String toString() 
   {
       return "Checking | Balance: "+getaccountBalance() +" | Withdrawals: " + getWithdrawals() +" | Potential Interest: "+ calcInterest();
   }
   //returns accountid method with no parameters/
public int getAccountID(Account a) 
   {
       return getAccountID();
   }
}
