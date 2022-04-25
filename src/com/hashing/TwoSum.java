/**
 * https://leetcode.com/problems/two-sum/
 */
package com.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author satis
 *
 */
public class TwoSum {

	/**
	 * Time: O(n) Space: O(n)
	 *
	 */
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> indices = new HashMap<>();

			for (int i = 0; i < nums.length; i++) {
				int remain = target - nums[i];
				if (indices.containsKey(remain)) {
					return new int[] { i, indices.get(remain) };
				} else {
					indices.put(nums[i], i);
				}

			}

			return null;
		}

	}

}
