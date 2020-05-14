// Luhn number checker
//123456
/*The Luhn algorithm was developed by German computer scientist Hans Peter Luhn in 1954.
 *It calculates simple checksum formula used to validate identification numbers such as credit card numbers.
 *The algorithm was designed to protect against accidental errors, such as a digit mistyping. It will detect any single-digit error,
 *as well as almost all transpositions of adjacent digits. It will not, however, detect transposition of the two-digit sequence 09 to 90 (or vice versa).
The calculator below gives Luhn checksum of the given digit sequence. The sequence is considered valid if the checksum mod 10 equals to zero.
It also gives the next check digit to be appended at the end of source sequence to form valid number according Luhn algorithm. */
//371449635398431 proves valid
import java.util.Scanner;

public class luhnCheckerStringEfficient {
public static void main(String[]args) {
    	Scanner in = new Scanner(System.in);
    	String s = in.next();
    	int count = 0 , sum = 0;

    	for(int i = s.length()-1; i >= 0; i--) {
    		int k = Character.getNumericValue(s.charAt(i));							//getting the int values of the characters

    		if(count%2 != 0)  sum += ( k > 4) ? ((k*2)-9) : (k*2);	//if an odd number, double it and add if(n>4) ((n*2)-9) onto sum

	 	    else if(count%2 == 0)  sum += k;										//if an even number, add the number onto the sum

    		count++;																//counter goes up
    	}

		if(sum%10 == 0)  System.out.println(sum+" % 10 = "+sum%10+" is valid");		//if sum mod 10 is 0, then it is valid
		else System.out.println(sum+" % 10 = "+sum%10+" is not valid");				//else its not valid

    }
}