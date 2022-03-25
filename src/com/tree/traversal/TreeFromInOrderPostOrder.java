package com.tree.traversal;

import java.util.HashMap;
import java.util.Map;
import com.tree.Node;

public class TreeFromInOrderPostOrder {
	static Map<Integer, Integer> mp = new HashMap<>();

	private static Node buildTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart,
			int postEnd) {
		if (inStart > inEnd) {
			return null;
		}

		// create a sub - root node from the last element of postOrder array
		Node newNode = new Node(postOrder[postEnd]);

		// Now check whether it is leaf node
		if (inStart == inEnd) {
			return newNode;
		}

		// get the index position current element in inOrder array
		int ind = mp.get(newNode.val);

		// Now calculate the length of left and right sub-tree
		int lLen = ind - inStart;
		int rLen = inEnd - ind;

		// create the left sub-tree by passing sub-post-array
		newNode.left = buildTree(inOrder, postOrder, inStart, ind - 1, postEnd - (rLen + lLen), postEnd - rLen - 1);

		// create right sub-tree
		newNode.right = buildTree(inOrder, postOrder, ind + 1, inEnd, postEnd - rLen, postEnd - 1);

		// return the root node
		return newNode;
	}

	/**
	 * This method creates a map mp which will keep track of indices for every
	 * element present in in-order array
	 * 
	 * @param inOrder
	 * @param postOrder
	 * @param inStart
	 * @param inEnd
	 * @param postStart
	 * @param postEnd
	 * @return
	 */
	private static Node createTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart,
			int postEnd) {
		for (int i = inStart; i <= inEnd; i++) {
			mp.put(inOrder[i], i);
		}
		return buildTree(inOrder, postOrder, inStart, inEnd, postStart, postEnd);
	}

	/**
	 * Main driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int inOrder[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
//		int preOrder[] = { 1, 2, 4, 5, 3, 6 };
		int postOrder[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
//		int inOrder[] = { 4, 2, 5, 1, 6, 3 };
////		int preOrder[] = { 1, 2, 4, 5, 3, 6 };
//		int postOrder[] = { 4, 5, 2, 6, 3, 1 };

		Node root = createTree(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
		System.out.print("InOrder   : ");
		TreeTraversal.inOrderTraversal(root);
		System.out.print("\nPreOrder  : ");
		TreeTraversal.preOrderTraversal(root);
		System.out.print("\nPostOrder : ");
		TreeTraversal.postOrderTraversal(root);
	}

}
