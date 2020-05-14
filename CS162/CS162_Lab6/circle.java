import java.lang.Math.*;
import java.util.Scanner;

public class circle {
public int radius;

    public circle() {
    	radius = 1;
    }

    public circle(int r) {
    	radius = r;
    }

    public int getRadius() {
    	return radius;
    }

       public void setRadius(int y) {
    		radius = y;
    }

    public double getCircumference() {
    	return Math.round((2*Math.PI*radius)* 1000.0) / 100.0;
    }

    public double getArea() {
    	return Math.round((Math.PI*Math.pow(radius,2))* 1000.0) / 1000.0;
    }
}