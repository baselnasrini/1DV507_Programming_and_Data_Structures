package mn223dn_assign3.count_words;

import java.util.*;

public class HashWordSet implements WordSet {
	private int sz;
	private Node[] buckets = new Node[8];

	@Override
	public Iterator<Word> iterator() {

		return new HashSetIterator();
	}

	class HashSetIterator implements Iterator<Word> {
		private int bucket;
		private Node current;

		public HashSetIterator() {
			current = null;
			bucket = -1;
		}

		@Override
		public boolean hasNext() {
			if (current != null && current.next != null) {
				return true;
			}
			for (int i = bucket + 1; i < buckets.length; i++) {
				if (buckets[i] != null) {
					return true;
				}
			}
			return false;
		}

		@Override
		public Word next() {
			if (current != null && current.next != null) {
				current = current.next;
			} else {
				do {
					bucket++;
					if (bucket == buckets.length) {
						throw new NoSuchElementException();
					}
					current = buckets[bucket];
				} while (current == null);
			}
			return current.value;
		}

	}

	@Override
	public String toString() {
		StringBuffer br = new StringBuffer();
		br.append("[");
		Iterator<Word> it = iterator();

		while (it.hasNext())
			br.append(it.next() + " ,");

		return br.toString();
	}

	@Override
	public void add(Word in) {
		int pos = getBucketNumber(in);
		Node node = buckets[pos]; // First node in list

		while (node != null) { // Search list
			if (node.value.equals(in))
				return; // Element found ==> return
			else
				node = node.next;
		}

		node = new Node(in); // Not found, add new node as first entry
		node.next = buckets[pos];
		buckets[pos] = node;
		sz++;
		if (sz == buckets.length)
			rehash(); // Rehash if needed

	}

	@Override
	public boolean contains(Word in) {
		int pos = getBucketNumber(in);
		Node node = buckets[pos];

		while (node != null) {
			if (node.value.equals(in))
				return true;
			else
				node = node.next;
		}
		return false;
	}

	@Override
	public int size() {
		return sz;
	}

	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2 * temp.length];
		sz = 0;

		for (Node n : temp) {
			if (n == null)
				continue;
			while (n != null) {
				add(n.value);
				n = n.next;
			}
		}
	}

	private int getBucketNumber(Word in) {

		int hc = in.hashCode(); // Use hashCode() from String class

		if (hc < 0)
			hc = -hc; // Make sure non..negative

		return hc % buckets.length; // Simple hash function

	}

	private class Node {

		Word value;
		Node next = null;

		public Node(Word in) {
			value = in;
		}

		public String toString() {
			return value.toString();
		}

	}

}
