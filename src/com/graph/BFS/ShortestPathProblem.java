/**
shortest path
Write a function, shortest_path, that takes in a list of edges for an undirected graph and two nodes (node_A, node_B). The function should return the length of the shortest path between A and B. Consider the length as the number of edges in the path, not the number of nodes. If there is no path between A and B, then return -1.

test_00:
edges = [
  ['w', 'x'],
  ['x', 'y'],
  ['z', 'y'],
  ['z', 'v'],
  ['w', 'v']
]

shortest_path(edges, 'w', 'z') # -> 2
test_01:
edges = [
  ['w', 'x'],
  ['x', 'y'],
  ['z', 'y'],
  ['z', 'v'],
  ['w', 'v']
]

shortest_path(edges, 'y', 'x') # -> 1
test_02:
edges = [
  ['a', 'c'],
  ['a', 'b'],
  ['c', 'b'],
  ['c', 'd'],
  ['b', 'd'],
  ['e', 'd'],
  ['g', 'f']
]

shortest_path(edges, 'a', 'e') # -> 3
test_03:
edges = [
  ['a', 'c'],
  ['a', 'b'],
  ['c', 'b'],
  ['c', 'd'],
  ['b', 'd'],
  ['e', 'd'],
  ['g', 'f']
]

shortest_path(edges, 'e', 'c') # -> 2
test_04:
edges = [
  ['a', 'c'],
  ['a', 'b'],
  ['c', 'b'],
  ['c', 'd'],
  ['b', 'd'],
  ['e', 'd'],
  ['g', 'f']
]

shortest_path(edges, 'b', 'g') # -> -1

test_05:
edges = [
  ['c', 'n'],
  ['c', 'e'],
  ['c', 's'],
  ['c', 'w'],
  ['w', 'e'],
]

shortest_path(edges, 'w', 'e') # -> 1
test_06:
edges = [
  ['c', 'n'],
  ['c', 'e'],
  ['c', 's'],
  ['c', 'w'],
  ['w', 'e'],
]

shortest_path(edges, 'n', 'e') # -> 2
test_07:
edges = [
  ['m', 'n'],
  ['n', 'o'],
  ['o', 'p'],
  ['p', 'q'],
  ['t', 'o'],
  ['r', 'q'],
  ['r', 's']
]

shortest_path(edges, 'm', 's') # -> 6
*/
package com.graph.BFS;


import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;


public class ShortestPathProblem{
	
		public static Map<Character, List<Character>> buildGraph(char[][] edges, char[] v) {
		Map<Character, List<Character>> adj = new HashMap<>();

		// adding vertices in the graph
		for (int i = 0; i < v.length; i++) {
			adj.put(v[i], new ArrayList<Character>());
		}

		// adding edges in the graph
		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		return adj;
	}
	
	
	public static int getShortestPath(Map<Character, List<Character>> adjList, char src, char dest){
		if (src == dest) return 0;
		
		// wrapper class 
		class Node{
			char data;
			int distance;
			
			Node(char data, int distance){
				this.data = data;
				this.distance = distance;
			}
		};
		
		// initializing the visited to avoid cycle
		Map<Character, Boolean> isVisited = new HashMap<>();
		for(char data: adjList.keySet()){
			isVisited.put(data, false);
		}
		
		// intialize the q
		Deque<Node> q = new ArrayDeque<Node>();
		
		q.add(new Node(src, 0));
		isVisited.put(src, true);
		
		while(!q.isEmpty()){
			Node current = q.poll();
			
			for(char adj : adjList.get(current.data)){
				if (adj == dest) return current.distance + 1;
				
				if (!isVisited.get(adj)){
					isVisited.put(adj, true);
					q.add(new Node(adj, current.distance + 1));
				}
			}
		}
		
		return -1;		
	}
	
	
	
	//public static void main(String []args){
	public static void main(String[] args){
		char edges[][] = {
							  {'m', 'n'},
							  {'n', 'o'},
							  {'o', 'p'},
							  {'p', 'q'},
							  {'t', 'o'},
							  {'r', 'q'},
							  {'r', 's'}
						};
		char v[] = {'m', 'n', 'o', 'p', 'q', 'r', 's', 't'};
		
		Map<Character, List<Character>> adjList = buildGraph(edges, v);
		System.out.println(adjList);
		System.out.println(getShortestPath(adjList, 'm', 's'));
		
		char edges2[][] = {
							  {'a', 'c'},
							  {'a', 'b'},
							  {'c', 'b'},
							  {'c', 'd'},
							  {'b', 'd'},
							  {'e', 'd'},
							  {'g', 'f'}
							};
		char v2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		System.out.println(getShortestPath(buildGraph(edges2, v2), 'e', 'c'));
		System.out.println(getShortestPath(buildGraph(edges2, v2), 'a', 'e'));
		System.out.println(getShortestPath(buildGraph(edges2, v2), 'b', 'g'));

		char edges3[][] ={
						  {'c', 'n'},
						  {'c', 'e'},
						  {'c', 's'},
						  {'c', 'w'},
						  {'w', 'e'},
						};
		char v3[] = {'c', 'n', 'e', 's', 'w'};
		System.out.println(getShortestPath(buildGraph(edges3, v3), 'w', 'e'));

	}
	
	
}