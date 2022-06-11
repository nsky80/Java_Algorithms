/**
 * 
 */
package com.two_pointers;

/**
 * As the size of num1 is m + n, it means if nums2 get exhausted then we won't
 * need to swap from num1, that's why starting the swapping from the end.
 * 
 * Time: O(n), Space: O(1)
 * 
 * @author Satish
 *
 */
public class MergeSortedArray {
	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int ptr = n + m - 1;
			n = n - 1;
			m = m - 1;

			while (n >= 0 && m >= 0) {
				if (nums1[m] > nums2[n]) {
					nums1[ptr] = nums1[m--];
				} else {
					nums1[ptr] = nums2[n--];
				}
				ptr--;
			}

			while (n >= 0) {
				nums1[ptr--] = nums2[n--];
			}

		}
	}
}
