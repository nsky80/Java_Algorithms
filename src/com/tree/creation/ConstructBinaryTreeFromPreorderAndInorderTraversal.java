/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
package com.tree.creation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author satis
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

//	  Definition for a binary tree node.
	public class TreeNode {
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

	/**
	 * This solution creates a hashMap which contains the value and it's index as
	 * key value pair from from the in-order array, using this hashMap we can get
	 * index in O(1) time.
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class SolutionUsingHash {
		int preTracker;
		Map<Integer, Integer> inOrderIndexMap;

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			preTracker = 0;
			inOrderIndexMap = new HashMap<>();
			for (int i = 0; i < inorder.length; i++) {
				inOrderIndexMap.put(inorder[i], i);
			}

			return createTree(preorder, inorder, 0, preorder.length - 1);
		}

		public TreeNode createTree(int[] pre, int[] in, int l, int r) {
			if (l > r)
				return null;

			int val = pre[preTracker++];

			// create the new root node
			TreeNode root = new TreeNode(val);

			// get the index of val in in-order array
			int index = inOrderIndexMap.get(val);

			// create left and right subtree
			root.left = createTree(pre, in, l, index - 1);
			root.right = createTree(pre, in, index + 1, r);

			return root;
		}
	}

	/**
	 * This approach searches the position of root element in in-order array using
	 * linear search which takes O(n) time for searching and it causes the time
	 * complexity of this solution O(n^2).
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class LinearSearchSolution {
		int preTracker;

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			preTracker = 0;
			return createTree(preorder, inorder, 0, preorder.length - 1);
		}

		public TreeNode createTree(int[] pre, int[] in, int l, int r) {
			if (l > r)
				return null;

			int val = pre[preTracker++];

			// create the new root node
			TreeNode root = new TreeNode(val);

			// get the index of val in in-order array
			int index = l;
			for (int i = l; i <= r; i++) {
				if (in[i] == val) {
					index = i;
					break;
				}
			}

			// create left and right subtree
			root.left = createTree(pre, in, l, index - 1);
			root.right = createTree(pre, in, index + 1, r);

			return root;
		}
	}
}
