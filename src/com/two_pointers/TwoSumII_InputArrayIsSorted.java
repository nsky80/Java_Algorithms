/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
package com.two_pointers;

/**
 * Time: O(n), Space: O(1)
 * 
 * As the array is already sorted then we can declare 2 pointer at front and end
 * position after that start scanning through the array, if sum of elements at
 * both positional pointer is greater than target then we need to reduce the sum
 * then we try to reduce end pointer otherwise front pointer.
 * 
 * @author satis
 *
 */
public class TwoSumII_InputArrayIsSorted {
	class Solution {
		public int[] twoSum(int[] numbers, int target) {
			int left = 0;
			int right = numbers.length - 1;

			while (left < right) {
				int sum = numbers[left] + numbers[right];

				if (sum == target)
					return new int[] { left + 1, right + 1 };
				else if (sum < target)
					left++;
				else
					right--;
			}

			return null;
		}
	}
}
