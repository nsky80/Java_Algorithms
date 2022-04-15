/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
package com.tree.bst;

/**
 * @author Satish Kumar Yadav
 *
 */
public class TrimABinarySearchTree {

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

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return null;

		// trim left and right sub tree
		TreeNode left = trimBST(root.left, low, high);
		TreeNode right = trimBST(root.right, low, high);

		if (root.val < low) {
			// if root is less than low then discard whole left sub tree
			// along with root and make right subtree as new tree.
			root = right;
		} else if (root.val > high) {
			// vice-versa
			root = left;
		} else {
			// otherwise save any possible changes
			root.left = left;
			root.right = right;
		}

		return root;
	}

}
