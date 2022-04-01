/**
 * Problem link: https://leetcode.com/problems/evaluate-division/
 */
package com.graph.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	/**
	 * This variable would keep track that whether solution is found or not.
	 */
	static boolean found;

	static class Edge {
		String to;
		double weight;

		Edge(String t, double w) {
			to = t;
			weight = w;
		}
	}

	public static void addEdge(Map<String, List<Edge>> adjList, List<String> edge, double weight) {
		// for forward and inverse edge
		Edge f = new Edge(edge.get(1), weight);
		Edge t = new Edge(edge.get(0), 1 / weight);

		// check whether this node exists or not
		if (!adjList.containsKey(edge.get(0))) {
			adjList.put(edge.get(0), new ArrayList<>());
		}

		// check whether this node exists or not
		if (!adjList.containsKey(edge.get(1))) {
			adjList.put(edge.get(1), new ArrayList<>());
		}

		adjList.get(edge.get(0)).add(f);
		adjList.get(edge.get(1)).add(t);

	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double answers[] = new double[queries.size()];

		// create the graph
		Map<String, List<Edge>> adjList = new HashMap<>();
		// add the edges
		for (int i = 0; i < equations.size(); i++) {
			addEdge(adjList, equations.get(i), values[i]);
		}

		// now graph is created and start traversing the query
		int tracker = 0;

		for (List<String> query : queries) {
			String src = query.get(0);
			String dest = query.get(1);

			// if any of key is not part of graph, then simply put -1.
			if (adjList.containsKey(src) && adjList.containsKey(dest)) {
				// if source and destination is same then it would be 1
				if (src.equals(dest)) {
					answers[tracker++] = 1;
				} else {
					// to avoid the cycle in the graph
					Set<String> visited = new HashSet<>();
					found = false;
					double temp = dfs(adjList, visited, src, dest);

					// if solution found, here 2 node might not be connected,
					// so we can ignore it.
					if (found) {
						answers[tracker++] = temp;
					} else {
						answers[tracker++] = -1;
					}
				}
			} else {
				answers[tracker++] = -1;
			}

		}

		return answers;
	}

	public double dfs(Map<String, List<Edge>> adjList, Set<String> visited, String src, String dest) {
		visited.add(src);

		double mul = 1;

		for (Edge adj : adjList.get(src)) {
			if (adj.to.equals(dest)) {
				found = true;
				return adj.weight;
			}
			if (!visited.contains(adj.to)) {
				// get the multiplication of edges in future traversal
				double temp = dfs(adjList, visited, adj.to, dest);

				// if previous traversal has a solution, then it would be
				// multiplication of current edge and future edges i.e.,
				// edges between src and dest.
				if (found) {
					mul *= (adj.weight * temp);
					return mul;
				}
			}
		}

		// if there is not any solution, then it will return
		// here we can return -1 as well, if we doesn't wanted to use found variable.
		return mul;
	}

}