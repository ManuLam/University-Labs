import java.util.*;

public class highesDupeAdvanced {
public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();		//size of Initial input array
	int[] aPos = new int[1000];	//positive array
	int[] aNeg = new int[1000]; //negative array
	int[] a = new int[n];		//initial input array


		for(int i = 0; i < n; i++) {
			int x = in.nextInt();	//user input
			a[i] = x;				//stored in Initial input array
			if(x < 0) aNeg[-x]++;	//and if it is a negative number, count it aNeg[] aswell
			else aPos[x]++;			//and if it is a positive number, count in aPos[] aswell

		}

		// p,q stands for highest counted values, x,y stands for highest number at that counted value
		int p = 0, q = 0, x = 0, y = 0;
		for(int i = 0; i < 1000; i++) {

			if(aPos[i] > p) {	//if count > previous
				x = i;			//number is replaced with higher count number
				p = aPos[i];	//count is replaced with higher count number
			}
			else if(aPos[i] == p) x = checkFirst(a, x, i);	//if the count is matched with another.. I ran it through
															//the Initial input array 'a[]' and got the first output
			if(aNeg[i] > q) {	//if count > previous
				y = i;			//number is replaced with higher count number
				q = aNeg[i];	//count is replaced with higher count number
			}
			else if(aNeg[i] == q) y = checkFirst(a, -y, i);	//if the count is matched with another.. I ran it through
		}													//the Initial input array 'a[]' and got the first output

		if(q < p)	System.out.println(x);	//if positive side has higher count, then positive print the number out
		if(q > p)	System.out.println("-"+y);	//if negative side has higher count, then negative print the number out
		if(q == p)  System.out.println(checkFirst(a, x, -y));	//if count of Neg / Pos are the same, check in Initial input array

    }

    public static int checkFirst(int[] a, int i, int j) {	//checking Initial input array
    	for(int p = 0; p < a.length; p++) {
    		if(a[p] == i) return i;			//return i if it was found first
    		else if(a[p] == j) return j;	//return j if it was found first
    	}
    	return 0;	//this shouldn't be returned
    }

}