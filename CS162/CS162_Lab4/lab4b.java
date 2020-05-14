import java.util.Scanner;

public class lab4b {
public static void main(String[]args) {
 	Scanner in = new Scanner(System.in);
 	int n  = in.nextInt();

 	System.out.println(q2Recursive(n));
 		}

 	public static int q2Recursive(int n) {
 		if(n==1) {
 			return 2;
 			}

 		else {
 			return (4*q2Recursive(n-1)) - (3*n);
 		}
 	}
}