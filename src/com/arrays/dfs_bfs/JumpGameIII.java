/**
 * https://leetcode.com/problems/jump-game-iii/
 */
package com.arrays.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author satis
 *
 */
public class JumpGameIII {
	/**
	 * Time: O(n)
	 * Space: O(n)
	 */
	class DFS {
		int n;

		public boolean canReach(int[] arr, int start) {
			n = arr.length;
			boolean visited[] = new boolean[n];
			return dfs(arr, visited, start);
		}

		public boolean dfs(int[] arr, boolean[] visited, int src) {
			if (src < 0 || src >= n || visited[src])
				return false;
			if (arr[src] == 0)
				return true;

			visited[src] = true;

			return dfs(arr, visited, src - arr[src]) || dfs(arr, visited, src + arr[src]);
		}
	}

	class BFS {
		public boolean canReach(int[] arr, int start) {
			if (arr[start] == 0)
				return true;

			int n = arr.length;

			Queue<Integer> q = new ArrayDeque<>();
			q.offer(start);
			boolean visited[] = new boolean[n];
			visited[start] = true;

			while (!q.isEmpty()) {
				int current = q.poll();

				int left = current - arr[current];

				if (left >= 0 && left < n && (!visited[left])) {
					if (arr[left] == 0)
						return true;
					visited[left] = true;
					q.offer(left);
				}

				left = current + arr[current];

				if (left >= 0 && left < n && (!visited[left])) {
					if (arr[left] == 0)
						return true;
					visited[left] = true;
					q.offer(left);
				}
			}

			return false;
		}
	}
}
