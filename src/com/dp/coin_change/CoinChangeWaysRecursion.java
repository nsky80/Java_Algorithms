// package com.dp.coin_change;


public class CoinChangeWaysRecursion{
	static long counter = 0;
	
	/**
	* This solution treats {1, 3} and {3, 1} as separate entity
	*/
	public long countIfOrderMatters(int S[], int m, int n) {
		counter++;
		
		if (n == 0) return 1;
		
		long ways = 0;
		
		for(int i = 0; i < m; i++){
			if (n - S[i] >= 0){
				ways += count(S, m, n - S[i]);
			}
		}
		
		return ways;
    }


	/**
	* Include a coin and exlude it 2 choices are there.
	*
	*/
	public long count(int S[], int m, int n){
		counter++;
		if (n == 0) return 1;
		
		// if sum is negative or there is no coin available
		if (n < 0 || m <= 0) return 0;
		
		// exclude the current coin + include the current coin
		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}














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

	
	public static void main(String [] args){
		CoinChangeWaysRecursion obj = new CoinChangeWaysRecursion();
		int arr[] = {1, 2, 3};
		
		counter = 0;
		System.out.println(obj.count(arr, arr.length, 4) + " " + counter);
		counter = 0;
		System.out.println(countGFG(arr, arr.length, 4) + " " + counter);
		
		
		counter = 0;
		arr = new int[]{2, 5, 3, 6};
		System.out.println(obj.count(arr, arr.length, 4) + " " + counter);
		counter = 0;
		System.out.println(obj.count(arr, arr.length, 4) + " " + counter);

	}
	
}