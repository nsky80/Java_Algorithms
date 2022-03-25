package com.tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import com.tree.Node;


//class Node {
//	public int data;
//	public Node left, right;
//
//	public Node(int data) {
//		this.data = data;
//		left = null;
//		right = null;
//	}
//}

public class ZigZagTraversal {

	/**
	 * Zig zag traversal using 2 Stack
	 * 
	 * @param root
	 * @return
	 */
	// Function to store the zig zag order traversal of tree in a list.
	static ArrayList<Integer> zigZagTraversal(Node root) {
		if (root == null) {
			return null;
		}

		ArrayList<Integer> path = new ArrayList<Integer>();

		// Add your code here.
		Deque<Node> st1 = new ArrayDeque<Node>();
		boolean flag = true;
		st1.add(root);
		Deque<Node> st2;

		while (!st1.isEmpty()) {
			st2 = new ArrayDeque<Node>();

			while (!st1.isEmpty()) {
				Node current = st1.pollLast();
				path.add(current.val);
				if (flag) {
					if (current.left != null) {
						st2.add(current.left);
					}
					if (current.right != null) {
						st2.add(current.right);
					}
				} else {
					if (current.right != null) {
						st2.add(current.right);
					}
					if (current.left != null) {
						st2.add(current.left);
					}
				}
			}
			flag = !flag;
			st1 = st2;

		}

		return path;
	}

	/**
	 * zigZag traversal using 1 Deque
	 * 
	 * @param root
	 * @return
	 */
	static ArrayList<Integer> zigZagTraversalDeque(Node root) {
		if (root == null) {
			return null;
		}

		ArrayList<Integer> path = new ArrayList<Integer>();

		// Add your code here.
		Deque<Node> q = new ArrayDeque<Node>();
		boolean flag = true;
		q.add(root);

		while (!q.isEmpty()) {
			// initial size of q
			int init = q.size();
			while (init > 0) {
				Node current;
				if (flag) {
					current = q.pollLast();
					if (current.left != null) {
						q.offerFirst(current.left);
					}
					if (current.right != null) {
						q.offerFirst(current.right);
					}
				} else {
					current = q.pollFirst();
					if (current.right != null) {
						q.offerLast(current.right);
					}
					if (current.left != null) {
						q.offerLast(current.left);
					}
				}
				path.add(current.val);
				init--;
			}
			flag = !flag;

		}

		return path;
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(2);

		System.out.println(zigZagTraversalDeque(root));
//		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
//		for(List<Integer> ar:  map.values()) {
//			
//		}
		 
		
	}

}
