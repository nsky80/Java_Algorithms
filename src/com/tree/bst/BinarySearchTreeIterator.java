/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
package com.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class BinarySearchTreeIterator {
	// Definition for a binary tree node.
	static public class TreeNode {
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
	 * This is O(1) for next(), O(1) for hasNext and O(n) for space solution.
	 * @author satis
	 *
	 */
	static class BSTIteratorN {
		private Deque<Integer> inorderList;

		public BSTIteratorN(TreeNode root) {
			inorderList = new ArrayDeque<>();
			inorder(root);
		}

		public int next() {
			return inorderList.poll();
		}

		public boolean hasNext() {
			return !inorderList.isEmpty();
		}

		private void inorder(TreeNode root) {
			if (root == null)
				return;
			inorder(root.left);
			inorderList.offer(root.val);
			inorder(root.right);
		}
	}

	/**
	 * This is amortized O(1) for next() and O(1) for hasNext() solution. Space is
	 * O(h).
	 * 
	 * @author satis
	 *
	 */
	static class BSTIterator {
		private Deque<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new ArrayDeque<>();
			processLeft(root);
		}

		/**
		 * If we iterate whole tree, every node just goes into stack once and is goes
		 * out once， so it's O(2) for each node
		 */
		public int next() {
			TreeNode node = stack.pollFirst();
			processLeft(node.right);
			return node.val;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		private void processLeft(TreeNode root) {
			if (root == null)
				return;
			while (root != null) {
				stack.addFirst(root);
				root = root.left;
			}
		}
	}

}
