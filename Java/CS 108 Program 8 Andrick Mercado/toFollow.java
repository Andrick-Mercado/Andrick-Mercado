/**
 * interface for newDonor
 *
 * @author (Andrick Mercado)
 * @version (5/3/2020)
 */
public abstract interface toFollow
{
    /**
     * Display
     * prints out all the information about the hospital at hand
     * @return [String all the info about current hospital]
     */
    public String Display();

     /**
     * getnumberOfMasks
     * @return [int number of current masks]
     */
    public int getnumberOfMasks();

     /**
     * getnumberOfSanitizer
     * @return [int number of current sanitizers]
     */
    public int getnumberOfSanitizer();

     /**
     * getnumberOfRespirators
     * @return [int number of current respirators]
     */
    public int getnumberOfRespirators();

    /**
     * getnumberOfShields
     * @return [int number of current shields]
     */
    public int getnumberOfShields();

    /**
     * getnumberOfGloves
     * @return [int number of current gloves]
     */
    public int getnumberOfGloves();
}
