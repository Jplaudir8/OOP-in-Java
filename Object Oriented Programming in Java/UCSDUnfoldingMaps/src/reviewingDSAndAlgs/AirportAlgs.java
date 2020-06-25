package reviewingDSAndAlgs;
import java.util.*;

public class AirportAlgs {


	// Algorithm 1 (Linear Search)
	// Performing a basic linear search to find airport code.
	// Computation here would be n times for n number of inputs.
	public static String findAirportCode1(String toFind, Airport[] airports) {
		int index = 0;
		while(index < airports.length){
			Airport a = airports[index];
			if(toFind.equals(a.getCity())) {
				return a.getCode();
			}
			index++;
		}
		return null;
	}
	
	// Algorithm 2 (Binary Search)
	// Improving Algorithm 1 by performing a binary search to find the airport code.
	// Computation here would be expressed as log(n) for n number of inputs.
	// It is also good to be aware that this implementation of low and high variables 
	// may fall in a situation in which we may be dealing with very huge indexes, 
	// making it not possible to represent an addition of the two numbers(also called as overflow). 
	// In order to help that situation, I decided to use mid = low + ((high-low)/2);
	public static String findAirportCode2(String toFind, Airport[] airports) {
		// Initializing local variables expressing a range boundary for the indexes. 
		// mid variable which will be used to start cutting our search in halves.
		int mid, low = 0, high = airports.length-1;
		while(low <= high) {
			mid = low + ((high-low)/2);
			int compare = toFind.compareTo(airports[mid].getCity());
			if(compare < 0) {
				high = mid - 1;
			} else if(compare > 0) {
				low = mid + 1;
			} else {
				return airports[mid].getCity();
			}
		}
		return null;
	}
	
	// Algorithm 3 (Selection Sort)
	// Implementing the selection sort algorithm. Ignore Airport stuff context.
	// Regarding its performance, this sorting algorithm would be much efficient with large 
	// inputs since it would become slower. Let's remember the use of any sorting or any other type of algorithms
	// will be used upon the context provided. Therefore, we will decide if either caring more about
	// space complexity or time complexity.
	// This algorithm gets no benefit from sorting an already sorted array though. Its inner loop will
	// still have to go through every element. We may be benefiting with this but in other algorithms.  
	public static void selectionSort(int[] vals) {
		
		int indexMin;
		for(int i = 0; i < vals.length; i++) {
			indexMin = i;
			for(int j=i+1; j < vals.length; j++) {
				if(vals[j] < vals[indexMin]) {
					//swap elements
					indexMin = j;
				}
			}
		}
	}
	
	// Algorithm 4 (Insertion Sort)
	public static void insertionSort(int[] vals) {
		int currInd;
		for(int pos = 1; pos < vals.length; pos++) {
			currInd = pos;
			while(currInd > 0 && vals[currInd] < vals[currInd-1]) {
				//swap(vals, currInd, currInd-1);
				currInd = currInd-1;
			}
		}
	}
	
	// There is a java built-in sort method and its an optimized version of the well-know 
	// merge-sort algorithm.
	// This algorithm's features are that it is fast for nearly sorted elements 
	// and also for the worst case scenario. The main difference between the merge-sort algorithm
	// and java's built-in sort method is that the latter performs less array copying.
	// Notice that when we want to compare non integers, we will need to make use of the Comparable
	// interface in order to help the sort method understand how to make comparisons between non integers.
	// With the Comparable interface we will have to implement the compareTo method, in which
	// an integer number will be returned depending on the comparison between the calling object and the object called
	// in the parameter. (See table in readme markdown file.)
	
	// Example making use of the java's built-in merge-sort algorithm (uses java.util.*)
	public static void builtInMergeSort() {
		Random random = new Random();
		List<Integer> numsToSort = new ArrayList();
		
		for(int i = 0; i < 5; i++) {
			numsToSort.add(random.nextInt(100));
		}
		
		Collections.sort(numsToSort);
		System.out.println("New array after builtin method use: " + numsToSort.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
		
