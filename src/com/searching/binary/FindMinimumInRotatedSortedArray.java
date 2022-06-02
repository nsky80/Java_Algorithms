/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
package com.searching.binary;

/**
 * Time: O(logn), Space: O(1)
 * 
 * @author Satish
 *
 */
public class FindMinimumInRotatedSortedArray {

	class Solution {
		public int findMin(int[] nums) {
			int l = 0;
			int r = nums.length - 1;

			if (nums[l] <= nums[r])
				return nums[l];

			while (l <= r) {
				int m = l + (r - l) / 2;

				// check for inflection point
				// incase of 0 1 -> 0 comes first, so there isn't any
				// chance of array overflow.
				if (nums[m] > nums[m + 1])
					return nums[m + 1];
				if (nums[m] < nums[m - 1])
					return nums[m];

				// compare and check if we're in increasing part
				// then min would be available at right of the mid
				if (nums[0] < nums[m]) {
					l = m + 1;
				} else {

					// search in left part from the right
					r = m - 1;

				}
			}

			return nums[0];
		}
	}
}
