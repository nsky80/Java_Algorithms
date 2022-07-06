/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
package com.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Satish
 *
 */
public class LongestConsecutiveSequence {
	/**
	 * This solution start counting the sequence if smallest number of that sequence
	 * encounter, so using this it counts a sequence in increasing order, where
	 * lookup for next number is being completed in O(1).
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * @author satis
	 *
	 */
	class Solution1 {
		public int longestConsecutive(int[] nums) {
			Set<Integer> numSet = new HashSet<>();

			for (int num : nums)
				numSet.add(num);
			int max = 0;

			for (int num : numSet) {
				if (!numSet.contains(num - 1)) {
					int streak = 1;

					while (numSet.contains(++num)) {
						streak++;
					}

					max = Math.max(streak, max);
				}
			}

			return max;
		}
	}

	/**
	 * It sorts the numbers and try to find out the unique consecutive sequences.
	 * 
	 * Time: O(nlogn), Space: O(1)
	 * 
	 * @author satis
	 *
	 */
	class Solution2 {
		public int longestConsecutive(int[] nums) {
			if (nums.length == 0)
				return 0;
			Arrays.sort(nums);
			int max = 1;
			int curr = 1;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] - 1 == nums[i - 1]) {
					curr++;
				} else if (nums[i] != nums[i - 1])
					curr = 1;
				max = Math.max(curr, max);
			}

			return max;
		}
	}
}
