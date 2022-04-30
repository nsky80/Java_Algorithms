/**
 * This problem can also be solved using sorting, where we can sort the array according to Euclidean distance
 * and sorting solution will have a time and space complexity of O(nlogn) and O(n) respectively. 
 * 
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Satish
 *
 */
public class K_ClosestPointsToOrigin {
	class DistanceTracker {
		int distance;
		int index;

		public DistanceTracker(int x, int y, int index) {
			this.distance = x * x + y * y;
			this.index = index;
		}
	}

	class Solution {

		/**
		 * Time: O(nlogn) Space: O(n)
		 */
		public int[][] kClosest(int[][] points, int k) {
			// priority queue(max heap) to store the elements according to distance
			PriorityQueue<DistanceTracker> pq = new PriorityQueue<>(new Comparator<DistanceTracker>() {
				public int compare(DistanceTracker o1, DistanceTracker o2) {
					return o1.distance - o2.distance;
				}
			});

			for (int i = 0; i < points.length; i++) {
				pq.add(new DistanceTracker(points[i][0], points[i][1], i));
			}

			int kPoints[][] = new int[k][];
			// return the result
			for (int i = 0; i < k; i++) {
				kPoints[i] = points[pq.poll().index];
			}

			return kPoints;
		}
	}

	class SpaceOptimized {
		private int getDistance(int []p) {
			return p[0] * p[0] + p[1] * p[1];
		}
		
		/**
		 * Time: O(nlogk) Space: O(k)
		 */
		public int[][] kClosest(int[][] points, int k) {
			// priority queue(max heap) to store the elements according to distance
			PriorityQueue<int[]> pq = new PriorityQueue<>(
					(p1, p2) -> (getDistance(p2) - getDistance(p1)));

			// add first k point which are mandatory
			for (int i = 0; i < k; i++) {
				pq.add(points[i]);
			}

			// now compare remaining points,
			// if any point is less than max available, replace
			for(int i = k; i < points.length; i++) {
				int []max = pq.peek();
				if (getDistance(max) > getDistance(points[i])) {
					pq.poll();
					pq.add(points[i]);
				}
			}
			
			int kPoints[][] = new int[k][];
			// return the result
			for (int i = 0; i < k; i++) {
				kPoints[i] = pq.poll();
			}

			return kPoints;
		}
	}

}
