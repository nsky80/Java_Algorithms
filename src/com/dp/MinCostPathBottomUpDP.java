package com.dp;

public class MinCostPathBottomUpDP {

	public static int min(int x, int y, int z) {
		return Math.min(Math.min(y, z), x);
	}

	public static int getMinPath(int[][] cost, int m, int n) {
		if (m == 0 && n == 0) {
			return cost[m][n];
		}

		// creating the dp array
		int dp[][] = new int[m + 1][n + 1];

		// base case
		dp[0][0] = cost[0][0];

		// if only 1 row present then min cost would be sum array
		for (int i = 1; i <= m; i++) {
			dp[0][i] = dp[0][i - 1] + cost[0][i];
		}

		// if only 1 column present then min cost would be vertical sum
		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + cost[i][0];
		}


		// now calculate the min path for remaining cells
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + cost[i][j];
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.println(getMinPath(cost, m - 1, n - 1));

	}

}
