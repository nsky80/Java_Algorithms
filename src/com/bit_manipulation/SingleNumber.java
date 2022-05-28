/**
 * https://leetcode.com/problems/single-number/
 */
package com.bit_manipulation;

/**
 * @author Satish Kumar Yadav
 *
 */
public class SingleNumber {
	/**
	 * XOR of any number with the same is 0, so last element would be remaining 1.
	 */
	public int singleNumber(int[] nums) {
		int ans = nums[0];

		for (int i = 1; i < nums.length; i++) {
			ans ^= nums[i];
		}

		return ans;
	}
}
