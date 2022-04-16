/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
package com.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertBSTtoGreaterTree {

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

	int sum;

	/**
	 * Iterative solution.
	 * O(n), O(n)
	 * @param root
	 * @return
	 */
	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;

		Deque<TreeNode> stack = new ArrayDeque<>();

		sum = 0;

		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {
			// go to extreme right
			while (node != null) {
				stack.push(node);
				node = node.right;
			}

			// pop the extreme right node
			node = stack.pop();
			sum += node.val;
			node.val = sum;

			// visit left sub tree
			node = node.left;
		}

		return root;

		// sum = 0;
		// revInOrder(root);
		// return root;
	}

	/**
	 * Recursive solution-reverse in-order traversal
	 * @param root
	 * @return
	 */
	public TreeNode revInOrder(TreeNode root) {
		if (root != null) {
			revInOrder(root.right);
			sum += root.val;
			root.val = sum;
			revInOrder(root.left);
		}
		return root;
	}

	public static void main(String[] args) {

	}

}
