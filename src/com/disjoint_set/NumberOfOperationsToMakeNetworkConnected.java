/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
package com.disjoint_set;

/**
 * @author satis
 *
 */
public class NumberOfOperationsToMakeNetworkConnected {
	/**
	 * Time: O(n + m*α(n)) ≈ O(n + m), m is the length of connections (union
	 * operations). Explanation: Using both path compression and union by size
	 * ensures that the amortized time per operation is only α(n), which is optimal,
	 * where α(n) is the inverse Ackermann function. This function has a value α(n)
	 * < 5 for any value of n that can be written in this physical universe, so the
	 * disjoint-set operations take place in essentially constant time. Reference:
	 * https://en.wikipedia.org/wiki/Disjoint-set_data_structure or
	 * https://www.slideshare.net/WeiLi73/time-complexity-of-union-find-55858534 for
	 * more information. Space: O(n)
	 * 
	 */
	public int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;

		// creating the disjoint set
		int parent[] = new int[n];
		// creating the rank of nodes
		int rank[] = new int[n];

		for (int i = 0; i < n; i++) {
			// initially all the nodes are parent of themselves
			parent[i] = i;

			// initially all the nodes have same rank of 1
			rank[i] = 1;
		}

		int components = n;
		// if 2 components are connected then they have same parent and union return 0
		// if they are not connected then union return 1 which will decrease the
		// total components

		for (int edge[] : connections) {
			components -= union(parent, rank, edge[0], edge[1]);
		}

		return components - 1;
	}

	public int findParent(int parent[], int child) {
		// This required when using recursive version
//		if (child == parent[child]) return child;

		while (child != parent[child]) {
			// doing path compression
			parent[child] = parent[parent[child]];
			child = parent[child];
		}

		return child;
	}

	public int union(int[] parent, int[] rank, int n1, int n2) {
		int p1 = findParent(parent, n1);
		int p2 = findParent(parent, n2);

		// if both the vertices belongs to same set
		if (p1 == p2)
			return 0;

		// merge sets and make the parent node having higher rank
		if (rank[p2] > rank[p1]) {
			parent[p1] = p2;
			rank[p2] += rank[p1];
		} else {
			parent[p2] = p1;
			rank[p1] += rank[p2];
		}
		return 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[10];
//		ArrayList<Integer>[] group = new ArrayList[4];
//
//		List<Integer>[] adjList = (List<Integer>[]) new List[10];

	}

}
