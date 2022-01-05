import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
/**
 * The test class newDonorTest.
 *
 * @author  (Andrick Mercado)
 * @version (5/4/2020)
 */
public class newDonorTest
{
    newDonor testDonor;
    /**
     * Default constructor for test class newDonorTest
     */
    public newDonorTest()
    {
        testDonor = new newDonor();
    }

    /**
     * test set method for masks
     */
    @Test
    public void testAdditionMasks()
    {
        testDonor.setnumberOfMasks(5);
        assertEquals(10, testDonor.getnumberOfMasks() );
    }

    /**
     * test set method for sanitizer
     */
    @Test
    public void testAdditionSanitizer()
    {
        testDonor.setnumberOfSanitizer(4);
        assertEquals(10, testDonor.getnumberOfSanitizer() );
    }

    /**
     * test set method for respirator
     */
    @Test
    public void testAdditionRespirator()
    {
        testDonor.setnumberOfRespirators(5);
        assertEquals(10, testDonor.getnumberOfRespirators() );
    }

    /**
     * test set method for shield
     */
    @Test
    public void testAdditionShields()
    {
        testDonor.setnumberOfShields(4);
        assertEquals(10, testDonor.getnumberOfShields() );
    }

    /**
     * test set method for glove
     */
    @Test
    public void testAdditionGlove()
    {
        testDonor.setnumberOfGloves(2);
        assertEquals(10, testDonor.getnumberOfGloves() );
    }

    /**
     * test the display method
     */
    @Test
    public void testDisplay()
    {
        assertEquals("5 6 5 6 8", testDonor.Display());
    }

    /**
     * test get method for masks
     */
    @Test
    public void testGetMasks()
    {
        assertEquals(5, testDonor.getnumberOfMasks() );
    }

    /**
     * test get method for sanitizer
     */
    @Test
    public void testGetSanitizer()
    {
        assertEquals(6, testDonor.getnumberOfSanitizer() );
    }

    /**
     * test get method for respirator
     */
    @Test
    public void testGetRespirator()
    {
        assertEquals(5, testDonor.getnumberOfRespirators() );
    }

    /**
     * test get method for Shields
     */
    @Test
    public void testGetShields()
    {
        assertEquals(6, testDonor.getnumberOfShields() );
    }

    /**
     * test get method for gloves
     */
    @Test
    public void testGetGlove()
    {
        assertEquals(8, testDonor.getnumberOfGloves() );
    }

    
}

