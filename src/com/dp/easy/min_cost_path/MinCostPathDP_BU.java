// package com.dp.easy.min_cost_path;
import java.util.Arrays;

public class MinCostPathDP_BU{
	static int count;
	/**
	*Time: O(m * n)
	* Space: O(m * n)
	* Here it solves the problem in top down approach - i.e. start from m, n and 
	* travel back to 0, 0.
	*
	*/
	public static int minCostPath(int [][] cost, int m, int n){
		int dp[][] = new int[m][n];
		
		// initializing the row
		int prevSum = 0;
		for(int i = 0; i < n; i++){
			dp[0][i] = prevSum + cost[0][i];
			prevSum = dp[0][i];
		}
		
		// initializing the column
		prevSum = 0;
		for(int i = 0; i < m; i++){
			dp[i][0] = prevSum + cost[i][0];
			prevSum = dp[i][0];
		}
		
		// calculating the DP array
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + cost[i][j];
			}
		}
		
		// for debugging - not part of solution				
		for(int arr[] : dp){
			System.out.print("[");
			for(int element: arr)
				System.out.printf("%-3d", element);
			System.out.println("]");
		}
		
		return dp[m - 1][n - 1];
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