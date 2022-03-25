package com.dp;

public class MaximumPathSumInMatrixDPBottomUP {

	static int maximumPath(int N, int cost[][]) {
		// if there is only single row
		if (N == 1) {
			// it is a square matrix
			return cost[0][0];
		}

		int dp[][] = new int[N][N];

		// max for the first would be first
		dp[0][0] = cost[0][0];

		// put first and last row as it is
		for (int i = 0; i < N; i++) {
			dp[0][i] = cost[0][i];
			dp[N - 1][i] = cost[N - 1][i];
		}

		// calculate the max except first and last row
		for (int i = 1; i < N - 1; i++) {
			dp[i][0] = dp[i - 1][0] + cost[i][0];
		}

		// now calculate the remaining part except last row
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N; j++) {
				dp[i][j] = max(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + cost[i][j];
				System.out.print(" " + dp[i][j]);
			}
			System.out.println();
		}

		// now check the max value from the top
		// it can go down or diagonal
		// it is dealing with last row
		int maxTill = Integer.MIN_VALUE;

		// now check with remaining value
		for (int i = 0; i < N; i++) {
			// top will always exists
			if (dp[N - 2][i] + cost[N - 1][i] > maxTill) {
				// add from the top
				maxTill = dp[N - 2][i] + cost[N - 1][i];
			}
			// check from left diagonal
			if (i > 1 && dp[N - 2][i - 1] + cost[N - 1][i] > maxTill) {
				// adds from the right diagonal
				maxTill = dp[N - 2][i - 1] + cost[N - 1][i];
			}
			// check from right diagonal
			if (i < N - 1 && dp[N - 2][i + 1] + cost[N - 1][i] > maxTill) {
				// adds from the right diagonal
				maxTill = dp[N - 2][i + 1] + cost[N - 1][i];
			}
		}

		return maxTill;
	}

	private static int max(int i, int j, int k) {
		return Math.max(Math.max(j, k), i);
	}

	public static void main(String[] args) {
//		int m = 3, n = 3;
//		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
//		int[][] matrix = { { 348, 391 }, { 618, 193 } };
		int[][] matrix = { { 2,2  }, { 2, 2 } };
//		System.out.println(maximumPath(n, cost));
		System.out.println(maximumPath(2, matrix));
	}

}
