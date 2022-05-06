/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
package com.dp.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Time: O(n * sum(nums)), Space: O(n * sum(nums))
 *
 */
public class PartitionEqualSubsetSum {

	/**
	 * Time: O(n * sum(nums)) Space: O(sum(nums))
	 */
	class SpaceOptimizedBottomUpDP {

		public boolean canPartition(int[] nums) {
			// to divide the array into equal subset, the sum should be even.
			int total = Arrays.stream(nums).sum();
			if (total % 2 != 0)
				return false;

			total /= 2;

			// As we're referring -1 row every time so here we can
			// use same dp
			boolean dp[] = new boolean[total + 1];
			// when sum is zero then there always be a solution : base case
			dp[0] = true;
			for (int i = 1; i <= nums.length; i++) {
				// as it will refer item from top and left so we need
				// go from reverse, otherwise it will reference updated value
				// and we need previous state of the array
				for (int sum = total; sum >= 1; sum--) {

					// this pair has capacity to neutralize this sum
					if (sum - nums[i - 1] >= 0) {
						dp[sum] |= dp[sum - nums[i - 1]];
					}
				}

				if (dp[total] == true)
					return true;
			}

			return false;
		}

	}

	class BottomUP_DP1 {

		public boolean canPartition(int[] nums) {
			int total = Arrays.stream(nums).sum();
			if (total % 2 != 0)
				return false;
			total /= 2;

			boolean dp[][] = new boolean[nums.length + 1][total + 1];
			// when sum is zero then there always be a solution : base case
			dp[0][0] = true;
			for (int i = 1; i <= nums.length; i++) {
				dp[i][0] = true;
				for (int sum = 1; sum <= total; sum++) {
					// take the value from the top
					dp[i][sum] = dp[i - 1][sum];

					// this pair has capacity to neutralize this sum
					if (sum - nums[i - 1] >= 0) {
						dp[i][sum] |= dp[i - 1][sum - nums[i - 1]];
					}
				}
				if (dp[i][total] == true)
					return true;
			}

			return false;
		}

	}

	/**
	 * This is fastest top-down DP solution, it uses object array to memoize the
	 * solutions of sub-problems.
	 */
	class TopDownDP3 {

		Boolean memo[][];

		public boolean canPartition(int[] nums) {
			int total = Arrays.stream(nums).sum();
			if (total % 2 != 0)
				return false;

			memo = new Boolean[nums.length][total / 2 + 1];

			return subsetSum(nums, nums.length - 1, total / 2);
		}

		public boolean subsetSum(int[] nums, int n, int currentSum) {
			if (currentSum == 0)
				return true;
			if (currentSum < 0 || n < 0)
				return false;

			if (memo[n][currentSum] != null)
				return memo[n][currentSum];

			return memo[n][currentSum] = subsetSum(nums, n - 1, currentSum - nums[n])
					|| subsetSum(nums, n - 1, currentSum);

		}
	}

	/**
	 * This is somewhat faster than version-1 of top down, it uses 1 integer array
	 * to maintain the the status of subproblems, -1 means need to be computed, 1
	 * means solution, 0 means there is no solution.
	 */
	class TopDownDP2 {
		int memo[][];

		public boolean canPartition(int[] nums) {
			int total = Arrays.stream(nums).sum();
			if (total % 2 != 0)
				return false;

			memo = new int[nums.length][total / 2 + 1];

			// it initialized the integer array which takes a lot of time.
			for (int i = 0; i < nums.length; i++) {
				Arrays.fill(memo[i], -1);
			}

			boolean ans = subsetSum(nums, nums.length - 1, total / 2);

			return ans;
		}

		public boolean subsetSum(int[] nums, int n, int currentSum) {
			if (currentSum == 0)
				return true;
			if (currentSum < 0 || n < 0)
				return false;

			if (memo[n][currentSum] != -1)
				return memo[n][currentSum] == 1;

			boolean ans = subsetSum(nums, n - 1, currentSum - nums[n]) || subsetSum(nums, n - 1, currentSum);

			memo[n][currentSum] = ans ? 1 : 0;
			return ans;
		}
	}

	/**
	 * This can optimize the space in average-best case, but in worst case it can go
	 * as large as version2 and version3, as it uses hash instead of array so it
	 * look-up time is more as compared to array version.
	 * 
	 * It works best when early solution found.
	 */
	class TopDownDP1 {
		Map<String, Boolean> memo;

		public boolean canPartition(int[] nums) {
			int total = Arrays.stream(nums).sum();
			if (total % 2 != 0)
				return false;

			memo = new HashMap<>();

			boolean ans = subsetSum(nums, nums.length - 1, total / 2);

			return ans;
		}

		public boolean subsetSum(int[] nums, int n, int currentSum) {
			if (currentSum == 0)
				return true;
			if (currentSum < 0 || n < 0)
				return false;

			String key = Integer.toString(n) + "," + Integer.toString(currentSum);
			if (memo.containsKey(key))
				return memo.get(key);

			boolean ans = subsetSum(nums, n - 1, currentSum - nums[n]) || subsetSum(nums, n - 1, currentSum);

			memo.put(key, ans);
			return ans;
		}
	}
}
