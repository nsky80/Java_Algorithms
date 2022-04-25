/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
package com.dp.easy;

public class MinimumPathSum {
	/**
	 * Time: O(m * n)
	 * Space: O(n) 
	 */
	class BottomUpDP {
	    public int minPathSum(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        int dp[] = grid[0].clone();
	        
	        for(int i = 1; i < n; i++){
	            dp[i] += dp[i - 1];
	        }

	        
	        for(int i = 1; i < m; i++){
	            for(int j = 0; j < n; j++){
	                dp[j] = (grid[i][j] + Math.min((j > 0 ? dp[j - 1] : Integer.MAX_VALUE), dp[j]));
	            }
	        }
	        
	        return dp[n - 1];
	    }
	}
}
