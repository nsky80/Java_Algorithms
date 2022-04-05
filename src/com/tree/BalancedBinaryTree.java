/**
 * Check whether given tree is height balanced or not.
 * URL: https://leetcode.com/problems/balanced-binary-tree/
 */
package com.tree;

/**
 * @author satis
 *
 */
public class BalancedBinaryTree {

	// Definition for a binary tree node.
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

	class Solution {
		/**
		 * Time complexity: O(n) Space Complexity: O(height)
		 * 
		 * @param root
		 * @return
		 */
		public boolean isBalanced(TreeNode root) {
			return isBalancedHelper(root) == -1 ? false : true;
		}

		public int isBalancedHelper(TreeNode root) {
			if (root == null)
				return 0;

			int leftHeight, rightHeight;

			if ((leftHeight = isBalancedHelper(root.left)) == -1)
				return -1;
			if ((rightHeight = isBalancedHelper(root.right)) == -1)
				return -1;

			if (Math.abs(leftHeight - rightHeight) <= 1) {
				return Math.max(leftHeight, rightHeight) + 1;
			} else {
				return -1;
			}
		}
	}
}
