/**
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3840/
 */
package com.disjoint_set;

/**
 * @author satis
 *
 */
public class DisjointSetQuickUnion {
	/**
	 * Here, unlike quick find, we put the parent node for each node, but find()
	 * method have worst case complexity of O(n), which leads to O(n) complexity for
	 * both union() and connected.
	 */
	static class UnionFind {
		int root[];

		UnionFind(int n) {
			root = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = i;
			}
		}

		// Worst Case: O(n)
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);

			// here simply replace the parent
			if (rootX != rootY) {
				root[rootY] = rootX;
			}
		}

		// Worst Case: O(n)
		public int find(int x) {
			while (x != root[x]) {
				x = root[x];
			}
			return x;
		}

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
