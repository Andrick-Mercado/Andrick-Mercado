package CS108;

/**
 * Concrete Class: Customer
 * Creates a customer object with no parameters and one parameter of string type, setters and getters
 * @ Andrick Mercado
 * @ 2/20/2020
 * CS 108 Section 1
 */
 
public class Customer
{
   private final int CustomerID;
   private String customerName;
   private int NumOfOpenAccounts;
Customer()//constructor for customer
    {
        CustomerID = Bank.CustomersNum++;//check plus plus if doesnt work
       customerName = "Customer" + CustomerID;
       NumOfOpenAccounts = 0;
   }
Customer(String name) //constructor for customer with parameter 
   {
       CustomerID = Bank.CustomersNum++;//check plus plus if doesnt work
       customerName = name;
       NumOfOpenAccounts = 0;
   }
   //getter for CUSTOMERID
int getCustomerID()
   {
       return CustomerID;
    } 
    // customer name
void setCustomerName(String name) 
   {
       customerName = name;
    }
String getcustomerName()
   {
       return customerName;
    }
    //customer accounts
void setCustomerAccounts(int openAccounts)
   {
       NumOfOpenAccounts = openAccounts;
    }
int getCustomerAccounts()
   {
       return NumOfOpenAccounts;
     }
     //prints out customer information
public String toString()
   {
       return "Customer: "+customerName+" | Customer ID: "+CustomerID;
    }
}
