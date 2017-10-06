import java.util.Scanner;
public class BiggestXth {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int[] a = new int[in.nextInt()];

	for(int i = 0; i < a.length; i++) {
		a[i] = in.nextInt();
	}
	a = insertion(a);
	System.out.print(a[(a.length)-(in.nextInt())]);

    }
	
    public static int[] insertion(int[] a) {
    	for(int i = 0; i < a.length; i++) {
    		for(int j = i+1; j < a.length; j++) {
    			if(a[i] > a[j]) {
    				int temp = a[i];
    				a[i] = a[j];
    				a[j] = temp;
    			}
    		}
    	}
    	return a;
    }

}
