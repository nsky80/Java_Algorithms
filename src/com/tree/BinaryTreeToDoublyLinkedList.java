package com.tree;

public class BinaryTreeToDoublyLinkedList {
	// This function should return head to the DLL

	// Function to convert binary tree to doubly linked list and return it.
	Node bToDLL(Node root) {
		// Your code here
		if (root == null || root.left == null && root.right == null) {
			return root;
		}

		// goto left part
		Node leftNode = bToDLL(root.left);
		Node rightNode = bToDLL(root.right);

		// if leftNode exists
		if (leftNode != null) {
			Node lastOfLeft = leftNode;

			// get the extreme most element
			while (lastOfLeft.right != null) {
				lastOfLeft = lastOfLeft.right;
			}

			lastOfLeft.right = root;
			root.left = lastOfLeft;

		} // if leftNode doesn't exist, make root as left and return
		else {
			leftNode = root;
			// lastOfLeft = root;
		}

		if (rightNode != null) {
			root.right = rightNode;
			rightNode.left = root;
		}

		return leftNode;
	}

}
