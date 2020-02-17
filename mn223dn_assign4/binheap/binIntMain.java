package mn223dn_assign4.binheap;


public class binIntMain {

	public static void main(String[] args) {

		BinaryIntHeap bin = new BinaryIntHeap ();
		
		bin.insert(6);
		bin.insert(12);
		bin.insert(7);
		bin.insert(10);
		bin.insert(8);
		bin.insert(20);
		
		System.out.println(bin.size());
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
