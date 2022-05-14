/**
 * https://leetcode.com/problems/network-delay-time/
 */
package com.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This solution uses lazy implementation of Dijkstra Algorithm, which
 * calculates the shortest distance to each node from the given node k, if any
 * node is not visited, then it returns -1 instead otherwise it returns the
 * maximum of shortest calculated distance.
 * 
 * Time: O(N + E logN) Space: The maximum element that can be present in the
 * priority Queue is E which would be O(E), the dist array would take O(N) space
 * and adjList takes O(E), so, total space would be O(E).
 * 
 * @author satis
 *
 */
public class NetworkDelayTime {
	class Edge {
		int to;
		int cost;

		public Edge() {

		}

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public String toString() {
			return "[Edge to=" + to + ", cost=" + cost + "]";
		}
	}

	class Solution {
		public int networkDelayTime(int[][] times, int n, int k) {

			// create adjList
			List<List<Edge>> adjList = new ArrayList<>();
			// for 0th index, it is dummy node
			for (int i = 0; i <= n; i++) {
				adjList.add(new ArrayList<>());
			}

			for (int time[] : times) {
				adjList.get(time[0]).add(new Edge(time[1], time[2]));
			}

			// now apply Dijkstra
			int dist[] = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			// for dummy node
			dist[0] = 0;
			dist[k] = 0;

			boolean visited[] = new boolean[n + 1];
			visited[0] = true;
			visited[k] = true;

			PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[1] - y[1]));

			pq.add(new int[] { k, 0 });

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int index = cur[0];
				int minValue = cur[1];

				visited[index] = true;

				// if it is already have a optimized path
				// this is optimization for lazy implementation
				if (dist[index] < minValue)
					continue;

				for (Edge nei : adjList.get(index)) {
					// if nei is already visited
					if (visited[nei.to])
						continue;

					// relax the edge
					int newDist = dist[index] + nei.cost;

					if (newDist < dist[nei.to]) {
						dist[nei.to] = newDist;
						pq.add(new int[] { nei.to, newDist });
					}
				}

			}

			int max = 0;

			for (int i = 0; i <= n; i++) {
				if (!visited[i])
					return -1;
				max = Math.max(max, dist[i]);
			}

			return max;
		}
	}
}
