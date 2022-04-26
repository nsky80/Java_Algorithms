/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
package com.dp.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Satish
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {

	/**
	 * Time: O(n)
	 * Space: O(n)
	 */
	class MemoizedSolutionUsingArrays {
	    int memo[][];
	    public int maxProfit(int[] prices) {
	        memo = new int[2][prices.length];
	        Arrays.fill(memo[0], Integer.MIN_VALUE);
	        Arrays.fill(memo[1], Integer.MIN_VALUE);

	        return getProfit(prices, 0, true);
	    }
	    
	    public int getProfit(int [] prices, int day, boolean canBuy){
	        if (day >= prices.length)
	            return 0;
	    
	        int key = canBuy ? 1 : 0;
	        
	        if (memo[key][day] != Integer.MIN_VALUE)
	            return memo[key][day];
	                
	        int pt;
	        
	        // if can buy then increase the day by 1 or increase the day by 2 for cooldown
	        if (canBuy){
	            pt = -prices[day] + getProfit(prices, day + 1, !canBuy);
	        }else{
	            pt = prices[day] + getProfit(prices, day + 2, !canBuy);
	        }
	        
	        int pwt = getProfit(prices, day + 1, canBuy);
	        
	        return memo[key][day] = Math.max(pt, pwt);
	    }
	}
	
	
	/**
	 * Time: O(n)
	 * Space: O(n)
	 * Slower than arrays version.
	 */
	class MemoizedSolutionUsingHashMap {
	    Map<String, Integer> memo;
	    public int maxProfit(int[] prices) {
	        memo = new HashMap<>();
	        return getProfit(prices, 0, true);
	    }
	    
	    public int getProfit(int [] prices, int day, boolean canBuy){
	        if (day >= prices.length)
	            return 0;
	    
	        String key = Integer.toString(day) + "," + (canBuy ? "1" : "0");
	        
	        if (memo.containsKey(key))
	            return memo.get(key);
	        
	        int pt;
	        
	        if (canBuy){
	            pt = -prices[day] + getProfit(prices, day + 1, !canBuy);
	        }else{
	            pt = prices[day] + getProfit(prices, day + 2, !canBuy);
	        }
	        
	        int pwt = getProfit(prices, day + 1, canBuy);
	        
	        memo.put(key, Math.max(pt, pwt));
	        return memo.get(key);
	    }
	}
	
	
	/**
	 * Time: O(2 ^ n)
	 * Space: O(n)
	 * Not the optimal recursive equation, it has 3 changing variable, which can be avoided.
	 */
	class RecursiveSolution {
	    public int maxProfit(int[] prices) {
	        return getProfit(prices, 0, 0, true);
	    }
	    
	    public int getProfit(int [] prices, int day, int profit, boolean canBuy){
	        if (day >= prices.length)
	            return profit;
	    
	        if (canBuy){
	            return Math.max(getProfit(prices, day + 1, profit - prices[day], !canBuy), 
	                           getProfit(prices, day + 1, profit, canBuy));
	        }else{
	            return Math.max(getProfit(prices, day + 2, profit + prices[day], !canBuy), getProfit(prices, day + 1, profit, canBuy));
	        }
	    }
	}
}
