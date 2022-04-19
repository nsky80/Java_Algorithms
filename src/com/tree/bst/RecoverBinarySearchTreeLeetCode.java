package com.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTreeLeetCode {
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

		public String toString() {
			return " " + val + " ";
		}
	}

	static class Solution {

		/**
		 * This is O(n), O(n) solution.
		 */
		public void recoverTree(TreeNode root) {
			List<TreeNode> in = new ArrayList<>();
			inorder(root, in);

			TreeNode prev = in.get(0);
			TreeNode maxNode = null;
			TreeNode minNode = null;

			for (int i = 1; i < in.size(); i++) {
				TreeNode current = in.get(i);

				if (!(prev.val < current.val)) {
					if (maxNode == null) {
						maxNode = prev;
					}
					minNode = current;
				}
				prev = current;
			}

			if (maxNode != null) {
				int temp = maxNode.val;
				maxNode.val = minNode.val;
				minNode.val = temp;
			}
		}

		public void inorder(TreeNode root, List<TreeNode> in) {
			if (root == null)
				return;

			inorder(root.left, in);
//			in.add(root);
			System.out.println(root.val);
			inorder(root.right, in);
		}

		TreeNode maxNode = null;
		TreeNode minNode = null;
		TreeNode prev = null;

		public void recoverTreeRecursive(TreeNode root) {
			inorderRecursive(root);

			if (maxNode != null) {
				int temp = maxNode.val;
				maxNode.val = minNode.val;
				minNode.val = temp;
			}
		}

		public void inorderRecursive(TreeNode root) {
			if (root == null)
				return;

			inorderRecursive(root.left);

			if (prev != null) {
				if (!(prev.val < root.val)) {
					if (maxNode == null) {
						maxNode = prev;
					}
					minNode = root;
				}
			}
			prev = root;

			inorderRecursive(root.right);
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
//		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		obj.inorder(root, null);
		obj.recoverTreeRecursive(root);
		System.out.println("fixed:");
		obj.inorder(root, null);

	}

}
