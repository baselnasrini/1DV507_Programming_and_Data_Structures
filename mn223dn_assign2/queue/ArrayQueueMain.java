package mn223dn_assign2.queue;

import java.util.Iterator;

public class ArrayQueueMain {

	public static void main(String[] args) {
		
		Queue a = new ArrayQueue ();
		
		
	
		for (int i =0 ; i<4 ; i++)
			a.enqueue(i);
		
		System.out.println("First: " + a.first());
		System.out.println("Last: " + a.last());
		System.out.println("Size: " + a.size());
		System.out.println("List: " + a);
		
		System.out.println("Dequeue: "	+a.dequeue());

		System.out.println("First: " + a.first());
		System.out.println("Last: " + a.last());
		System.out.println("Size: " + a.size());
		System.out.println("List: " + a);
		
		
			a.enqueue("a");
			a.enqueue("b");
		
		
		System.out.println("First: " + a.first());
		System.out.println("Last: " + a.last());
		System.out.println("Size: " + a.size());
		System.out.println("List: " + a);

		
		Iterator<Object> it = a.iterator();
		
		while (it.hasNext())
			System.out.print("  " + it.next());
		
		
		
		Queue s = new ArrayQueue();
		
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		s.enqueue(4);
		System.out.println("List: " + s);
		s.dequeue();
		s.enqueue(100);
		System.out.println("List: " + s);


		
		
	}

}
