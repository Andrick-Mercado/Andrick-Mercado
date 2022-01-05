public class Animal {
    
    /**PRIVATE INSTANCE VARIABLES: THE STATE OF AN OBJECT/WHAT IT KNOWS/CHARACTERISTICS */
    private int birthdate;
    private String sound;
    private double weightPounds; 
    private boolean isWild;
    
    /**CONSTRUCTORS TO BUILD THE ANIMAL OBJECTS */
    // build a generic Animal object(no parameters)
    public Animal(){
        birthdate = 19000101;
        isWild = true;
        weightPounds = 0.0;
        sound = "oof";
    } // end constructor
    // build a customized object with user defined parameters
    public Animal(int bdate, String s, double w, boolean wild){
        birthdate = bdate;
        sound = s;
        weightPounds = w;
        isWild = wild;
    }// end constructor
    /** ACCESSOR METHODS **/
    public int getBirthdate(){
        return birthdate;
        
    }
    public String getSound(){
        
        return sound;
    }
    public double getWeightPounds(){
        return weightPounds;
    }
    public boolean getIsWild(){
        return isWild;
    }
    public void setWeightPounds(double w){
        weightPounds = w;
    }
    public void setSound(String ound){
        sound = ound;
    }
    //represent the object as text 
    @ Override
    public String toString(){
        return "birthday: "+birthdate+"\nsound "+sound+"\npesop= "+weightPounds+"\nwild?"+isWild;
    }
} // end class

