/**
 * all the information about the hospitals is changed here
 *
 * @author (Andrick Mercado)
 * @version (5/3/2020)
 */
import java.util.*;
public class newDonor implements toFollow
{
    private int numberOfMasks;
    private int numberOfSanitizer;
    private int numberOfRespirators;
    private int numberOfShields;
    private int numberOfGloves;
    /**
     * newDonor
     * constructor, creates random data
     * from 0 to 9
     */
    newDonor()
    {
        Random random = new Random(1);
        numberOfMasks = Math.abs( random.nextInt()%10 );
        numberOfSanitizer = Math.abs( random.nextInt()%10 );
        numberOfRespirators = Math.abs( random.nextInt()%10 );
        numberOfShields = Math.abs( random.nextInt()%10 );
        numberOfGloves = Math.abs( random.nextInt()%10 );
    }

    /**
     * Display
     * prints out all the information about the hospital at hand
     * @return [String all the info about current hospital]
     */
    public String Display()
    {
        //System.out.println("M S R S G");
        return this.numberOfMasks+ " "+ this.numberOfSanitizer+ " "+
        this.numberOfRespirators+" " +this.numberOfShields+ " " + this.numberOfGloves;
    }

    /**
     * setnumberOfMasks
     * adds to mask the user input
     * @param [int maskDonated: input from user] 
     */
    public void setnumberOfMasks(int maskDonated)
    {
        this.numberOfMasks += maskDonated;
    }

    /**
     * getnumberOfMasks
     * @return [int of the number of current masks]
     */
    public int getnumberOfMasks()
    {
        return this.numberOfMasks;
    }

    /**
     * setnumberOfSanitizer
     * adds user input to the current amount
     * @param [int sanitizerDonated: input of new sanitizer]
     */
    public void setnumberOfSanitizer(int sanitizerDonated)
    {
        this.numberOfSanitizer += sanitizerDonated;
    }

    /**
     * getnumberOfSanitizer
     * @return [returns current number of sanitizer]
     */
    public int getnumberOfSanitizer()
    {
        return this.numberOfSanitizer;
    }

    /**
     * setnumberOfRespirators
     * adds input to current
     * @param [int respiratorDonated: donation] 
     */
    public void setnumberOfRespirators(int respiratorDonated)
    {
        this.numberOfRespirators += respiratorDonated;
    }

    /**
     * getnumberOfRespirators
     * @return [int the number of current respirators]
     */
    public int getnumberOfRespirators()
    {
        return this.numberOfRespirators;
    }

    /**
     * setnumberOfShields
     * @param [the parameter it takes first with type] 
     */
    public void setnumberOfShields(int shieldDonated)
    {
        this.numberOfShields += shieldDonated;
    }

    /**
     * getnumberOfShields
     * @return [int returns current shield]
     */
    public int getnumberOfShields()
    {
        return this.numberOfShields;
    }

    /**
     * setnumberOfGloves
     * @param [int glovesDonated: gloves to be donated] 
     */
    public void setnumberOfGloves(int glovesDonated)
    {
        this.numberOfGloves += glovesDonated;
    }

    /**
     * getnumberOfGloves
     * @return [current number of gloves]
     */
    public int getnumberOfGloves()
    {
        return this.numberOfGloves;
    }
}
