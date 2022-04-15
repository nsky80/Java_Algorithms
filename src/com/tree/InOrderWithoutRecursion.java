package com.tree;

import java.util.ArrayList;

public class InOrderWithoutRecursion {
	// Definition for binary tree
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> arr = new ArrayList<>();

		TreeNode current = A;
		ArrayList<TreeNode> stack = new ArrayList<>();

		while (current != null || stack.size() != 0) {
			if (current != null) {
				stack.add(current);
				current = current.left;
			}

			if (current == null) {
//				stack.rem
				current = stack.remove(stack.size() - 1);
				arr.add(current.val);
				current = current.right;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(inorderTraversal(root));

	}

}
