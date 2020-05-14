import java.util.Scanner;

public class lab4d {
public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n>=0)
		System.out.println(recursiveSum(n));
		}

	public static int recursiveSum(int n) {
		String num = String.valueOf(n);		// Working with Strings would benefit me more in this case

		if(num.length()<=1) {
			return Character.getNumericValue(num.charAt(0));		// Returning the first element
		}
		return recursiveSum(Integer.parseInt(num.substring(1)))+Character.getNumericValue(num.charAt(0)); // 123 > 23, 3 , (1,2,3 returned = 6)
	}


}