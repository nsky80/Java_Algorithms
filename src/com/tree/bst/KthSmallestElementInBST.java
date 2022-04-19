/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
package com.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class KthSmallestElementInBST {
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

	int kthSmall;
	boolean flag;
	int pos;

	public int kthSmallest(TreeNode root, int k) {
		setKth(root, k);
		pos = 0;
		flag = false;
		return kthSmall;
	}

	public void setKth(TreeNode root, int k) {
		if (root == null)
			return;
		setKth(root.left, k);

		if (flag) {
			return;
		}
		pos++;
		if (pos == k) {
			kthSmall = root.val;
			flag = true;
			return;
		}

		setKth(root.right, k);
		return;
	}

	public int kthSmallestIterative(TreeNode root, int k) {

		int pos = 0;
		int kthSmall = root.val;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			pos++;
			if (pos == k) {
				kthSmall = node.val;
				break;
			}

			node = node.right;
		}

		return kthSmall;
	}

}
