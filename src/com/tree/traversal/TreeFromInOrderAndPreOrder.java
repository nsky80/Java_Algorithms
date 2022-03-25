package com.tree.traversal;

import com.tree.Node;

public class TreeFromInOrderAndPreOrder {
	static int preIndex = 0;

	public static Node buildTree(int pre[], int in[], int inStart, int inEnd) {
		// If any root node have only one child then it'll get executed
		// for other child
		if (inStart > inEnd) {
//			System.out.println("Called");
			return null;
		}

		// Create a new node which is root from pre-order
		Node newNode = new Node(pre[preIndex++]);

		// If this is only node, i.e. leaf node then return it simply
		if (inStart == inEnd) {
			return newNode;
		}

		// get the position of element in In-order array
		int inIndex = getIndexInInOrder(in, inStart, inEnd, newNode.val);

		// Create the left sub tree
		newNode.left = buildTree(pre, in, inStart, inIndex - 1);

		// Create the right sub tree
		newNode.right = buildTree(pre, in, inIndex + 1, inEnd);

		// return the root of the tree
		return newNode;
	}

	/**
	 * This method searches the given "val" in the in-order sequence and returns the
	 * index
	 * 
	 * @param in
	 * @param inStart
	 * @param inEnd
	 * @param val
	 * @return index of the element otherwise -1
	 */
	private static int getIndexInInOrder(int[] in, int inStart, int inEnd, int val) {
		int ind = -1;

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == val) {
				ind = i;
				break;
			}
		}
		return ind;
	}

	public static void main(String[] args) {
		int inOrder[] = { 4, 2, 5, 1, 6, 3 };
		int preOrder[] = { 1, 2, 4, 5, 3, 6 };

		Node root = buildTree(preOrder, inOrder, 0, inOrder.length - 1);
		TreeTraversal.inOrderTraversal(root);
		System.out.println();
		TreeTraversal.preOrderTraversal(root);
	}

}
