/**
* Problem Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*/

package com.graph.DFS.grid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(m * n), Space: O(m * n)
 * @author satis
 *
 */
public class LongestIncreasingPathInA_Matrix {
	class SolutionUsingDFSandDP {
		public int longestIncreasingPath(int[][] matrix) {
			int track[][] = new int[matrix.length][matrix[0].length];
			int max = 0;
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < matrix[r].length; c++) {
					if (track[r][c] == 0) {
						dfs(track, matrix, r, c);
					}

					max = Math.max(max, track[r][c]);
				}
			}

			return max;
		}

		public int dfs(int[][] track, int[][] mat, int r, int c) {

			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, 1, -1 };

			track[r][c] = 1;

			int max = 0;

			for (int adj = 0; adj < dr.length; adj++) {
				int rr = dr[adj] + r;
				int cc = dc[adj] + c;

				if (!(rr < 0 || cc < 0 || rr >= mat.length || cc >= mat[0].length) && mat[r][c] < mat[rr][cc]) {
					int temp;
					if (track[rr][cc] == 0)
						temp = dfs(track, mat, rr, cc);
					else
						temp = track[rr][cc];

					if (temp >= max) {
						max = temp;
					}
				}
			}

			track[r][c] += max;

			return track[r][c];

		}
	}

	/**
	 * Approach: We regard
	 * 
	 * a cell in the matrix as a node, a directed edge from node x to node y if x
	 * and y are adjacent and x's value < y's value Then a graph is formed.
	 * 
	 * No cycles can exist in the graph, i.e. a DAG is formed.
	 * 
	 * The problem becomes to get the longest path in the DAG.
	 * 
	 * Topological sort can iterate the vertices of a DAG in the linear ordering.
	 * 
	 * Using Kahn's algorithm(BFS) to implement topological sort while counting the
	 * levels can give us the longest chain of nodes in the DAG.
	 * 
	 * 
	 * @author satis
	 *
	 */
	static class Solution {

		static int dvr[] = { -1, 1, 0, 0 };
		static int dvc[] = { 0, 0, -1, 1 };

		public int longestIncreasingPath(int[][] matrix) {
			// let's create in-degree of the graph
			int m = matrix.length;
			int n = matrix[0].length;

			int in[][] = new int[m][n];

			// calculate the in-degree of the graph
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					for (int d = 0; d < dvr.length; d++) {
						int rr = i + dvr[d];
						int cc = j + dvc[d];

						if (rr >= 0 && rr < m && cc >= 0 && cc < n && matrix[i][j] < matrix[rr][cc]) {
							in[rr][cc] += 1;
						}
					}
				}
			}

			Deque<Integer> rq = new ArrayDeque<>();
			Deque<Integer> cq = new ArrayDeque<>();

			// get the nodes with 0 in-degree i.e. leaf nodes
			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (in[r][c] == 0) {
						rq.offer(r);
						cq.offer(c);
					}
				}
			}

			// now remove the nodes 1 by 1 and count the levels
			int maxPath = 0;
			while (!rq.isEmpty()) {
				int size = rq.size();

				while (size-- > 0) {
					int r = rq.poll();
					int c = cq.poll();

					for (int d = 0; d < dvr.length; d++) {
						int rr = r + dvr[d];
						int cc = c + dvc[d];

						if (rr >= 0 && rr < m && cc >= 0 && cc < n && in[rr][cc] != 0
								&& matrix[r][c] < matrix[rr][cc]) {
							in[rr][cc] -= 1;

							if (in[rr][cc] == 0) {
								rq.add(rr);
								cq.add(cc);
							}
						}
					}

				}
				maxPath++;
			}

			return maxPath;
		}

	}

}
