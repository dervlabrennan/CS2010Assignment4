// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Dervla Brennan
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[])
    {
    	if(a != null)
    	{
    		double temp;
        	for(int i = 1; i < a.length; i++)
        	{
        		for(int j = i; j > 0; j--)
        		{
        			if(a[j] < a[j-1])
        			{
        				temp = a[j];
        				a[j] = a[j-1];
        				a[j-1] = temp;
        			}
        		}
        		
        	}
        	return a;
    	}
    	return null;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    
    static double [] quickSort (double a[])
    {
    	if(a != null)
    	{
    		int low = 0;
    		int high = a.length-1;
    		qSort(a, low, high);
    		return a;
    	}
    	return null;
    }//end quicksort

    private static void qSort (double a[], int lo, int hi)
    {
    	/*if(lo >= hi)
    	{
    		return;
    	}*/
    	//get pivot val
    	int mid = lo + (hi - lo)/2;
    	double pivot = a[mid];
    	
    	int i = lo;
    	int j = hi;
    	
    	while (i <= j)
    	{
    		while(a[i] < pivot)
    		{
    			i++;
    		}
    		while(a[j] > pivot)
    		{
    			j--;
    		}
    		if(i <= j)
    		{
    			double temp = a[i];
    			a[i] = a[j];
    			a[j] = temp;
    			i++;
    			j--;
    		}
    	}
    	//recursively sort the two partitions
    	if(lo < j)
    	{
    		qSort(a, lo, j);
    	}
    	if(hi > i)
    	{
    		qSort(a, i, hi);
    	}
    }
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    //bottom up
    static double[] mergeSortIterative (double a[]) 
    {
    	if(a != null)
    	{
    		int size = a.length;
        	double [] auxiliary = new double[size];
        	for(int s = 1; s < size; s = s+s)
        	{
        		for(int l = 0; l < size - s; l += s+s)
        		{
        			merge(a, auxiliary, l, l+s-1, Math.min(l+s+s-1, size-1));
        		}
        	}
        	return a;
    	}
    	return null;
    }//end mergesortIterative*/
   
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    //top down
    static double[] mergeSortRecursive (double a[]) 
    {
    	if(a != null)
    	{
    		double [] aux = new double[a.length];
    		msort(a, aux, 0, a.length - 1);
    		return a;
    	}
    	return null;
    }//end mergeSortRecursive

    private static void msort(double [] a, double [] aux, int lo, int hi)
    {
    	if(hi <= lo) return;
    	int mid = lo + (hi - lo)/2;
    	msort(a, aux, lo, mid);
    	msort(a, aux, mid + 1, hi);
    	merge(a, aux, lo, mid, hi);
    }

    private static void merge(double [] a, double[] aux, int lo, int mid, int hi)
    {
    	for(int k = lo; k <= hi; k++)
    	{
    		aux[k] = a[k];
    	}
    	int i = lo, j = mid + 1;
    	for(int k = lo; k <= hi; k++)
    	{
    		if(i > mid)
    		{
    			a[k] = aux[j++];
    		}
    		else if(j > hi)
    		{
    			a[k] = aux[i++];
    		}
    		else if(aux[j] < aux[i])
    		{
    			a[k] = aux[j++];
    		}
    		else
    		{
    			a[k] = aux[i++];
    		}
    	}
    }
    
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[])
    {
    	if(a != null)
    	{
    		for (int i = 0; i < a.length; i++)
        	{
        		int min = i;
        		for (int j = i + 1; j < a.length; j++)
        		{
        			if(a[j] < a[min])
        			{
        				min = j;
        			}
        		}
        		double temp = a[min];
        		a[min] = a[i];
        		a[i] = temp;
        	}
        	return a;
    	}
    	return null;
    	
    }//end selectionsort

   


    /*public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }*/

 }//end class

