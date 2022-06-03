/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
package com.arrays.prefix_sum;

/**
 * Time: O(mn + q), Space: O(mn)
 * 
 * @author Satish
 *
 */
public class RangeSumQuery2D_Immutable {

	/**
	 * This solution uses 1 based indexing for storing the prefix sum, by using this
	 * technique we can avoid all the if-else comparison, which will make it
	 * somewhat efficient.
	 * 
	 * @author satis
	 *
	 */
	class NumMatrixOptimized {
		private int subSum[][];

		public NumMatrixOptimized(int[][] matrix) {
			subSum = new int[matrix.length + 1][matrix[0].length + 1];

			// calculate the prefix sum
			for (int i = 1; i <= matrix.length; i++) {
				for (int j = 1; j <= matrix[0].length; j++) {
					subSum[i][j] = matrix[i - 1][j - 1] + subSum[i - 1][j] + subSum[i][j - 1] - subSum[i - 1][j - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			// using 1 based indexing
			row1++;
			row2++;
			col1++;
			col2++;
			return subSum[row2][col2] - subSum[row1 - 1][col2] - subSum[row2][col1 - 1] + subSum[row1 - 1][col1 - 1];
		}
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
	 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */

	/**
	 * This is same solution, but it uses same indexing as the input have, in-order
	 * to avoid array index out of bound it uses multiple if-else check which
	 * consumes time.
	 * 
	 * @author satis
	 *
	 */
	class NumMatrixComplicated {
		private int subSum[][];

		public NumMatrixComplicated(int[][] matrix) {
			subSum = new int[matrix.length][matrix[0].length];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					subSum[i][j] = matrix[i][j] + (i > 0 ? subSum[i - 1][j] : 0) + (j > 0 ? subSum[i][j - 1] : 0)
							- (i > 0 && j > 0 ? subSum[i - 1][j - 1] : 0);
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return subSum[row2][col2] - (row1 > 0 ? subSum[row1 - 1][col2] : 0)
					- (col1 > 0 ? subSum[row2][col1 - 1] : 0) + (row1 > 0 && col1 > 0 ? subSum[row1 - 1][col1 - 1] : 0);
		}
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
	 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */
}
