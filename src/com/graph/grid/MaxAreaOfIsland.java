/**
 * Get the maximum area of an island.
 * URL: https://leetcode.com/problems/max-area-of-island/
 */
package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		boolean visited[][] = new boolean[m][n];
		int maxArea = 0;

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 1 && (!visited[r][c])) {
					maxArea = Math.max(maxArea, calculateAreaDFS(grid, visited, r, c));
				}
			}
		}
		return maxArea;
	}

	/**
	 * BFS implementation of problem.
	 * Time: O(m * n)
	 * Space: O(m * n)
	 * @param grid
	 * @param visited
	 * @param r
	 * @param c
	 * @return
	 */
	public int calculateAreaBFS(int[][] grid, boolean[][] visited, int r, int c) {
		int[] dvr = { -1, 1, 0, 0 };
		int[] dvc = { 0, 0, -1, 1 };

		int count = 0;
		Deque<Integer> rq = new ArrayDeque<>();
		Deque<Integer> cq = new ArrayDeque<>();

		// Queue<Integer> rq = new LinkedList<>();
		// Queue<Integer> cq = new LinkedList<>();

		visited[r][c] = true;
		rq.add(r);
		cq.add(c);

		while (!rq.isEmpty()) {
			count++;
			int row = rq.poll();
			int col = cq.poll();

			for (int dir = 0; dir < dvr.length; dir++) {
				int rr = row + dvr[dir];
				int cc = col + dvc[dir];

				if (isSafe(grid, visited, rr, cc)) {
					visited[rr][cc] = true;
					rq.add(rr);
					cq.add(cc);
				}
			}
		}
		return count;
	}

	/**
	 * DFS implementation of the problem.
	 * Time: O(m * n)
	 * Space: O(m * n)
	 * @param grid
	 * @param visited
	 * @param r
	 * @param c
	 * @return
	 */
	public int calculateAreaDFS(int[][] grid, boolean[][] visited, int r, int c) {
		visited[r][c] = true;
		int[] dvr = { -1, 1, 0, 0 };
		int[] dvc = { 0, 0, -1, 1 };

		int count = 1;

		for (int dir = 0; dir < dvr.length; dir++) {
			int rr = r + dvr[dir];
			int cc = c + dvc[dir];

			if (isSafe(grid, visited, rr, cc)) {
				count += calculateAreaDFS(grid, visited, rr, cc);
			}
		}

		return count;
	}

	/**
	 * Utility method to check whether it is safe to visit given row r and column c.
	 * 
	 * @param grid
	 * @param visited
	 * @param r
	 * @param c
	 * @return true if safe to visit otherwise false.
	 */
	public boolean isSafe(int[][] grid, boolean visited[][], int r, int c) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 1 || visited[r][c])
			return false;
		return true;
	}

	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		System.out.println(obj.maxAreaOfIsland(grid));
	}

}
