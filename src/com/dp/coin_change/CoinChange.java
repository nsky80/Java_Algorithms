/**
 * https://leetcode.com/problems/coin-change/
 */
package com.dp.coin_change;

import java.util.Arrays;

public class CoinChange {

	/**
	 * Time: amount * coins, Space: O(amount)
	 * Takes more space as compared to bottom up approach
	 */
	class Memoization {
		int[] memo;

		public int coinChange(int[] coins, int amount) {
			memo = new int[amount + 1];
			Arrays.fill(memo, -10);
			return getCoins(coins, amount);
		}

		private int getCoins(int coins[], int amount) {
			if (amount == 0)
				return 0;
			if (amount < 0)
				return -1;
			if (memo[amount] != -10)
				return memo[amount];

			int min = -1;

			for (int coin : coins) {
				int temp = getCoins(coins, amount - coin);
				if (temp != -1)
					if (min == -1)
						min = temp + 1;
					else
						min = Math.min(min, temp + 1);
			}

			return memo[amount] = min;
		}
	}

	/**
	 * Time: O(m * n), Space: O(m)
	 * m = amount, n = coins
	 */
	class Tabulation1 {
		public int coinChange(int[] coins, int amount) {
			int[] dp = new int[amount + 1];

			for (int amt = 1; amt <= amount; amt++) {
				int min = -1;
				for (int coin : coins) {
					int diff = amt - coin;

					// if difference is not in bound i.e., negative for current coin
					if (diff >= 0 && dp[diff] != -1) {
						if (min == -1)
							min = dp[diff] + 1;
						else
							min = Math.min(min, dp[diff] + 1);
					}
				}
				dp[amt] = min;
			}

			return dp[amount];
		}

	}

	/**
	 * Time: O(m * n), Space: O(m)
	 * m = amount, n = coins
	 */
	class MoreOptimizedTabulation {
		public int coinChange(int[] coins, int amount) {
			int[] dp = new int[amount + 1];
			Arrays.fill(dp, amount + 1);
			dp[0] = 0;

			for (int amt = 1; amt <= amount; amt++) {
				for (int coin : coins) {
					int diff = amt - coin;

					// if difference is not in bound i.e., negative for current coin
					if (diff >= 0) {
						dp[amt] = Math.min(dp[amt], dp[diff] + 1);
					}
				}
			}

			return dp[amount] == amount + 1 ? -1 : dp[amount];
		}

	}
}
