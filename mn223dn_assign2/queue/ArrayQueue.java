package mn223dn_assign2.queue;

import java.util.Iterator;

public class ArrayQueue implements Queue {

	private final int DEFAULT_CAPACITY = 4;
	private int first, last, size;
	private Object[] queue;

	// Create an empty queue
	public ArrayQueue() {
		first = size = 0;
		last = -1;
		queue = new Object[DEFAULT_CAPACITY];
	}

	// Add an element to the end of the queue.
	public void enqueue(Object element) {
		if (size == queue.length)
			resize();

		
		last = (last + 1) % queue.length;
		
		queue[last] = element;

		size++;
	}

	// Removes the element at the first of the queue and return it.
	public Object dequeue() throws IllegalArgumentException {
		if (isEmpty())
			throw new IllegalArgumentException("The queue is empty");

		Object result = queue[first];
		queue[first] = null;

		first = (first + 1) % queue.length;

		size--;
		return result;
	}

	// Return the first element
	public Object first() throws IllegalArgumentException {
		if (isEmpty())
			throw new IllegalArgumentException("The queue is empty");

		return queue[first];
	}

	public Object last() throws IllegalArgumentException {
		if (isEmpty())
			throw new IllegalArgumentException("The queue is empty");
//		System.out.println("Last: " + last);
		return queue[last];
	}

	// Return true if this queue is empty.
	public boolean isEmpty() {
		return (size == 0);
	}

	// Return the number of elements currently in this queue.
	public int size() {
		return size;
	}

	// Return a string representation of the queue content.
	public String toString() {
		String str = "[ ";
		
		int i = 0;
		int j = first;
		
		while (i < queue.length) {
			if (queue[i] != null) {
				str += queue[j].toString() + " ";
				j = (j + 1) % queue.length;
			}
			i++;
		}
		str += "]";
		
//		for (int i = first; i < size ; i++) {
//			str += queue[first] + " ";
//			first = (first + 1) % queue.length;
//		}
//		
//		str += "]";
		
//		Iterator<Object> it = this.iterator();
//		while (it.hasNext()){
////			System.out.println("asd" + first);
//			str += queue[first] + " ";
//			first = (first + 1) % queue.length;
//
//		}
//		str += "]";
		return str;
	}

	public Iterator<Object> iterator() {
		return new ArrayIterator();
	}

	class ArrayIterator implements Iterator<Object> {
		private int count = first;
		
		public Object next() {
			Object val = queue[count++];
			
			return val;
//			 Object n = queue[(first + currentOffset) % queue.length];
//	            currentOffset += 1;
//	            return n;
		}

		public boolean hasNext() {
			return count < first + size;
//			return currentOffset < size;
		}

	}

	// Create a new array to store the contents of the queue with
	// double the capacity of the old one.
	private void resize() {
		Object[] tmp = new Object[queue.length * 2];

		for (int i = 0; i < size; i++) {
			tmp[i] = queue[first];
			first = (first + 1) % queue.length;
		}
//		System.arraycopy(queue,0,tmp,0,queue.length); 

		first = 0;
		last = size-1;
		queue = tmp;
	}
}