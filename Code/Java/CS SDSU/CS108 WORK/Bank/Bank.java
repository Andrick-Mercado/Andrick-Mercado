/**
 * Concrete Class: Bank
 * Creates a bank object if called witth no parameters, keeps track of current month
 * getter method for month, two methods that return ints
 * @author
 * @date
 * CS 108 Section X (1 or 3)
 */
public class Bank
{ 
      static int AccountsNum=0;
      static int CustomersNum=0;
      private int Month;
      boolean isMonthEnd;
    Bank()//constructor for the class
      {
         Month = 0;
         isMonthEnd = false;
        }
        //getter for month
    int getMonth()
      {
          return Month;
        }
        /**
 * nextMonth
 * if month end is false then is not the end of the month and returns -1\
 * else add months +1, and if month is 11 or decemver it resets month to 0 and ismonthend is false ad returns month
 * if the statements is false then ismonth - false and returns current month 
 * @return [int return month]
 */
    int nextMonth()
      {
         if(!isMonthEnd)
         {
             System.out.println("It is not the end of month!");
             return -1;//odesnt matter could be any number as long as its not zero
        }
        else
        {
            Month++;
            if(Month==11)
        {
            Month=0;
            isMonthEnd =false;
            return Month;
        }
            isMonthEnd =false;
            return Month;
        }
    }
    /**
 * endOfMonth
 * if endofmonth true print its end of month else is makes endsofmonth to true and 
 * prints its end of month
 * @return [int month number]
 */
    int endOfMonth()
      {
          if(isMonthEnd)
          {
              System.out.println("It is already end of month!");
              return -1; 
            }
          else
          {
              isMonthEnd = true;
              System.out.println("It is now end of month!");
              return Month;
            }
        }
}
    