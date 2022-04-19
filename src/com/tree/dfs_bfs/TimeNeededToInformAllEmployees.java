/**
 * 
 */
package com.tree.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author satis
 *
 */
public class TimeNeededToInformAllEmployees {
	// Time: O(n + e) O(n + e)
	@SuppressWarnings("unchecked")
	public int numOfMinutesBFS(int n, int headID, int[] manager, int[] informTime) {
		int time[] = informTime.clone();

		List<Integer>[] subOrdinates = (List<Integer>[]) new List[n];

		for (int i = 0; i < n; i++) {
			subOrdinates[i] = new ArrayList<Integer>();
		}

		// add all the nodes to the array
		for (int i = 0; i < n; i++) {
			if (manager[i] != -1) {
				subOrdinates[manager[i]].add(i);
			}
		}

		Deque<Integer> q = new ArrayDeque<>();
		q.offer(headID);
		int max = 0;

		while (!q.isEmpty()) {
			int current = q.poll();

			if (manager[current] != -1)
				time[current] += time[manager[current]];
			max = Math.max(max, time[current]);
			q.addAll(subOrdinates[current]);
		}

		return max;
	}

	
	
	
	int max;
	@SuppressWarnings("unchecked")
	public int numOfMinutesDFS(int n, int headID, int[] manager, int[] informTime) {
//		int time[] = informTime.clone();

		List<Integer>[] subOrdinates = (List<Integer>[]) new List[n];

		for (int i = 0; i < n; i++) {
			subOrdinates[i] = new ArrayList<Integer>();
		}

		// add all the nodes to the array
		for (int i = 0; i < n; i++) {
			if (manager[i] != -1) {
				subOrdinates[manager[i]].add(i);
			}
		}
		max = 0;
		
		dfs(subOrdinates, manager, headID, informTime, informTime[headID]);
		return max;
	}
	
	private void dfs(List<Integer>[] subOrdinates, int[] manager, int headID, int[] informTime, int t) {
		
		for(int adj: subOrdinates[headID]) {
			max = Math.max(max, t + informTime[adj]);
			dfs(subOrdinates, manager, adj, informTime, t + informTime[adj]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
