/**
 * 
 */
package com.tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Satish Kumar Yadav
 *
 */
public class RightViewOfBinaryTree {

	/**
	 * O(n), O(h)
	 */
	class DFS {
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> values = new ArrayList<Integer>();
	        if (root == null)
	            return values;
	        getRightView(root, values, 1);
	        return values;
	    }
	    
	    private void getRightView(TreeNode root, List<Integer> values, int level){
	        if (root == null)
	            return;
	        
	        if (values.size() < level)
	            values.add(root.val);
	        
	        getRightView(root.right, values, level+1);
	        getRightView(root.left, values, level+1);
	    }
	}
	
	
	/**
	 * O(n), O(n = 2^h)
	 */
	class BFS {
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> values = new ArrayList<Integer>();
	        if (root == null)
	            return values;
	        getRightView(root, values, 1);
	        return values;
	    }
	    
	    private void getRightView(TreeNode root, List<Integer> values, int level){
	        if (root == null)
	            return;
	        
	        if (values.size() < level)
	            values.add(root.val);
	        
	        getRightView(root.right, values, level+1);
	        getRightView(root.left, values, level+1);
	    }
	}
}
