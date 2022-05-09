/**
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3878/
 */
package com.disjoint_set;

/**
 * @author satis
 *
 */
public class DisjointSetQuickFind {
	/**
	 * In this implementation, instead of storing the parent of node, it stores the
	 * root itself, which gives the root in O(1) time, but it comes with some
	 * tradeoff in union, where it need to traverse whole array for a union, which
	 * will take O(n) time.
	 */
	static class UnionFind {
		int root[];

		UnionFind(int n) {
			root = new int[n];
			// initialized all the nodes to it's own
			for (int i = 0; i < n; i++) {
				root[i] = i;
			}
		}

		// O(n)
		public void union(int x, int y) {
			int rootx = find(x);
			int rooty = find(y);

			// if root is same, then nodes are already connected
			if (rootx != rooty) {
				// update, where rooty was the parent to rootx
				for (int i = 0; i < root.length; i++) {
					if (root[i] == rooty) {
						root[i] = rootx;
					}
				}
			}
		}

		public int find(int node) {
			return root[node];
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
