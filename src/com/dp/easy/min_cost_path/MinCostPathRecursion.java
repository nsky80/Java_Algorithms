 package com.dp.easy.min_cost_path;

public class MinCostPathRecursion{
	static int count;
	/**
	*
	* Here it solves the problem in top down approach - i.e. start from m, n and 
	* travel back to 0, 0.
	*
	* Time: O(3 ^ m * n)
	* Space: m + n
	*/
	public static int minCostPath(int [][] cost, int m, int n){
		count++;
		// base case
		if (m < 1 || n < 1) return Integer.MAX_VALUE;
		
		// if reached to destination
		if (m == 1 && n == 1) return cost[m - 1][n - 1];
		
		// go to diagonal - top - left
		return Math.min(minCostPath(cost, m - 1, n - 1), Math.min(minCostPath(cost, m, n - 1), minCostPath(cost, m - 1, n))) + cost[m - 1][n - 1];
	}
	
	
	public static void main(String [] args){
		int mat[][] = {{1, 2, 3}, {4, 5, 6}, {1, 2, 2}};
		count = 0;
		System.out.println(minCostPath(mat, 3, 3) + " " + count);
		count = 0;
		System.out.println(minCostPath(mat, 1, 3) + " " + count);
		count = 0;
		System.out.println(minCostPath(mat, 2, 3) + " " + count);
		count = 0;
		System.out.println(minCostPath(mat, 1, 1) + " " + count);
				// int cost[][] = { {1, 2, 3},
                         // {4, 8, 2},
                         // {1, 5, 3} };
        // count = 0;
        // System.out.print(minCostPath(cost, 3, 3) + " " + count);
		int cost[][] = { {1, 2, 3, 4, 1, 3, 1, 5, 6},
                         {4, 8, 2, 3, 5, 1, 6, 4, 1},
                         {1, 5, 3, 1, 3, 4, 1, 4, 5},
						 {4, 3, 5, 6, 8, 3, 5, 6, 7}};
        count = 0;
        System.out.print(minCostPath(cost, 9, 4) + " " + count);

	}
}