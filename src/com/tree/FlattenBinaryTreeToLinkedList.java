package com.tree;

class TreeNode {
	public int val;
	public TreeNode left, right;

	TreeNode(int val) {
		this.val = val;
		right = null;
		left = null;
	}
}

public class FlattenBinaryTreeToLinkedList {

	public TreeNode flatten(TreeNode node) {
		// if it is leaf node then return the node
		if (node == null || node.left == null && node.right == null) {
			return node;
		}

		// take the backup of left and right sub tree
		TreeNode tempLeft = node.left;
		TreeNode tempRight = node.right;

		// create the left of this node as null
		node.left = null;

		// flatten the left and right subtree
		flatten(tempLeft);
		flatten(tempRight);

		// put the left of current to the right
		node.right = tempLeft;

		TreeNode temp = node;

		// iterate to the extreme right so that right sub tree can be attached
		while (temp.right != null) {
			temp = temp.right;
		}
		temp.right = tempRight;

		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
