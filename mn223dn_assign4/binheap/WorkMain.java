package mn223dn_assign4.binheap;


public class WorkMain {

	public static void main(String[] args) {

		PriorityQueue bin = new BinaryHeapQueue ();
		
		System.out.println("Is Empty before adding:" + bin.isEmpty());

		bin.insert(new WorkTask (12,"Twelve"));
		bin.insert(new WorkTask (7,"Seven"));
		bin.insert(new WorkTask (6,"Six"));
		bin.insert(new WorkTask (10,"Ten"));
		bin.insert(new WorkTask (8,"Eight"));
		bin.insert(new WorkTask (20,"Twenty"));
		
		System.out.println(bin);
		System.out.println("Is Empty after adding:" + bin.isEmpty());

		Task t = new WorkTask (20,"Twenty") ;
						
		System.out.println("Contain:" + bin.contains(t));
		System.out.println();
		System.out.println("Peek:" + bin.peekHighest());

		
		System.out.println(bin);
		System.out.println(bin.pullHighest());
		System.out.println(bin);
		System.out.println(bin.pullHighest());
		System.out.println(bin);
		System.out.println(bin.pullHighest());
		System.out.println(bin);
		System.out.println(bin.pullHighest());
		System.out.println(bin);
		System.out.println(bin.pullHighest());
		System.out.println(bin);
		System.out.println(bin.pullHighest());
		System.out.println(bin);
		System.out.println(bin.pullHighest());

		

	}

}
