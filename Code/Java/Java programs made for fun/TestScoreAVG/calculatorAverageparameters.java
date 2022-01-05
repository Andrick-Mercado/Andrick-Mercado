public class calculatorAverageparameters
{
    public static void main(String[]args){
        double [] ty = {100,100,100,23,23,56,56,67,78,89,12,32,78,78,89,68,79,70}; 
        double xy = AverageChecker(ty);
        System.out.println("\nScores: ");
        scores(ty,xy);
        System.out.println("Average: "+xy+" or " + letterGrade(xy));
        System.out.println("Highest Score: "+findHighestScore(ty));
        System.out.println("Lowest Score: "+findLowestScore(ty));
        System.out.println("Passing: " + findPassing(ty)+" with A's");
        System.out.println("Failing: " + findFailing(ty) + " with lower then C's");
        System.out.println("Odds: " + findSumOdds(ty));
        System.out.println("First sum: " + findSumFirst(ty));
        scores1(ty,xy);
     }
    public static double findSumFirst(double [] x )
    {
        double a = 0;
        for(int y=0;y<x.length;y++)
        {
          if(x[0] ==x[y] )
          {
             a = a +x[y]; 
            }
        }
        return a;
    }
    public static double findSumOdds(double [] x )
    {
        double a = 0;
        for(int y=0;y<x.length;y++)
        {
          if(x[y] %2!=0 )
          {
             a = a +x[y]; 
            }
        }
        return a;
    }
    public static int findFailing(double [] x )
    {
        int a = 0;
        for(int y=0;y<x.length;y++)
        {
          if(x[y]<70)
          {
             a = a +1; 
            }
        }
        return a;
    }
    public static int findPassing(double [] x )
    {
        int a = 0;
        for(int y=0;y<x.length;y++)
        {
          if(x[y]>=90)
          {
             a = a +1; 
            }
        }
        return a;
    }
    public static double AverageChecker(double [] ty){
        double sum = 0;
        for(int index = 0;index<ty.length;index++)
        {
           sum = sum + ty[index] ;
        }
        return sum/ty.length;
    }
    public static double findLowestScore(double [] x)
    {
       double highest = x[0];
           for(int y=0;y<x.length;y++)
        {
           if(highest > x[y])
           {
             highest = x[y];  
            }
        }  
        return highest; 
    }
       public static double findHighestScore(double [] x ) 
       { 
        double highest = 0;
           for(int y=0;y<x.length;y++)
        {
           if(highest < x[y])
           {
             highest = x[y];  
            }
        }  
        return highest;
    }
    public static String letterGrade(double  xy) 
       { 
        if ( xy >=90)
        return "A ";
        else if (xy >= 80)
        return "B ";
        else if (xy >=70)
        return "C ";
        else 
        return " F "; 
        }
        public static void scores(double [] ty, double xy){
        for(int x=0;x<ty.length;x++){
         System.out.println("TEST SCORE "+(x+1)+": " + ty[x]);
        }
        if (xy >=70)
         System.out.println("WELL DONE BOY");
        else
         System.out.println("YOU'RE A FAILURE");  
    }
    public static void scores1(double [] ty, double xy){
        
        for(int x=0;x<ty.length;x++){
            double c = ty[x];
            System.out.println("TEST SCORE "+(x+1)+": " + (c+3));
        }
        if (xy >=70)
         System.out.println("WELL DONE BOY");
        else
         System.out.println("YOU'RE A FAILURE");  
    }
}
