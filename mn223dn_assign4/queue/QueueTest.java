package mn223dn_assign4.queue;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

public class QueueTest {

	@Test
	public void testSizeIsEmpty() {

		// test the size and (isEmpty) of an empty queue
		Queue<Integer> a = new LinkedQueue<Integer>();
		assertEquals(0, a.size());
		assertTrue(a.isEmpty());

		Queue<String> b = new LinkedQueue<String>();
		assertEquals(0, b.size());
		assertTrue(b.isEmpty());

		// test the size and (isEmpty) after enqueue
		Queue<Integer> c = new LinkedQueue<Integer>();
		c.enqueue(1);
		assertEquals(1, c.size());
		assertFalse(c.isEmpty());

		Queue<String> d = new LinkedQueue<String>();
		d.enqueue("a");
		assertEquals(1, d.size());
		assertFalse(d.isEmpty());

		// test the size after dequeue
		c.dequeue();
		assertEquals(0, c.size());

		d.dequeue();
		assertEquals(0, d.size());

	}

	@Test
	public void testEnqueueLast() {

		Queue<Integer> a = new LinkedQueue<Integer>();
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);

		// test if the enqueue is done in the last of the queue
		assertEquals((Integer) 3, a.last());

		// test if the enqueue increase the size
		assertEquals(3, a.size());

		Queue<String> b = new LinkedQueue<String>();
		b.enqueue("a");
		b.enqueue("b");
		b.enqueue("c");

		// test if the enqueue is done in the last of the queue
		assertEquals("c", b.last());

		// test if the enqueue increase the size
		assertEquals(3, b.size());

		// test the exception for (last()) if the queue is empty
		Queue<Integer> c = new LinkedQueue<Integer>();
		boolean res = false;
		try {
			c.last();
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);

		Queue<String> d = new LinkedQueue<String>();
		boolean resu = false;
		try {
			d.last();
		} catch (IllegalArgumentException e) {
			resu = true;
		}
		assertTrue(resu);

	}

	@Test
	public void testDequeueFirst() {
		Queue<Integer> a = new LinkedQueue<Integer>();
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);

		// test if the dequeued object is the first one
		assertEquals(a.first(), a.dequeue());

		// test if the dequeue reduce the size
		assertEquals(a.size(), 2);

		Queue<String> b = new LinkedQueue<String>();
		b.enqueue("a");
		b.enqueue("b");
		b.enqueue("c");

		// test if the dequeued object is the first one
		assertEquals(b.first(), b.dequeue());

		// test if the dequeue reduce the size
		assertEquals(b.size(), 2);

		// test the exception of the dequeue if the queue is empty
		Queue<Integer> c = new LinkedQueue<Integer>();
		boolean res = false;
		try {
			c.dequeue();
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);
		
		Queue<String> d = new LinkedQueue<String>();
		boolean resu = false;
		try {
			d.dequeue();
		} catch (IllegalArgumentException e) {
			resu = true;
		}
		assertTrue(resu);
		

		// test the exception of the first if the queue is empty
		res = false;
		try {
			c.first();
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);
		
		
		resu = false;
		try {
			d.first();
		} catch (IllegalArgumentException e) {
			resu = true;
		}
		assertTrue(resu);

	}

	// test toSting method
	@Test
	public void testToString() {
		Queue<Integer> a = new LinkedQueue<Integer>();
		assertEquals(a.toString(), "[ ]");

		a.enqueue(0);
		a.enqueue(1);
		assertEquals(a.toString(), "[ 0 1 ]");
		
		
		Queue<String> b = new LinkedQueue<String>();
		assertEquals(b.toString(), "[ ]");
		
		b.enqueue("a");
		b.enqueue("b");
		assertEquals(b.toString(), "[ a b ]");
		
	}

	@Test
	public void testIterator() {
		Queue<Integer> a = new LinkedQueue<Integer>();
		Iterator<Integer> it = a.iterator();
		assertFalse(it.hasNext());

		a.enqueue(1);
		it = a.iterator();

		assertTrue(it.hasNext());
		assertEquals(it.next(), a.first());
		
		Queue<String> b = new LinkedQueue<String>();
		Iterator<String> its = b.iterator();
		assertFalse(its.hasNext());

		b.enqueue("a");
		its = b.iterator();

		assertTrue(its.hasNext());
		assertEquals(its.next(), b.first());
		

	}

}
