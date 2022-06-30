/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 */
package com.sorting;

import java.util.Arrays;

/**
 * Time: O(nlogn), Space: O(n)
 * 
 * If array is even length then take the average of two middle element as median
 * otherwise take the middle element.
 * 
 * @author Satish
 *
 */
public class MinimumMovesToEqualArrayElementsII {
	class Solution {
		public int minMoves2(int[] nums) {
			Arrays.sort(nums);
			int n = nums.length / 2;
			int svg = 0;

			if ((nums.length & 1) == 0) {
				svg = (nums[n] + nums[n - 1]) / 2;
			} else {
				svg = nums[n];
			}

			int ans = 0;

			for (int num : nums) {
				ans += Math.abs(svg - num);
			}
			return ans;
		}
	}
}
