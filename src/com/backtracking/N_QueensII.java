/**
 * https://leetcode.com/problems/n-queens-ii/
 */
package com.backtracking;

/**
 * This solution will not create board as we need to count the number of
 * possible solution, we're using 2*n size boolean array as diagonal values are
 * ranging from -(n - 1) to (n - 1).
 * 
 * @author satis
 *
 */
public class N_QueensII {
	class Solution {
		int n;

		public int totalNQueens(int n) {
			this.n = n;
			return backtrack(new boolean[n], new boolean[2 * n], new boolean[2 * n], 0);
		}

		public int backtrack(boolean[] columns, boolean[] posDiag, boolean[] negDiag, int row) {
			if (row == n)
				return 1;

			int count = 0;

			for (int col = 0; col < n; col++) {
				// calculating the values of positive and negative slop diagonals
				int pos = row + col;
				int neg = n + row - col - 1;

				if (columns[col] || posDiag[pos] || negDiag[neg])
					continue;

				// include current column
				columns[col] = true;
				posDiag[pos] = true;
				negDiag[neg] = true;

				// recurse
				count += backtrack(columns, posDiag, negDiag, row + 1);

				// backtrack
				columns[col] = false;
				posDiag[pos] = false;
				negDiag[neg] = false;
			}

			return count;
		}
	}
}
