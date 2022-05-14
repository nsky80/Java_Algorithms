/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish Kumar Yadav
 *
 */
public class PopulatingNextRightPointersInEachNodeII {

	// Definition for a Node.
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	/**
	 * It treats the newly created list as Queue for level order traversal.
	 * 
	 * Time: O(n), Space: O(1)
	 * 
	 * @author satis
	 *
	 */
	class SpaceOptimizedSolution {
		public Node connect(Node root) {
			if (root == null)
				return null;

			// pointer which points to the first node at every level of the tree.
			Node head = root;

			while (head != null) {
				// it will behave like head of singly linked list
				Node ch = head;

				// It will keep track of previous element in Singly Linked List
				Node prev = null;

				// making it null so that it can get assigned with head of SLL in next step
				head = null;

				while (ch != null) {

					// if there a prev exists then make current node as next to the prev
					if (ch.left != null) {
						if (prev != null)
							prev.next = ch.left;
						prev = ch.left;
					}

					// if this is the first node
					if (head == null)
						head = prev;

					// if it has right child then check prev and take action accordingly
					if (ch.right != null) {
						if (prev != null)
							prev.next = ch.right;
						prev = ch.right;
					}

					// Check again, there might not be a left node
					if (head == null)
						head = prev;

					// move to next node of the list which will behaves like BFS
					ch = ch.next;
				}
			}

			return root;

		}
	}

	/**
	 * BFS solution, Time: O(n), Space: O(n)
	 * 
	 * @author satis
	 *
	 */
	class Solution {
		public Node connect(Node root) {
			if (root == null)
				return null;

			Deque<Node> q = new ArrayDeque<>();
			q.add(root);

			while (!q.isEmpty()) {
				int size = q.size();

				while (size-- > 0) {
					Node current = q.poll();

					if (size == 0) {
						current.next = null;
					} else {
						current.next = q.peek();
					}

					if (current.left != null)
						q.add(current.left);
					if (current.right != null)
						q.add(current.right);
				}
			}

			return root;

		}
	}
}
