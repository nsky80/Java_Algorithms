/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */
package com.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Both the solution uses same concept: Finding the maximum subarray is standard
 * and can be done greedily. If it exists an answer, then it means we have a
 * subarray in the middle of original array whose sum is == totalSum - x
 * 
 * Time: O(n), Space: O(1)
 * 
 * @author Satish
 *
 */
public class MinimumOperationsToReduceXtoZero {

	/**
	 * Time: O(n), O(1)
	 * 
	 * This approach uses sliding window protocol, where we slide the window as soon
	 * as overall sum exceeds.
	 * 
	 * @author satis
	 *
	 */
	class SpaceOptimizedSolution {
		public int minOperations(int[] nums, int x) {
			int sum = 0;
			for (int num : nums)
				sum += num;

			int maxLength = -1;
			int current = 0;
			int target = sum - x;

			for (int l = 0, r = 0; r < nums.length; r++) {
				current += nums[r];

				// if x == sum(nums) then we need to use =
				// slide the left pointer
				while (l <= r && current > target)
					current -= nums[l++];

				if (current == target)
					maxLength = Math.max(maxLength, r - l + 1);
			}

			return maxLength == -1 ? -1 : nums.length - maxLength;
		}

	}

	/**
	 * It uses the concept of 2 sum problem, where we store the remaining/required
	 * sum in hashmap and try to refer them from each calculation if there exist a
	 * solution.
	 * 
	 * Time: O(n), Space: O(1)
	 * 
	 * @author satis
	 *
	 */
	class Solution {
		public int minOperations(int[] nums, int x) {
			int sum = 0;
			for (int num : nums)
				sum += num;

			if (sum == x)
				return nums.length;

			int maxLength = -1;
			int current = 0;
			int target = sum - x;

			Map<Integer, Integer> map = new HashMap<>();

			// base case
			map.put(0, -1);

			for (int i = 0; i < nums.length; i++) {
				current += nums[i];

				if (map.containsKey(current - target)) {
					maxLength = Math.max(maxLength, i - map.get(current - target));
				}

				// all nums are positive, therefore sum is going to be unique.
				map.put(current, i);
			}

			return maxLength == -1 ? -1 : nums.length - maxLength;
		}

	}

}
