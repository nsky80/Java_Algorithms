/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
package com.graph.adj_list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author satis
 *
 */
public class NumberOfOperationsToMakeNetworkConnected {
	int nodes;

	/**
	 * Time: O(n+m), m is the length of connections Space: O(n)
	 * 
	 * @param n
	 * @param connections
	 * @return
	 */
	public int makeConnected(int n, int[][] connections) {
		nodes = n;

		// at-least n - 1 cables required to connect n stations
		if (connections.length < (n - 1))
			return -1;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int edge[] : connections) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		boolean visited[] = new boolean[n];

		int connected = 0;

		for (int v = 0; v < n; v++) {
			if (!visited[v]) {
				connected++;
				dfs(adjList, visited, v);
			}
		}

		return connected - 1;
	}

	public void dfs(List<List<Integer>> adjList, boolean[] visited, int src) {
		visited[src] = true;

		for (int adj : adjList.get(src)) {
			if (!visited[adj]) {
				dfs(adjList, visited, adj);
			}
		}
	}

	public void bfs(List<List<Integer>> adjList, boolean[] visited, int src) {
		visited[src] = true;
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(src);

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int adj : adjList.get(current)) {
				if (!visited[adj]) {
					visited[adj] = true;
					q.offer(adj);
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[10];
//		ArrayList<Integer>[] group = new ArrayList[4];
//
//		List<Integer>[] adjList = (List<Integer>[]) new List[10];

	}

}
