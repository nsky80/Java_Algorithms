package com.dp.lcs;

import java.util.Map;
import java.util.HashMap;


public class CountLCS_DP{
	
	public static long count = 0;
	
	/**
	* Time complexity = O(m * n)
	* Space complexity = O(m * n) + O(m + n) stack overhead
	*/
	public static int countLCS_DP_Hash(String s1, int m, String s2, int n, Map<String, Integer> memo){
		count++;
		// base case 
		if ( m == s1.length() || n == s2.length()) return 0;
		
		// check in memo
		String key = Integer.toString(m) + "," + Integer.toString(n);
		
		if (memo.containsKey(key)) return memo.get(key);
		
		
		int max = 0;
		
		// if both the current matching then go forward
		if ( s1.charAt(m) == s2.charAt(n)){
			max = countLCS_DP_Hash(s1, m + 1, s2, n + 1, memo) + 1;
		}else{
		
			int left = countLCS_DP_Hash(s1, m + 1, s2, n, memo);
			int right = countLCS_DP_Hash(s1, m, s2, n + 1, memo);
			
			max = Math.max(left, right);
		}
		memo.put(key, max);
		return max;
	}
	
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs_Hash( char[] X, char[] Y, int m, int n, Map<String, Integer> memo)
	{
		count++;
		if (m == 0 || n == 0) return 0;
		
		String key = Integer.toString(m) + "," + Integer.toString(n);
		
		if (memo.containsKey(key)) return memo.get(key);

		int max = 0;
		
		if (X[m-1] == Y[n-1])
			max = 1 + lcs_Hash(X, Y, m-1, n-1, memo);
		else
			max = Math.max(lcs_Hash(X, Y, m, n-1, memo), lcs_Hash(X, Y, m-1, n, memo));
		
		memo.put(key, max);
		return max;
	}
 
	/**
	* Time complexity = O(m * n)
	* Space complexity = O(m * n)
	*/
	public static int countLCS_DP_BU(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				count++;
				if ( s1.charAt(i - 1) == s2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		// print dp array
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				System.out.print(String.format("%-4d", dp[i][j]));
			}
			System.out.println();
		}
		
		return dp[m][n];
	}
	
	
	public static int countLCS(String s1, String s2){
		Map<String, Integer> memo = new HashMap<>();
		// int max = countLCS_DP_Hash(s1, 0, s2, 0, memo);
		int max = countLCS_DP_BU(s1, s2);
		// int max = lcs_Hash(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), memo);
		System.out.println(memo);
		
		return max;
	}
	
	
	/**
	 * Time: O(m * n)
	 * Space: O(n)
	 * Space Optimized version
	 */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[] = new int[n + 1];
        
        int prevDia = 0;
        int currentDia = 0;
        
        for(int i = 0; i < m; i++){
            currentDia = dp[0];
            for(int j = 1; j <= n; j++){
                prevDia = dp[j];
                
                if (text1.charAt(i) == text2.charAt(j - 1))
                    dp[j] = currentDia + 1;
                else
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                
                currentDia = prevDia;
            }
        }
        
        return dp[n];
    }
	
	public static void main(String[] args){
		String str1 = "abc";
		String str2 = "ac";
		
		count = 0;
		System.out.println(countLCS(str1, str2) + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("abcd", "ac") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("abcdef", "adbcf") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("AGGTAB", "GXTXAYB") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("ABCD", "ACBAD") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("branch", "workattech") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("abcdef", "ghijkl") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("abc", "jkl") + " " + count + "\n");

		
	}
	
	
}