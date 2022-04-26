/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
package com.graph.adj_list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author satis
 *
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
	class DFS_NegativeEdgeSolution {

		@SuppressWarnings("unchecked")
		public int minReorder(int n, int[][] connections) {

			List<Integer>[] adjList = (List<Integer>[]) new List[n];

			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int edge[] : connections) {
				// adding incoming edges as negative edge
				adjList[edge[1]].add(-edge[0]);

				// outgoing edges - which need to be change
				adjList[edge[0]].add(edge[1]);
			}

			return dfs(adjList, new boolean[n], 0);

		}

		private int dfs(List<Integer>[] al, boolean[] visited, int src) {
			visited[src] = true;
			int changes = 0;

			for (int to : al[src]) {
				int adj = Math.abs(to);
				// to avoid cycle
				if (!visited[adj]) {
					// if this is a positive edge then it need to be counted
					changes += (dfs(al, visited, adj) + (to > 0 ? 1 : 0));
				}
			}
			return changes;
		}

	}

	class DFSInDegreeOutDegreeDeletion {
		int count;

		@SuppressWarnings("unchecked")
		public int minReorder(int n, int[][] connections) {
			count = 0;

			Set<Integer>[] inList = (Set<Integer>[]) new Set[n];
			Set<Integer>[] outList = (Set<Integer>[]) new Set[n];

			for (int i = 0; i < n; i++) {
				inList[i] = new HashSet<>();
				outList[i] = new HashSet<>();
			}

			for (int edge[] : connections) {
				inList[edge[1]].add(edge[0]);
				outList[edge[0]].add(edge[1]);
			}

			dfs(inList, outList, 0);

			return count;
		}

		private void dfs(Set<Integer>[] inList, Set<Integer>[] outList, int src) {
			for (int in : inList[src]) {
				outList[in].remove(src);
				dfs(inList, outList, in);
			}

			for (int out : outList[src]) {
				inList[out].remove(src);
				count++;
				dfs(inList, outList, out);
			}
		}

	}

	class BFSInDegreeOutDegreeDeletion {
		@SuppressWarnings("unchecked")
		public int minReorder(int n, int[][] connections) {
			int count = 0;

			Set<Integer>[] inList = (Set<Integer>[]) new Set[n];
			Set<Integer>[] outList = (Set<Integer>[]) new Set[n];

			for (int i = 0; i < n; i++) {
				inList[i] = new HashSet<>();
				outList[i] = new HashSet<>();
			}

			for (int edge[] : connections) {
				inList[edge[1]].add(edge[0]);
				outList[edge[0]].add(edge[1]);
			}

			Queue<Integer> q = new ArrayDeque<>();
			q.offer(0);

			while (!q.isEmpty()) {
				int current = q.poll();

				// first visit the nodes which are incoming to 0 and remove
				// the neighbours from outgoing
				// as these are incoming so there is no change in direction
				for (int in : inList[current]) {
					outList[in].remove(current);
					q.offer(in);
				}

				// get all the outgoing edges which needs to be change
				// as the direction is going to change, remove the edge from incoming
				// it is changing the direction count it.
				for (int out : outList[current]) {
					inList[out].remove(current);
					q.add(out);
					count++;
				}
			}

			return count;
		}

	}
}
