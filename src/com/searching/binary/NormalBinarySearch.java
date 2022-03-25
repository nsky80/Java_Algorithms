package com.searching.binary;

public class NormalBinarySearch {

	/**
	 * Recursive implementation of binary search algorithm.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param element
	 * @return
	 */
	public static int binarySearchRecursive(int[] arr, int start, int end, int element) {
		if (start > end)
			return -1;
		// put end = end + 1 for choosing right side to break the tie.
		int mid = start + (end - start) / 2;

		if (arr[mid] == element)
			return mid;
		
		// if element is smaller than mid, then check in left sub-array
		if (element < arr[mid])
			return binarySearchRecursive(arr, start, mid - 1, element);

		// otherwise check in right sub-array
		return binarySearchRecursive(arr, mid + 1, end, element);
	}
	
	
	public static int binarySearchIterative(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		int mid;
		
		while (start <= end) {
			mid = start + (end  - start) / 2;
			
			if (arr[mid] == element) {
				return mid;
			}
			
			if (element < arr[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] arr, int element) {
		return binarySearchIterative(arr, element);
	}

	
	
	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8 };
		System.out.println("4: " + binarySearch(arr, 4));
		System.out.println("1: " + binarySearch(arr, 1));
		System.out.println("2: " + binarySearch(arr, 2));
		System.out.println("3: " + binarySearch(arr, 3));
		System.out.println("7: " + binarySearch(arr, 7));
		System.out.println("8: " + binarySearch(arr, 8));
		System.out.println("9: " + binarySearch(arr, 9));
		System.out.println("99: " + binarySearch(arr, 99));
	}

}
