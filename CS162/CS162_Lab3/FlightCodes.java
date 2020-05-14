import java.util.Scanner;

public class FlightCodes {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	String sen = in.nextLine();

	System.out.println(sen.matches("[A-Z]{2,3}[0-9]{3,4}"));  //A-Z between 2-3 letters , followed with 3-4 digits

    }
}