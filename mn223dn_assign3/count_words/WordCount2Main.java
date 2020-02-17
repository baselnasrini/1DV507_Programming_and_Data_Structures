package mn223dn_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) throws IOException {

		String text = readFile("C:\\Users\\Basel Nasrini\\java_courses\\1DV507\\word.txt");

		WordSet hash = new HashWordSet();

		fillSet(text, hash);

		System.out.println("HashWordSet Size: " + hash.size());

		System.out.print("Hash Word Set:");

		Iterator<Word> it = hash.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ,");

		System.out.println();
		System.out.println();

		WordSet tree = new TreeWordSet();

		fillSet(text, tree);

		System.out.println("TreeWordSet Size: " + tree.size());

		System.out.print("Tree Word Set:");

		Iterator<Word> it1 = tree.iterator();
		while (it1.hasNext())
			System.out.print(it1.next() + " ,");

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

	public static void fillSet(String file, WordSet s) {
		int first = 0;
		int last = 0;

		for (int i = 0; i < file.length(); i++) {
			String w = null;

			if (Character.getNumericValue(file.charAt(i)) == -1) {
				int a = i;
				last = a;
				w = file.substring(first, last);
				s.add(new Word(w));
				first = a + 1;
			}
		}
	}

}
