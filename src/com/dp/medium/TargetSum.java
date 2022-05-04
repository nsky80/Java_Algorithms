/**
 * 
 */
package com.dp.medium;

import java.util.Arrays;

/**
 * @author Satish
 *
 */
public class TargetSum {
	class TopDownMemoizedSolution {
		// this offset is used to use negative sum as array index
		int offsetSum;
		int memo[][];

		public int findTargetSumWays(int[] nums, int target) {
			offsetSum = Arrays.stream(nums).sum();
			memo = new int[nums.length][2 * offsetSum + 1];
			for (int i = 0; i < nums.length; i++) {
				Arrays.fill(memo[i], Integer.MAX_VALUE);
			}
			return findWays(nums, 0, target, 0);
		}

		private int findWays(int nums[], int currentSum, int target, int currentIndex) {
			// to avoid negative sum values
			int index = currentSum + offsetSum;

			if (currentIndex == nums.length && index == target + offsetSum)
				return 1;

			if (currentIndex >= nums.length)
				return 0;

			if (memo[currentIndex][index] != Integer.MAX_VALUE)
				return memo[currentIndex][index];

			return memo[currentIndex][index] = findWays(nums, -nums[currentIndex] + currentSum, target,
					currentIndex + 1) + findWays(nums, nums[currentIndex] + currentSum, target, currentIndex + 1);

		}
	}

	/**
	 * Time: O(target * n), Space: O(t * n)
	 */
	class BottomUpTabulation {
		/**
		 * here we're counting how many times a particular sum may occur ignore the
		 * offsetSum as of now
		 */
		public int findTargetSumWays(int[] nums, int target) {
			// this offsetSum is used to access the array incase of negative sum
			int offsetSum = Arrays.stream(nums).sum();

			// first check whether target is in bound or not
			// it can be out of bound which may cause IndexOutOfBound Error
			if (Math.abs(target) > offsetSum)
				return 0;

			int dp[][] = new int[nums.length][2 * offsetSum + 1];

			// if we add first value of nums it will generate 1 for each case
			// i.e. for + and for -, and nums[i] could be 0
			dp[0][nums[0] + offsetSum] = 1;
			dp[0][-nums[0] + offsetSum] += 1;

			// as first index is covered, start from second
			for (int i = 1; i < nums.length; i++) {
				// for every sum
				for (int sum = -offsetSum; sum <= offsetSum; sum++) {
					// add and subtract current nums[i]
					// and add the count when current element was not included
					if (dp[i - 1][sum + offsetSum] > 0) {
						// this if is used to remove the bug: when sum = offsetSum and
						// -num[i] and num[i] will lead to indexOutOfBoundException
						dp[i][nums[i] + sum + offsetSum] += dp[i - 1][sum + offsetSum];
						dp[i][-nums[i] + sum + offsetSum] += dp[i - 1][sum + offsetSum];
					}
				}
			}

			return dp[nums.length - 1][offsetSum + target];
		}

	}
}
