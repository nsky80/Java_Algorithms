package com.graph.grid;

public class NumberOfEnclaves {
	int m;
	int n;
	static int dvr[] = { -1, 1, 0, 0 };
	static int dvc[] = { 0, 0, -1, 1 };

	public int numEnclaves(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int count = 0;
		boolean tracker[][] = new boolean[m][n];

		// for first and last row
		for (int c = 0; c < n; c++) {
			checkAndCall(0, c, grid, tracker);
			checkAndCall(m - 1, c, grid, tracker);
		}

		// for first and last column
		for (int r = 1; r < m - 1; r++) {
			checkAndCall(r, 0, grid, tracker);
			checkAndCall(r, n - 1, grid, tracker);
		}

		// now count
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 1 && (!tracker[r][c])) {
					count++;
				}
			}
		}

		return count;
	}

	public void checkAndCall(int r, int c, int grid[][], boolean tracker[][]) {
		if (grid[r][c] == 1 && !tracker[r][c]) {
			dfs(grid, tracker, r, c);
		}
	}

	public void dfs(int grid[][], boolean[][] visited, int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < dvr.length; d++) {
			int rr = r + dvr[d];
			int cc = c + dvc[d];

			if (!(rr < 0 || cc < 0 || rr >= m || cc >= n || grid[rr][cc] != 1 || visited[rr][cc])) {
				dfs(grid, visited, rr, cc);
			}
		}
	}
}
