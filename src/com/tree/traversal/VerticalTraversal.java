package com.tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class used for level order traversal
 * @author satis
 *
 */
class Qobj{
	public Node node;
	public int hd;
	
	public Qobj(Node node, int hd){
		this.node = node;
		this.hd = hd;
	}
}

public class VerticalTraversal {

    static void verticalTraversalUsingPreOrder(Node root, int hd, Map<Integer, ArrayList<Integer>> map){
        if(root == null){
            return;
        }
        
        // put the data in map
        if (map.containsKey(hd)){
            map.get(hd).add(root.data);
        } else{
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(root.data);
            map.put(hd, temp);
        }
        
        verticalTraversalUsingPreOrder(root.left, hd - 1, map);
        verticalTraversalUsingPreOrder(root.right, hd + 1, map);
    }
    

    
    static void verticalTraversalUsingLevelOrder(Node root, Map<Integer, ArrayList<Integer>> map) {
    	if (root == null) {
    		return;
    	}
    	
    	Deque<Qobj> q = new ArrayDeque<>();
    	// adding root to the queue
    	
    	// adding horizontal distance and 0 for root
    	q.add(new Qobj(root, 0));
    	
    	while (!q.isEmpty()) {
    		Qobj current = q.poll();
    		
    		// add the current data into the map for corresponding hd
    		if (map.containsKey(current.hd)) {
    			map.get(current.hd).add(current.node.data);
    		} else {
    			ArrayList<Integer> temp = new ArrayList<>();
    			temp.add(current.node.data);
    			map.put(current.hd, temp);
    		}
    		
    		// now add left and right keys into queue
    		if (current.node.left != null) {
    			q.add(new Qobj(current.node.left, current.hd - 1));
    		}
    		
    		if (current.node.right != null) {
    			q.add(new Qobj(current.node.right, current.hd + 1));
    		}
    		    		
    	}
    	
    }
    
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalTraversalUsingLevelOrder(root, map);
//        System.out.println(map);
        ArrayList<Integer> order = new ArrayList<>();
        for(ArrayList<Integer> li: map.values()){
            order.addAll(li);
        }
        return order;
    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println(verticalOrder(root));
	}

}
