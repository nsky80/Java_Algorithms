package com.dp.easy.fib;

import java.util.Arrays;

public class MinCostClimbingStairs {
	static int count;

	/**
	 * Greedy fails for input: 10 15 20
	 * 
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairsGreedy(int[] cost) {
		int totalCost = 0;

		int n = cost.length;
		int i = 0;

		while (i < n - 1) {
			if (cost[i] < cost[i + 1]) {
				totalCost += cost[i];
				i++;
			} else {
				totalCost += cost[i + 1];
				i += 2;
			}
		}
		return totalCost;
	}

	/**
	 * Time complexity of this solution: O(2 ^ n) Space Complexity: O(n) - Recursion
	 * stack
	 * 
	 * @param cost
	 * @param i
	 * @param n
	 * @return
	 */
	public int minCostRecursionBU(int[] cost, int i, int n) {
		count++;
		// exceptional case
		if (n == 1)
			return cost[n - 1];

		if (i == n - 1)
			return cost[i];

		if (i >= n)
			return 0;

		// get the minimum from nth index
		int n1 = minCostRecursionBU(cost, i + 1, n);
		int n2 = minCostRecursionBU(cost, i + 2, n);
		int res = Math.min(n1, n2);

		// for the root element which is -1, it doesn't have any value to include
		if (i >= 0)
			res += cost[i];
//		System.out.println(n1 + " " + n2 + " " + res);
		return res;
	}

	/**
	 * Time complexity: O(2 ^ n) Space complexity: O(n)
	 * 
	 * @param cost
	 * @param n
	 * @return
	 */
	public int minCostRecursionTD(int[] cost, int n) {
		count++;
		// exceptional case
		if (cost.length == 1)
			return cost[0];

		// base case
		if (n == 0)
			return cost[n];
		if (n < 0)
			return 0;

		// get the minimum from nth index
		int n1 = minCostRecursionTD(cost, n - 1);
		int n2 = minCostRecursionTD(cost, n - 2);
		int res = Math.min(n1, n2);

		// for the root element which is n, it doesn't have any value to include
		if (n < cost.length)
			res += cost[n];
//		System.out.println(n1 + " " + n2 + " " + res);
		return res;
	}

	public int minCostClimbingStairsRecursion(int[] cost) {
		System.out.println(minCostRecursionBU(cost, -1, cost.length) + " " + count);
		;
		count = 0;
		return minCostRecursionTD(cost, cost.length);
	}

	/**
	 * Memoized solution || Top down Dynamic programming
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairsDP_TD(int[] cost) {
		// exceptional case
		if (cost.length == 1)
			return cost[0];

		int memo[] = new int[cost.length + 1];
		Arrays.fill(memo, -1);
		System.out.println(minCostDP_TD_BU(cost, -1, cost.length, memo) + " " + count);

		count = 0;
		Arrays.fill(memo, -1);
		return minCostDP_TD(cost, cost.length, memo);
	}

	private int minCostDP_TD(int[] cost, int n, int[] memo) {
//		count++;

		// base case
		if (n == 0)
			return cost[n];
		if (n < 0)
			return 0;

		if (memo[n] != -1)
			return memo[n];
		System.out.println(n);
		// get the minimum from nth index
		int n1 = minCostDP_TD(cost, n - 1, memo);
		int n2 = minCostDP_TD(cost, n - 2, memo);
		int res = Math.min(n1, n2);

		// for the root element which is n, it doesn't have any value to include
		if (n < cost.length)
			res += cost[n];

		memo[n] = res;
		return res;
	}

	private int minCostDP_TD_BU(int[] cost, int i, int n, int[] memo) {

		return 0;
	}
	
	
	private int minCostDP_BU(int []cost) {
		int n = cost.length;
		int [] dp = new int[n + 1];
		
		// base case
		dp[0] = cost[0];
		dp[1] = cost[1];
		
		for(int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
		}
		
		return Math.min(dp[n - 1], dp[n - 2]);
	}

	public static void main(String[] args) {
		MinCostClimbingStairs obj = new MinCostClimbingStairs();
		int[] arr = { 10, 15, 20 };
		int[] arr2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		count = 0;
		System.out.println(obj.minCostClimbingStairsRecursion(arr) + " " + count);
		count = 0;
		System.out.println(obj.minCostClimbingStairsRecursion(arr2) + " " + count);
		count = 0;
		System.out.println(obj.minCostClimbingStairsDP_TD(arr) + " " + count);
		count = 0;
		System.out.println(obj.minCostClimbingStairsDP_TD(arr2) + " " + count);
		count = 0;
		System.out.println(obj.minCostDP_BU(arr) + " " + count);
		count = 0;
		System.out.println(obj.minCostDP_BU(arr2) + " " + count);
	}

}
