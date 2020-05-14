// Simple Binary Search logic
import java.util.*;

public class BinarySearch {
public static void main(String[]args) {
	Scanner input = new Scanner(System.in);
	int search = input.nextInt(); // element to search for
	int[] array = {1,2,3,4,5,6,7,8,9,10};	// An array with 10 elements
	int n = 10;		// Array n size = 10
	int first = 0;		// First Position = 0
	int last = n-1;		// Last Position = n-1 so 9
	int middle = (first+last)/2;// Middle is first and last added divide by 2 for centre
	int count = 0;			// Count the amount of steps taken

	while(first<=last) {		// A loop where last is divided in 2 until it is 0
		count++;		// Count rises per step taken
		if(array[middle]<search) {	// If the search is larger than middle value
			first = middle+1;	// The first is changed into the middle+1 location so that (middle-last) is the search
			}
		else if(array[middle]==search) {	// If the middle index value is the search, there is the element found
			System.out.println("Element found at: "+middle+" position");
			break;		// break the loop 
			}
		else{
			last = middle-1;	// If the search is located below middle index then middle-1 index so that (first-middle) 
			}
			middle = (first+last)/2;// The middle is halfed so that the search will centre the search to the middle value
		}
		if(first>last) {	// If the first element is bigger than the end element 0, meaning the search did not contain the element
			System.out.println("Element is not in the array");	// Prints that the element is not in the array
		}
		System.out.println(count+" counts taken to search");	// Prints the steps taken 

    }
}
