/**
* https://leetcode.com/problems/count-sorted-vowel-strings/
*/
package com.dp.string;

public class CountSortedVowelStrings{
	
	/**
	* Time: O(n), Space: O(n)
	*/
	class BottomUpDP {
		public int countVowelStrings(int n) {
			int dp[][] = new int[5 + 1][n + 1];
			
			for(int i = 1; i <= 5; i++){
				
				// if i characters available then there would be i possibilities
				dp[i][1] = i;
				for(int j = 2; j <= n; j++){
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
			
			return dp[5][n];
		}
	}
	
	
	/**
	* Time: (n), Space: O(n)
	*/
	static class TopDownDP {
		// this is not required in counting, used for reference
		static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		int memo[][];
		
		public int countVowelStrings(int n) {
			memo = new int[vowels.length][n];
			return dfs(0, n);
		}
		
		public int dfs(int index, int n){
			if (n == 0)
				return 1;
			
			if (memo[index][n - 1] != 0)
				return memo[index][n - 1];
			
			// count from current character to last character
			int total = 0;
			for(int i = index; i < vowels.length; i++){
				total += dfs(i, n - 1);
			}
			
			return memo[index][n - 1] = total;
		}
	}	
	
}