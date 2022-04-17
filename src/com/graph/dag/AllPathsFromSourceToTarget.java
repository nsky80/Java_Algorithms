/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
package com.graph.dag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author satis
 *
 */
public class AllPathsFromSourceToTarget {
	int n;
	List<List<Integer>> paths;

	/**
	 * This method is less complex
	 */
	public List<List<Integer>> allPathsSourceTargetOptimized(int[][] graph) {
		n = graph.length;
		paths = new ArrayList<>();
		List<Integer> tracker = new ArrayList<>();
		tracker.add(0);
		getAllPathDFS(graph, 0, tracker);
		return paths;
	}

	public void getAllPathDFS(int[][] graph, int src, List<Integer> tracker) {

		if (src == n - 1) {
			List<Integer> temp = new ArrayList<>(tracker);
			paths.add(temp);
			return;
		}

		for (int adj : graph[src]) {
			tracker.add(adj);
			getAllPathDFS(graph, adj, tracker);
			tracker.remove(tracker.size() - 1);
		}

	}

	// backtracking solution
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		n = graph.length;
		return dfsGetUniquePath(graph, 0);
	}

	// backtracking dfs
	public List<List<Integer>> dfsGetUniquePath(int[][] graph, int src) {
		List<List<Integer>> paths = new LinkedList<>();
		if (src == n - 1) {
			List<Integer> temp = new LinkedList<>();
			temp.add(n - 1);
			paths.add(temp);
			return paths;
		}

		List<List<Integer>> currentList;
		for (int adj : graph[src]) {
			currentList = dfsGetUniquePath(graph, adj);
			if (!currentList.isEmpty()) {
				// add the current node in front
				for (List<Integer> li : currentList) {
					li.add(0, src);
				}

				// add current list into the answer
				paths.addAll(currentList);
			}
		}

		return paths;
	}
}
