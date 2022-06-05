/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
package com.tree;

/**
 * From a particular node, there are 4 solutions possible - max in left subtree,
 * right subtree, root itself, left + right + root; we have to update the
 * maximum from these possible solutions at every step.
 * 
 * Return the maximum between left + root, right + root and root itself.
 * 
 * Time: O(n), Space: O(n)
 * 
 * @author Satish
 *
 */
public class BinaryTreeMaximumPathSum {

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

	class Solution {
		int max;

		public int maxPathSum(TreeNode root) {
			max = Integer.MIN_VALUE;
			getMax(root);
			return max;
		}

		public int getMax(TreeNode root) {
			if (root == null)
				return 0;

			int left = getMax(root.left) + root.val;
			int right = getMax(root.right) + root.val;

			// update the Maximum value pointer, by checking left, right root,
			// left + right - root i.e. whole branch with maximum sum in left and
			// right subtree
			max = Math.max(max, Math.max(left, Math.max(right, Math.max(root.val, left + right - root.val))));

			// return maximum by including and excluding left and right
			return Math.max(left, Math.max(root.val, right));
		}
	}
}
