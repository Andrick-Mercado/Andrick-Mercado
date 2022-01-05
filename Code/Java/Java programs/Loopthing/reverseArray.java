
    public class reverseArray { 
  static void reverse(int a[], int n) 
    { 
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        for (int k = 0; k < n; k++) { 
            System.out.print(b[k]+" , "); 
        } 
  } 
  public static void main(String[] args) 
    { 
      int [] a = {2,2,2,8,2,2};
      int x = 0;
      int y = a.length-1;
      int xy;
      boolean sd = true;
      for(int sx = 0; sx<a.length;sx++)
      {
          if(a[sx]==2)
          if(!(sx-1>=0&&a[sx-1]==2)&&!(sx+1<a.length&&a[x+1]==2))
          sd = false;
       }
       System.out.println(" qwhatww eflerf "+ sd);
      while(x<y)
      {
         xy = a[x]; 
         a[x]=a[y];
         a[y]=xy;
         x++;
         y--;
        }
       
        for(int yx = 0; yx<a.length;yx++)
      {
          System.out.println(a[yx]);
        }
    }
}