package com.tree.view;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {

	public static void printLeftBoundaryExceptLeaf(Node root, ArrayList<Integer> path) {
		// check whether current node is leaf node or not
		if (root == null || root.left == null && root.right == null) {
			return;
		}

		// print the value
//		System.out.print(" " + root.data);
		path.add(root.data);

		// call for next left node
		printLeftBoundaryExceptLeaf(root.left, path);

		if (root.left == null) {
			printLeftBoundaryExceptLeaf(root.right, path);
		}
	}

	public static void printLeafNode(Node root, ArrayList<Integer> path) {
		// check whether current root is null
		if (root == null) {
			return;
		}

		// goto the left subtree
		printLeafNode(root.left, path);

		// if both the child is null then print the node
		if (root.left == null && root.right == null) {
//			System.out.print(" " + root.data);
			path.add(root.data);
		}

		// goto the right subtree
		printLeafNode(root.right, path);
	}

	public static void printRightBoundaryExceptLeaf(Node root, ArrayList<Integer> path) {
		// check whether current node is leaf node or not
		if (root == null || root.left == null && root.right == null) {
			return;
		}

		// call for next right node, bottom up approach
		printRightBoundaryExceptLeaf(root.right, path);
		
		// if right side is null but it still have left side
		if (root.right == null && root.left != null) {
			printRightBoundaryExceptLeaf(root.left, path);
		}
		
		// print the value
//		System.out.print(" " + root.data);
		path.add(root.data);

	}

	public static ArrayList<Integer> boundaryTraversal(Node root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		// root always be the first path
		path.add(root.data);

		printLeftBoundaryExceptLeaf(root.left, path);

		// leaf for left sub tree
		printLeafNode(root.left, path);
		// leaf for right sub tree
		printLeafNode(root.right, path);

		printRightBoundaryExceptLeaf(root.right, path);

		return path;
	}

	public static void main(String[] args) {
		Node root1 = new Node(20);
		root1.left = new Node(8);
		root1.right = new Node(22);
		root1.left.left = new Node(4);
		root1.left.right = new Node(12);
		root1.left.right.left = new Node(10);
		root1.left.right.right = new Node(14);
		root1.right.right = new Node(25);

//		printLeafNode(root1);
//		printRightBoundaryExceptLeaf(root1);

		System.out.println("\nFor first tree: " + boundaryTraversal(root1));

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.left.right = new Node(3);
		System.out.println("\nFor second tree: " + boundaryTraversal(root2));

		Node root3 = new Node(1);
		root3.left = new Node(2);
		root3.right = new Node(3);
		root3.left.right = new Node(4);
		root3.left.right.left = new Node(5);
		root3.left.right.right = new Node(6);
		root3.right.left = new Node(7);
		root3.right.right = new Node(8);

		System.out.println("\nFor third tree: " + boundaryTraversal(root3));

		Node root4 = new Node(1);
		root4.right = new Node(2);
		root4.right.left = new Node(3);
		root4.right.left.left = new Node(4);
		root4.right.left.left.left = new Node(5);
		root4.right.left.left.right = new Node(6);
//		root4.right.left.right = new Node(5);
		
		System.out.println("\nFor fourth tree: " + boundaryTraversal(root4));
		
	}

}
