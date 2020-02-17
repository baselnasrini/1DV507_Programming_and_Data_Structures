package mn223dn_assign3.sortingaAlgorithms;


import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {

	public static void main(String[] args) {

		int[] intArr = { 6, -7, 9, 2, -12, -2 };

		System.out.print("Integer Insertion Sort: ");
		for (int i : insertionSort(intArr))
			System.out.print(i + " ");

		System.out.println();
		System.out.println();

		System.out.print("Integer Merge Sort: ");

		for (int i : mergeSort(intArr))
			System.out.print(i + " ");

		System.out.println();
		System.out.println();

		String[] strArr = { "a", "y", "f", "b", "z" };

		System.out.print("String Insertion Sort: ");

		for (String i : insertionSort(strArr, new alphabetic()))
			System.out.print(i + "  ");

		System.out.println();
		System.out.println();

		System.out.print("String Merge Sort: ");
		for (String i : mergeSort(strArr, new alphabetic()))
			System.out.print(i + "  ");

	}

	public static int[] insertionSort(int[] in) {
		int[] tmp = new int[in.length];

		System.arraycopy(in, 0, tmp, 0, in.length);

		for (int i = 0; i < tmp.length - 1; i++) {

			if (tmp[i] > tmp[i + 1]) {

				for (int j = i; j >= 0; j--) {

					if (tmp[j] > tmp[j + 1]) {

						int tmpInt = tmp[j + 1];
						tmp[j + 1] = tmp[j];
						tmp[j] = tmpInt;
					}
				}
			}

		}
		return tmp;
	}

	public static String[] insertionSort(String[] in, Comparator<String> c) {
		String[] tmp = new String[in.length];

		System.arraycopy(in, 0, tmp, 0, in.length);

		for (int i = 0; i < tmp.length - 1; i++) {

			if (tmp[i].compareTo(tmp[i + 1]) > 0) {

				for (int j = i; j >= 0; j--) {

					if (tmp[j].compareTo(tmp[j + 1]) > 0) {

						String tmpString = tmp[j + 1];
						tmp[j + 1] = tmp[j];
						tmp[j] = tmpString;
					}
				}
			}
		}
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
