package com.tree.traversal;
import com.tree.Node;

public class TreeTraversal {
	/**
	 * It takes root of the tree as parameter and prints the in-order traversal
	 * 
	 * @param node
	 */
	public static void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.val + " ");
			inOrderTraversal(node.right);
		}
	}

	/**
	 * Pre-order traversal of the tree.
	 * 
	 * @param node
	 */
	public static void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	/**
	 * Post-order traversal of the tree.
	 * 
	 * @param node
	 */
	public static void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.val + " ");
		}
	}
}
