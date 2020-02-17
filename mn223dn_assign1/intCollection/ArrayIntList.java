package mn223dn_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	public ArrayIntList() {
	}

	public void add(int n) {
		if (size == values.length)
			resize();
		values[size] = n;
		size++;
	}

	public void addAt(int n, int index)  {
		if ( index > size)
			throw new IndexOutOfBoundsException ("Index out of range.");
		
		if (size == values.length)
			resize();

		size++;

		for (int i = size - 1; i > index; i--)
			values[i] = values[i - 1];
		values[index] = n;
	}

	public void remove(int index) {
		if ( index > size-1 )
			throw new IndexOutOfBoundsException ("Index out of range.");
		
		for (int i=index; i<size; i++)
			values[i] = values[i++];
		
		size--;
	}

	public int get(int index) {
		if ( index > size-1 )
			throw new IndexOutOfBoundsException ("Index out of range.");

		return values[index];
	}
	
	public int indexOf(int n) {
		for(int i=0 ; i<size ; i++)
			if(values[i] == n)
				return i;
		return -1 ;
	}

	}