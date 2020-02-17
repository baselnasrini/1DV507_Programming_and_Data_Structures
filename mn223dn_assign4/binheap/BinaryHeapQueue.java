package mn223dn_assign4.binheap;

import java.util.*;


public class BinaryHeapQueue implements PriorityQueue {

	private ArrayList<Task> arr;

	// Constructs an empty heap
	public BinaryHeapQueue() {
		arr = new ArrayList<Task>();
		arr.add(null);
	}

	// Add input to heap
	public void insert(Task input) {
		arr.add(null);
		int index = arr.size() - 1;

		while (index > 1 && getParent(index).getPriority() < input.getPriority()) {

			arr.set(index, getParent(index));
			index = index / 2;

		}
		arr.set(index, input);
	}

	// Return the element with the highest priority
	public Task peekHighest() {
		if (arr.size() > 1)
			return arr.get(1);
		else {
			throw new IndexOutOfBoundsException("The heap is empty");
		}
	}

	// Return and remove element with the highest priority
	public Task pullHighest() {

		if (arr.size() > 1) {

			Task root = arr.get(1);

			int lastIndex = arr.size() - 1;
			Task last = arr.remove(lastIndex);

			if (lastIndex > 1) {
				arr.set(1, last);
				percolationDown();
			}
			return root;
		}

		else
			throw new IndexOutOfBoundsException("The heap is empty");
	}

	public boolean contains(Task t) {
		ArrayList<Task> tmp = new ArrayList<Task>(arr);
		tmp.remove(0);
		for (int i = 0 ; i<tmp.size() ; i++){
			if (tmp.get(i).equals(t))
				return true;
		}
		return false;
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

		ArrayList<Task> tmp = new ArrayList<Task>(arr);
		tmp.remove(0);
		return Arrays.toString(tmp.toArray());
	}

	private void percolationDown() {
		Task root = arr.get(1);

		int lastIndex = arr.size() - 1;

		int index = 1;
		boolean more = true;
		while (more) {
			int childIndex = index * 2;
			if (childIndex <= lastIndex) {

				Task child = getLeftChild(index);

				if (index * 2 + 1 <= lastIndex && arr.get(index * 2 + 1).getPriority() > child.getPriority()) {

					childIndex = index * 2 + 1;
					child = getRightChild(index);
				}

				if (child.getPriority() > root.getPriority()) {
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

	private Task getParent(int index) {
		return arr.get(index / 2);
	}

	private Task getLeftChild(int index) {
		return arr.get(index * 2);
	}

	private Task getRightChild(int index) {
		return arr.get(index * 2 + 1);
	}

}
