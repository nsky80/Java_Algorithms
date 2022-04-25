/**
 * https://leetcode.com/problems/matrix-block-sum/
 */
package com.arrays.prefix_sum;

/**
 * @author satis
 *
 */
public class MatrixBlockSum {

	/**
	 * This is solved using cumulative prefix sum and range query
	 * https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-integral-image/
	 */
	class Solution {
		public int[][] matrixBlockSum(int[][] mat, int k) {
			int m = mat.length;
			int n = mat[0].length;
			int prefix[][] = new int[m][n];

			getPrefixSum(mat, m, n, prefix);

			int rangeSum[][] = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {

					// calculate the dia, if exist and add it as we have
					// substracted top and left so dia got substracted 2 times
					int r = i - k - 1;
					int c = j - k - 1;
					int topLeft = r >= 0 && c >= 0 ? prefix[r][c] : 0;

					// calculate the bottom left if exist, it will get substracted
					r = i + k;
					c = j - k - 1;
					int bottomLeft = 0;
					if (c >= 0) {
						r = r >= m ? m - 1 : r;
						bottomLeft = prefix[r][c];
					}

					// now calculate the top right, it will also get substracted
					r = i - k - 1;
					c = j + k;
					int topRight = 0;
					if (r >= 0) {
						c = c >= n ? n - 1 : c;
						topRight = prefix[r][c];
					}

					// this is sum, which is will be included always
					r = i + k >= m ? m - 1 : i + k;
					c = j + k >= n ? n - 1 : j + k;
					int bottomRight = prefix[r][c];

					rangeSum[i][j] = bottomRight - bottomLeft - topRight + topLeft;

				}
			}

			return rangeSum;
		}

		private void getPrefixSum(int[][] mat, int m, int n, int[][] prefix) {
			// calculating the prefix sum or cumulative sum matrix where
			// prefix[i][j] is the sum of all cells in the rectangle
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int top = i > 0 ? prefix[i - 1][j] : 0;
					int left = j > 0 ? prefix[i][j - 1] : 0;

					// diagonal included 2 times in the sum so it needs to be substracted
					int diagonal = i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0;

					prefix[i][j] = mat[i][j] + top + left - diagonal;
				}
			}
		}
	}
}
