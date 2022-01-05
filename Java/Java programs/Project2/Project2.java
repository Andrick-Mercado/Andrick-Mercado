
public class Project2
{
    private String Name;
    private String Answer1;
    private String Answer2;
    private String Answer3;
    private String Answer4;
    private String Answer5;
    private String Retake;
  public Project2(){
       Answer1 = "ERROR";
       Answer2 = "ERROR";
       Answer3 = "ERROR";
       Answer4 = "ERROR";
       Answer5 = "ERROR";
       Name = "No Name";
       Retake = "Nel";
  }
   public Project2(String nombre, String respuesta1, String respuesta2,String respuesta3,String respuesta4,String respuesta5, String re){
       Answer1 = respuesta1;
       Answer2 = respuesta2;
       Answer3 = respuesta3;
       Answer4 = respuesta4;
       Answer5 = respuesta5;
       Name = nombre;
       Retake = re;
  }
   public void setAnswer1(String nel){
       Answer1 = nel;
  }
   public void setAnswer2(String nel){
       Answer2 = nel;
  }  
   public void setAnswer3(String nel){
       Answer3 = nel;
  }   
   public void setAnswer4(String nel){
       Answer4 = nel;
  }   
   public void setAnswer5(String nel){
       Answer5 = nel;
  } 
  public void setRetake(String re){
       Retake = re;
  }
  public void setName(String nel){
       Name = nel;
  }
  public String getRetake(){
       return Retake;
  }
  public String getName(){
      return Name;
    }
   @ Override
  public String toString(){
       if(Answer1.equals("9X+C") && Answer2.equals("B")&&Answer3.equals("B")&&Answer4.equals("C")&&Answer5.equals("A")||Answer1.equals("9x+c") && Answer2.equals("b")&&Answer3.equals("b")&&Answer4.equals("c")&&Answer5.equals("a"))
       return "YOU ARE PERFECT";//CODE ABOVE DOES NOT CHECK SPACES 
       return "NOT PERFECT";
  }
  public int toInt(){
       int counter= 0;
       while(counter >= 0 && counter <6){
       if(Answer1.equals("9x+c")||Answer1.equals("9X+C")||Answer1.equals("9x + c")||Answer1.equals("9X + C"))
       counter = counter +1;
       if(Answer2.equals("B")||Answer2.equals("b"))
       counter= counter +1;
       if(Answer3.equals("B")||Answer3.equals("b"))
       counter= counter +1;
       if(Answer4.equals("C")||Answer4.equals("c"))
       counter= counter +1;
       if(Answer5.equals("A")||Answer5.equals("a"))
       counter= counter +1; 
       
       return counter;
      }
      return counter;
  }
  
}
