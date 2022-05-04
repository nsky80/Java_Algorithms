/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
package com.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author satis
 *
 */
public class MaxNumberOfK_SumPairs {
	/**
	 * This is single pass hashing solution, which stores the count of the element
	 * dynamically. Time: O(n), Space: O(n)
	 */
	class SolutionUsingHashTable {
		public int maxOperations(int[] nums, int k) {
			Map<Integer, Integer> map = new HashMap<>();
			int count = 0;

			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					count++;
					int cnt = map.get(nums[i]);
					if (cnt > 1) {
						map.put(nums[i], cnt - 1);
					} else {
						map.remove(nums[i]);
					}
				} else {
					int diff = k - nums[i];
					map.put(diff, map.getOrDefault(diff, 0) + 1);
				}
			}
			return count;
		}
	}

	/**
	 * Time: O(nlogn), Space: O(n) First sort the array and use 2 pointers to get
	 * the pairs.
	 */
	class SolutionUsingSorting {
		public int maxOperations(int[] nums, int k) {
			Arrays.sort(nums);
			int count = 0;
			int l = 0;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[l] + nums[r];
				if (sum == k) {
					count++;
					l++;
					r--;
				} else if (sum < k) {
					l++;
				} else {
					r--;
				}
			}

			return count;
		}
	}
}
