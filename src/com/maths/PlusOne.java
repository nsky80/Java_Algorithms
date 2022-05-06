/**
 * https://leetcode.com/problems/plus-one/
 */
package com.maths;

/**
 * @author Satish
 *
 */
public class PlusOne {
	class Solution {
		public int[] plusOne(int[] digits) {
			int n = digits.length;

			boolean isAllNine = true;

			// if it is all 9
			for (int i = 0; i < n; i++) {
				if (digits[i] != 9) {
					isAllNine = false;
					break;
				}
			}

			int ans[];

			// if it is all nine then simply add 1 at top and return
			if (isAllNine) {
				ans = new int[n + 1];
				ans[0] = 1;
			} else {
				// copy all the values
				ans = new int[n];
				int carry = 1;
				for (int i = n - 1; i >= 0; i--) {
					int sum = digits[i] + carry;
					if (sum > 9) {
						ans[i] = 0;
						carry = 1;
					} else {
						ans[i] = sum;
						carry = 0;
					}
				}
			}

			return ans;

		}
	}
}
