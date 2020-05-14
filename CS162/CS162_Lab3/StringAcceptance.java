import java.util.Scanner;

public class StringAcceptance {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	String sen = in.nextLine();

	String y = check(sen)==true ? sen+" is true" : sen+" is false";
	System.out.println(y);

    }

    public static boolean check(String s) {

    	return s.matches("[0-1]*");

    }

}