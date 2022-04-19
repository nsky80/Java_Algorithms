/**
 * https://leetcode.com/problems/number-of-provinces/submissions/
 */
package com.graph.adj_matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class NumberOfProvinces {

	int n;

	public int findCircleNumBFS(int[][] isConnected) {
		n = isConnected.length;
		int provinces = 0;
		Deque<Integer> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[n][n];

		for (int node = 0; node < n; node++) {
			if (!visited[node][node]) {
				provinces++;
				visited[node][node] = true;
				q.offer(node);

				while (!q.isEmpty()) {
					int current = q.poll();

					for (int adj = 0; adj < n; adj++) {
						if (isConnected[current][adj] == 1 && !visited[adj][adj]) {
							q.offer(adj);
							visited[adj][adj] = true;
						}
					}
				}

			}
		}

		return provinces;
	}

	public int findCircleNumDFS(int[][] isConnected) {
		n = isConnected.length;
		boolean visited[][] = new boolean[n][n];
		int provinces = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i][i]) {
				System.out.println(i);
				provinces++;
				dfs(isConnected, visited, i);
			}
		}

		return provinces;
	}

	public void dfs(int[][] adjMat, boolean[][] visited, int src) {
		visited[src][src] = true;
		System.out.println("Here");
		for (int adj = 0; adj < n; adj++) {
			System.out.println(src + " " + adj + " " + adjMat[src][adj] + " " + visited[adj][adj]);
			if (adjMat[src][adj] == 1 && (!visited[adj][adj])) {
				dfs(adjMat, visited, adj);
				// System.out.println("Here: " + src + " " +adj);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int g[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		NumberOfProvinces np = new NumberOfProvinces();
		System.out.println(np.findCircleNumBFS(g));
	}

}
