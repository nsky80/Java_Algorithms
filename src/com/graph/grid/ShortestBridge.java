/**
 * https://leetcode.com/problems/shortest-bridge/
 */
package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * First visit all the 1 in first island and put their position into queue and
 * then apply BFS on all 1's simultaneously and get the shortest path. Time: O(m
 * * n) Space: O(m * n)
 * 
 * @author satis
 *
 */
public class ShortestBridge {
	static int[] dvr = { -1, 1, 0, 0 };
	static int[] dvc = { 0, 0, -1, 1 };
	Queue<Integer> rq;
	Queue<Integer> cq;
	int n;

	public int shortestBridge(int[][] grid) {
		rq = new ArrayDeque<>();
		cq = new ArrayDeque<>();
		n = grid.length;

		boolean[][] visited = new boolean[n][n];

		boolean flag = false;
		// it will visit the first island and add it into the queue
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 1) {
					visitFirstIsland(grid, visited, r, c);
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

		// apply BFS to get all the islands
		int nodesRemain = rq.size();
		int nodesNext = 0;
		int levels = 0;

		// now apply BFS and count the levels, it ensures the shortest path
		while (!rq.isEmpty()) {
			int r = rq.poll();
			int c = cq.poll();

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (!(rr < 0 || cc < 0 || rr >= n || cc >= n || visited[rr][cc])) {
					if (grid[rr][cc] == 1)
						return levels;

					visited[rr][cc] = true;
					rq.offer(rr);
					cq.offer(cc);
					nodesNext++;
				}
			}

			nodesRemain--;
			if (nodesRemain == 0) {
				nodesRemain = nodesNext;
				nodesNext = 0;
				levels++;
			}

		}

		return levels;

	}

	/**
	 * Visiting and adding all the element of first island.
	 * 
	 * @param grid
	 * @param visited
	 * @param r
	 * @param c
	 */
	public void visitFirstIsland(int[][] grid, boolean[][] visited, int r, int c) {
		visited[r][c] = true;
		rq.offer(r);
		cq.offer(c);
		for (int d = 0; d < dvr.length; d++) {
			int rr = r + dvr[d];
			int cc = c + dvc[d];

			if (!(rr < 0 || cc < 0 || rr >= n || cc >= n || grid[rr][cc] != 1 || visited[rr][cc])) {
				visitFirstIsland(grid, visited, rr, cc);
			}
		}
	}

}
