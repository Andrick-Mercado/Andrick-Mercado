package CS108;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import java.util.*;
/**
 * tests all major methods, or atleast the methods
 * that might fail when called
 *
 * @author (Andrick Mercado)
 * @version (5/4/2020)
 */
public class UnitTest
{
    public static void main(String [] args)
    {
        /** TESTING FOR NEWDONOR CLASS **/
        Result result = JUnitCore.runClasses(newDonorTest.class);
        for(Failure failure : result.getFailures() )
        {
            System.out.println(failure.toString() );
        }
        System.out.println("newDonor work? "  + result.wasSuccessful() );
        System.out.println();

        /** testing for sorting  **/
        DonorPage testPage = new DonorPage();
        testPage.randomGeneratedData();
        System.out.println("BEFORE SORTING");
        for (HashMap.Entry<String, newDonor> entry : testPage.hospitalInfo.entrySet())  
        {
            System.out.println(entry.getKey() );
        }
        System.out.println();
        System.out.println("AFTER SORTING");
        testPage.printHospitals(testPage.hospitalInfo);
        System.out.println();

        /** testing for recursion  **/
        System.out.println("PRINTING WITH RECURSION NOT SORTED");
        testPage.recursionDisplay(testPage.hospitalInfo);
    }
}
