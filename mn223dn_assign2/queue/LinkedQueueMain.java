package mn223dn_assign2.queue;

import java.util.Iterator;

public class LinkedQueueMain {

	public static void main(String[] args) {

		Queue a = new LinkedQueue();
//		a.dequeue();
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);

		System.out.println("List: " + a);

		System.out.println("Is Empty: " + a.isEmpty());
		System.out.println("First: " + a.first());
		System.out.println("Last: " + a.last());
		System.out.println("Dequeue: " + a.dequeue());

		Iterator<Object> it = a.iterator();
		while (it.hasNext())
			System.out.print("  " + it.next());

	}
}
