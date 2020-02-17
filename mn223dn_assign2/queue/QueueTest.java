package mn223dn_assign2.queue;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testSizeIsEmpty() {

		// test the size and (isEmpty) of an empty queue
		Queue a = linkedBuild(0);
		assertEquals(0, a.size());
		assertTrue(a.isEmpty());

		// test the size and (isEmpty) after enqueue
		Queue b = linkedBuild(2);
		assertEquals(2, b.size());
		assertFalse(b.isEmpty());

		// test the size after dequeue
		b.dequeue();
		assertEquals(1, b.size());

		// test the size and (isEmpty) of an empty queue
		Queue c = arrayBuild(0);
		assertEquals(0, c.size());
		assertTrue(c.isEmpty());

		// test the size and (isEmpty) after enqueue
		Queue d = linkedBuild(2);
		assertEquals(2, d.size());
		assertFalse(d.isEmpty());

		// test the size after dequeue
		d.dequeue();
		assertEquals(1, d.size());

	}

	@Test
	public void testEnqueueLast() {

		Queue a = new LinkedQueue();
		int size = 2;

		Queue b = new ArrayQueue();

		// test if the enqueue is done in the last of the queue
		for (int i = 0; i < size; i++) {
			a.enqueue(i);
			assertEquals(i, a.last());

			b.enqueue(i);
			assertEquals(i, b.last());
		}

		// test if the enqueue increase the size
		assertEquals(size, a.size());

		// test the exception for (last()) if the queue is empty
		Queue c = linkedBuild(0);
		boolean res = false;
		try {
			c.last();
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);

		// test the exception for (last()) if the queue is empty
		Queue d = arrayBuild(0);
		boolean resu = false;
		try {
			d.last();
		} catch (IllegalArgumentException e) {
			resu = true;
		}
		assertTrue(resu);

		// test the last object after many enqueues and dequeues
		Queue e = arrayBuild(4);
		e.dequeue();
		e.enqueue(100);
		assertEquals(100, e.last());

	}

	@Test
	public void testDequeueFirst() {
		int size = 50;
		int size1 = 50;

		Queue a = linkedBuild(size);
		Queue b = arrayBuild(size);

		for (int i = 0; i < size; i++) {
			// test if the dequeued object is the first one
			assertEquals(a.first(), a.dequeue());

			// test if the dequeue reduce the size
			assertEquals(a.size(), --size);

			// test if the dequeued object is the first one
			assertEquals(b.first(), b.dequeue());

			// test if the dequeue reduce the size
			assertEquals(b.size(), --size1);
		}

		// test the exception of the dequeue if the queue is empty
		Queue c = linkedBuild(0);
		boolean res = false;
		try {
			c.dequeue();
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);

		// test the exception of the first if the queue is empty
		res = false;
		try {
			c.first();
		} catch (IllegalArgumentException e) {
			res = true;
		}
		assertTrue(res);

		// test the exception of the dequeue if the queue is empty
		Queue d = arrayBuild(0);
		boolean resu = false;
		try {
			d.dequeue();
		} catch (IllegalArgumentException e) {
			resu = true;
		}
		assertTrue(resu);

		// test the exception of the dequeue if the queue is empty
		resu = false;
		try {
			d.first();
		} catch (IllegalArgumentException e) {
			resu = true;
		}
		assertTrue(resu);

		// test the first object after many enqueues and dequeues
		Queue e = arrayBuild(4);
		e.dequeue();
		e.enqueue(100);
		assertEquals(1, e.first());

	}

	// test toSting method
	@Test
	public void testToString() {
		Queue a = new LinkedQueue();
		assertEquals(a.toString(), "[ ]");

		a = linkedBuild(2);
		assertEquals(a.toString(), "[ 0 1 ]");

		Queue b = new ArrayQueue();
		assertEquals(b.toString(), "[ ]");

		b = arrayBuild(2);
		assertEquals(b.toString(), "[ 0 1 ]");

	}

	@Test
	public void testIterator() {
		Queue a = new LinkedQueue();
		Iterator<Object> it = a.iterator();
		assertFalse(it.hasNext());

		a = linkedBuild(2);
		it = a.iterator();

		assertTrue(it.hasNext());
		assertEquals(it.next(), a.first());

		Queue b = new ArrayQueue();
		Iterator<Object> it1 = b.iterator();
		assertFalse(it1.hasNext());

		b = arrayBuild(2);
		it1 = b.iterator();

		assertTrue(it1.hasNext());
		assertEquals(it1.next(), b.first());
	}

	// Creates an array based queue
	private Queue arrayBuild(int size) {
		Queue que = new ArrayQueue();
		for (int i = 0; i < size; i++)
			que.enqueue(i);
		return que;
	}

	// Creates a linked list based queue
	private Queue linkedBuild(int size) {
		Queue que = new LinkedQueue();
		for (int i = 0; i < size; i++)
			que.enqueue(i);
		return que;
	}
}
