package mn223dn_assign4;

public class StringConcatenations {

	public static void main(String[] args) {
		String str = "";

		long after = 0;
		long average = 0;
		long conCount = 0;
		
		
		long before = System.nanoTime();
		while (average < 1000000000) {
			str += "a";
			after = System.nanoTime();
			average = after - before;
		}
		
		
		
		System.out.println("----------Plus Operator----------");
		average = 0;
		str = "";
		
		before = System.nanoTime();
		while (average < 1000000000) {
			str += "a";
			after = System.nanoTime();
			conCount += 1;
			average = after - before;
		}

		System.out.println("Short String number of concatenations: " + conCount);
		System.out.println("Short String Size:" + str.length());
		System.out.println();
		
		average = 0;
		conCount = 0;
		str = "";
		
		String longString = longString();

		before = System.nanoTime();
		while (average < 1000000000) {
			str += longString;
			after = System.nanoTime();
			conCount += 1;
			average = after - before;
		}

		System.out.println("Long String number of concatenations: " + conCount);
		System.out.println("Long String Size:" + str.length());
		System.out.println();

		System.out.println("----------String Builder----------");
		average = 0;
		conCount = 0;
		
		StringBuilder sb = new StringBuilder();

		before = System.nanoTime();
		while (average < 1000000000) {
			sb.append("a");
			sb.toString();
			after = System.nanoTime();
			conCount += 1;
			average = after - before;
		}

		System.out.println("Short String number of concatenations: " + conCount);

		System.out.println("Short String Size:" + sb.toString().length());

		System.out.println();
		average = 0;
		conCount = 0;
		sb = new StringBuilder();

		before = System.nanoTime();
		while (average < 1000000000) {
			sb.append(longString);
			sb.toString();
			after = System.nanoTime();
			conCount += 1;
			average = after - before;
		}

		System.out.println("Long String number of concatenations: " + conCount);

		System.out.println("Long String Size:" + sb.toString().length());

	}

	private static String longString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= 80; i++)
			sb.append("a");

		return sb.toString();
	}

}
