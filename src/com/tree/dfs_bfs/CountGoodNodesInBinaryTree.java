/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
package com.tree.dfs_bfs;

/**
 * @author satis
 *
 */
public class CountGoodNodesInBinaryTree {

//	  Definition for a binary tree node.
	static class TreeNode {
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

	/**
	 * Use DFS (Depth First Search) to traverse the tree, and constantly keep track
	 * of the current path maximum.
	 * 
	 * O(n), O(height)
	 */
	class Solution {
		public int goodNodes(TreeNode root) {
			return countGood(root, Integer.MIN_VALUE);
		}

		private int countGood(TreeNode root, int prevMax) {
			if (root == null)
				return 0;
			int count = 0;
			if (root.val >= prevMax) {
				prevMax = root.val;
				count++;
			}

			return count + countGood(root.left, prevMax) + countGood(root.right, prevMax);
		}

	}
}
