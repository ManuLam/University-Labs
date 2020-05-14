import java.util.Scanner;

public class lab3c {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	String sen = in.nextLine();

	System.out.println(reverseRecursive(sen));


    }

    public static String reverseRecursive(String s) {
    	if(s.length()<=1) {
    		return s;
    	}
    	else {
    		return reverseRecursive(s.substring(1))+s.charAt(0);	// taking a String + 1 , and keeping the first char
    	}															// String > tring , ring, ing, ng, g

    }

}