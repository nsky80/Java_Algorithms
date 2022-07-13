/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
package com.tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.tree.Node;

/**
 * Time: O(n), Space: O(n)
 * 
 * @author satis
 *
 */
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

	
	
	class DFS_Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> tr = new ArrayList<>();
	        if (root == null) return tr;
	        
	        updateLevel(tr, root, 0);
	        
	        return tr;
	    }
	    
	    public void updateLevel(List<List<Integer>> tr, TreeNode root, int level){
	        if (root == null)
	            return;
	        
	        if (level == tr.size())
	            tr.add(new LinkedList<>());
	        
	        tr.get(level).add(root.val);
	        
	        updateLevel(tr, root.left, level + 1);
	        updateLevel(tr, root.right, level + 1);
	    }
	}
}
