package com.graph.BFS;

/**
* Get the problem statement here: 
*/


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class MinimumHeightTrees{
	
	/**
	* This method creates the adjacency list representation of graph and returns the list.
	*/
	public static List<List<Integer>> createAdjList(int n, int[][] edges){
		List<List<Integer>> adjList = new ArrayList<>();
				
		for(int i = 0; i < n; i++){
			adjList.add(new ArrayList<>());
		}
		
		// adding the edges
		for(int edge[] : edges){
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		
		return adjList;
	}
	
	/**
	* This method calculates the height of the tree from given node as root.
	* It uses BFS for every level
	*/
	public static int getHeightBFS(int src, List<List<Integer>> adjList){
		boolean visited[] = new boolean[adjList.size()];
		
		Deque<Integer> q = new ArrayDeque<>();
		
		q.add(src);
		visited[src] = true;
		
		// it will keep track of the levels traversed in BFS.
		int height = 0;
		int nodesAtCurrentLevel = 1;
		int nodesAtNextLevel = 0;
		
		while(!q.isEmpty()){
			int node = q.poll();
			
			for(int adj : adjList.get(node)){
				if (!visited[adj]){
					visited[adj] = true;
					nodesAtNextLevel++;
					q.add(adj);
				}
			}
			
			nodesAtCurrentLevel--;
			
			// if 1 level traversed completely then increment the height and prepare for next level
			if(nodesAtCurrentLevel == 0){
				nodesAtCurrentLevel = nodesAtNextLevel;
				nodesAtNextLevel = 0;
				height++;
			}
		
		}
		// System.out.println("Height : " + height + ", root: " + src);
		return height;

	}
	
	/**
	* This solution is having O(V^2) time complexity, which uses conventional BFS 
	* on every vertex.
	*/
    public static List<Integer> findMinHeightTreesBruteForce(int n, int[][] edges) {
        List<List<Integer>> adjList = createAdjList(n, edges);
		// System.out.println("Graph: " + adjList);
		int heightAtIthNode[] = new int[n];
		
		int minHeight = Integer.MAX_VALUE;
		
		// applying BFS on each node inorder to get the height
		// at the same time, keeping track of minimum height.
		for(int i = 0; i < n; i++){
			// it will give the height of tree if the tree rooted at current node
			heightAtIthNode[i] = getHeightBFS(i, adjList);
			
			// check if the current height is max
			minHeight = Math.min(heightAtIthNode[i], minHeight);
		}
		
		// printArray(heightAtIthNode);
		
		// Now add all the nodes having same minHeight and return
		List<Integer> minHeights = new ArrayList<>();
		for(int i = 0; i < n; i++){
			if(heightAtIthNode[i] == minHeight)
				minHeights.add(i);
		}
		
		return minHeights;
    }
	
	
	
	/**
	* This method creates the adjacency list representation of graph and in-degree of a graph.
	*/
	public static void createAdjListAndInDegree(int n, int[][] edges, List<List<Integer>> adjList,
	int [] inDegree){
				
		for(int i = 0; i < n; i++){
			adjList.add(new ArrayList<>());
		}
		
		// adding the edges
		for(int edge[] : edges){
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
			inDegree[edge[0]]++;
			inDegree[edge[1]]++;
		}
		
	}
	
	/**
	* This solution is having a time complexity of O(V + E)
	* Space complexity : O(V)
	* Algorithm:
	* 1). calculate the in-degree of every node 
	* 2). apply topological sort on leaf node i.e. having in-degree = 1 (Kahn's Algorithm)
	* 3). 
	* This is the best solution.
	*/
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1){
            return Arrays.asList(0);
        }
		
		
        List<List<Integer>> adjList = new ArrayList<>();
		int []inDegree = new int[n];
		createAdjListAndInDegree(n, edges, adjList, inDegree);
		
		// now using Kahn's algo
		List<Integer> q = new LinkedList<>();
		
		// putting all the leaf node into the queue
		// to avoid the ambiguity, putting 0 instead of 1
		// as it is undirected graph
		for(int i = 0; i < n; i++){
			if (inDegree[i] == 1){
				q.add(i);
				inDegree[i] = 0;
			}
		}
		
		// it would keep track of nodes after removing leaves at every node
		int count = n;
		
		// now applying top-sort using BFS
		while (count > 2){
			// remove the leaf
			int leavesAtCurrentLevel = q.size();
			count -= leavesAtCurrentLevel;
			
			// consume all the leaf node at current level
			for(int i = 0; i < leavesAtCurrentLevel; i++){
				int node = q.remove(0);
				// decrease the degree of affected node
				for(int adj: adjList.get(node)){
					if (inDegree[adj] > 0){
						inDegree[adj]--;
						// if it is becoming a leaf node
						if (inDegree[adj] == 1){
							inDegree[adj] = 0;
							q.add(adj);
						}
					}
				}
			}
		}
		
		// System.out.println(q);
		// Now add all the nodes having same minHeight and return
		// List<Integer> minHeights = new ArrayList<>();
		// for(int num : q){
			// minHeights.add(num);
		// }
		
		return q;
		
	}
	
	
	
	public static void createAdjListAndInDegreeSet(int n, int[][] edges, List<Set<Integer>> adjList){
				
		for(int i = 0; i < n; i++){
			adjList.add(new HashSet<>());
		}
		
		// adding the edges
		for(int edge[] : edges){
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		
	}
	
	
	
	public static List<Integer> findMinHeightTreesSet(int n, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();
		createAdjListAndInDegreeSet(n, edges, adjList);
		
		// now using Kahn's algo
		List<Integer> q = new LinkedList<>();
		if (n == 1) {
			q.add(0);
			return q;
		}
		/**
		* If it is leaf node, add into q 
		*/
		for(int i = 0; i < n; i++){
			if (adjList.get(i).size() == 1){
				q.add(i);
			}
		}
		
		int count = n;
		
		// now applying top-sort using BFS
		while (count > 2){
			int size = q.size();
			count -= size;
			
			// remove the leaf at current level 
			for(int leave = 0; leave < size; leave++){
				int node = q.remove(0);
				
				// update the adjacent node, i.e.,
				// remove current node from the adjList of neighbor
				// removing the "only" adjacent element of the leaf node
				int indexOfAdj = adjList.get(node).iterator().next();
				// get rid of this node from other nodes list
				adjList.get(indexOfAdj).remove(node);

				// if affected node become a leaf node then add it into the q
				if (adjList.get(indexOfAdj).size() == 1) {
					q.add(indexOfAdj);
				}
			}
			
		}
		
		return q;
	}
	
	public static void main(String [] args){
		int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
		int n = 6;
		System.out.println(findMinHeightTreesSet(n, edges));
		edges = new int[][]{{1,0},{1,2},{1,3}};
		n = 4;
		System.out.println(findMinHeightTreesSet(n, edges));

	}
	
	public static void printArray(int [] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

}