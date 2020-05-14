import java.util.Scanner;

public class testCircle {
public static void main(String[]args) {
    	Scanner in = new Scanner(System.in);
    	circle[] arrayCircle = new circle[3];

    	for(int i=0; i<3; i++) arrayCircle[i] = new circle(in.nextInt());
    	for(int i=0; i<3; i++) System.out.println("Circle " + (i+1) + " has a radius of " + arrayCircle[i].getRadius());
    	for(int i=0; i<3; i++) System.out.println("Circle " + (i+1) + " has a radius of " + arrayCircle[i].getCircumference());
		for(int i=0; i<3; i++) System.out.println("Circle " + (i+1) + " has a radius of " + arrayCircle[i].getArea());
    }

}