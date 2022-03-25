package com.tree.traversal;

import java.util.ArrayDeque;
import java.util.Deque;

import com.tree.Node;

public class LevelOrderBinaryTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		getLevelOrderTraversel(root);
	}

	private static void getLevelOrderTraversel(Node root) {
		// create an empty queue 
		Deque<Node> q = new ArrayDeque<>();
		
		// add first element to q
		q.add(root);
		
		while (!q.isEmpty()) {
			Node currentNode = q.poll();
			
			if (currentNode.left != null) {
				q.add(currentNode.left);
			}
			
			if (currentNode.right != null) {
				q.add(currentNode.right);
			}
			
			System.out.println(currentNode.val + " ");
		}
	}

}
