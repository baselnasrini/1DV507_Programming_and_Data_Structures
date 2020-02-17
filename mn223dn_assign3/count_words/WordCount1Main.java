package mn223dn_assign3.count_words;

import java.io.*;
import java.util.*;

public class WordCount1Main {

	public static void main(String[] args) throws IOException {

		String text = readFile("C:\\Users\\Basel Nasrini\\java_courses\\1DV507\\word.txt");

		Set<Word> hashSet = hashSet(text);

		System.out.println("Hash Set Size: " + hashSet.size());

		System.out.println(hashSet);

		Set<Word> treeSet = treeSet(text);

		System.out.println("Tree Set Size: " + treeSet.size());

		System.out.println(treeSet);

	}

	public static String readFile(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(path);
		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {
			String line = scan.nextLine();

			if (!"".equals(line))
				sb.append(line + "\n");
		}
		scan.close();
		return sb.toString();
	}

	public static Set<Word> hashSet(String text) {
		Set<Word> hashSet = new HashSet<Word>();
		int first = 0;
		int last = 0;

		for (int i = 0; i < text.length(); i++) {
			String w = null;

			if (Character.getNumericValue(text.charAt(i)) == -1) {
				int a = i;
				last = a;
				w = text.substring(first, last);
				hashSet.add(new Word(w));
				first = a + 1;
			}
		}
		return hashSet;
	}

	public static Set<Word> treeSet(String text) {
		Set<Word> treeSet = new TreeSet<Word>();
		int first = 0;
		int last = 0;

		for (int i = 0; i < text.length(); i++) {
			String w = null;

			if (Character.getNumericValue(text.charAt(i)) == -1) {
				int a = i;
				last = a;
				w = text.substring(first, last);
				treeSet.add(new Word(w));
				first = a + 1;
			}
		}
		return treeSet;
	}

}