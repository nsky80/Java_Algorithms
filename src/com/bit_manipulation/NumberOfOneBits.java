/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
package com.bit_manipulation;

/**
 * @author satis
 *
 */
public class NumberOfOneBits {

	public class Solution {
		// you need to treat n as an unsigned value
		public int hammingWeight(int n) {
			int count = 0;

			while (n != 0) {
				n &= (n - 1);
				count++;
			}

			return count;
		}
	}

	public class Solution2 {
		// you need to treat n as an unsigned value
		public int hammingWeight(int n) {
			int count = 0;
			for (int i = 0; i < 32; i++) {
				count += ((n >> i) & 1);
			}

			while (n != 0) {
				n &= (n - 1);
				count++;
			}
			return count;
		}
	}

	public class Solution1 {
		// you need to treat n as an unsigned value
		public int hammingWeight(int n) {
			int ones = 0;
			while (n != 0) {
				ones = ones + (n & 1);
				n = n >>> 1;
			}
			return ones;
		}
	}
}
