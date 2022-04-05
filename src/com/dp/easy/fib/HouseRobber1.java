/**
 * URL: https://leetcode.com/problems/house-robber/
 */
package com.dp.easy.fib;

import java.util.Arrays;

public class HouseRobber1 {
	static int count;

	public int robEfficient(int[] nums) {
		return rob(nums, nums.length - 1);
	}

	private int rob(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}

	public int robSpaceOptimizedDP_BU(int nums[]) {
		int n = nums.length;
		if (n == 0) return 0;
		
		int p1 = 0;
		int p2 = nums[0];
		int p3 = 0;
		
		for(int i = 1; i <= n; i++) {
			int val = nums[i - 1];
			p3 = Math.max(p1 + val, p2);
			p1 = p2;
			p2 = p3;
		}
		
		return p3;
	}
	
	
	/**
	 * As n >= 1, so handling special case doesn't require.
	 * 
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {

		// recursive solution takes n + 1 in-place of n as
		// at a time robber can go either of n - 2 and n - 3
		count = 0;
		System.out.println(robRecursion(nums, nums.length + 1) + "  " + count);

		int memo[] = new int[nums.length + 2];
		Arrays.fill(memo, -1);
		count = 0;
		System.out.println(robDP_TD(nums, nums.length + 1, memo) + "  " + count);
		System.out.println(robDP_BU(nums) + "  " + count);
		System.out.println(robSpaceOptimizedDP_BU(nums) + "  " + count);

		return 0;
	}

	/**
	 * Initially n was nums.length + 1
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	private int robRecursion(int[] nums, int n) {
		count++;
		if (n == 0)
			return nums[0];
		// base case.
		if (n < 0)
			return 0;

		int maxRobbery = Math.max(robRecursion(nums, n - 2), robRecursion(nums, n - 3));

		if (n < nums.length) {
			maxRobbery += nums[n];
		}
		return maxRobbery;
	}

	private int robDP_TD(int[] nums, int n, int[] memo) {
		count++;
		if (n == 0)
			return nums[0];
		// base case.
		if (n < 0)
			return 0;

		if (memo[n] != -1)
			return memo[n];

		int maxRobbery = Math.max(robDP_TD(nums, n - 2, memo), robDP_TD(nums, n - 3, memo));

		if (n < nums.length) {
			maxRobbery += nums[n];
		}
		return memo[n] = maxRobbery;
	}

	private int robDP_BU(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		dp[2] = nums[1];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
		}

		return Math.max(dp[n - 1], dp[n]);
	}

	public static void main(String[] args) {
		int test1[] = { 1, 2, 3, 1 };
		int test2[] = { 2, 7, 9, 3, 1 };
		int test3[] = { 3 };
		int test4[] = { 1, 2, 1, 2, 3, 4, 3, 4, 5, 6, 5, 6 };
		HouseRobber1 obj = new HouseRobber1();
		obj.rob(test1);
		obj.rob(test2);
		obj.rob(test3);
		obj.rob(test4);
	}

}
