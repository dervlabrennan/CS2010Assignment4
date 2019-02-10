import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Dervla Brennan
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[]array = null;
    	assertNull(SortComparison.insertionSort(array));
    	assertNull(SortComparison.selectionSort(array));
    	assertNull(SortComparison.quickSort(array));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testInsertion()
    {
    	double [] array = {3,2,1};
    	double [] expResult = {1,2,3};
    	assertTrue(Arrays.equals(expResult, SortComparison.insertionSort(array)));
    	
    	double [] array2 = {4,5,1,7,2,1};
    	double [] expResult2 = {1,1,2,4,5,7};
    	assertTrue(Arrays.equals(expResult2, SortComparison.insertionSort(array2)));
    }
    
    @Test
    public void testQuick()
    {
    	double [] array = {3,2,1};
    	double [] expResult = {1,2,3};
    	assertTrue(Arrays.equals(expResult, SortComparison.quickSort(array)));
    	
    	double [] array2 = {4,5,1,7,2,1,15,9};
    	double [] expResult2 = {1,1,2,4,5,7,9,15};
    	assertTrue(Arrays.equals(expResult2, SortComparison.quickSort(array2)));
    }
    
    @Test
    public void testSelection()
    {
    	double [] array = {3,2,1};
    	double [] expResult = {1,2,3};
    	assertTrue(Arrays.equals(expResult, SortComparison.selectionSort(array)));
    	
    	double [] array2 = {4,5,1,7,2,1};
    	double [] expResult2 = {1,1,2,4,5,7};
    	assertTrue(Arrays.equals(expResult2, SortComparison.selectionSort(array2)));
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

