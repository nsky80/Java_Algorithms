/**
 * 
 */
package com.graph.BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author satis
 *
 */
public class ShortestPathWithAlternatingColors {
	class Solution {

		public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

			@SuppressWarnings("unchecked")
			Set<Integer>[][] graph = (Set<Integer>[][]) new Set[2][n];

			// 0 - for red
			// 1 - for blue

			// create the graph
			createGraph(graph, redEdges, blueEdges, n);

			// create tracker
			int shortestPath[][] = new int[2][n];
			// initialize with infinite
			for (int i = 1; i < n; i++) {
				shortestPath[0][i] = Integer.MAX_VALUE;
				shortestPath[1][i] = Integer.MAX_VALUE;
			}

			// now add current node as well as next color to the queue
			Queue<Integer> nodes = new ArrayDeque<>();
			Queue<Integer> color = new ArrayDeque<>();

			nodes.offer(0);
			color.offer(0);
			nodes.offer(0);
			color.offer(1);

			while (!nodes.isEmpty()) {
				int currentNode = nodes.poll();
				int currentColor = color.poll();

				// take the adjacent of opposite color
				for (int adj : graph[1 - currentColor][currentNode]) {
					
					// If adjacent node is not visited for next expected color
					if (shortestPath[1 - currentColor][adj] == Integer.MAX_VALUE) {
						// update the path, as it would + 1 from previous or current level
						shortestPath[1 - currentColor][adj] = 1 + shortestPath[currentColor][currentNode];

						nodes.offer(adj);
						color.offer(1 - currentColor);
					}
				}
			}

			
			int ans[] = new int[n];
			for (int i = 1; i < n; i++) {
				int min = Math.min(shortestPath[0][i], shortestPath[1][i]);
				if (min == Integer.MAX_VALUE) {
					ans[i] = -1;
				} else {
					ans[i] = min;
				}
			}

			
			return ans;
		}

		private void createGraph(Set<Integer>[][] graph, int[][] redEdges, int[][] blueEdges, int n) {
			for (int i = 0; i < n; i++) {
				graph[0][i] = new HashSet<>();
				graph[1][i] = new HashSet<>();
			}

			// for red edges
			for (int[] edge : redEdges) {
				graph[0][edge[0]].add(edge[1]);
			}

			// for blue edges
			for (int[] edge : blueEdges) {
				graph[1][edge[0]].add(edge[1]);
			}

		}
	}
}
