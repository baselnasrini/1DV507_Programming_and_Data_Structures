package mn223dn_assign4;

import java.util.*;

public class SortingAlgorithms {
	public static void main(String[] args) {

		int[] intArr = newIntArr();
		String[] strArr = newStrArr();
		long after = 0;
		long average = 0;
		long sortCount = 0;

		long before = System.nanoTime();
		while (average < 1000000000) {
			insertionSort(intArr);
			after = System.nanoTime();
			average = after - before;
		}
		average = 0;

		System.out.println("--------------- Integer Array ---------------");

		before = System.nanoTime();
		while (average < 1000000000) {
			insertionSort(intArr);
			after = System.nanoTime();
			sortCount += 400;
			average = after - before;
		}
		System.out.println("Insertion Sort: " + sortCount);

		average = 0;
		sortCount = 0;

		before = System.nanoTime();
		while (average < 1000000000) {
			doMergeSort(intArr);
			after = System.nanoTime();
			sortCount += 400;
			average = after - before;
		}

		System.out.println("Merge     Sort: " + sortCount);

		sortCount = 0;
		average = 0;
		System.out.println("\n--------------- String Array ---------------");

		Comparator<String> c = new alphabetic();

		before = System.nanoTime();
		while (average < 1000000000) {
			insertionSort(strArr, c);
			after = System.nanoTime();
			sortCount += 400;
			average = after - before;
		}
		System.out.println("Insertion Sort: " + sortCount);

		sortCount = 0;
		average = 0;

		before = System.nanoTime();
		while (average < 1000000000) {
			doMergeSort(strArr, c);
			after = System.nanoTime();
			sortCount += 400;
			average = after - before;
		}
		System.out.println("Merge     Sort: " + sortCount);

	}

	public static int[] newIntArr() {

		int[] intArr = new int[400];

		Random rn = new Random();

		for (int i = 0; i < intArr.length; i++)
			intArr[i] = rn.nextInt();

		return intArr;
	}

	public static String[] newStrArr() {
		String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();

		String[] strArr = new String[400];

		for (int i = 0; i < strArr.length; i++) {
			String str = "";

			for (int j = 0; j < 10; j++) {
				str += Character.toString(a.charAt(rnd.nextInt(a.length())));
			}

			strArr[i] = str;

		}
		return strArr;
	}

	public static int[] insertionSort(int[] in) {
		int[] tmp = new int[in.length];

		System.arraycopy(in, 0, tmp, 0, in.length);

		for (int i = 1; i < tmp.length; i++) {

			for (int j = i; j > 0; j--) {

				if (tmp[j] < tmp[j - 1]) {

					int tmpInt = tmp[j];
					tmp[j] = tmp[j - 1];
					tmp[j - 1] = tmpInt;
				}
			}

		}
		return tmp;
	}

	public static String[] insertionSort(String[] in, Comparator<String> c) {
		String[] tmp = new String[in.length];

		System.arraycopy(in, 0, tmp, 0, in.length);

		for (int i = 1; i < tmp.length; i++) {

			for (int j = i; j > 0; j--) {

				if (tmp[j - 1].compareTo(tmp[j]) > 0) {

					String tmpString = tmp[j];
					tmp[j] = tmp[j - 1];
					tmp[j - 1] = tmpString;
				}
			}
		}
		return tmp;
	}

	public static int[] doMergeSort(int[] in) {
		int[] tmp = new int[in.length];
		System.arraycopy(in, 0, tmp, 0, in.length);

		mergeSort(tmp);
		return tmp;
	}

	public static int[] mergeSort(int[] in) {

		if (in.length <= 1) {
			return in;
		}

		int[] first = new int[in.length / 2];
		int[] second = new int[in.length - first.length];
		System.arraycopy(in, 0, first, 0, first.length);
		System.arraycopy(in, first.length, second, 0, second.length);

		mergeSort(first);
		mergeSort(second);

		merge(first, second, in);
		return in;
	}

	private static void merge(int[] first, int[] second, int[] result) {
		int iFirst = 0;
		int iSecond = 0;
		int iMerged = 0;

		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) {
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}

	public static String[] doMergeSort(String[] in, Comparator<String> c) {
		String[] tmp = new String[in.length];
		System.arraycopy(in, 0, tmp, 0, in.length);

		mergeSort(tmp, c);
		return tmp;
	}

	public static String[] mergeSort(String[] in, Comparator<String> c) {

		if (in.length <= 1) {
			return in;
		}

		String[] first = new String[in.length / 2];
		String[] second = new String[in.length - first.length];
		System.arraycopy(in, 0, first, 0, first.length);
		System.arraycopy(in, first.length, second, 0, second.length);

		Arrays.sort(first, new alphabetic());
		Arrays.sort(second, new alphabetic());

		mergeSort(first, new alphabetic());
		mergeSort(second, new alphabetic());

		merge(first, second, in);
		return in;
	}

	private static void merge(String[] first, String[] second, String[] result) {
		int iFirst = 0;
		int iSecond = 0;
		int iMerged = 0;

		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}

	public static class alphabetic implements Comparator<String> {
		// Returns a negative integer , zero , or a positive integer as
		// s1 is less than, equal to, or greater than s2.

		@Override
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}

	}

}