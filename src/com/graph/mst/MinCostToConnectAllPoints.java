/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */
package com.graph.mst;

import java.util.PriorityQueue;

/**
 * @author satis
 *
 */
public class MinCostToConnectAllPoints {

	class Pair {
		int weight;
		int node;

		public Pair(int weight, int next) {
			this.weight = weight;
			this.node = next;
		}
	}

	
	/**
	 * O(N^2.log(N)), O(N ^ 2)
	 */
	class PrimsUsingPriorityQueue {
		public int minCostConnectPoints(int[][] points) {
			int n = points.length;
			boolean visited[] = new boolean[n];
			int totalCost = 0;
			
			PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> (p1.weight - p2.weight));
			
			// adding the first co-ordinate into the queue
			heap.add(new Pair(0, 0));
			int edgeAdded = 0;
			
			// n - 1 edge should be added into the MST
			while(edgeAdded < n) {
				// pick minimum among reachable nodes
				Pair current = heap.poll();
				
				// if the current node is visited then remove the edge
				if (visited[current.node])
					continue;
				
				// now mark the current node as visited
				visited[current.node] = true;
				totalCost += current.weight;
				edgeAdded++;
				
				// add the adjacent un-visited nodes
				for(int next = 0; next < n; next++) {
					if (!visited[next]) {
						heap.add(new Pair(getDistance(points[current.node], points[next]), next));
					}
				}
				
			}
			return totalCost;
		}

		private int getDistance(int p1[], int p2[]) {
			return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
		}
	}
}
