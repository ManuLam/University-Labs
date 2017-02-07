public class dowhile {
public static void main(String[]args) {

	int num = 13;
	int num1 = 1;
	final int number = num;
	int f = 0;

	do{
	if(number%num1==0) {
		f++; }
		num1++;
	}
	while (num>num1);

	if(f==1)
		System.out.println(num+" is a prime number");
		else { System.out.println(num+" is not a prime number"); }
	}
}