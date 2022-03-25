package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

	public void printGraph() {
		for (Node adj : neighbors) {
			System.out.print(" " + adj.val);
		}
		System.out.println();

	}

	@Override
	public String toString() {
		printGraph();
		return "" + val + ", ";
	}

}

class Solution3 {

	public Node cloneGraphBFS(Node node) {
		// if graph is null, then it should return null
		if (node == null)
			return null;

		// at-least 1 node is present in the graph

		// creating queue for BFS
		Deque<Node> q = new ArrayDeque<>();

		// It will keep reference of visited node
		// It checks whether a node is visited or not
		// if node is not visited then add the copy of node into this
		Map<Integer, Node> visited = new HashMap<>();

		// first node added into the queue
		q.add(node);

		// BFS
		while (!q.isEmpty()) {
			Node current = q.poll();

			// if current node is not available then add it's copy
			if (!visited.containsKey(current.val)) {
				visited.put(current.val, new Node(current.val, new ArrayList<Node>()));
			}

			// it gives the reference of copy node if already exist then fine otherwise
			// it gets added in previous step
			Node copyNode = visited.get(current.val);

			// now visit and add the copy of neighbors
			for (Node adj : current.neighbors) {
				// if it's copy doesn't exist, make it and add it into visited node
				// this node also need to explored, so added to the queue
				if (!visited.containsKey(adj.val)) {
					visited.put(adj.val, new Node(adj.val, new ArrayList<Node>()));
					q.add(adj);
				}

				// add copy of current adjacent node into the neighbors list
				copyNode.neighbors.add(visited.get(adj.val));
			}
		}

//		System.out.println(visited.get(node.val));
		// return the source of the graph
		return visited.get(node.val);
	}
}




public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node g1 = new Node(1, new ArrayList<>());
//		Node g2 = new Node(2, new ArrayList<>());
//		Node g3 = new Node(3, new ArrayList<>());
//		Node g4 = new Node(4, new ArrayList<>());
//		
//		g1.neighbors.add(g2);
//		g1.neighbors.add(g4);
//		
//		g2.neighbors.add(g1);
//		g2.neighbors.add(g3);
//		
//		g3.neighbors.add(g2);
//		g3.neighbors.add(g4);
//		
//		g4.neighbors.add(g1);
//		g4.neighbors.add(g3);

		System.out.println(g1);

		Solution3 sol = new Solution3();
		sol.cloneGraphBFS(g1);
	}

}
