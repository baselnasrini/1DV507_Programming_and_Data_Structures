package mn223dn_assign4.binheap;

import java.util.*;

public class BinaryIntHeap {
	private ArrayList<Integer> arr;

	// Constructs an empty heap
	public BinaryIntHeap() {
		arr = new ArrayList<Integer>();
		arr.add(null);
	}

	// Add in to heap
	public void insert(int input) {
		arr.add(null);
		int index = arr.size() - 1;

		while (index > 1 && getParent(index) < input) {

			arr.set(index, getParent(index));
			index = index / 2;

		}
		arr.set(index, input);
	}

	// Return and remove element with highest priority
	public int pullHighest() {

		if (arr.size() > 1) {
			int root = arr.get(1);

			int lastIndex = arr.size() - 1;
			int last = arr.remove(lastIndex);

			if (lastIndex > 1) {
				arr.set(1, last);
				percolationDown();
			}
			return root;
		}

		else
			throw new IndexOutOfBoundsException("The heap is empty");
	}

	// Current heap size
	public int size() {
		return arr.size() - 1;
	}

	// True if heap is empty
	public boolean isEmpty() {
		return arr.size() == 1;
	}
	
	@Override
	public String toString() {
		ArrayList<Integer> tmp = new ArrayList<Integer>(arr);
		tmp.remove(0);
		return Arrays.toString(tmp.toArray());
	}

	private void percolationDown() {
		int root = arr.get(1);

		int lastIndex = arr.size() - 1;

		int index = 1;
		boolean more = true;
		while (more) {
			int childIndex = index * 2;
			if (childIndex <= lastIndex) {

				int child = getLeftChild(index);

				if (index * 2 + 1 <= lastIndex && arr.get(index * 2 + 1) > child) {

					childIndex = index * 2 + 1;
					child = getRightChild(index);
				}

				if (child > root) {
					arr.set(index, child);
					index = childIndex;
				} else {
					more = false;
				}
			}

			else {
				more = false;
			}
		}

		arr.set(index, root);
	}

	private int getParent(int index) {
		return arr.get(index / 2);
	}

	private int getLeftChild(int index) {
		return arr.get(index * 2);
	}

	private int getRightChild(int index) {
		return arr.get(index * 2 + 1);
	}
}
