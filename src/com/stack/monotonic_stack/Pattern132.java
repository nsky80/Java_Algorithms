/**
 * Monotonic Stack: https://leetcode.com/problems/132-pattern/
 */
package com.stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish
 *
 */
public class Pattern132 {

	/**
	 * This uses monotonic stack (decreasing) and it also maintains the previous
	 * minimum value which is i for every j and as soon as it founds k return true.
	 * 
	 * Time: O(n), Space: O(n)
	 */
	class OptimizedSolution {
		public boolean find132pattern(int[] nums) {
			if (nums.length < 3)
				return false;

			Deque<int[]> stack = new ArrayDeque<>();
			int currentMin = nums[0];

			for (int i = 0; i < nums.length; i++) {

				while (!stack.isEmpty() && stack.peekFirst()[0] <= nums[i]) {
					stack.pop();
				}

				if (!stack.isEmpty() && stack.peekFirst()[1] < nums[i]) {
					return true;
				}

				stack.push(new int[] { nums[i], currentMin });
				currentMin = Math.min(currentMin, nums[i]);
			}

			return false;
		}

	}

	/**
	 * Time: O(n^2), Space: O(n)
	 */
	class OptimizedBruteForce {
		public boolean find132pattern(int[] nums) {

			for (int i = 0; i < nums.length; i++) {
				int prevMax = Integer.MIN_VALUE;
				for (int j = i + 1; j < nums.length; j++) {

					if (prevMax == Integer.MIN_VALUE && nums[j] > nums[i]) {
						prevMax = nums[j];
					} else if (prevMax <= nums[j]) {
						prevMax = nums[j];
					} else if (nums[i] < nums[j]) {
						return true;
					}
				}
			}

			return false;
		}

	}

	/**
	 * Search for every 3 pair whether they are in 132 pattern Time: O(n^3), Space:
	 * O(1)
	 */
	class BruteForce {
		public boolean find132pattern(int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] < nums[j]) {
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[k] > nums[i] && nums[k] < nums[j])
								return true;
						}
					}
				}
			}

			return false;
		}

	}
}
