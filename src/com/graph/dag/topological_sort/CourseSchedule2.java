/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
package com.graph.dag.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Satish
 *
 */
public class CourseSchedule2 {

	/**
	 * This approach uses Kahn's algorithm to find out the topological sort
	 */
	class BFS_Soluton {
		// final int WHITE = 0, GRAY = 1, BLACK = 2;
		public int[] findOrder(int numCourses, int[][] prerequisites) {

			int index = numCourses - 1;
			int[] courses = new int[numCourses];

			// creating the adjList
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i < numCourses; i++) {
				adjList.add(new ArrayList<>());
			}

			int[] inDegree = new int[numCourses];

			// adding the dependency
			for (int edge[] : prerequisites) {
				adjList.get(edge[0]).add(edge[1]);
				inDegree[edge[1]] += 1;
			}

			Deque<Integer> q = new ArrayDeque<>();
			// add all the nodes into the queue having indegree 0
			for (int i = 0; i < numCourses; i++) {
				if (inDegree[i] == 0) {
					q.offer(i);
				}
			}

			// now visit each node
			while (!q.isEmpty()) {
				int curr = q.poll();
				courses[index--] = curr;

				for (int adj : adjList.get(curr)) {
					inDegree[adj]--;
					if (inDegree[adj] == 0) {
						q.offer(adj);
					}
				}
			}

			// check if all the topological covered or not, there might be a cycle
			// and if there is a cycle then either q would be empty initially or
			// all the vertices not visited.
			if (index != -1)
				return new int[0];

			return courses;

		}

	}

	
	/**
	 * This is DFS solution which checks the cycle using graph coloring and 
	 * also adds the values meantime.
	 */
	class DFS_Solution {
		final int WHITE = 0, GRAY = 1, BLACK = 2;

		public int[] findOrder(int numCourses, int[][] prerequisites) {

			int[] courses = new int[numCourses];
			int[] tracker = new int[numCourses];

			// creating the adjList
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i < numCourses; i++) {
				adjList.add(new ArrayList<>());
			}

			// adding the dependency
			for (int edge[] : prerequisites) {
				adjList.get(edge[1]).add(edge[0]);
			}

			int index = numCourses - 1;
			// now visit each node

			for (int node = 0; node < numCourses; node++) {
				if (tracker[node] == WHITE) {
					index = dfs(courses, tracker, index, adjList, node);
				}
				// check cycle
				if (index == -2)
					return new int[0];
			}

			return courses;

		}

		public int dfs(int[] courses, int[] tracker, int index, List<List<Integer>> adjList, int src) {
			tracker[src] = GRAY;

			for (int adj : adjList.get(src)) {
				if (tracker[adj] == GRAY) {
					// cycle found
					return -2;
				}

				if (tracker[adj] == WHITE) {
					index = dfs(courses, tracker, index, adjList, adj);
				}

				// if cycle found in any of the previous node
				if (index == -2) {
					return -2;
				}
			}

			// now put the nodes
			courses[index--] = src;
			tracker[src] = BLACK;

			return index;
		}
	}
}
