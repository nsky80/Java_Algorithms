/**
 * https://www.lintcode.com/problem/663/description
 */
package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class WallsAndGates {

	/**
	 * O(m * n), O(m * n): solution
	 */
	static class Solution {
		/**
		 * @param rooms: m x n 2D grid
		 * @return: nothing
		 */
		static int INF = 2147483647;
		static int[] dvr = { -1, 1, 0, 0 };
		static int[] dvc = { 0, 0, -1, 1 };

		public void wallsAndGates(int[][] rooms) {
			// write your code here
			Deque<Integer> rq = new ArrayDeque<>();
			Deque<Integer> cq = new ArrayDeque<>();

			int m = rooms.length;
			int n = rooms[0].length;

			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (rooms[r][c] == 0) {
						rq.offer(r);
						cq.offer(c);
					}
				}
			}

			while (!rq.isEmpty()) {
				int r = rq.poll();
				int c = cq.poll();

				for (int d = 0; d < dvr.length; d++) {
					int rr = r + dvr[d];
					int cc = c + dvc[d];

					if (rr >= 0 && rr < m && cc >= 0 && cc < n && rooms[rr][cc] == INF) {
						rooms[rr][cc] = rooms[r][c] + 1;
						rq.offer(rr);
						cq.offer(cc);
					}
				}
			}
		}
	}
}
