/**
 * To detect a cycle in DAG using DFS: 
 * Source: https://leetcode.com/problems/course-schedule/submissions/
 */

package com.graph.dag.topological_sort;

import java.util.List;
import java.util.ArrayList;

public class CourseSchedule {

	public static void main(String[] args) {
		SolutionCourse problem = new SolutionCourse();
		int course = 2;
		int [][] pre = {{1,0}};
		System.out.println(problem.canFinish(course, pre));

		course = 2;
		pre = new int[][] {{1, 0}, {0, 1}};
		
		System.out.println(problem.canFinish(course, pre));
	}

}

class SolutionCourse {

	public boolean dfs(int source, boolean visited[], boolean recStack[], List<List<Integer>> adjList) {
//         if (recStack[source]){
//             return false;
//         }

		visited[source] = true;
		recStack[source] = true;

		for (int adj : adjList.get(source)) {
			if (recStack[adj]) {
				return true;
			}

			if (!visited[adj]) {
				if (dfs(adj, visited, recStack, adjList)) {
					return true;
				}
			}
		}

		recStack[source] = false;
		return false;
	}

	public boolean detectCycle(int n, List<List<Integer>> adjList) {
		boolean[] visited = new boolean[n];
		boolean[] recStack = new boolean[n];

		boolean cycleFound = false;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				cycleFound = dfs(i, visited, recStack, adjList);
				if (cycleFound) {
					break;
				}
			}
		}
		return !cycleFound;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// create adj list
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		// add the edges
		for (int edge[] : prerequisites) {
			adjList.get(edge[0]).add(edge[1]);
		}
		
//		System.out.println(adjList);
		// check for the cycle
		return detectCycle(numCourses, adjList);

	}
}