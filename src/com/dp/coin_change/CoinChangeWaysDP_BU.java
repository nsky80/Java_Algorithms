 package com.dp.coin_change;
// import java.util.HashMap;
// import java.util.Map;
import java.util.Arrays;

public class CoinChangeWaysDP_BU{
	static long counter = 0;

	/**
	* Time: O(m * n)
	* Space: O (mn)
	*/
	public int countCoinChange(int [] coin, int m, int n){
		int dp[][] = new int[m + 1][n + 1];
		
		// if sum = 0, then there always be 1 solution
		for(int i = 0; i <= m; i++){
			dp[i][0] = 1;
		}
		
		// now for every coin, 
		for(int i = 1; i <= m; i++){
			// check every sum
			for(int j = 1; j <= n; j++){
				// for complexity
				counter++;
				
				// if current sum is not less than available coin
				// then it can utilize this coin
				if (j >= coin[i - 1]){
					// get the total possibility by including and excluding this coin
					dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
				}else{
					// exclude this coin as it coin is greater than available amount
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[m][n];
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


	public static void main(String [] args){
		CoinChangeWaysDP_BU obj = new CoinChangeWaysDP_BU();
		int arr[] = {1, 2, 3};
		
		counter = 0;
		System.out.println(obj.countCoinChange(arr, arr.length, 4) + " " + counter);
		counter = 0;
		System.out.println(countGFG(arr, arr.length, 4) + " " + counter);
		
		
		counter = 0;
		arr = new int[]{2, 5, 3, 6, 1, 8, 9, 12, 4};
		System.out.println(obj.countCoinChange(arr, arr.length, 20) + " " + counter);
		counter = 0;
		System.out.println(countGFG(arr, arr.length, 20) + " " + counter);

	}
	
}