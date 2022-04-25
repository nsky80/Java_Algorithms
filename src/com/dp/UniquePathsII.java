/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
package com.dp;

import java.util.Arrays;

/**
 * @author satis
 *
 */
public class UniquePathsII {
	/**
	 * O(m * n), O(n)
	 */
	class BottomUpSpaceOptimized {
	    public int uniquePathsWithObstacles(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        if (grid[0][0] == 1)
	            return 0;
	        int dp[] = new int[n];
	        
	        // int dp[][] = new int[m][n];
	        
	        int i = 0;
	        while(i < n && grid[0][i] != 1){
	            dp[i] = 1;
	            i++;
	        }
	        
	        while(i < n){
	            dp[i] = 0;
	            i++;
	        }
	        
	        for(i = 1; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if (grid[i][j] == 1){
	                    dp[j] = 0;
	                } else{
	                    dp[j] += (j > 0 ? dp[j - 1] : 0);
	                }
	            }
	        }
	        
	        return dp[n -1 ];
	    }
	    
	}
	
	/**
	 * Time: O(m * n)
	 * Space: O(m * n)
	 * @author satis
	 *
	 */
	class TopDownDP {
	    int memo[][];
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        memo = new int[obstacleGrid.length][obstacleGrid[0].length];
	        for(int i = 0; i < obstacleGrid.length; i++){
	            Arrays.fill(memo[i], -1);
	        }
	        
	        return helper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
	    }
	    
	    
	    public int helper(int [][] grid, int m, int n){
	        if (m == 0 && n == 0 && grid[m][n] != 1)
	            return 1;
	        
	        if (m < 0 || n < 0 || grid[m][n] == 1)
	            return 0;
	        
	        if (memo[m][n] != -1)
	            return memo[m][n];
	        
	        return memo[m][n] = helper(grid, m - 1, n) + helper(grid, m, n - 1);
	    }
	}
}
