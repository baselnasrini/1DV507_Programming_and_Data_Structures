package mn223dn_assign1;

public class SumMain {

	public static void main(String[] args) {

		System.out.println(sum(1, 6));
	}

	public static int sum(int st, int en) {
		if (st == en)
			return en;
		else
			return sum(st, ((st + en) / 2)) + sum((((st + en) / 2) + 1), en);
	}

}
