/**
 * This is implementation of detecting cycle in DAG(Directed Acyclic Graph) using coloring of nodes.
 * Source: https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
 */

package com.graph.dag;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUsingColors {
	static final int WHITE = 0;
	static final int GRAY = 1;
	static final int BLACK = 2;

	static class Graph {
		int v;
		List<List<Integer>> adjList;

		Graph(int v) {
			this.v = v;
			adjList = new ArrayList<>();

			for (int i = 0; i < v; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		// directed graph
		public void addEdge(int u, int v) {
			adjList.get(u).add(v);
		}
	}

	public static void main(String[] args) {
		// Create a graph given in the above diagram
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
//		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		if (isCyclic(g))
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");

	}

	/**
	 * This method is doing Depth First Traversal.
	 * 
	 * @param g
	 * @return
	 */
	private static boolean isCyclic(Graph g) {
		int color[] = new int[g.v];

		for (int i = 0; i < g.v; i++) {
			if (color[i] == WHITE) {
				// if cycle found
				if (dfs(g, i, color)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(Graph g, int source, int[] color) {
		// make the source node as GRAY
		color[source] = GRAY;

		// visit the adjacent node
		for (int adj : g.adjList.get(source)) {
			// if this node is already in recursion stack
			if (color[adj] == GRAY) {
				return true;
			} else if (color[adj] != BLACK) {
				// if node is not visited
				return dfs(g, adj, color);
			}
		}

		color[source] = BLACK;
		return false;
	}

}
