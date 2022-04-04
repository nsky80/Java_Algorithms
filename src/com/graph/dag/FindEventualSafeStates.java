/**
 * Problem Statement URL: https://leetcode.com/submissions/detail/673586919/
 */
package com.graph.dag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
	static final int WHITE = 0, GRAY = 1, BLACK = 2;

	/**
	 * Approach: Reverse Edge
	 * 
	 * @param graph
	 * @return
	 */
	public List<Integer> eventualSafeNodes(int[][] graph) {
		// creating graph and incidentGraph
		List<List<Integer>> g = new ArrayList<>();
		List<List<Integer>> gi = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			g.add(new ArrayList<>());
			gi.add(new ArrayList<>());
		}

		Queue<Integer> q = new LinkedList<>();

		// adding the data for graph and incident graph list
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				g.get(i).add(graph[i][j]);
				gi.get(graph[i][j]).add(i);
			}

			// if this is safe node, i.e. it doesn't have any outgoing edge
			if (g.get(i).size() == 0) {
				q.add(i);
			}
		}

		boolean safe[] = new boolean[graph.length];

		// start checking the safe state
		while (!q.isEmpty()) {
			Integer current = q.poll();
			safe[current] = true;

			for (Integer incidentNode : gi.get(current)) {
				// remove current from adjList
				g.get(incidentNode).remove(current);

				// by removing edge from x -> safeNode, if x becomes safe
				if (g.get(incidentNode).size() == 0) {
					q.add(incidentNode);
				}
			}

		}

		List<Integer> res = new ArrayList<>();
		// now prepare the result
		for (int i = 0; i < graph.length; i++) {
			if (safe[i]) {
				res.add(i);
			}
		}

		return res;
	}

	/**
	 * Using DFS
	 * 
	 * @param graph
	 * @return
	 */
	public List<Integer> eventualSafeNodes2(int[][] graph) {
		int n = graph.length;

		// tracker array
		int tracker[] = new int[n];

		// call DFT
		for (int i = 0; i < n; i++) {
			if (tracker[i] == WHITE) {
				markSafeStatesDFS(graph, tracker, i);
			}
		}

		// now get all the result
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (tracker[i] == BLACK) {
				res.add(i);
			}
		}

		return res;

	}

	/**
	 * Implementation of DFS-TopSort
	 * 
	 * @param adjList
	 * @param tracker
	 * @param i
	 * @return true if there is any cycle so that all the nodes which involved in
	 *         cycle could be marked.
	 */
	private boolean markSafeStatesDFS(int[][] adjList, int[] tracker, int src) {
		tracker[src] = GRAY;

		for (int adj : adjList[src]) {
			if (tracker[adj] == GRAY) {
				tracker[adj] = GRAY;
				return false;
			}

			// If this node also involved in cycle then put it into gray list and return
			if (tracker[adj] == WHITE && !markSafeStatesDFS(adjList, tracker, adj)) {
				tracker[adj] = GRAY;
				return false;
			}
		}

		tracker[src] = BLACK;
		return true;
	}

	public static void main(String[] args) {
		int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		FindEventualSafeStates obj = new FindEventualSafeStates();
		System.out.println(obj.eventualSafeNodes2(graph));
	}
}