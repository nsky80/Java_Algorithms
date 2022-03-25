package com.tree;
import java.util.Deque;
import java.util.ArrayDeque;


public class TreeMinValueProblem{
	
	/**
	Time : O(n)
	Space: O(n)
	*/
	static int getMinDFS(Node root){
		if (root == null) return Integer.MAX_VALUE;	
		return Math.min(root.val, Math.min(getMinDFS(root.left), getMinDFS(root.right)));
	}
	
		/**
	Time : O(n)
	Space: O(n)
	*/
	static int getMaxSum(Node root){
		if (root == null) return Integer.MIN_VALUE;	
		
		if (root.left == null && root.right == null) return root.val;
		
		int max = Math.max(getMaxSum(root.left), getMaxSum(root.right));
		return max + root.val;
	}
	
	
	/**
	Time: O(n)
	Space: O(n)
	*/
	static int getMinBFS(Node root){
		if (root == null) return Integer.MAX_VALUE;
		
		Deque<Node> q = new ArrayDeque<>();
		int min = root.val;
		q.add(root);
		
		while (!q.isEmpty()){
			Node current = q.poll();
			min = Math.min(current.val, min);
			
			if (current.left != null) q.add(current.left);
			if (current.right != null) q.add(current.right);
			
		}
		
		return min;
	}
	
	
	public static void main(String [] args){
		Node fi = new Node(5);
		Node el = new Node(11);
		Node th = new Node(3);
		Node fo = new Node(4);
		Node fif = new Node(15);
		Node tw = new Node(12);
		
		fi.left = el;
		fi.right = th;
		el.left = fo;
		el.right = fif;
		th.right = tw;
	
		System.out.println("Mininum: " + getMinDFS(fi));
		System.out.println("Mininum: " + getMinBFS(fi));
		System.out.println("Max Sum: " + getMaxSum(fi));
	
	}
}