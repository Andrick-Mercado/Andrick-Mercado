/**
 * Interface: Account
 * every method here gives a behavior of each method here
 * @ Andrick Mercado
 * @ 3/20/2020
 * CS 108 Section 1
 */
public interface Account {
   public boolean addAccountHolder(); //returns boolean
   public boolean updateAccount(Customer x); // returns boolean
   public boolean updateAccount(Customer x, int y); //returns boolean
   public Account deleteAccount(); //returns account type object
   public int getAccountID(Account x); //returns int
}

