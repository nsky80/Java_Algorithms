package com.dp;

import java.util.Arrays;

public class CoinChangeDPBottomUP {
	static int countCoins(int S[], int m, int n) {
		// creating a DP for each possible amount upto n
		int dp[] = new int[n + 1];

		// initialize the array with maximum value
		// it will used to check whether we got any solution or not
		Arrays.fill(dp, n + 1);
		
		// for 0th coin, amount is also 0
		dp[0] = 0;
		
		// now calculate the number of coins required from 1 to n i.e. each amount
		for(int amount = 1; amount <=n; amount++) {
			
			// for every number, consider all the coins
			for(int j = 0; j < m; j++) {
				// the minimum coin required for current amount
				// could be either 
				// if difference between current amount and current coin is less than 0 then ignore
				if (amount - S[j] >= 0) {
					// what is minimum, including current coin or
					// excluding it
					dp[amount] = Math.min(dp[amount], 1 + dp[amount - S[j]]);
				}
			}
		}
		// check whether change exists
		return dp[n] != n + 1 ? dp[n] : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int change [] = {1, 3, 4, 5};
		System.out.println(countCoins(change, 4, 7));
	}

}
