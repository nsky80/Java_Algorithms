package com.graph.topological_sort;

import java.util.ArrayList;

public class TopSortAdjListDFS {
	static int dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[], int i, int[] topOrder) {
		visited[src] = true;

		for (int neighbours : adj.get(src)) {
			if (!visited[neighbours]) {
				i = dfs(neighbours, adj, visited, i, topOrder);
			}
		}
		// add the node in topOrder in reverse DFS order.
		topOrder[i--] = src;

		return i;

	}

	// Function to return list containing vertices in Topological order.
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		// add your code here
		// this will keep track of topological order
		int topOrder[] = new int[V];

		// it will keep track of index in topOrder array
		int tracker = V - 1;

		boolean visited[] = new boolean[V];

		// start from any node randomly
		for (int node = 0; node < V; node++) {
			if (!visited[node]) {
				// if there is dependent nodes, they should be added
				// in topOrder, that's why tracker is getting updated.
				tracker = dfs(node, adj, visited, tracker, topOrder);
			}
		}

		return topOrder;
	}
}
