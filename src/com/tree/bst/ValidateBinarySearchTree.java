/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
package com.tree.bst;

/**
 * @author satis
 *
 */
public class ValidateBinarySearchTree {

	// Definition for a binary tree node.
	static class TreeNode {
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
	 * This solution keeps track of previous value and uses BST property whose 
	 * inorder traversal is sorted.
	 * 
	 * Time: O(n), Space: O(n)
	 */
	class Solution {
		long prev;

		public boolean isValidBST(TreeNode root) {
			prev = Long.MIN_VALUE;
			return isValid(root);
		}

	    public boolean isValid(TreeNode root){
	        if (root == null)
	            return true;
	        
	        // check whether left subtree is valid or not, and follows the property
	        if(!isValid(root.left) || prev >= root.val)
	            return false;
	        
	        // set the previous for next value
	        prev = root.val;
	        
	        // check the right sub-tree.
	        return isValid(root.right);

	    }

	}
}
