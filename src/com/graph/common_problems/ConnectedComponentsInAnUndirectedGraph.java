/**
* This problem would be solved using Depth First Traversal
* This solution uses adjacency matrix representation of graph for DFS and DFT
*
*/
package com.graph.common_problems;

import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;


public class ConnectedComponentsInAnUndirectedGraph{
	
	static void DFS(List<List<Integer>> adj, boolean []visited, int source, int V){
		// For debugging
		System.out.print(source + " ");
		
		// make source as visited
		visited[source] = true;
		
		// visit nodes adjacent to source
		for(int i = 0; i < V; i++){
			if (adj.get(source).get(i) == 1 && !visited[i])
				DFS(adj, visited, i, V);
		}
	}
	
	/**
	* DFT using numProvinces alias
	*/
	static int numProvinces(List<List<Integer>> adj, int V) {
		// it will count the number of disconnected components
		int count = 0;
	
		// visited array
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		
		// applying DFS for every non-visited node
		for(int i = 0; i < V; i++){
			if (!visited[i]){
				count++;
				DFS(adj, visited, i, V);
				System.out.println();
			}
		}
		
		return count;
	}
	
	
	public static void main(String [] args){
		List<List<Integer>> graph = Arrays.asList(Arrays.asList(0, 0, 1), 
		Arrays.asList(0, 0, 0), Arrays.asList(1, 0, 0));
		System.out.println(graph);
		System.out.println("Unconnected components: " + numProvinces(graph, 3));

		graph = Arrays.asList(Arrays.asList(1, 1, 0, 0, 0), Arrays.asList(0, 1, 0, 0, 1), Arrays.asList(1, 0, 0, 1, 1), Arrays.asList(0, 0, 0, 0, 0), Arrays.asList(1, 0, 1, 0, 1));
		System.out.println(graph);
		System.out.println("Unconnected components: " + numProvinces(graph, 5));
	}
}