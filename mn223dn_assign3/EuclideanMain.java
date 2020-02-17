package mn223dn_assign3;

public class EuclideanMain {

	public static void main(String[] args) {
		System.out.println(gcd(12,18));
		
		
	}
	
	
	
	public static int gcd(int a , int b){
		if (a == 0)
			return b;
		else if (b == 0)
			return a;
		else{
			return gcd(b, a%b);
		}		
	}

}
