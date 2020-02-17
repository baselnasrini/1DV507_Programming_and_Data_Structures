package mn223dn_assign1.intCollection;

public class CollectionMain {

	public static void main(String[] args) {

		ArrayIntList arr = new ArrayIntList();

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);

		arr.addAt(5, 1);
		// arr.addAt(8, 9);
		System.out.println(arr.toString());

		System.out.println("Is Empty: " + arr.isEmpty());

		arr.remove(1);
		// arr.remove(15);'
		
		System.out.println(arr.toString());

		System.out.println("Array Size: " + arr.size());

		System.out.println("Get: " + arr.get(0));
		// arr.get(20);

		System.out.println("Index of: " + arr.indexOf(6));
		System.out.println("Index of: " + arr.indexOf(2));

		System.out.println(arr.toString());

		
		
		System.out.println("*****Stack*******");
		ArrayIntStack stack = new ArrayIntStack();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack.toString());

		System.out.println("Stack Size: " + stack.size());

		System.out.println("Peek: "+stack.peek());

		System.out.println("Stack Size after peek: " + stack.size());

		System.out.println("Pop: "+stack.pop());

		System.out.println("Stack Size after pop: " + stack.size());

		System.out.println("Stack after pop: "+stack.toString());

	}

}
