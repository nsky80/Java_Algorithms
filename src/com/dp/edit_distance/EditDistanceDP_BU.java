package com.dp.edit_distance;

public class EditDistanceDP_BU{
	static int count;
	
	/**
	* Time complexity of this solution is always going to be O(m * n)
	* Space Complexity: O(m * n)
	*/
	public static int editDistance(String str1, String str2, int m, int n){
		int dp[][] = new int[m + 1][n + 1];
		
		// initializing the dp array
		// first row - it means that str1 is empty we need to insert all 
		// the n characters
		for(int i = 0; i <= n; i++){
			dp[0][i] = i;
		}
		
		// first column - it means that str2 is emtpy and we need to remove 
		// all the characters from str1.
		for(int i = 0; i <= m; i++){
			dp[i][0] = i;
		}
		
		// now calculate the whole DP array
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				// if both characters are equal
				count++;
				if (str1.charAt(i - 1) == str2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				}
			}
		}
		
		return dp[m][n];
	}
	
	
	public static void main(String [] args){
		count = 0;
		System.out.println(editDistance("abc", "xyz", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("geek", "gesek", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("voldemort", "dumbledore", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("sksdflsjfwwiejlksdjdfklJSFKL", "SKFDOIOJSksdflksjfsfdislaflksddk", 28, 32) + " " + count);
		
		/**
		count = 0;
		System.out.println(minDistanceGFG("abc", "xyz", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("geek", "gesek", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("voldemort", "dumbledore", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("sksdflsjfwwiejlksdjdfklJSFKL", "SKFDOIOJSksdflksjfsfdislaflksddk", 28, 32) + " " + count);
		*/
	}

	
}