package mn223dn_assign1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	public ArrayIntStack (){
		
	}
	
	public void push(int n) {
		if (size == values.length)
			resize();
		
		values[size] = n ;
		
		size++;
	}

	public int pop()  {
		if (isEmpty())
			throw new IndexOutOfBoundsException ("The stack is empty.");
		
		int temp = values[size-1];
		
		size--;
		
		return temp;
	}

	public int peek() {
		if (isEmpty())
			throw new IndexOutOfBoundsException ("The stack is empty.");

		return values[size-1];
	}

}
