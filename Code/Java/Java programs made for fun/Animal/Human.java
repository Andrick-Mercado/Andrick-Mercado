public class Human
{
    private int idNumber;
    private String firstN;
    private String lastN;
    
    public Human(){
       idNumber = 1074648;
       firstN = "Andrick";
       lastN = "Mercado";
        }
    public Human(int id,String first,String last){
        idNumber = id;
        firstN= first;
        lastN = last;
        }
    public void setfirstN(String first){
        firstN = first;
    }
    public String getfirstN(){
        return firstN;
    }
    public void setlastN(String last){
        lastN= last;
    }
    public String getlastN(){
        return lastN;
    }
      @Override
        public String toString(){
        return "Student ID #: "+idNumber+"\nFirst Name: "+firstN+"\nLast Name: "+lastN;
    }
}
