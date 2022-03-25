package com.tree.traversal;

import java.util.HashMap;
import java.util.Map;

import com.tree.Node;

public class TreeFromInOrderAndPreOrderUsingHash {
	static int preIndex = 0;
	static Map<Integer, Integer> mp = new HashMap<>();

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
		int inIndex = mp.get(newNode.val);

		// Create the left sub tree
		newNode.left = buildTree(pre, in, inStart, inIndex - 1);

		// Create the right sub tree
		newNode.right = buildTree(pre, in, inIndex + 1, inEnd);

		// return the root of the tree
		return newNode;
	}

	/**
	 * Using hash for searching the index of tree to reduce the search time.
	 * 
	 * @param pre
	 * @param in
	 * @param inStart
	 * @param inEnd
	 * @return
	 */
	private static Node createTree(int pre[], int[] in, int inStart, int inEnd) {
		for (int i = inStart; i <= inEnd; i++) {
			mp.put(in[i], i);
		}
		System.out.println(mp);
		return buildTree(pre, in, inStart, inEnd);
	}

	public static void main(String[] args) {
		int inOrder[] = { 4, 2, 5, 1, 6, 3 };
		int preOrder[] = { 1, 2, 4, 5, 3, 6 };

		Node root = createTree(preOrder, inOrder, 0, inOrder.length - 1);
		TreeTraversal.inOrderTraversal(root);
		System.out.println();
		TreeTraversal.preOrderTraversal(root);
		System.out.println();
		TreeTraversal.postOrderTraversal(root);
	}

}
