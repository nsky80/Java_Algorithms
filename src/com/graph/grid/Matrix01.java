package com.graph.grid;

import java.util.Queue;
import java.util.ArrayDeque;

public class Matrix01 {

	int[] dvr = { -1, 1, 0, 0 };
	int[] dvc = { 0, 0, -1, 1 };

	/**
	 * Apply BFS at the 0's at the same time. Time: O(m * n) Space: O(m * n) for
	 * queue
	 */

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		Queue<Integer> rq = new ArrayDeque<>();
		Queue<Integer> cq = new ArrayDeque<>();

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (mat[r][c] == 0) {
					rq.offer(r);
					cq.offer(c);
				}
			}
		}

		int[][] distance = new int[m][n];

		while (!rq.isEmpty()) {
			int r = rq.poll();
			int c = cq.poll();

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (!(rr < 0 || cc < 0 || rr >= m || cc >= n || mat[rr][cc] != 1 || distance[rr][cc] != 0)) {
					distance[rr][cc] = distance[r][c] + 1;
					rq.offer(rr);
					cq.offer(cc);
				}
			}

		}
		return distance;
	}

}
