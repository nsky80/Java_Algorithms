/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
package com.dp.medium;

import java.util.Arrays;

/**
 * @author satis
 *
 */
public class MinimumFallingPathSum {
	static class Tabulation {
		/**
		 * O(n * n), O(n * n).
		 */
		public int minFallingPathSum(int[][] matrix) {
			int n = matrix.length;

			int dp[][] = new int[n][n];
			dp[n - 1] = matrix[n - 1].clone();

			for (int r = n - 2; r >= 0; r--) {
				for (int c = 0; c < n; c++) {
					dp[r][c] = Math.min(dp[r + 1][c - 1 < 0 ? 0 : c - 1],
							Math.min(dp[r + 1][c], dp[r + 1][c + 1 >= n ? c : c + 1])) + matrix[r][c];
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				min = Math.min(min, dp[0][i]);
			}

			return min;
		}
	}

	static class Memoization {
		/**
		 * Time: n * n Space: O(n * n)
		 */
		int memo[][];

		public int minFallingPathSum(int[][] matrix) {
			int n = matrix.length;
			int min = Integer.MAX_VALUE;
			memo = new int[n][n];

			for (int i = 0; i < n; i++) {
				Arrays.fill(memo[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < n; i++) {
				min = Math.min(min, getMin(0, i, n, matrix));
			}

			return min;
		}

		private int getMin(int r, int c, int n, int[][] matrix) {
			if (r >= n)
				return 0;

			if (c < 0 || c >= n)
				return Integer.MAX_VALUE;

			if (memo[r][c] != Integer.MAX_VALUE)
				return memo[r][c];

			return memo[r][c] = Math.min(getMin(r + 1, c, n, matrix),
					Math.min(getMin(r + 1, c - 1, n, matrix), getMin(r + 1, c + 1, n, matrix))) + matrix[r][c];
		}
	}

	static class Recursive {
		/**
		 * Time: n * (3 ^ n - 1) Space: O(n)
		 */
		public int minFallingPathSum(int[][] matrix) {
			int n = matrix.length;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				min = Math.min(min, getMin(0, i, n, matrix));
			}

			return min;
		}

		private int getMin(int r, int c, int n, int[][] matrix) {
			if (r >= n)
				return 0;

			if (c < 0 || c >= n)
				return Integer.MAX_VALUE;

			return Math.min(getMin(r + 1, c, n, matrix),
					Math.min(getMin(r + 1, c - 1, n, matrix), getMin(r + 1, c + 1, n, matrix))) + matrix[r][c];
		}
	}
}
