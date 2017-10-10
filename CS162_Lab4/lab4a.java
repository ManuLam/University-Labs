import java.util.Scanner;

public class lab4a {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
//	int n = in.nextInt();
	int[] array =	{9,88,5,7,12,2,9};	 // new int[n];

	System.out.println(q1Recursive(array,array.length-1));
			}

	public static int q1Recursive(int[] a, int start) {
		int min = a[start];
		if(a[start]>a[start-1]) {	// change position, because it is smaller
			min = a[start-1];
			}
		if(start<=1) {
			return min;
		}
		return q1Recursive(a,start-1);
	}
}