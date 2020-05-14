import java.util.*;

public class Solution {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int[] a = new int[in.nextInt()];
	int count = 0, max = 0;

		for(int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();					//storing our input inside an array
		}

		for(int i = 0; i < a.length; i++) {			//looping through our array to find dupes
			int c = 0;								//start the loop with a counter = 0 everytime

			for(int j = i+1; j < a.length; j++) {	//letting j = i+1 , so that we don't overlook the same elements too much
				if(a[i] == a[j]) c++;				//when two numbers are the same, we count it
			}

			if(c > count) {							//when count is higher than previous, it is stored as the highest
				count = c;
				max = a[i];							//storing our highest counted dupe into max
			}
		}

	System.out.print(max);							//return our highest "dupe counted" number
	}
}