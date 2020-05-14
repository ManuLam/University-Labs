import java.util.Scanner;

public class test {
public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		square[] arraySquare = new square[4];

		for(int i=0; i<4; i++) arraySquare[i] = new square(in.nextInt());
		arraySquare[0].setLength(10);
		arraySquare[2].setLength(10);

		for(int i=0; i<4; i++) System.out.println("Square " + (i+1) + " has a length of " + arraySquare[i].getLength());
		System.out.println("Square " + (1) + " has an area of " + arraySquare[0].getArea());
		System.out.println("Square " + (2) + " has an area of " + arraySquare[2].getArea());
		System.out.println("LENGTH: " + arraySquare[3].toString());
	}
}