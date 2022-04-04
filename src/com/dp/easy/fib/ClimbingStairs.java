/**
 * URL: https://leetcode.com/problems/climbing-stairs/
 */
package com.dp.easy.fib;

public class ClimbingStairs {

	public int climbStairsTD(int n) {
		int memo[] = new int[n + 1];
		return f(n, memo);
	}

	public int f(int n, int memo[]) {
		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		if (memo[n] != 0)
			return memo[n];

		return memo[n] = f(n - 1, memo) + f(n - 2, memo);
	}

	public int climbingStairsBU(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
