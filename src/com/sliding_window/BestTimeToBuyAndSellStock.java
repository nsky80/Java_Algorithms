/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
package com.sliding_window;

/**
 * @author satis
 *
 */
public class BestTimeToBuyAndSellStock {
	/**
	 * Time: O(n), space: O(1)
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;

		// here b-buy pointer which is intended to be minimum
		// s-sell pointer, trying to maximize it.

		int b = 0;
		for (int s = 1; s < prices.length; s++) {
			if (prices[s] - prices[b] > 0) {
				profit = Math.max(profit, prices[s] - prices[b]);
			} else {
				b = s;
			}
		}
		return profit;
	}
}
