 package com.dp.easy;
/**
If we have a matrix of size m * n like:
[S, 0, 0]
[0, 0, E]

It will calculate the maximum ways to reach from Start (S) to End(E). 
Moving diagonally is not allowed.
*/

import java.util.Arrays;

public class MaxWayGridTravel{
	
	/**
	* Brute force solution
	* Time Complexity: O(2 ^ (m + n))
	* Space Complexity: O(m + n)
	*/
	static int getMaxGridRecr(int mat[][], int m, int n){
		// base condition
		
		// if matrix is 1 * 1, then there is only 1 way
		if(m == 1 && n == 1)
			return 1;
		
		// if any of the value is invalid the it would be 0
		if (m == 0 || n == 0)
			return 0;
		
		// first go to down and get all the path and then go right and get all path
		return getMaxGridRecr(mat, m - 1, n) + getMaxGridRecr(mat, m, n - 1);
	}
	
	
	/**
	* Memoization DP
	*/
	static long getMaxGridDPMemoHelper(int mat[][], long memo[][], int m, int n){

		if (m == 0 || n == 0)
			return 0;
		
		if (memo[m - 1][n - 1] != -1)
			return memo[m - 1][n - 1];
		
		memo[m - 1][n - 1] = getMaxGridDPMemoHelper(mat, memo, m - 1, n) + getMaxGridDPMemoHelper(mat, memo, m, n - 1);
	
		return memo[m - 1][n - 1];
	}
	
	
	static long getMaxGridDPMemo(int mat[][], int m, int n){
		long memo[][] = new long[m][n];
		
		for(int i = 0; i < m; i++){
			Arrays.fill(memo[i], -1);
		}
		
		memo[0][0] = 1;
		
		return getMaxGridDPMemoHelper(mat, memo, m, n);
	}
	
	public static void main(String[] args){
	
		int mat[][] = {{1, 2, 3}, {4, 5, 6}, {1, 2, 2}};
		System.out.println(getMaxGridRecr(mat, 3, 3));
		System.out.println(getMaxGridDPMemo(mat, 3, 3));
		System.out.println(getMaxGridDPMemo(mat, 8, 8));
		System.out.println(getMaxGridDPMemo(mat, 18, 18));
		System.out.println(Integer.MAX_VALUE);
		
		
	}
	
}