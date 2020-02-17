package mn223dn_assign3.sortingaAlgorithms;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import mn223dn_assign3.sortingaAlgorithms.SortingAlgorithms.alphabetic;

public class SortTest {

	@Test
	public void testInsertion() {
		
		int[] intArr = { 6, -7, 9, 2, -12, -2 };

		int[] intArrsorted = SortingAlgorithms.insertionSort(intArr) ;
		for (int i=0 ; i<intArrsorted.length-1 ; i++)
			assertTrue(intArrsorted[i]<intArrsorted[i+1]);

		String[] strArr = { "a", "y", "f", "b", "z" };

				
		String[] strArrSorted = SortingAlgorithms.insertionSort(strArr , new alphabetic());
		for (int i=0 ; i<strArrSorted.length-1 ; i++)
			assertTrue( strArrSorted[i].compareTo(strArrSorted[i+1]) < 0 );
		
		
	}
	
	@Test
	public void testMerge() {
		
		int[] intArr = { 6, -7, 9, 2, -12, -2 };

		int[] intArrsorted = SortingAlgorithms.mergeSort(intArr) ;
		for (int i=0 ; i<intArrsorted.length-1 ; i++)
			assertTrue(intArrsorted[i]<intArrsorted[i+1]);

		String[] strArr = { "a", "y", "f", "b", "z" };
				
		String[] strArrSorted = SortingAlgorithms.mergeSort(strArr , new alphabetic());
		for (int i=0 ; i<strArrSorted.length-1 ; i++)
			assertTrue( strArrSorted[i].compareTo(strArrSorted[i+1]) < 0 );
		
		
	}
	
}
