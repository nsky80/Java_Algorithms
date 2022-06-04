/**
 * https://leetcode.com/problems/n-queens/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author satis
 *
 */
public class N_Queens {
	class Solution {
		private int n;

		public List<List<String>> solveNQueens(int n) {
			this.n = n;
			List<List<String>> ans = new ArrayList<>();
			char[][] board = new char[n][n];

			for (int i = 0; i < n; i++)
				Arrays.fill(board[i], '.');

			// set would be used to track the already included columns and diagonals
			backtrack(ans, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);

			return ans;
		}

		public void backtrack(List<List<String>> ans, char[][] board, Set<Integer> cols, Set<Integer> negDiag,
				Set<Integer> posDiag, int row) {
			if (row == n) {
				// A solution has been found, add this into the answer
				List<String> solution = new ArrayList<>();

				for (char[] r : board) {
					solution.add(new String(r));
				}

				ans.add(solution);
				return;
			}

			for (int col = 0; col < n; col++) {
				// the sum of row and col would be same in all positive diagonal
				int pDia = row + col;

				// the difference of row and col would same in all negative diagonal
				int nDia = row - col;

				// validate the current col and perform
				if (!cols.contains(col) && !negDiag.contains(nDia) && !posDiag.contains(pDia)) {
					// add Q at current position
					board[row][col] = 'Q';
					cols.add(col);
					posDiag.add(pDia);
					negDiag.add(nDia);

					// check in next row
					backtrack(ans, board, cols, negDiag, posDiag, row + 1);

					// backtrack
					board[row][col] = '.';
					cols.remove(col);
					posDiag.remove(pDia);
					negDiag.remove(nDia);
				}
			}

		}
	}
}
