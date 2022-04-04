/**
* Single Source Shortest/Longest path on a Directed Acyclic Graph (DAG)
* URL: https://youtu.be/09_LlHjoEiY
*/
package com.graph.dag;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SingleSourceShortestPathInDAG{
	
	/**
	* Representation of edge.
	*/
	static class Edge{
		int to;
		int weight;
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		
		public String toString(){
			return "[to=" + to + ", weight=" + weight + "]";
		}
	}
	
	/**
	* Representation of graph.
	*/
	static class Graph{
		int V;
		Map<Integer, List<Edge>> adjList;
		
		Graph(int n, int nodes[]){
			V = n;
			adjList = new HashMap<>();
			
			for(int i = 0; i < n; i++){
				adjList.put(nodes[i], new ArrayList<>());
			}
		}
		
		void addEdge(int from, int to, int weight){
			Edge edge = new Edge(to, weight);
			adjList.get(from).add(edge);
		}
		
		public String toString(){
			return "" + adjList;
		}

	}
	
	public static void printArray(int [] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
	
	/**
	* This prepares the topological order of elements using DFS.
	*/
	public static int prepareTopSort(Graph g, int src, Map<Integer, Boolean> visited, int[] topSortArr, int tracker){
		visited.put(src, true);
		
		for(Edge edge: g.adjList.get(src)){
			if (!visited.containsKey(edge.to)){
				tracker = prepareTopSort(g, edge.to, visited, topSortArr, tracker);
			}
		}
		
		topSortArr[tracker--] = src;
		return tracker;
		
	}
	
	/**
	* This method prepares the topological order of given graph and returns 
	* the order as an array.
	*/
	public static int[] topologicalSort(Graph g){
		int topSortArray[] = new int[g.V];
		int tracker = g.V - 1;
		// instead of Map, HashSet can also be used.
		Map<Integer, Boolean> visited = new HashMap<>();
		
		for(int node: g.adjList.keySet()){
			if (!visited.containsKey(node)){
				tracker = prepareTopSort(g, node, visited, topSortArray, tracker);
			}
		}
		// printArray(topSortArray);
		return topSortArray;
	}
	
	/**
	* This method calculates the shortest path from the given source.
	*/
	public static Map<Integer, Integer> dagShortestPath(Graph graph, int start){
		// creating shortest path hash, it would contain shortest path
		// if exist otherwise null.
		Map<Integer, Integer> shortestPath = new HashMap<>();
		
		// initializing the path from source to all node as infinite
		for(int node: graph.adjList.keySet()){
			shortestPath.put(node, null);
		}
		
		int []topSort = topologicalSort(graph);
		
		// source node has distance as 0
		shortestPath.put(start, 0);
		
		// now iterating through the topological order and updating the shortest path
		// remember this is DAG - there must be cases when path doesn't exist between 2 nodes
		// then it would remain null or infinite
		
		for(int i = 0; i < graph.V; i++){
			
			int nodeKey = topSort[i];
			// if this is neither start nor reachable node from start then skip
			if (shortestPath.get(nodeKey) != null){
				// now visit and relax all the adjacent node 
				for(Edge edge : graph.adjList.get(nodeKey)){
					
					// Relaxing the edges
					
					// check, might be they are infinite
					if (shortestPath.get(edge.to) == null) 
						shortestPath.put(edge.to, shortestPath.get(nodeKey) + edge.weight);
					else
						shortestPath.put(edge.to, Math.min(shortestPath.get(edge.to), shortestPath.get(nodeKey) + edge.weight));
				}
			}
		}
		
		return shortestPath;
	}
	
	public static void main(String [] args){
		int numNodes = 4;
		int nodes[] = {0, 1, 2, 3};
		Graph g = new Graph(numNodes, nodes);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 6);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 3, 0);
		
		System.out.println(g);
		topologicalSort(g);
		System.out.println(dagShortestPath(g, 2));
	}
	
}