import java.util.Scanner;

public class WhichExpression {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	String sen = in.nextLine();

	if(sen.matches("[a-b]")==true) {
		if(sen.matches("a[a-b]b")==true)	System.out.println(1);
		if(sen.matches("[ab]*b") ==true) 	System.out.println(2);
		if(sen.matches("a[a-b]*")==true)	System.out.println(3);
		if(sen.matches("[a-b]a*")==true)	System.out.println(4);
		}
	else {
		System.out.println("Not in the language");
		}
    }
}