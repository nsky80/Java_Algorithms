/**
 * https://leetcode.com/problems/missing-number/
 */
package com.bit_manipulation;

/**
 * Time: O(n), Space: O(1)
 * 
 * @author satis
 *
 */
public class MissingNumber {
	class MathSolution {
		public int missingNumber(int[] nums) {
			int n = nums.length;
			int sum = 0;
			for (int i : nums)
				sum += i;
			return (n * (n + 1) / 2) - sum;
		}
	}

	/**
	 * a number XOR itself will become 0, any number XOR with 0 will stay unchanged.
	 * 
	 * @author Satish
	 *
	 */
	class BitManipulationSolutin {
		public int missingNumber(int[] nums) { // xor
			int res = nums.length;
			for (int i = 0; i < nums.length; i++) {
				res ^= i;
				res ^= nums[i];
			}
			return res;
		}

	}
}
