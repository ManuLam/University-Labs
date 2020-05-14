import java.util.Scanner;

public class ValidAge {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	boolean t = true;

	while(t==true) {
		String age = in.nextLine();
		if(age.matches("[0-9][0-9]|1[0-4][0-9]|[1-9]")==true) {
			System.out.println(age+" Age is valid");
			t=false;
			}
		else {
			System.out.println(age+" Age is invalid");
			}
		}
    }
}