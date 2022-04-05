package com.tree;

public class DiameterOfBinaryTree {

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

	static int maxTillNow = 0;

	public int helper(TreeNode root) {
		// base case
		if (root == null)
			return 0;

		int leftDia = helper(root.left);
		int rightDia = helper(root.right);

		if ((leftDia + rightDia) > maxTillNow) {
			maxTillNow = leftDia + rightDia;
		}

		return Math.max(leftDia, rightDia) + 1;

	}

	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return maxTillNow;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(obj.diameterOfBinaryTree(root));
	}

}
