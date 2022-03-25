package com.tree.view;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

class Node {
	public int data;
	public int hd;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
		hd = 0;
		left = null;
		right = null;
	}
}

public class BottomViewOfTree {
	public static ArrayList<Integer> bottomView(Node root) {
		// Code here
		Deque<Node> q = new ArrayDeque<>();
		Map<Integer, Integer> map = new TreeMap<>();

		// put the root into the q
		// make the distance of root as 0
		root.hd = 0;
		q.add(root);

		while (!q.isEmpty()) {
			Node current = q.poll();

			// add the current node with it's height into the map
			map.put(current.hd, current.data);

			// now check if current is having left or right child
			if (current.left != null) {
				current.left.hd = current.hd - 1;
				q.add(current.left);
			}

			// for right node
			if (current.right != null) {
				current.right.hd = current.hd + 1;
				q.add(current.right);
			}
		}

		return new ArrayList<Integer>(map.values());
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println(bottomView(root));
	}
}
