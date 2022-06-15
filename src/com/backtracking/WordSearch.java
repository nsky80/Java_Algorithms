/**
 * https://leetcode.com/problems/word-search/
 */
package com.backtracking;

/**
 * Apply DFS from every element of the board as soon as the current character
 * matches the first character of the string. 
 * 
 * Time: O(m*n*4^s), Space: O (m + n)
 * 
 * @author satis
 *
 */
public class WordSearch {

	static class Solution {
		static int[] dvr = { -1, 1, 0, 0 };
		static int[] dvc = { 0, 0, -1, 1 };
		int m;
		int n;

		public boolean exist(char[][] board, String word) {
			m = board.length;
			n = board[0].length;

			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (board[r][c] == word.charAt(0) && dfs(board, r, c, word, 0))
						return true;
				}
			}

			return false;
		}

		public boolean dfs(char[][] board, int r, int c, String word, int pos) {
			if (pos == word.length())
				return true;

			if (r < 0 || c < 0 || r >= m || c >= n || word.charAt(pos) != board[r][c])
				return false;

			// select current character
			char backup = board[r][c];
			board[r][c] = '$';

			// recurse using dfs
			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (dfs(board, rr, cc, word, pos + 1))
					return true;
			}

			// backtrack
			board[r][c] = backup;

			return false;
		}
	}
}
