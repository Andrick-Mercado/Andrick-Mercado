public class spcs
{
 public static void whatsIt(int n)
   {
    if (n > 10)
      {
        whatsIt(n / 10);
      }
        System.out.print(n % 10);
    }
 public static void main (String[]args){
     whatsIt(347);
    
    }
    
}
