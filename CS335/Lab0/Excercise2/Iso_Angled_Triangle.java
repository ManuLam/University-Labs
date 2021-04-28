package Shapes;

public class Iso_Angled_Triangle {
	/**
	*Calculate area of an isosceles triangle
	*@param base double
	*@param height double
	*@return area double
	*/
	public static double area(double base, double height)	{
	return (base*height)/2;
	}
	/**
	*Calculate perimeter of an isosceles triangle
	*@param a double
	*@param b double
	*@return perimeter
	*/
	public static double perimeter(double a, double b)	{
	return (2*a) + b;
	}

}
