/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
package com.tree.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(n), Space: O(n)
 * @author Satish Kumar Yadav
 *
 */
public class DeepestLeavesSum {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class DFS_Solution {
		// These will keep track of maximum level found till now and sum for that level
		int sum;
		int maxLevel;

		public int deepestLeavesSum(TreeNode root) {
			sum = 0;
			dfs(root, 0);
			return sum;
		}

		public void dfs(TreeNode root, int currentLevel) {
			if (root == null)
				return;

			// if max level found so far is equals to current level then add this value
			if (currentLevel == maxLevel) {
				sum += root.val;
			}

			// there exist higher level, reset the sum, update the max level
			if (currentLevel > maxLevel) {
				maxLevel = currentLevel;
				sum = root.val;
			}

			// check in left and right subtree.
			dfs(root.left, currentLevel + 1);
			dfs(root.right, currentLevel + 1);
		}
	}

	class BFS_Solution {
		public int deepestLeavesSum(TreeNode root) {
			Deque<TreeNode> q = new ArrayDeque<>();

			q.add(root);

			int sum = 0;

			while (!q.isEmpty()) {
				int size = q.size();
				sum = 0;
				while (size-- > 0) {
					TreeNode current = q.poll();
					sum += current.val;

					if (current.left != null) {
						q.add(current.left);
					}

					if (current.right != null) {
						q.add(current.right);
					}
				}
			}

			return sum;
		}
	}
}
