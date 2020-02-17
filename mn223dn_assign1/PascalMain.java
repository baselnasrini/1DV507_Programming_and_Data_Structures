package mn223dn_assign1;

public class PascalMain {
	public static void main(String[] args) {

		for (int a : pascalTriangle(6))
			System.out.print(a + "  ");

	}

	private static int[] pascalTriangle(int n) {

		int[] pt = new int[n + 1];
		if (n == 0) {
			pt[0] = 1;
			return pt;
		}

		pt[0] = pt[n] = 1;

		int[] ppt = pascalTriangle(n - 1);
		
		for (int i = 1; i < ppt.length; i++) {
			pt[i] = ppt[i - 1] + ppt[i];
		}

		return pt;
	}
}
