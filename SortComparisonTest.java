import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
 *  
 *  							Insert			 Quick			Merge 			 Merge			Selection
 *  														  Recursive		   Iterative			
 *  10 random			    |		   	   |	     	  |				  |					|				|
 *  100 random			    |			   |			  |			      |					|				|
 *  1000 random			    |			   |			  |				  |					|				|
 *  1000 few unique		    |			   |		   	  |				  |					|				|
 *  1000 nearly ordered     |			   |			  |				  |					|				|
 *  1000 reverse order      |			   |			  |				  |					|				|
 *  1000 sorted			    |			   |			  |				  |					|				|
 *  
 *  
 *  
 *  a. Which of the sorting algorithms does the order of input have an impact on? Why?
	b. Which algorithm has the biggest difference between the best and worst performance, based
		on the type of input, for the input of size 1000? Why?
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
		based on the input size? Please consider only input files with random order for this answer.
	d. Did you observe any difference between iterative and recursive implementations of merge sort?
	e. Which algorithm is the fastest for each of the 7 input files? 
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
    	assertNull(SortComparison.mergeSortIterative(array));
    	assertNull(SortComparison.mergeSortRecursive(array));
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
    
    @Test
    public void testMergeIterative()
    {
    	double [] array = {3,2,1};
    	double [] expResult = {1,2,3};
    	assertTrue(Arrays.equals(expResult, SortComparison.mergeSortIterative(array)));
    	
    	double [] array2 = {4,5,1,7,2,1};
    	double [] expResult2 = {1,1,2,4,5,7};
    	assertTrue(Arrays.equals(expResult2, SortComparison.mergeSortIterative(array2)));
    }
    
    @Test
    public void testMergeRecursive()
    {
    	double [] array = {3,2,1};
    	double [] expResult = {1,2,3};
    	assertTrue(Arrays.equals(expResult, SortComparison.mergeSortRecursive(array)));
    	
    	double [] array2 = {4,5,1,7,2,1};
    	double [] expResult2 = {1,1,2,4,5,7};
    	assertTrue(Arrays.equals(expResult2, SortComparison.mergeSortRecursive(array2)));
    }


    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    /*
     * Create a main method in SortComparisonTest that runs all the experiments on SortComparison
 	described below and prints the time in milliseconds that each method execution took. This method
 	will not run on the submission server, but you should run it locally on your computers. You need to
 	record the results in a comment at the top of your SortComparisonTest file.
 	Your experiments in this section should be run from within the provided main method. Do not run
 	these experiments from within a jUnit test.
     */
   public static void main(String[] args)
    {
	   for(int i = 0; i < args.length; i++)
	   {
		   double[] testArray = SortComparison.readFile(args[i], SortComparison.elemsInFile(args[i]));
		   double start = System.nanoTime();
	       SortComparison.insertionSort(testArray);
	       double end = System.nanoTime();
	       double duration = (end - start) * (Math.pow(10, -6));
	       System.out.println((i + 1) + ". " + args[i] + "\nTime taken for insertion sort = " + duration + " ms");
	       
	       start = System.nanoTime();
	       SortComparison.selectionSort(testArray);
	       end = System.nanoTime();
	       duration = (end - start) * (Math.pow(10, -6));
	       System.out.println("Time taken for selection sort = " + duration + " ms");
	       
	       start = System.nanoTime();
	       SortComparison.quickSort(testArray);
	       end = System.nanoTime();
	       duration = (end - start) * (Math.pow(10, -6));
	       System.out.println("Time taken for quick sort = " + duration + " ms");
	       
	       start = System.nanoTime();
	       SortComparison.mergeSortIterative(testArray);
	       end = System.nanoTime();
	       duration = (end - start) * (Math.pow(10, -6));
	       System.out.println("Time taken for merge sort iterative = " + duration + " ms");
	       
	       start = System.nanoTime();
	       SortComparison.mergeSortRecursive(testArray);
	       end = System.nanoTime();
	       duration = (end - start) * (Math.pow(10, -6));
	       System.out.println("Time taken for merge sort recursive = " + duration + " ms\n");
	       
	   }
	} 
   
   
}

