/**
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 */
package com.dp;

/**
 * @author satis
 *
 */
public class LongestIncreasingSubsequenceBruteForceRecursion {
	static int counter = 0;
	
	/**
	 * Here prev will track the index of last included element in the tree.
	 * 
	 * @param prev
	 * @param current
	 * @param arr
	 * @return
	 */
	public static int getLIS(int prev, int current, int arr[]) {
		System.out.println("Counter : " + counter++);
		// check for base condition, if all the element traversed
		if (current == arr.length) {
			return 0;
		}

		// include the current element in sequence and check subsequent
		int include = 0;

		// here prev=-1 signifies, this is first element of array
		// and it doesn't have any previous

		// if current is greater than previous include it into sequence
		if (prev == -1 || arr[prev] < arr[current]) {
			// this is included now, check for subsequent element
			include = 1 + getLIS(current, current + 1, arr);
		}

		// now exclude current element and check the sequence
		// as we are excluding current element, prev is not going to change.
		int exclude = getLIS(prev, current + 1, arr);

		System.out.println("Include Exclude: " + include + " " + exclude);
		System.out.println("Max Till: " + Math.max(include, exclude));
		
		// now return the maximum increasing sequence by including
		// and excluding current element
		return Math.max(include, exclude);
	}

	/**
	 * Here start means starting position of array and end is length i.e. n
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	static int getLISIterativeAndRecursion(int arr[], int start, int end) {
		
		
		return 0;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] seq = { 1, 3, 2 };
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };


		System.out.println(getLIS(-1, 0, arr));

	}

}
