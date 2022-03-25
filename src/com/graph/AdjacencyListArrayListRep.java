package com.graph;

//Java code to demonstrate Graph representation
//using ArrayList in Java

import java.util.*;

class Graph1 {

	// A utility function to add an edge in an
	// undirected graph
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	// A utility function to print the adjacency list
	// representation of graph
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("\nAdjacency list of vertex: " + i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

}

/**
 * This implements the adjacency representation of the list.
 * 
 * @author satis
 *
 */
public class AdjacencyListArrayListRep {
	// Driver Code
	public static void main(String[] args) {
		// Creating a graph with 5 vertices
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		System.out.println(adj.size());
//		System.out.println(adj.get(0));
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		// Adding edges one by one
		Graph1.addEdge(adj, 0, 1);
		Graph1.addEdge(adj, 0, 4);
		Graph1.addEdge(adj, 1, 2);
		Graph1.addEdge(adj, 1, 3);
		Graph1.addEdge(adj, 1, 4);
		Graph1.addEdge(adj, 2, 3);
		Graph1.addEdge(adj, 3, 4);

		Graph1.printGraph(adj);
	}

}
