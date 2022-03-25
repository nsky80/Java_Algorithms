package com.tree;

import com.tree.traversal.TreeTraversal;

public class CartesianTree {

	public static void main(String[] args) {
		int inOrder[] = { 5, 10, 40, 30, 28 };
//			int preOrder[] = { 1, 2, 4, 5, 3, 6 };
//			int postOrder[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
//			int inOrder[] = { 4, 2, 5, 1, 6, 3 };
////			int preOrder[] = { 1, 2, 4, 5, 3, 6 };
//			int postOrder[] = { 4, 5, 2, 6, 3, 1 };

		Node root = buildCartesianTree(inOrder, 0, inOrder.length - 1);
		System.out.print("InOrder   : ");
		TreeTraversal.inOrderTraversal(root);
		System.out.print("\nPreOrder  : ");
		TreeTraversal.preOrderTraversal(root);
		System.out.print("\nPostOrder : ");
		TreeTraversal.postOrderTraversal(root);

	}

	private static Node buildCartesianTree(int[] inOrder, int start, int end) {
		// base case, i.e. if there is no child
		if (start > end) {
			return null;
		}

		// get the index of maximum element first
		int indexOfMax = getMaxElement(inOrder, start, end);

		// create a new Node
		Node newNode = new Node(inOrder[indexOfMax]);

		// If current node is leaf node then return it
		if (start == end) {
			return newNode;
		}

		// get the left sub tree
		newNode.left = buildCartesianTree(inOrder, start, indexOfMax - 1);

		// get the right sub tree
		newNode.right = buildCartesianTree(inOrder, indexOfMax + 1, end);

		// return the root
		return newNode;
	}

	/**
	 * This method finds the maximum element present in given range of array
	 * 
	 * @param inOrder
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getMaxElement(int[] inOrder, int start, int end) {
		int max = inOrder[start];
		int indexOfMax = start;

		for (int i = start; i <= end; i++) {
			if (max < inOrder[i]) {
				max = inOrder[i];
				indexOfMax = i;
			}
		}
		return indexOfMax;
	}
}
