 package com.dp.coin_change;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class CoinChangeWaysDP_TD{
	static long counter = 0;


	/**
	* Include a coin and exlude it 2 choices are there.
	* Time: O(m * n)
	* Space: O(m * n)
	*/
	public long countHashHelper(int S[], int m, int n, Map<String, Long> memo){
		if (n == 0) return 1;
		
		// if sum is negative or there is no coin available
		if (n < 0 || m <= 0) return 0;
		counter++;

		String key = Integer.toString(m) + "," + Integer.toString(n);
		
		if (memo.containsKey(key)) return memo.get(key);
		
		// exclude the current coin + include the current coin
		memo.put(key, countHashHelper(S, m - 1, n, memo) + countHashHelper(S, m, n - S[m - 1], memo));
		return memo.get(key);
	}


	public long countHash(int S[], int m, int n){
		Map<String, Long> memo = new HashMap<>();
		return countHashHelper(S, m, n, memo);
	}
	
	
	
	static int coinchange(int[] a, int v, int n, int[][] dp)
    {
        if (v == 0)
            return dp[n][v] = 1;
        if (n == 0)
            return 0;
		counter++;

        if (dp[n][v] != -1)
            return dp[n][v];
        if (a[n - 1] <= v)
        {
           
            // Either Pick this coin or not
            return dp[n][v]
                = coinchange(a, v - a[n - 1], n, dp)
                  + coinchange(a, v, n - 1, dp);
        }
        else // We have no option but to leave this coin
            return dp[n][v] = coinchange(a, v, n - 1, dp);
    }
 
 	public static long countGFG(int S[], int m, int n){
		int memo[][] = new int[m + 1][n + 1];
		for(int i = 0; i < memo.length; i++){
			Arrays.fill(memo[i], -1);
		}
		return coinchange(S, n, m, memo);
	}


/*
	static int countGFG(int S[], int m, int n)
	{
		counter++;
		// If n is 0 then there is 1 solution
		// (do not include any coin)
		if (n == 0)
			return 1;
		 
		// If n is less than 0 then no
		// solution exists
		if (n < 0)
			return 0;
	 
		// If there are no coins and n
		// is greater than 0, then no
		// solution exist
		if (m <= 0 && n >= 1)
			return 0;
	 
		// count is sum of solutions (i)
		// including S[m-1] (ii) excluding S[m-1]
		return countGFG(S, m - 1, n) +
			   countGFG(S, m, n - S[m - 1]);
	}

*/
	public static void main(String [] args){
		CoinChangeWaysDP_TD obj = new CoinChangeWaysDP_TD();
		int arr[] = {1, 2, 3};
		
		counter = 0;
		System.out.println(obj.countHash(arr, arr.length, 4) + " " + counter);
		counter = 0;
		System.out.println(countGFG(arr, arr.length, 4) + " " + counter);
		
		
		counter = 0;
		arr = new int[]{2, 5, 3, 6, 1, 8, 9, 12, 4};
		System.out.println(obj.countHash(arr, arr.length, 20) + " " + counter);
		counter = 0;
		System.out.println(countGFG(arr, arr.length, 20) + " " + counter);

	}
	
}