/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
package com.bit_manipulation;

/**
 * @author satis
 *
 */
public class NumberOfStepsToReduceNumberToZero {
	/**
	 * This solution checks each bit, if it is zero then it would get divided by 2
	 * which is single operation otherwise we have to perform two tasks - substract
	 * 1 and divide by 2. The extreme 1 has only 1 operation thats why count - 1
	 * being performed.
	 * 
	 * Time: O(logn), Space: O(1)
	 * @author Satish
	 *
	 */
	class Optimized {
		public int numberOfSteps(int num) {
			if (num == 0)
				return 0;

			int count = 0;
			while (num != 0) {
				count += (num & 1) == 1 ? 2 : 1;
				num >>= 1;
			}

			return count - 1;
		}
	}

	class BruteForce {
		public int numberOfSteps(int num) {
			int count = 0;

			while (num > 0) {
				if ((num & 1) == 1)
					num -= 1;
				else
					num /= 2;
				count++;
			}

			return count;
		}
	}
}
