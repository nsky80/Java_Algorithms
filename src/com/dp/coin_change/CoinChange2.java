/**
 * Coin Change 2: https://leetcode.com/problems/coin-change-2/
 */
package com.dp.coin_change;

import java.util.Arrays;

/**
 * @author satis
 *
 */
public class CoinChange2 {
	/**
	 * Time: O(m * n), Space: O(m * n), it also has stack overhead which can go upto O(m + n)
	 */
	class MemoizedSolution {
	    int memo[][];
	    public int change(int amount, int[] coins) {
	        int n = coins.length - 1;
	        memo = new int[coins.length][amount + 1];
	        for(int i = 0; i < coins.length; i++)    
	            Arrays.fill(memo[i], -1);
	        return countWays(coins, amount, n);
	    }
	    
	    public int countWays(int [] coins, int amount, int index){
	        if (amount == 0)
	            return 1;
	        
	        if (amount < 0 || index < 0)
	            return 0;
	        
	        if (memo[index][amount] != -1)
	            return memo[index][amount];
	        
	        // this coin is included and excluded
	        return memo[index][amount] = countWays(coins, amount - coins[index], index) + countWays(coins, amount, index - 1);
	    }
	}
	
	
	/**
	 * Time: O(m * n), Space: O(m)
	 */
	class SpaceOptimizedBottomUp {
	    public int change(int amount, int[] coins) {
	        int dp[] = new int[amount + 1];
	        // there is always 1 way for 0
	        dp[0] = 1;
	        
	        // for every coin
	        for(int c = 0; c < coins.length; c++){
	        	// going through the amount
	            for(int amt = 1; amt <= amount; amt++){
	            	
	            	// if it is not negative then update the dp array
	                if (amt - coins[c] >= 0)
	                    dp[amt] += dp[amt - coins[c]];
	            }
	        }
	        
	        return dp[amount];
	    }
	    
	}
}
