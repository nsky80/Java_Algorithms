/**
 * https://leetcode.com/problems/redundant-connection/
 */
package com.disjoint_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Satish Kumar Yadav
 *
 */
public class RedundantConnection {
	/**
	 * Time complexity: O(n * α(N)), where α(N) is the Inverse-Ackermann function it
	 * is approximately O(1), so overall time: O(n).
	 * Space: O(n)
	 * 
	 * Approach: As tree contains n - 1 edges, and 1 edge is redundant, here it adds every edge
	 * into the graph and checks whether it is possible to cover current 2 nodes (edge), if yes then
	 * this edge is redundant.
	 */
	class SolutionByUnion {
		int parent[];
		int rank[];
		int n;

		public int[] findRedundantConnection(int[][] edges) {
			// As there are n edges = number of vertices
			n = edges.length;

			// now create the parent and rank array
			parent = new int[n + 1];
			rank = new int[n + 1];

			// initialize the parent and rank = 1
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}

			// now add each edge and check whether they are connected or not
			for (int edge[] : edges) {
				// if these 2 vertices are already connected then it means
				// there is redundancy
				if (union(edge[0], edge[1])) {
					return edge;
				}
			}

			// in java, return is mandatory
			return null;
		}

		// if two nodes are already connected then it return true
		// otherwise false
		public boolean union(int x, int y) {
			int rootx = find(x);
			int rooty = find(y);

			if (rootx == rooty) {
				return true;
			} else {
				// now union by rank
				if (rank[rootx] > rank[rooty]) {
					parent[rooty] = rootx;
				} else if (rank[rootx] < rank[rooty]) {
					parent[rootx] = rooty;
				} else {
					// if they are equal
					parent[rooty] = rootx;
					rank[rootx] += 1;
				}

				return false;
			}
		}

		public int find(int x) {
			while (parent[x] != x) {
				// path compression
				parent[x] = parent[parent[x]];
				x = parent[x];
			}
			return x;
		}
	}
	
	/**
	 * It's basically doing Cycle Prevention and not Detection, we're building the graph one edge at a time.
	 * However, before adding an edge between u and v, we first check if there already is a path between
	 *  them, avoiding a cycle.
	 * 
	 * Time: O(n ^ 2), Space: O(n)
	 * We're doing DFS for every edge, each DFS will take O(n) and for every node it'll take
	 * O(n^2) time.
	 */
	class SolutionByUsingDFS {

	    public int[] findRedundantConnection(int[][] edges) {
	        // As there are n edges = number of vertices
	        int n = edges.length;
	        
	        // create a graph
	        @SuppressWarnings("unchecked")
			ArrayList<Integer>[] adjList = new ArrayList[n + 1];
	        for(int i = 0; i <= n; i++){
	            adjList[i] = new ArrayList<>();
	        }
	        
	        // now create a visited set
	        Set<Integer> visited = new HashSet<>();
	        
	        // now add each edge and check whether they are already connected or not
	        for(int edge[]: edges){
	            // if these 2 vertices are already connected 
	            // it uses DFS and tries to find whether these 2 are connected
	            // in present graph
	            if (dfs(adjList, edge[0], edge[1], visited)){
	                return edge;
	            } else{
	                adjList[edge[0]].add(edge[1]);
	                adjList[edge[1]].add(edge[0]);
	            }
	            
	            visited.clear();
	        }
	        
	        // in java, return is mandatory
	        return null;
	    }
	    
	    
	    private boolean dfs(ArrayList<Integer> adjList[], int src, int dest, Set<Integer> visited){
	        visited.add(src);
	        
	        for(int adj: adjList[src]){
	            if (adj == dest)
	                return true;
	            if (!visited.contains(adj) && dfs(adjList, adj, dest, visited)){
	                return true;
	            }
	        }
	        
	        return false;
	    }
	}
}
