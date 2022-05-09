/**
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3879/
 * This is time optimization for QuickUnion disjoint set. It uses one more array.
 */
package com.disjoint_set;

/**
 * 
 * # For regular union and find, each operation takes O(logn) in average, and
 * O(n) in worst case. # For union by rank, it takes at most O(logn) time since
 * the height of tree-like structure is restricted in O(logn). # For path
 * compression, the time complexity is reduced to O(1) in average and worst
 * case, since the structure is flattened.
 * 
 * @author Satish
 * 
 */
public class DisjointSetUnionByRank {
	/**
	 * While updating the parent, it'll make parent to that node having higher rank,
	 * by using that, it would avoid to make the set tree as skewed.
	 * 
	 * @author Satish Kumar Yadav
	 */
	static class UnionFind {
		int root[];
		int rank[];

		UnionFind(int n) {
			root = new int[n];
			rank = new int[n];

			// initially every node has rank 1.
			for (int i = 0; i < n; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		public void union(int x, int y) {
			// get the root of both the nodes
			int rootX = find(x);
			int rootY = find(y);

			if (rootX != rootY) {
				// now check the rank, higher rank root node would be new root.
				if (rank[rootX] > rank[rootY]) {
					root[rootY] = rootX;
				} else if (rank[rootY] > rank[rootX]) {
					root[rootX] = rootY;
				} else {
					root[rootX] = rootY;
					rank[rootY] += 1;
				}
			}
		}

		/**
		 * It uses the same approach as earlier, but now tree is balanced so it's time
		 * complexity will be reduced to logN.
		 * 
		 * @param x the value
		 * @return the root of the tree in which node belongs.
		 */
		public int find(int x) {
			while (x != root[x])
				x = root[x];
			return x;
		}

		/**
		 * Function to check whether two nodes are connected or not.
		 * 
		 * @param x first node
		 * @param y second node
		 * @return <b>true</b> if nodes are connected else <b>false</b>
		 */
		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}
	}

	public static void main(String[] args) throws Exception {
		UnionFind uf = new UnionFind(10);
		// 1-2-5-6-7 3-8-9 4
		uf.union(1, 2);
		uf.union(2, 5);
		uf.union(5, 6);
		uf.union(6, 7);
		uf.union(3, 8);
		uf.union(8, 9);
		System.out.println(uf.connected(1, 5)); // true
		System.out.println(uf.connected(5, 7)); // true
		System.out.println(uf.connected(4, 9)); // false
		// 1-2-5-6-7 3-8-9-4
		uf.union(9, 4);
		System.out.println(uf.connected(4, 9)); // true
	}
}
