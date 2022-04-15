/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
	int[] dvr = { -1, -1, -1, 1, 1, 1, 0, 0 };
	int[] dvc = { 0, 1, -1, 0, 1, -1, -1, 1 };

	public int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
			return -1;
		if (n == 1)
			return 1;

		boolean visited[][] = new boolean[n][n];

		Queue<Integer> rq = new ArrayDeque<>();
		Queue<Integer> cq = new ArrayDeque<>();
		rq.add(0);
		cq.add(0);
		visited[0][0] = true;
		int nodesRemains = 1;
		int nodesToBeVisited = 0;
		int levels = 1;

		while (!rq.isEmpty()) {
			int r = rq.poll();
			int c = cq.poll();

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (!(rr < 0 || cc < 0 || rr >= n || cc >= n || grid[rr][cc] != 0 || visited[rr][cc])) {
					if (rr == n - 1 && cc == n - 1) {
						return levels + 1;
					}
					visited[rr][cc] = true;
					rq.offer(rr);
					cq.offer(cc);
					nodesToBeVisited++;
				}
			}

			nodesRemains--;
			if (nodesRemains == 0) {
				nodesRemains = nodesToBeVisited;
				nodesToBeVisited = 0;
				levels++;
			}
		}

		return -1;
	}

}
