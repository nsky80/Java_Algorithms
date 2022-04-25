/**
 * https://leetcode.com/problems/maximal-square/
 */
package com.dp;

/**
 * @author satis
 *
 */
public class MaximalSquare {

	class SpaceOptimizedDP_BU {
		int m;
		int n;

		/**
		 * Time: O(m * n) ^ 2, Space: O(n)
		 */
		public int maximalSquare(char[][] matrix) {
			int max = 0;
			m = matrix.length;
			n = matrix[0].length;

			int dp[] = new int[n + 1];

			for (int i = 0; i < m; i++) {
				// saving diagonal for comparison
				int dia = 0;

				// starting j from 1 to avoid underflow condition
				for (int j = 1; j <= n; j++) {
					int backup = dp[j];
					if (matrix[i][j - 1] == '1') {

						dp[j] = Math.min(dp[j - 1], Math.min(dp[j], dia)) + 1;
						// update the result
						max = Math.max(max, dp[j]);
					} else {
						// reset the value
						dp[j] = 0;
					}
					// update the dia
					dia = backup;
				}

			}

			return max * max;
		}

	}

	class BottomUpDynamicProgramming {
		int m;
		int n;

		/**
		 * Time: O(m * n) ^ 2, Space: O(max(m, n))
		 */
		public int maximalSquare(char[][] matrix) {
			int max = 0;
			m = matrix.length;
			n = matrix[0].length;

			int dp[][] = new int[m + 1][n + 1];

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (matrix[i - 1][j - 1] == '1') {
						dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
						max = Math.max(max, dp[i][j]);
					}
				}
			}

			return max * max;
		}

	}

	class BruteForceRecursive {
		int m;
		int n;

		/**
		 * Time: O(m * n) ^ 2, Space: O(max(m, n))
		 */
		public int maximalSquare(char[][] matrix) {
			int max = 0;
			m = matrix.length;
			n = matrix[0].length;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == '1')
						max = Math.max(max, 1 + getMax(matrix, i, j, 1));
				}
			}

			return max * max;
		}

		public int getMax(char[][] grid, int r, int c, int steps) {
			if (r + steps >= m || c + steps >= n)
				return 0;

			for (int cc = c; cc <= c + steps; cc++) {
				if (grid[r + steps][cc] == '0')
					return 0;
			}

			for (int rr = r; rr <= r + steps; rr++) {
				if (grid[rr][c + steps] == '0')
					return 0;
			}

			return 1 + getMax(grid, r, c, steps + 1);

		}
	}
}
