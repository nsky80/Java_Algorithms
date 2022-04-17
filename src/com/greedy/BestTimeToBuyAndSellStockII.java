package com.greedy;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		// Sell according to future, when price is going to fall, sell it otherwise keep
		// it.
		int profit = 0;
		int n = prices.length;
		int b = 0;

		for (int s = 1; s < n;) {
			// we're going to perform a transaction
			if (prices[b] < prices[s]) {

				// get the highest price to sell
				while (s < n - 1 && prices[s] < prices[s + 1]) {
					s++;
				}

				// sell the stock
				profit += prices[s] - prices[b];
				b = s + 1;
				s += 2;
			} else {
				b = s;
				s++;
			}
		}

		return profit;
	}

}
