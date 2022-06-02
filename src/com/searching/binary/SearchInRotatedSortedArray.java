/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
package com.searching.binary;

/**
 * @author Satish Kumar Yadav
 *
 */
public class SearchInRotatedSortedArray {
	/**
	 * Time: O(logn), Space: O(1)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class Solution {
		public int search(int[] arr, int x) {
			int left = 0;
			int right = arr.length - 1;

			int mid;

			while (left <= right) {
				mid = left + (right - left) / 2;

				if (arr[mid] == x)
					return mid;

				// As per property - from a particular position, either left or
				// right sub-array would be sorted, so using that property

				// if left side is sorted
				if (arr[left] <= arr[mid]) {
					// if element lies in left sorted segment
					if (x < arr[mid] && x >= arr[left])
						right = mid - 1;
					else
						left = mid + 1;
				} else {
					// here right part of the array is sorted
					if (x > arr[mid] && x <= arr[right])
						left = mid + 1;
					else
						right = mid - 1;
				}
			}
			return -1;
		}
	}
}
