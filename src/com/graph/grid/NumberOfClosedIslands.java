/**
 * https://leetcode.com/problems/number-of-closed-islands/
 */
package com.graph.grid;

public class NumberOfClosedIslands {

	int[] dvr = { -1, 1, 0, 0 };
	int[] dvc = { 0, 0, -1, 1 };
	int m;
	int n;

	public int closedIsland(int[][] grid) {
		int count = 0;

		m = grid.length;
		n = grid[0].length;
		boolean visited[][] = new boolean[m][n];

		for (int r = 1; r < m - 1; r++) {
			for (int c = 1; c < n - 1; c++) {
				if (grid[r][c] == 0 && (!visited[r][c]) && dfs(r, c, grid, visited, true)) {
					count++;
				}
			}
		}

		return count;
	}

	public boolean dfs(int r, int c, int grid[][], boolean[][] visited, boolean status) {
		visited[r][c] = true;

		for (int d = 0; d < dvr.length; d++) {
			int rr = dvr[d] + r;
			int cc = dvc[d] + c;

			if (!(rr < 0 || cc < 0 || rr >= m || cc >= n || grid[rr][cc] == 1 || visited[rr][cc])) {
				if (rr == 0 || cc == 0 || rr == m - 1 || cc == n - 1) {
					status = false;
				}
				status = dfs(rr, cc, grid, visited, status);
			}
		}

		return status;
	}

	public static void main(String[] args) {
		NumberOfClosedIslands obj = new NumberOfClosedIslands();
		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		System.out.println(obj.closedIsland(grid));

	}

}
