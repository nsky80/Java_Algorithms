package com.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution1 {
	static class Node {
		public TreeNode node;
		int level;

		public Node(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	/**
	 * It implements BFS recursively
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderTrueBottom(TreeNode root) {
		List<List<Integer>> tracker = new ArrayList<>();
		if (root == null)
			return tracker;

		levelOrderDFS(root, tracker, 0);

		return tracker;
	}

	private void levelOrderDFS(TreeNode root, List<List<Integer>> tracker, int level) {
		if (root == null)
			return;

		// check the level and if list is not available add it
		if (tracker.size() <= level) {
			tracker.add(0, new LinkedList<>());
		}

		// goto left and right subtree
		levelOrderDFS(root.left, tracker, level + 1);
		levelOrderDFS(root.right, tracker, level + 1);

		// add current element into the tracker
		tracker.get(tracker.size() - (level + 1)).add(root.val);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> arr = new ArrayList<>();

		if (root == null)
			return arr;

		Deque<Node> q = new ArrayDeque<>();

		q.add(new Node(root, 0));

		while (!q.isEmpty()) {
			// add into the array
			Node current = q.poll();
			if (arr.size() == current.level) {
				arr.add(new ArrayList<>());
			}
			arr.get(current.level).add(current.node.val);

			if (current.node.left != null) {
				q.add(new Node(current.node.left, current.level + 1));
			}

			if (current.node.right != null) {
				q.add(new Node(current.node.right, current.level + 1));
			}

		}

		Collections.reverse(arr);

		return arr;
	}
}

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
