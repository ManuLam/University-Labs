import java.util.Scanner;

public class ValidName {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	String sen = in.nextLine();

	System.out.println(sen.matches("[A-Z][a-z]{1,24}"));

    }
}