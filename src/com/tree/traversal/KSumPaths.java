package com.tree.traversal;

import java.util.List;
import java.util.ArrayList;


class Node{
	public Node left, right;
	public int data;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

public class KSumPaths{
	
	static void printPath(List<Integer> arr, int start, int end){
		for(int i = start; i < end; i++){
			System.out.print(arr.get(i) + " " );
		}
		System.out.println();
	}
	
	
	/**
	* This function will count the number of possible consecutive sum = k
	*/
	static int countSumKInArray(List<Integer> arr, int totalSum, int k){
		// total consecutive elemnet sum = k found 0 till now
		int count = 0;
		
		// It will keep track of sum of excluded element
		int prevSum = 0;
		
		for(int i = 0; i < arr.size(); i++){
			if(totalSum - prevSum == k){
				printPath(arr, i, arr.size());
				count++;
			}
			prevSum += arr.get(i);
		}
		
		// System.out.println(arr + " " + totalSum + " " + count);

		
		return count;
	}
	
	
	
	static int sumKHelper(Node root, int k, List<Integer> tracker, int totalSum){
		// base case
		if (root == null) return 0;
		
		// add current element into tracker and totalSum
		tracker.add(root.data);
		totalSum += root.data;
		
		// goto left sub-tree
		int leftCount = sumKHelper(root.left, k, tracker, totalSum);
		
		// count the number of possibilities in current tree
		int count = countSumKInArray(tracker, totalSum, k);
		
		// count in right sub-tree
		int rightCount = sumKHelper(root.right, k, tracker, totalSum);
		
		// remove the current element from array for next iteration
		tracker.remove(tracker.size() - 1);
		
		return leftCount + count + rightCount;
	
	}
	
	/**
	* Method to Find the number of paths in the tree which have their sum equal to K.
	*/
	static int sumK(Node root, int k){
		if (root == null) return 0;
		
		// create a tracker which acts as a stack
		List<Integer> tracker = new ArrayList<Integer>();
		// It will keep track of total sum till now for every change
		// it will avoid 1 extra iteration
		int totalSum = 0;
		
		return sumKHelper(root, k, tracker, totalSum);
	}
	
	public static void main(String [] args){
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(-1);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right.right = new Node(6);
		
		int k = 5;
		System.out.println(sumK(root, k));
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3); 
		k = 3;
		System.out.println(sumK(root2, k));

	}
}