 package com.dp.easy.min_cost_path;
import java.util.Arrays;

public class MinCostPathDP_TD{
	static int count;
	/**
	*
	*Time: O(m * n * 3)
	* Space: O(m * n)
	* Here it solves the problem in top down approach - i.e. start from m, n and 
	* travel back to 0, 0.
	*/
	public static int minCostPath(int [][] cost, int m, int n){
		if (m == 1 && n == 1) return cost[m - 1][n - 1];
		int memo[][] = new int[m][n];
		
		for(int i = 0; i < m; i++)
			Arrays.fill(memo[i], -1);
		
		int min = minCostPathHelper(cost, m, n, memo);
		
		for(int arr[] : memo){
			System.out.print("[");
			for(int element: arr)
				System.out.printf("%-3d", element);
			System.out.println("]");
		}
		return min;
	}
	
	public static int minCostPathHelper(int [][] cost, int m, int n, int [][] memo){
		count++;
		// base case
		if (m < 1 || n < 1) return Integer.MAX_VALUE;
		
		// if reached to destination
		if (m == 1 && n == 1) return cost[m - 1][n - 1];
		
		if (memo[m - 1][n - 1] != -1) return memo[m - 1][n - 1];
		
		
		// go to diagonal - top - left
		memo[m - 1][n - 1] = Math.min(minCostPathHelper(cost, m - 1, n - 1, memo), Math.min(minCostPathHelper(cost, m, n - 1, memo), minCostPathHelper(cost, m - 1, n, memo))) + cost[m - 1][n - 1];
		return memo[m - 1][n - 1];
	}

	
	public static void main(String [] args){
		int mat[][] = {{1, 2, 3}, {4, 5, 6}, {1, 2, 2}};
		count = 0;
		System.out.println(minCostPath(mat, 3, 3) + " " + count + "\n");
		count = 0;
		System.out.println(minCostPath(mat, 1, 3) + " " + count + "\n");
		count = 0;
		System.out.println(minCostPath(mat, 2, 3) + " " + count + "\n");
		count = 0;
		System.out.println(minCostPath(mat, 1, 1) + " " + count + "\n");
		
		
		int cost[][] = { {1, 2, 3, 4, 1, 3, 1, 5, 6},
                         {4, 8, 2, 3, 5, 1, 6, 4, 1},
                         {1, 5, 3, 1, 3, 4, 1, 4, 5},
						 {4, 3, 5, 6, 8, 3, 5, 6, 7}};
        count = 0;
        System.out.print(minCostPath(cost, 4, 9) + " " + count + "\n");

	}
}