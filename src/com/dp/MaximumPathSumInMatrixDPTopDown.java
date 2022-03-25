package com.dp;

import java.util.Arrays;

public class MaximumPathSumInMatrixDPTopDown {
	static int maximumPath(int N, int Matrix[][]) {
		// code here
		int dp[][] = new int[N][N];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int ans = 0;
		for (int j = 0; j < N; j++) {
			ans = Math.max(ans, helper(N - 1, j, Matrix, dp));
		}
		return ans;
	}

	static int helper(int m, int n, int o[][], int[][] dp) {
		if (m < 0 || n < 0 || n > o[0].length - 1)
			return 0;

		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		int top = helper(m - 1, n, o, dp);
		int down = helper(m - 1, n + 1, o, dp);
		int middle = helper(m - 1, n - 1, o, dp);

		dp[m][n] = o[m][n] + Math.max(top, Math.max(down, middle));
		return dp[m][n];
	}

	public static void main(String[] args) {
//		int m = 3, n = 3;
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
//		int[][] matrix = { { 348, 391 }, { 618, 193 } };
//		int[][] matrix = { { 2, 2 }, { 2, 2 } };
		System.out.println(maximumPath(3, cost));
//		System.out.println(maximumPath(2, matrix));
	}

}
