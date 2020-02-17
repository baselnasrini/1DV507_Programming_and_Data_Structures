package mn223dn_assign3.count_words;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IdentyfyWordsMain {

	public static void main(String[] args) throws IOException {

		String text = readFile("C:\\Users\\Basel Nasrini\\java_courses\\1DV507\\HistoryOfProgramming.txt");

		writeFile("C:\\Users\\Basel Nasrini\\java_courses\\1DV507\\word.txt", text);

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

	public static void writeFile(String path, String text) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		
		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == '\n')
				writer.newLine();
			else if (Character.isLetter(text.charAt(i)) || Character.isWhitespace(text.charAt(i)))
				writer.write(text.charAt(i));
			
		}
		
		
		writer.close();
	}

}
