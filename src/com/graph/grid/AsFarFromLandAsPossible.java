/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/submissions/
 */
package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author satis
 *
 */
public class AsFarFromLandAsPossible {

	int n;
	int dvr[] = { -1, 1, 0, 0 };
	int dvc[] = { 0, 0, -1, 1 };

	/**
	 * Time complexity: O(n * n) Space: O(n)
	 * 
	 * @param grid
	 * @return
	 */
	public int maxDistance(int[][] grid) {
		n = grid.length;

		// get all the nodes with land and add into the queue
		Queue<Integer> rq = new ArrayDeque<>();
		Queue<Integer> cq = new ArrayDeque<>();

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 1) {
					rq.add(r);
					cq.add(c);
				}
			}
		}
		int max = bfs(grid, rq, cq);
//		for (int r = 0; r < n; r++) {
//			for (int c = 0; c < n; c++) {
//				max = Math.max(max, grid[r][c]);
//			}
//		}

		return max <= 1 ? -1 : max - 1;
	}

	private int bfs(int[][] grid, Queue<Integer> rq, Queue<Integer> cq) {
		int nodesRemains = rq.size();
		int nodesInNext = 0;
		int dis = 1;

		while (!rq.isEmpty()) {
			int r = rq.poll();
			int c = cq.poll();

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (!(rr < 0 || cc < 0 || rr >= n || cc >= n || grid[rr][cc] != 0)) {
					grid[rr][cc] += grid[r][c] + 1;
					rq.offer(rr);
					cq.offer(cc);
					nodesInNext++;
				}
			}

			nodesRemains--;
			if (nodesRemains == 0) {
				nodesRemains = nodesInNext;
				nodesInNext = 0;
				dis++;
			}
		}

		return dis - 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[][] = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		int arr1[][] = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int arr2[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int arr3[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		AsFarFromLandAsPossible obj = new AsFarFromLandAsPossible();
		System.out.println(obj.maxDistance(arr));
		System.out.println(obj.maxDistance(arr1));
		System.out.println(obj.maxDistance(arr2));
		System.out.println(obj.maxDistance(arr3));
	}

}
