package mn223dn_assign2.queue;

import java.util.Iterator;

/**
 * 
 * The <code> Queue</code> interface represents a queue of objects.
 * <p>
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods <em>first</em> for returning the first item off the queue,
 * <em>last</em> for returning the last item of the queue, <em>isEmpty</em>
 * testing if the queue is empty, and iterating through
 * the items.
 *  
 *
 * @author Mohammed Basel Nasrini
 * @since 2017-02-13
 */

public interface Queue {

	/**
	 *  Returns the current size of this queue.
	 * @return the current size of this queue
	 */
	public int size();

	
	/**
	 * Returns true if this queue contains no elements.
	 * @return true if this queue contains no elements 
	 */
	public boolean isEmpty();

	/**
     * Adds the item <code>in</code> to the end of this queue.
     * @param element the item to add
     */
	public void enqueue(Object element);

	/**
     * Removes and returns the first item of this queue.
     * @return the first item of this queue
     */
	public Object dequeue(); 

	/**
     * Returns (without removing) the first item of this queue.
     * @return the first item of this queue
     */
	public Object first(); 

	/**
     * Returns (without removing) the last item on this queue.
     * @return the last item on this queue
     */
	public Object last(); 

	 /**
     * Returns a string representation of this queue.
     * @return string representation of this queue separated by spaces
     */
	public String toString();

	/**
     * Returns an iterator that iterates over all items in this queue.
     * @return an iterator that iterates over all items in this queue
     */
	public Iterator<Object> iterator();

}