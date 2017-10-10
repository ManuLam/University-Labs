import java.util.Scanner;

public class lab4e {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int n = 4;
	int[] a = {1,10,40,6,60,60,54,540};

	System.out.println(checkArray(a, n));

   	}

	public static boolean checkArray(int[] a,int n) {
		int sum = a[n]*10;

		if(a.length-1==n) {
			return false;
			}

		if(a[n+1]==sum) {
			return true;
			}

		else {
			return checkArray(a, n+1);
			}
		}

}