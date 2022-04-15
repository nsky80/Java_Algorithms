/**
 * 
 */
package com.graph;

import java.util.LinkedList;

/**
 * This uses LinkedList to represent the graph
 * 
 * @author satis
 *
 */

class Graph2 {
	private int V; // number of vertices
	private LinkedList<Integer> adj[]; // adjacency list array

	@SuppressWarnings("unchecked")
	Graph2(int V) {
		this.V = V;

		// initializing the list with V node
		adj = new LinkedList[V];

		// initializing the linked list for each node
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void add(int v, int w) {
		adj[v].add(w);

		// for undirected graph
		adj[w].add(v);
	}

	// print the graph
	void printGraph() {
		for (int i = 0; i < V; i++) {
			System.out.print(i);
			for (int j = 0; j < adj[i].size(); j++) {
				System.out.print("->" + adj[i].get(j));
			}
			System.out.println("\n");
		}
	}
}

public class AdjacencyListLinkedListRep {
	// creating the graph
	public static void main(String [] args) {
		Graph2 g = new Graph2(5);
		g.add(0, 1);
		g.add(0, 4);
		g.add(1, 2);
		g.add(1, 3);
		g.add(1, 4);
		g.add(2, 3);
		g.add(3, 4);
		
		g.printGraph();
	}
}
