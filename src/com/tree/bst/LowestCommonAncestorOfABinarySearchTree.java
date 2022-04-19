/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
package com.tree.bst;

/**
 * @author satis
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {

//	 Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root.val == p.val || root.val == q.val || (p.val < root.val && q.val > root.val)
					|| (q.val < root.val && p.val > root.val))
				return root;

			if (p.val < root.val)
				return lowestCommonAncestor(root.left, p, q);
			else
				return lowestCommonAncestor(root.right, p, q);
		}
	}
}
