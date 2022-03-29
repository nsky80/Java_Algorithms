/**
 * Practice: https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 */

package com.graph.dag.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopSortKahnsAlgorithm {
	static class Graph {
		public int V;
		public Map<Character, List<Character>> adjList;

		Graph(int v, char[] nodes) {
			V = v;
			adjList = new HashMap<>();

			// adding adj list
			for (char node : nodes) {
				adjList.put(node, new ArrayList<>());
			}
		}

		// As graph is DAG
		public void addEdge(char u, char v) {
			adjList.get(u).add(v);
		}

		/**
		 * Time Complexity: O(V + E)
		 * 
		 * @param inDegree
		 */
		private void calculateInDegree(Map<Character, Integer> inDegree) {
			// creating in-degree
			for (Entry<Character, List<Character>> node : adjList.entrySet()) {
				for (char neighbor : node.getValue()) {
					if (inDegree.containsKey(neighbor)) {
						inDegree.put(neighbor, inDegree.get(neighbor) + 1);
					} else {
						inDegree.put(neighbor, 1);
					}
				}

				// if current node doesn't have any neighbor or it is not traversed yet
				if (!inDegree.containsKey(node.getKey())) {
					inDegree.put(node.getKey(), 0);
				}
			}
		}

		public void topologicalSort() {
			Map<Character, Integer> inDegree = new HashMap<>();
			calculateInDegree(inDegree);
			List<Character> topSort = new ArrayList<>();
			Deque<Character> q = new ArrayDeque<>();

			// add all the nodes into the q having in-degree as 0
			for (Entry<Character, Integer> node : inDegree.entrySet()) {
				if (node.getValue() == 0) {
					q.add(node.getKey());
				}
			}

			// this step has a time complexity of O(V + E)
			// iterate through q
			while (!q.isEmpty()) {
				char currentNode = q.poll();
				topSort.add(currentNode);

				// update and check adjacent nodes
				for (char neighbor : adjList.get(currentNode)) {
					// if a node is zero, it means that node already included in top-sort
					int degree = inDegree.get(neighbor);
					if (degree > 0) {
						inDegree.put(neighbor, degree - 1);
						// if the degree of this node is going to be zero
						if (degree - 1 == 0) {
							q.add(neighbor);
						}
					}
				}
			}
			
			System.out.println(topSort);
		}
	}

	public static void main(String[] args) {
//		Graph g = new Graph(v, new char[] {'')
		// Create a graph given in the above diagram
		Graph g = new Graph(7, new char[] { '0', '1', '2', '3', '4', '5', '6' });
		g.addEdge('5', '2');
		g.addEdge('5', '0');
		g.addEdge('4', '0');
		g.addEdge('4', '1');
		g.addEdge('2', '3');
		g.addEdge('3', '1');
		System.out.print("Following is a Topological Sort: ");
		g.topologicalSort();

	}
}
