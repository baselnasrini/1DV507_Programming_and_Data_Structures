package mn223dn_assign4.binheap;


import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryIntHeapTest {

	@Test
	public void testSizeIsEmpty() {

		// Empty heap
				BinaryIntHeap bin = new BinaryIntHeap();
				assertTrue(bin.isEmpty());
				assertEquals(0, bin.size());
				
				// non empty heap
				BinaryIntHeap bin1 = new BinaryIntHeap();
				bin1.insert(10);
				assertFalse(bin1.isEmpty());
				assertEquals(1, bin1.size());
	}

	@Test
	public void testInsertAndPullHighest() {
		
		// test pullHighest()
		BinaryIntHeap bin = new BinaryIntHeap();
		bin.insert(6);
		bin.insert(12);
		bin.insert(7);
		
		assertEquals(3, bin.size());

		
		assertEquals(12, bin.pullHighest());
		assertEquals(2, bin.size());

		assertEquals(7, bin.pullHighest());
		assertEquals(1, bin.size());
		
		assertEquals(6, bin.pullHighest());
		assertEquals(0, bin.size());

		
		// the exception for (pullHighest()) if the heap is empty
		boolean res = false;
		try {
			bin.pullHighest();
		} catch (IndexOutOfBoundsException e) {
			res = true;
		}
		assertTrue(res);

	}

}
