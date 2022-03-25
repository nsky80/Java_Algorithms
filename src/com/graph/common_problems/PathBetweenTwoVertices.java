package com.graph.common_problems;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PathBetweenTwoVertices {

	public static ArrayList<ArrayList<Integer>> createAdjList(int n, int edges[][]) {
		// initialized adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// add edges
		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		return adj;
	}

	public static boolean hasPathDFS(ArrayList<ArrayList<Integer>> adj, boolean visited[], int src, int dest) {
		Deque<Integer> stack = new ArrayDeque<>();
		visited[src] = true;
		stack.push(src);

		while (!stack.isEmpty()) {
			int current = stack.pop();
			if (current == dest)
				return true;

			for (int w : adj.get(current)) {
				if (w == dest)
					return true;

				if (!visited[w]) {
					stack.push(w);
					visited[w] = true;
				}
			}
		}

		return false;

	}
	
	
	public static boolean hasPathBFS(ArrayList<ArrayList<Integer>> adj, boolean visited[], int src, int dest) {
		if (src == dest) return true;

		Deque<Integer> q = new ArrayDeque<>();
		visited[src] = true;
		q.add(src);
		
		while (! q.isEmpty()) {
			int current = q.poll();
			
			for(int w: adj.get(current)) {
				if (w == dest) return true;
				if(!visited[w]) {
					visited[w] = true;
					q.add(w);
				}
			}
		}
		
		return false;
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {

		// initialized adjacency list
		ArrayList<ArrayList<Integer>> adj = createAdjList(n, edges);

		boolean visited[] = new boolean[n];

		return hasPathDFS(adj, visited, source, destination);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
