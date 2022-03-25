package com.tree.LCA;

import java.util.ArrayList;
import java.util.List;

import com.tree.Node;
import com.tree.traversal.TreeTraversal;

public class PathToNodeFromRoot {
	static boolean found;

	static void getPath(Node currentNode, int nodeToSearch, ArrayList<Integer> path) {
		if (currentNode == null) {
			return;
		}

		// If nodeToSearch found then make true and return
		if (currentNode.val == nodeToSearch) {
			found = true;
			path.add(currentNode.val);

			return;
		}
		// search at left subtree
		getPath(currentNode.left, nodeToSearch, path);

		// if node still not found then search in right subtree
		if (!found) {
			getPath(currentNode.right, nodeToSearch, path);
		}
		if (found) {
			// if node found then add current value to arrayList
			path.add(currentNode.val);
		}
	}

	public static boolean getPathApproach2(Node root, List<Integer> path, int x) {

		// if root is null return
		if (root == null) {
			return false;
		}

		// add current element to the path
		path.add(root.val);

		// if element found return true
		if (root.val == x) {
			return true;
		}

		// check the element in left and right subtree
		if (getPathApproach2(root.left, path, x) || getPathApproach2(root.right, path, x)) {
			return true;
		}

		// here element doesn't found in the tree, remove current
		path.remove(path.size() - 1);

		return false;

	}

	public static int lca(Node A, int B, int C) {
		ArrayList<Integer> pathForB = new ArrayList<>();
		ArrayList<Integer> pathForC = new ArrayList<>();

		// get path from the root for B
		found = false;
		getPath(A, B, pathForB);

		// get path from the root for A
		found = false;
		getPath(A, C, pathForC);

		// path doesn't exist for any of the A or B return
		if (pathForB.size() == 0 || pathForC.size() == 0) {
			return -1;
		}

		// pointers for B and C
		int b = pathForB.size();
		int c = pathForC.size();

		// backtrack upto path is matching to find out the ancestor
		int i;
		for (i = 0; i < b && i < c; i++) {
			if (!(pathForB.get(b - i - 1) == pathForC.get(c - i - 1))) {
				break;
			}
		}

		return pathForB.get(b - i);
	}
	
	
	public static int lca2(Node A, int B, int C) {
		List<Integer> pathForB = new ArrayList<>();
		List<Integer> pathForC = new ArrayList<>();
		
		// get path from the root for B
		boolean leftFound = getPathApproach2(A, pathForB, B);
		boolean rightFound = getPathApproach2(A, pathForC, C);
				
		// path doesn't exist for any of the A or B return
		if (!leftFound || !rightFound) {
			return -1;
		}
		
		// pointers for B and C
		int b = pathForB.size();
		int c = pathForC.size();
		
		// find out the ancestor
		int i;
		for (i = 0; i < b && i < c; i++) {
			if (!(pathForB.get(i) == pathForC.get(i))) {
				break;
			}
		}
		
		return pathForB.get(i - 1);
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(1);
		root.right.left = new Node(0);
		root.right.right = new Node(8);
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);

		System.out.print("Pre-order traversal: ");
		TreeTraversal.preOrderTraversal(root);
		List<Integer> path = new ArrayList<Integer>();
		System.out.println(getPathApproach2(root, path, 87));
		System.out.println(path);

//		ArrayList<TreeNode> pathForNode1 = new ArrayList<>();
//		ArrayList<TreeNode> pathForNode2 = new ArrayList<>();
//
//		getPath(root, 5, pathForNode1);
//		found = false;
//		getPath(root, 4, pathForNode2);
//
//		System.out.println("\n7 from root: " + pathForNode1);
//		System.out.println("\n8 from root: " + pathForNode2);

//		System.out.println("\nLeast common ancestor between 0 and 8: " + lca(root, 0, 8));
//		System.out.println("\nLeast common ancestor between 7 and 8: " + lca(root, 7, 8));
//		System.out.println("\nLeast common ancestor between 5 and 4: " + lca(root, 34, 9));
		
		System.out.println("\nLeast common ancestor between 0 and 8: " + lca2(root, 0, 8));
		System.out.println("\nLeast common ancestor between 7 and 8: " + lca2(root, 7, 8));
		System.out.println("\nLeast common ancestor between 5 and 4: " + lca2(root, 34, 9));
	}

}
