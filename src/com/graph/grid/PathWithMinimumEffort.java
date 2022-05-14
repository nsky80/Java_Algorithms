/**
 * Binary Search: https://leetcode.com/problems/path-with-minimum-effort/
 */
package com.graph.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author satis
 *
 */
public class PathWithMinimumEffort {

	/**
	 * Time: log(maxDifference - minDifference)*(m * n) Space: m * n
	 */
	static class MinMaxApproach {
		static int[] dvr = { 1, -1, 0, 0 };
		static int[] dvc = { 0, 0, 1, -1 };
		int m;
		int n;

		public int minimumEffortPath(int[][] h) {
			m = h.length;
			n = h[0].length;

			// if there is only single element
			if (m == 1 && n == 1)
				return 0;

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			// get upper and lower bound for binary search
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					// right
					if (j < n - 1) {
						int right = Math.abs(h[i][j] - h[i][j + 1]);
						min = Math.min(min, right);
						max = Math.max(max, right);
					}

					// for bottom
					if (i < m - 1) {
						int bottom = Math.abs(h[i][j] - h[i + 1][j]);
						min = Math.min(min, bottom);
						max = Math.max(max, bottom);

					}
				}
			}

			int ans = max;

			// apply binary search on bounds
			while (min <= max) {
				int mid = min + (max - min) / 2;

				if (dfs(h, 0, 0, new boolean[m][n], mid)) {
					max = mid - 1;
					ans = Math.min(ans, mid);
				} else {
					min = mid + 1;
				}
			}

			return ans;
		}

		private boolean dfs(int[][] h, int r, int c, boolean[][] visited, int expected) {
			if (r == m - 1 && c == n - 1)
				return true;

			visited[r][c] = true;

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (rr >= 0 && rr < m && cc >= 0 && cc < n && (!visited[rr][cc])) {
					if (Math.abs(h[r][c] - h[rr][cc]) <= expected) {
						if (dfs(h, rr, cc, visited, expected)) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}

	/*
	 * k = number of unique differences Time: O(klogk + logk * m * n) Space: O(k +
	 * m*n)
	 */
	static class SolutionUsingSetAndSorting {
		static int[] dvr = { 1, -1, 0, 0 };
		static int[] dvc = { 0, 0, 1, -1 };
		int m;
		int n;

		public int minimumEffortPath(int[][] h) {
			m = h.length;
			n = h[0].length;

			// if there is only single element
			if (m == 1 && n == 1)
				return 0;

			Set<Integer> set = new HashSet<>();

			// get upper and lower bound for binary search
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					// right
					if (j < n - 1) {
						set.add(Math.abs(h[i][j] - h[i][j + 1]));
					}

					// for bottom
					if (i < m - 1) {
						set.add(Math.abs(h[i][j] - h[i + 1][j]));
					}
				}
			}

			List<Integer> values = new ArrayList<>(set);
			Collections.sort(values);

			int min = 0;
			int max = values.size();

			int ans = values.get(values.size() - 1);

			// apply binary search on bounds
			while (min <= max) {
				int mid = min + (max - min) / 2;

				if (dfs(h, 0, 0, new boolean[m][n], values.get(mid))) {
					max = mid - 1;
					ans = Math.min(ans, values.get(mid));
				} else {
					min = mid + 1;
				}
			}

			return ans;
		}

		private boolean dfs(int[][] h, int r, int c, boolean[][] visited, int expected) {
			if (r == m - 1 && c == n - 1)
				return true;

			visited[r][c] = true;

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (rr >= 0 && rr < m && cc >= 0 && cc < n && (!visited[rr][cc])) {
					if (Math.abs(h[r][c] - h[rr][cc]) <= expected) {
						if (dfs(h, rr, cc, visited, expected)) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}
}
