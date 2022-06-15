/**
 * https://leetcode.com/problems/maximum-erasure-value/
 */
package com.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Satish
 *
 */
public class MaximumErasureValue {

	/**
	 * It stores all the elements present in the window, if any element already
	 * present in the window then we slide left pointer past to the position of the
	 * first occurrence of repeating element.
	 * 
	 * Time: O(n), Space: O(m); m = number of unique elements
	 * 
	 * @author Satish
	 *
	 */
	class SpaceOptimized {
		public int maximumUniqueSubarray(int[] nums) {
			Set<Integer> window = new HashSet<>();

			int maxSum = 0;
			int currentSum = 0;

			for (int l = 0, r = 0; r < nums.length; r++) {
				if (window.contains(nums[r])) {
					while (nums[l++] != nums[r]) {
						currentSum -= nums[l - 1];
						window.remove(nums[l - 1]);
					}
				} else {
					window.add(nums[r]);
					currentSum += nums[r];
					maxSum = Math.max(maxSum, currentSum);

				}
			}

			return maxSum;
		}
	}

	/**
	 * It stores the index of each element in a hash for quick retrieval, for
	 * calculation of range sum, it uses prefix sum array.
	 * 
	 * Time: O(n), Space: O(n)
	 */
	class TimeOptimized {
		public int maximumUniqueSubarray(int[] nums) {
			Map<Integer, Integer> lastIndex = new HashMap<>();

			int maxSum = 0;
			int preSum[] = new int[nums.length + 1];

			for (int l = 0, r = 0; r < nums.length; r++) {
				preSum[r + 1] = preSum[r] + nums[r];

				if (lastIndex.containsKey(nums[r])) {
					l = Math.max(l, lastIndex.get(nums[r]) + 1);
				}

				lastIndex.put(nums[r], r);
				maxSum = Math.max(maxSum, preSum[r + 1] - preSum[l]);

			}

			return maxSum;
		}
	}
}
