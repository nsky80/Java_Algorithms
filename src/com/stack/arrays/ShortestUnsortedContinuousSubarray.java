/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
package com.stack.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Satish
 *
 */
public class ShortestUnsortedContinuousSubarray {
	/**
	 * This sorts the array and then using 2 pointers try to find out the left and
	 * right boundary of the solution. Time: O(nlogn), Space: O(n)
	 */
	class SolutionUsingSorting {
		public int findUnsortedSubarray(int[] nums) {
			int sortedCopy[] = nums.clone();
			Arrays.sort(sortedCopy);

			int l = 0;
			int r = nums.length - 1;

			while (l <= r) {
				if (nums[l] == sortedCopy[l]) {
					l++;
				} else if (nums[r] == sortedCopy[r]) {
					r--;
				} else {
					break;
				}
			}

			return r - l + 1;
		}
	}

	/**
	 * This is 2 pass solution, where, we try to find out the left boundary using
	 * stack and then right bound. Time: O(n), Space: O(n)
	 */
	class SolutionUsingStack {
		public int findUnsortedSubarray(int[] nums) {
			Deque<Integer> stack = new ArrayDeque<>();
			int l = nums.length;
			int r = 0;

			// get the left boundary
			for (int i = 0; i < nums.length; i++) {
				// if this element is not at it's correct position
				while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
					l = Math.min(l, stack.poll());
				}
				stack.offerFirst(i);
			}
			stack.clear();

			for (int i = nums.length - 1; i >= 0; i--) {
				// if this element is not at it's correct position
				while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
					r = Math.max(r, stack.poll());
				}
				stack.offerFirst(i);
			}

			return r - l < 0 ? 0 : r - l + 1;
		}
	}

}
