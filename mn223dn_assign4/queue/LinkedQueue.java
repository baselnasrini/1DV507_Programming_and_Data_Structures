package mn223dn_assign4.queue;

import java.util.Iterator;


public class LinkedQueue<T> implements Queue<T> {
	private int size = 0;
	private Node head, tail;

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
	 * 
	 * @return true if this queue contains no elements
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Adds the item <code>in</code> to the end this queue.
	 * 
	 * @param in
	 *            the item to add
	 */
	public void enqueue(T in) {
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
	 * 
	 * @return the first item of this queue
	 * @throws IllegalArgumentException
	 *             if this queue is empty
	 */
	public T dequeue() throws IllegalArgumentException {
		if (head == null)
			throw new IllegalArgumentException("This queue is empty");

		T tmp = head.value;
		head = head.next;

		size--;
		return tmp;
	}

	/**
	 * Returns (without removing) the first item of this queue.
	 * 
	 * @return the first item of this queue
	 * @throws IllegalArgumentException
	 *             if this queue is empty
	 */
	public T first() throws IllegalArgumentException {
		if (head == null)
			throw new IllegalArgumentException("This queue is empty");

		return head.value;
	}

	/**
	 * Returns the last item on this queue.
	 * 
	 * @return the last item on this queue
	 * @throws IllegalArgumentException
	 *             if this queue is empty
	 */
	public T last() throws IllegalArgumentException {
		if (tail == null)
			throw new IllegalArgumentException("This queue is empty");

		return tail.value;
	}

	/**
	 * Returns a string representation of this queue.
	 * 
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
	 * 
	 * @return an iterator that iterates over all items in this queue
	 */
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	class ListIterator implements Iterator<T> {
		private Node node = head;

		public T next() {
			T value = node.value;
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
		T value;
		Node next = null;

		Node(T in) {
			value = in;
		}
	}

}
