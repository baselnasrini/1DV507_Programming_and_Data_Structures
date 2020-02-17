package mn223dn_assign3.count_words;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeWordSet implements WordSet {
	private BST root = null;
	int sz = 0;
	String str = "";

	@Override
	public void add(Word word) {
		if (root == null) {
			root = new BST(word);
			sz++;
		} else
			root.add(word);
	}

	@Override
	public boolean contains(Word word) {

		return root.contains(word);
	}

	@Override
	public int size() {
		return sz;
	}

	@Override
	public Iterator<Word> iterator() {
		str = "";

		root.print();
		String[] stringArr = str.toString().split(",");
		ArrayList<Word> wordList = new ArrayList<Word>();

		for (String a : stringArr)
			wordList.add(new Word(a));
		return wordList.iterator();
	}

	@Override
	public String toString() {
		// Iterator<Word> it = iterator();
		str = "";

		str += "[ ";
		//
		// while (it.hasNext())
		// str += it.next() + " ,";
		//
		root.print();
		str += " ]";

		return str;
	}

	private class BST { // private inner class
		Word value;
		BST left = null;
		BST right = null;

		BST(Word val) {
			value = val;
		}

		void add(Word n) {

			if (n.compareTo(this.value) < 0) { // add to left branch
				if (left == null) {
					left = new BST(n);
					sz++;
				} else
					left.add(n);
			} else if (n.compareTo(this.value) > 0) { // add to right branch
				if (right == null) {
					right = new BST(n);
					sz++;
				} else
					right.add(n);
			}
		}

		boolean contains(Word n) { // recursive look up

			if (n.compareTo(this.value) < 0) { // search left branch
				if (left == null)
					return false;
				else
					return left.contains(n);
			} else if (n.compareTo(this.value) > 0) { // search right branch
				if (right == null)
					return false;
				else
					return right.contains(n);
			}
			return true; // Found!
		}

		void print() {

			if (left != null)
				left.print();

			str += "," + value.toString();

			if (right != null)
				right.print();

			// StringBuilder sb = new StringBuilder();
			// sb.append("[");
			//
			// String w = "";
			//
			// if (left != null) // visit left child
			// left.print();
			//
			// w += " , " + value; // in..order print value
			//
			// if (right != null) // visit right child
			// right.print();
			//
			// sb.append("]");
			// return w;
		}
	}

}
