package mn223dn_assign2.queue;

import java.util.Iterator;
/**
 * 
 * The <code> LinkedQueue</code> class represents a first-in-first-out (FIFO)
 * queue of objects.
 * <p>
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods <em>first</em> for returning the first item off the queue,
 * <em>last</em> for returning the last item of the queue, <em>isEmpty</em>
 * testing if the queue is empty, and iterating through
 * the items in FIFO order.
 *  
 * 
 *
 *
 * @author Mohammed Basel Nasrini
 * @since 2017-02-13
 */

public class LinkedQueue implements Queue {
	private int size = 0;
	private Node head , tail;

	/**
     * Creates an empty queue.
     */
	public LinkedQueue() {
		head = null;
		tail = null;
	}
	
	/**
	 * This returns the current size of the linked queue
	 * 
	 * @return the linked queue size
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if this queue contains no elements.
	 * @return true if this queue contains no elements 
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
     * Adds the item <code>in</code> to the end this queue.
     * @param in the item to add
     */
	public void enqueue(Object in) {
		if (head == null) {
			head = new Node(in);
			tail = head;
		} else {
			tail.next = new Node(in);
			tail = tail.next;
		}
		size++;
	}

	/**
     * Removes and returns the first item of this queue.
     * @return the first item of this queue
     * @throws IllegalArgumentException if this queue is empty
     */
	public Object dequeue() throws IllegalArgumentException {
		if (head == null)
			throw new IllegalArgumentException("This queue is empty");

		Object tmp = head.value;
		head = head.next;

		size--;
		return tmp;
	}

	/**
     * Returns (without removing)  the first item of this queue.
     * @return the first item of this queue
     * @throws IllegalArgumentException if this queue is empty
     */
	public Object first() throws IllegalArgumentException {
		if (head == null)
			throw new IllegalArgumentException("This queue is empty");

		return head.value;
	}

	/**
     * Returns the last item on this queue.
     * @return the last item on this queue
     * @throws IllegalArgumentException if this queue is empty
     */
	public Object last() throws IllegalArgumentException {
		if (tail == null)
			throw new IllegalArgumentException("This queue is empty");

		return tail.value;
	}

	 /**
     * Returns a string representation of this queue.
     * @return string representation of this queue separated by spaces
     */
	public String toString() {
		StringBuffer str = new StringBuffer();
		Node current = head;

		str.append("[ ");
		while (current != null) {
			str.append(current.value + " ");
			current = current.next;
		}
		str.append("]");

		return str.toString();

	}

	/**
     * Returns an iterator that iterates over all items in this queue.
     * @return an iterator that iterates over all items in this queue
     */
	public Iterator<Object> iterator() {
		return new ListIterator();
	}

	class ListIterator implements Iterator<Object> {
		private Node node = head;

		public Object next() {
			Object value = node.value;
			node = node.next;

			return value;
		}

		public boolean hasNext() {
			return node != null;
		}

		public void remove() {
			dequeue();
		}

	}

	private class Node {
		Object value;
		Node next = null;

		Node(Object in) {
			value = in;
		}
	}

}
