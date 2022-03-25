package com.tree;
//package com.java.tree;

/**
 * Node of the tree By default, left and right child are null
 * 
 * @author satis
 *
 */
public class Node {
	public int val;
	public Node left;
	public Node right;

	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "[val=" + val + "]";
	}
	
	
}
