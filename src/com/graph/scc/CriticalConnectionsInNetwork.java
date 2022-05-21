/**
 * 
 */
package com.graph.scc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This problem uses Tarjan's algo to find the bridges in the graph, it can be
 * modified to get the strongly connected components as well.
 * 
 * @author Satish Kumar Yadav
 *
 */
public class CriticalConnectionsInNetwork {

	/**
	 * Time: O(V + E), Space: O(V + E)
	 * @author satis
	 *
	 */
	class TarjansSCC_Algo {
		// it will keep the depth/time of each node
		int id[];
		// parent would be used to prevent a node so that it won't visit a predecessor
		int parent[];
		// the lowest id reachable from the current node
		// the nodes having same low value are involved in a cycle or these are SCC
		int low[];

		// it would be used to keep track of unique id's
		int time;

		public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
			// initialize the vars
			id = new int[n];
			parent = new int[n];
			low = new int[n];
			time = 0;

			// id is also used as visited
			for (int i = 0; i < n; i++) {
				id[i] = -1;
				parent[i] = -1;
			}

			// create adj List
			List<List<Integer>> adjList = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				adjList.add(new ArrayList<>());
			}

			for (List<Integer> edge : connections) {
				adjList.get(edge.get(0)).add(edge.get(1));
				adjList.get(edge.get(1)).add(edge.get(0));
			}

			// this list would hold all the bridges or critical edges
			List<List<Integer>> ans = new ArrayList<>();

			// as the graph is connected and labeled from 0 - n - 1, calling DFS with random
			// node - 0
			getCriticalConnectionDFS(adjList, ans, 0);

			return ans;
		}

		public void getCriticalConnectionDFS(List<List<Integer>> adjList, List<List<Integer>> ans, int src) {
			// initialize the id and low with current time
			id[src] = low[src] = time++;

			for (int nei : adjList.get(src)) {

				// if it is not visited then
				if (id[nei] == -1) {
					// update the parent node
					parent[nei] = src;

					// further explore the node
					getCriticalConnectionDFS(adjList, ans, nei);

					// update the low value
					low[src] = Math.min(low[src], low[nei]);

					// if id of src is less than low value of nei
					// then it means current edge is not involved in the cycle
					// and this edge is critical
					if (low[nei] > id[src])
						ans.add(Arrays.asList(src, nei));

				} else if (nei != parent[src]) {
					// if it is not parent node, i.e. previous node and we might
					// backtracking from here and it would be the node which is currently in
					// recursion stack
					// as nei is already explore, it might have lesser low value
					low[src] = Math.min(low[src], low[nei]);
				}
			}

		}
	}

	/**
	 * This is brute force solution, steps to execute: - It creates a adjacency list
	 * from the given graph - Remove an edge a->b and apply dfs and try to find out
	 * whether a->b is still reachable - If a -> b is reachable then it is not a
	 * critical edge and if not then it is critical edge
	 * 
	 * Time: O(E(V + E)), Space: O(V + E)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class Solution1 {
		public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
			List<Set<Integer>> adjList = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				adjList.add(new HashSet<>());
			}

			for (List<Integer> edge : connections) {
				adjList.get(edge.get(0)).add(edge.get(1));
				adjList.get(edge.get(1)).add(edge.get(0));
			}

			List<List<Integer>> ans = new ArrayList<>();

			for (List<Integer> edge : connections) {
				adjList.get(edge.get(0)).remove(edge.get(1));
				if (!isReachable(adjList, new boolean[n], edge.get(0), edge.get(1))) {
					ans.add(Arrays.asList(edge.get(0), edge.get(1)));
				}

				// backtrack
				adjList.get(edge.get(0)).add(edge.get(1));
			}

			return ans;
		}

		public boolean isReachable(List<Set<Integer>> adjList, boolean[] visited, int src, int dest) {
			visited[src] = true;

			for (int nei : adjList.get(src)) {
				if (src == dest)
					return true;

				if (!visited[nei] && isReachable(adjList, visited, nei, dest))
					return true;
			}

			return false;
		}
	}
}
