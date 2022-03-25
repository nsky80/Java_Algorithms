package com.graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class GraphBFS {
	int V;
	ArrayList<Integer> adj[];

	GraphBFS(int v) {
		this.V = v;

		adj = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
//		adj[w].add(v);
	}
}

public class BreadthFirstSearch {

	public static void bfs(GraphBFS graph, int source) {
		boolean visited[] = new boolean[graph.V];

		// initializing the visited
		for (int i = 0; i < graph.V; i++) {
			visited[i] = false;
		}

		// create an empty queue
		Deque<Integer> q = new ArrayDeque<>();
		
		// mark first node as visited
		visited[source] = true;
		// add first node to the queue
		q.add(source);
		

		// iterate until q is empty
		while (q.size() != 0) {
			// now iterate through all the adjacent of current element
			int u = q.poll();

			for (int i : graph.adj[u]) {
				// if current adjacent node is not visited
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}

			System.out.println(" " + u);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphBFS graph = new GraphBFS(7);
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(0, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(3, 4);
//		graph.addEdge(3, 5);
//		graph.addEdge(4, 6);
//		graph.addEdge(5, 6);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		bfs(graph, 2);
	}

}
