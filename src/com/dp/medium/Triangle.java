/**
 * https://leetcode.com/problems/triangle/
 */
package com.dp.medium;

import java.util.List;

/**
 * @author satis
 *
 */
public class Triangle {
	/**
	 * Time: O(2 ^ n), space: O(n)
	 */
	class Recursive {
		int n;

		public int minimumTotal(List<List<Integer>> triangle) {
			n = triangle.size();
			return mint(triangle, 0, 0);
		}

		private int mint(List<List<Integer>> tr, int r, int c) {
			if (r >= n)
				return 0;
			return Math.min(mint(tr, r + 1, c), mint(tr, r + 1, c + 1)) + tr.get(r).get(c);
		}
	}

	/**
	 * Time: O(n * n), Space: O(n)
	 */
	class TopDownDP {
		public int minimumTotal(List<List<Integer>> triangle) {
			int n = triangle.size();
			int dp[] = new int[n + 1];

			for (int i = n - 1; i >= 0; i--) {
				List<Integer> cr = triangle.get(i);
				for (int j = 0; j <= i; j++) {
					dp[j] = Math.min(dp[j], dp[j + 1]) + cr.get(j);
				}
			}

			return dp[0];
		}
	}
}
