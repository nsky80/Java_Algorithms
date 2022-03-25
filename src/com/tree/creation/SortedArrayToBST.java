package com.tree.creation;

class Node {
	public int data;
	public Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class SortedArrayToBST {
	static int len = 0;

	public static Node createBST(int arr[], int start, int end) {
		if (start == end) {
			return new Node(arr[start]);
		}

		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		Node newNode = new Node(arr[mid]);
		newNode.left = createBST(arr, start, mid - 1);
		newNode.right = createBST(arr, mid + 1, end);

		return newNode;
	}

	public static void preOrder(Node node, int arr[]) {
		if (node == null) {
			return;
		}
		arr[len++] = node.data;
		// System.out.println(" " + node.data);
		preOrder(node.left, arr);
		preOrder(node.right, arr);
	}

	public static int[] sortedArrayToBST(int[] nums) {
		// Code here
		len = 0;
		Node root = createBST(nums, 0, nums.length - 1);
		int inOrderArray[] = new int[nums.length];
		preOrder(root, inOrderArray);
		return inOrderArray;
	}
	
	
	public static void printIt(int arr[]) {
		System.out.println();
		for(int i : arr) {
			System.out.println(" " + i);
		}
	}
	public static void main(String [] args) {
		int arr[] = {-8, 4};
		int in [] = sortedArrayToBST(arr);
		printIt(in);
		
		int arr1[] = {1, 2, 3, 4, 5, 6, 7};
		int in1 [] = sortedArrayToBST(arr1);
		printIt(in1);
		
		

	}
}
