/**
 * 
 */
package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author satis
 *
 */
public class NearestExitFromEntranceInMaze {
	static int[] dvr = { -1, 1, 0, 0 };
	static int[] dvc = { 0, 0, -1, 1 };
	int m;
	int n;

	public int nearestExit(char[][] maze, int[] entrance) {
		m = maze.length;
		n = maze[0].length;

		boolean visited[][] = new boolean[m][n];
		int r = entrance[0];
		int c = entrance[1];

		visited[r][c] = true;
		Queue<Integer> rq = new ArrayDeque<>();
		Queue<Integer> cq = new ArrayDeque<>();

		rq.offer(r);
		cq.offer(c);
		int levels = 0;
		boolean isEscaped = false;
		int nodesRemains = 1;
		int nodesNext = 0;
		while (!rq.isEmpty()) {
			r = rq.poll();
			c = cq.poll();

			for (int d = 0; d < dvr.length; d++) {
				int rr = r + dvr[d];
				int cc = c + dvc[d];

				if (!(r == entrance[0] && c == entrance[1])) {
					if (rr < 0 || cc < 0 || rr >= m || cc >= n) {
						isEscaped = true;
						break;
					}
				}

				if (!(rr < 0 || cc < 0 || rr >= m || cc >= n || maze[rr][cc] != '.' || visited[rr][cc])) {
					visited[rr][cc] = true;
					rq.offer(rr);
					cq.offer(cc);
					nodesNext++;
				}
			}
			if (isEscaped)
				break;

			nodesRemains--;
			if (nodesRemains == 0) {
				nodesRemains = nodesNext;
				nodesNext = 0;
				levels++;
			}
		}

		return isEscaped ? levels : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
		int ent[] = {1, 2};
		NearestExitFromEntranceInMaze obj = new NearestExitFromEntranceInMaze();
		System.out.println(obj.nearestExit(maze, ent));
	}

}
