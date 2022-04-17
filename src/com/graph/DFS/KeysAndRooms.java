/**
 * https://leetcode.com/problems/keys-and-rooms/
 */
package com.graph.DFS;

import java.util.List;

/**
 * @author satis
 *
 */
public class KeysAndRooms {
	/**
	 * O(n), O(n)
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean visited[] = new boolean[rooms.size()];
		dfs(rooms, 0, visited);

		for (int i = 0; i < rooms.size(); i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

	public void dfs(List<List<Integer>> rooms, int src, boolean visited[]) {
		visited[src] = true;

		for (int adj : rooms.get(src)) {
			if (!visited[adj]) {
				dfs(rooms, adj, visited);
			}
		}
	}
}
