/**
 * 
 */
package com.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(m * n), Space: O(1)
 * 
 * @author Satish
 *
 */
public class SpiralMatrix {

	class SolutionUsingOneLoop {
		/**
		 * When traversing the matrix in the spiral order, at any time we follow one out
		 * of the following four directions: RIGHT DOWN LEFT UP.
		 * https://leetcode.com/problems/spiral-matrix/discuss/20573/A-concise-C%2B%2B-implementation-based-on-Directions
		 * 
		 */
		public List<Integer> spiralOrder(int[][] matrix) {
			int m = matrix.length;
			int n = matrix[0].length;
			List<Integer> ans = new ArrayList<>();

			// It'll follow: Right -> Bottom -> Left -> Up order
			int dirs[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

			// Here m - 1, take example of 3 * 3
			int steps[] = { n, m - 1 };

			// It will keep track of current direction out of 4
			int direction = 0;

			// initial position
			int r = 0;
			int c = -1;

			// we have 2 choices row order and column order
			while (steps[direction % 2] > 0) {

				// add all the element of current row/column
				for (int d = 0; d < steps[direction % 2]; d++) {
					r += dirs[direction][0];
					c += dirs[direction][1];
					ans.add(matrix[r][c]);
				}

				// update the direction
				steps[direction % 2]--;
				direction = (direction + 1) % 4;
			}

			return ans;
		}
	}

	/**
	 * This is simulation of given problem, it solves the problem by dividing into 4
	 * small directional problem.
	 * 
	 * @author Satish
	 *
	 */
	class SolutionUsingFourLoops {
		public List<Integer> spiralOrder(int[][] matrix) {
			int m = matrix.length;
			int n = matrix[0].length;
			List<Integer> ans = new ArrayList<>();

			for (int i = 0; i < (int) Math.min(Math.ceil((float) m / 2), Math.ceil((float) n / 2)); i++) {
				// copy current top row
				for (int j = i; j < n - i; j++) {
					ans.add(matrix[i][j]);
				}

				// copy current right column
				for (int j = i + 1; j < m - i; j++) {
					ans.add(matrix[j][n - i - 1]);
				}

				// if there is spiral
				if (i < m / 2) {
					// copy current last row
					for (int j = n - i - 2; j >= i; j--) {
						ans.add(matrix[m - i - 1][j]);
					}

					// copy current first column
					for (int j = m - i - 2; j > i && i < n / 2; j--) {
						ans.add(matrix[j][i]);
					}
				}
			}

			return ans;
		}
	}
}
