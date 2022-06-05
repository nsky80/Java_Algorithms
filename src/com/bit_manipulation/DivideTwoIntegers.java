/**
 * https://leetcode.com/problems/divide-two-integers/
 */
package com.bit_manipulation;

/**
 * @author Satish
 *
 */
public class DivideTwoIntegers {

	/**
	 * 
	 * Time: O(logn), Space: O(1)
	 */
	class Solution {
		public int divide(int dividend, int divisor) {

			// special case when quotient would be greater than 2^31 - 1
			if (dividend == 1 << 31 && divisor == -1)
				return (1 << 31) - 1;

			int a = Math.abs(dividend);
			int b = Math.abs(divisor);
			int ans = 0;
			int q = 0;

			while (a - b >= 0) {
				// first b is getting shifted q times and then result gets shifted 1 time
				// Here b << q << 1 === b * 2 ^ (q + 1)
				// As we need to get immediate number which is less than a
				// so thats why we're doing advance checking, so that a >= b*2^q at the end
				for (q = 0; a - (b << q << 1) >= 0; q++)
					;

				// updating the queotient and dividend
				ans += 1 << q;
				a -= b << q;
			}

			// check negativity and return
			return (dividend > 0) == (divisor > 0) ? ans : -ans;

		}
	}
}
