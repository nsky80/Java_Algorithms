/**

largest_component({
  0: [8, 1, 5],
  1: [0],
  5: [0, 8],
  8: [0, 5],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2]
}) # -> 4
test_01:
largest_component({
  1: [2],
  2: [1,8],
  6: [7],
  9: [8],
  7: [6, 8],
  8: [9, 7, 2]
}) # -> 6
test_02:
largest_component({
  3: [],
  4: [6],
  6: [4, 5, 7, 8],
  8: [6],
  7: [6],
  5: [6],
  1: [2],
  2: [1]
}) # -> 5
test_03:
largest_component({}) # -> 0
test_04:
largest_component({
  0: [4,7],
  1: [],
  2: [],
  3: [6],
  4: [0],
  6: [3],
  7: [0],
  8: []
}) # -> 3


  3: [],
  4: [6],
  6: [4, 5, 7, 8],
  8: [6],
  7: [6],
  5: [6],
  1: [2],
  2: [1]
  
  expected: 5
*/
 package com.graph.common_problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LargestComponentProblem {
	public static int count;

	public static Map<Integer, List<Integer>> buildGraph(int[][] edges, int[] v) {
		Map<Integer, List<Integer>> adj = new HashMap<>();

		// adding vertices in the graph
		for (int i = 0; i < v.length; i++) {
			adj.put(v[i], new ArrayList<Integer>());
		}

		// adding edges in the graph
		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		return adj;
	}

	public static int dfs(Map<Integer, List<Integer>> adj, Map<Integer, Boolean> visited, int src) {
		visited.put(src, true);
		count++;
		System.out.print(src + " ");

		for (int w : adj.get(src)) {
			if (!visited.get(w)) {
				dfs(adj, visited, w);
			}
		}

		return count;
	}

	/**
		In this approach a static variable count is used, need to avoid it 2nd approach
	*/
	public static int getLargestCount(Map<Integer, List<Integer>> adj) {
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int key : adj.keySet()) {
			visited.put(key, false);
		}

		int maxConnected = 1;

		for (int key : adj.keySet()) {
			count = 0;
			if (!visited.get(key)) {
				dfs(adj, visited, key);
				maxConnected = Math.max(maxConnected, count);
			}
		}

		return maxConnected;
	}




	public static int dfs2(Map<Integer, List<Integer>> adj, Map<Integer, Boolean> visited, int src) {
		visited.put(src, true);
		int count = 1;
		System.out.print(src + " ");

		for (int w : adj.get(src)) {
			if (!visited.get(w)) {
				count += dfs2(adj, visited, w);
			}
		}

		return count;
	}

	/**
		 2nd approach
		 Time: O(v + e)
		 space: O(v)
	*/
	public static int getLargestCount2(Map<Integer, List<Integer>> adj) {
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int key : adj.keySet()) {
			visited.put(key, false);
		}

		int maxConnected = 1;

		for (int key : adj.keySet()) {
			if (!visited.get(key)) {
				
				maxConnected = Math.max(maxConnected, dfs2(adj, visited, key));
			}
		}

		return maxConnected;
	}




	public static void main(String[] args) {
		int v[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int edges[][] = { { 4, 6 }, { 6, 5 }, { 6, 7 }, { 6, 8 }, { 1, 2 } };

		Map<Integer, List<Integer>> graph = buildGraph(edges, v);

		System.out.println(graph);
		System.out.println("\n" + getLargestCount(graph));
		System.out.println("\n" + getLargestCount2(graph));

		v = new int[]{0, 1, 2, 3, 4, 5, 8};
		edges = new int[][]{{0, 8}, {0, 1}, {0, 5}, {5, 8}, {2, 3}, {2, 4}, {3, 4}};
		graph = buildGraph(edges, v);
		System.out.println(graph);
		System.out.println("\n" + getLargestCount(graph));
		System.out.println("\n" + getLargestCount2(graph));

	}
}