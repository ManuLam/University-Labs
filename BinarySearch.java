import java.util.*;

public class BinarySearch {
public static void main(String[]args) {
	Scanner input = new Scanner(System.in);
	int search = input.nextInt(); // element to search for
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	int n = 10;
	int first = 0;
	int last = n-1;
	int middle = (first+last)/2;
	int count = 0;

	while(first<=last) {
		count++;
		if(array[middle]<search) {
			first = middle+1;
		}
		else if(array[middle]==search) {
			System.out.println("Element found at: "+middle+" position");
			break;
		}
		else{
			last = middle-1;
		}
			middle = (first+last)/2;
		}
		if(first>last) {
			System.out.println("Element is not in the array");
		}
		System.out.println(count+" counts taken to search");

    }
}