package com.dp;

public class MinCostPathBruteForce {
	public static int min(int x, int y, int z) {
		return Math.min(Math.min(y, z), x);
	}

	public static int getMinPath(int cost[][], int m, int n) {
		if(m == 0 && n == 0) {
			return cost[m][n];
		}
		int up = Integer.MAX_VALUE;
		int left = Integer.MAX_VALUE;
		int diagonal = Integer.MAX_VALUE;
		
		if (m > 0 && n > 0) {
			diagonal = getMinPath(cost, m - 1, n - 1);
			up = getMinPath(cost, m - 1, n);
			left = getMinPath(cost, m, n - 1); 
			System.out.println("Both are fine");
		} else if(m > 0 && n == 0) {
			up = getMinPath(cost, m - 1, n);
			System.out.println("Going up only");
		} else if(m == 0 && n > 0) {
			left = getMinPath(cost, m, n - 1);
			System.out.println("Going left only");
		}

		return cost[m][n] + min(up, left, diagonal);
		
	}

	public static void main(String[] args) {
		int m = 3, n = 3;
		int [][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
		
		System.out.println(getMinPath(cost, m-1, n-1));
	}

}
