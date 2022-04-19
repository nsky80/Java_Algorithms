/**
 * https://leetcode.com/problems/arithmetic-slices/
 */
package com.dp.easy;

/**
 * @author satis
 *
 */
public class ArithmeticSlices {
	/**
	 * O(n), O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int numberOfArithmeticSlicesConstantSpace(int[] nums) {
		int n = nums.length;
		if (n <= 2)
			return 0;
		int prev = 0;
		int sum = 0;
		// as it take minimum 3 contiguous elements
		for (int i = 2; i < n; i++) {
			int p1 = nums[i - 2];
			int p2 = nums[i - 1];
			int p3 = nums[i];

			// check if current is compatible
			if ((p3 - p2) == (p2 - p1)) {
				// take the total of previous and add + 1
				int current = (prev + 1);
				sum += current;
				prev = current;
			} else {
				prev = 0;
			}
		}

		return sum;
	}

	/**
	 * O(n), O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int numberOfArithmeticSlicesWithSpace(int[] nums) {
		int n = nums.length;
		if (n <= 2)
			return 0;
		int subArr[] = new int[n];

		for (int i = 2; i < n; i++) {
			int p1 = nums[i - 2];
			int p2 = nums[i - 1];
			int p3 = nums[i];
			if ((p3 - p2) == (p2 - p1)) {
				subArr[i] += (subArr[i - 1] + 1);
			}
		}

		int sum = 0;
		for (int i : subArr)
			sum += i;
		return sum;
	}

}
