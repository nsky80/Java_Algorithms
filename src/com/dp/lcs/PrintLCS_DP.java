package com.dp.lcs;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class PrintLCS_DP {

	public static long count = 0;

	/**
	 * Time complexity = O(m * n) Space complexity = O(m * n) + O(m + n) stack
	 * overhead
	 */
	public static int countLCS_DP_Hash(String s1, int m, String s2, int n, Map<String, Integer> memo) {
		count++;
		// base case
		if (m == s1.length() || n == s2.length())
			return 0;

		// check in memo
		String key = Integer.toString(m) + "," + Integer.toString(n);

		if (memo.containsKey(key))
			return memo.get(key);

		int max = 0;

		// if both the current matching then go forward
		if (s1.charAt(m) == s2.charAt(n)) {
			max = countLCS_DP_Hash(s1, m + 1, s2, n + 1, memo) + 1;
		} else {

			int left = countLCS_DP_Hash(s1, m + 1, s2, n, memo);
			int right = countLCS_DP_Hash(s1, m, s2, n + 1, memo);

			max = Math.max(left, right);
		}
		memo.put(key, max);
		return max;
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs_Hash(char[] X, char[] Y, int m, int n, Map<String, Integer> memo) {
		count++;
		if (m == 0 || n == 0)
			return 0;

		String key = Integer.toString(m) + "," + Integer.toString(n);

		if (memo.containsKey(key))
			return memo.get(key);

		int max = 0;

		if (X[m - 1] == Y[n - 1])
			max = 1 + lcs_Hash(X, Y, m - 1, n - 1, memo);
		else
			max = Math.max(lcs_Hash(X, Y, m, n - 1, memo), lcs_Hash(X, Y, m - 1, n, memo));

		memo.put(key, max);
		return max;
	}

	/**
	 * Time complexity = O(m * n) Space complexity = O(m * n)
	 */
	public static int countLCS_DP_BU(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				count++;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// print dp array
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(String.format("%-4d", dp[i][j]));
			}
			System.out.println();
		}

		findAllLCS(s1, s2, m, n, dp);

		return dp[m][n];
	}

	/**
	 * Space: Stack(Longest Path in matrix(m + n) + 
	 * in the worst case the time complexity will be about (n + m) * 2^(max(n, m)), 
	 * where (n + m) is the height of recursive tree and 2^(max(n, m)) is the very approximate number of 
	 * recursive calls per one level in the recursive tree. 
	 * You can see the worst case when the input strings consist from completely different characters
	 *  (e.g.: "abc" and "xyz").
	 * @param s1
	 * @param s2
	 * @param m
	 * @param n
	 * @param dp
	 * @return
	 */
	private static Set<String> findAllLCS(String s1, String s2, int m, int n, int[][] dp) {
		// it will contain the set of sequences
		Set<String> seq = new HashSet<>();
		
		// base case: put an empty string into the set and return
		if (m == 0 || n == 0) {
			seq.add("");
			return seq;
		}
		
		// now check the character, if they are equal or not
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			// this character would be present in all subsequences
			// get the subsequences in remaining part and add this char
			Set<String> tmp = findAllLCS(s1, s2, m - 1, n - 1, dp);
			
			for(String s: tmp) {
				seq.add(s + s1.charAt(m - 1));
			}
		}else {
			// in this if both (top-left ) equal then have to include both
			// top
			if (dp[m - 1][n] >= dp[m][n - 1]) {
				seq = findAllLCS(s1, s2, m - 1, n, dp);
			}
			
			// left
			if (dp[m][n - 1] >= dp[m - 1][n]) {
				// in-case both are equal then both sequences should be covered.
				seq.addAll(findAllLCS(s1, s2, m, n - 1, dp));
			}
		}
		
		return seq;
	}

	public static int countLCS(String s1, String s2) {
		Map<String, Integer> memo = new HashMap<>();
		// int max = countLCS_DP_Hash(s1, 0, s2, 0, memo);
		int max = countLCS_DP_BU(s1, s2);
		// int max = lcs_Hash(s1.toCharArray(), s2.toCharArray(), s1.length(),
		// s2.length(), memo);
		System.out.println(memo);

		return max;
	}

	public static void main(String[] args) {
//		String str1 = "abc";
//		String str2 = "ac";
//
//		count = 0;
//		System.out.println(countLCS(str1, str2) + " " + count + "\n");
//		count = 0;
//		System.out.println(countLCS("abcd", "ac") + " " + count + "\n");
//		count = 0;
//		System.out.println(countLCS("abcdef", "adbcf") + " " + count + "\n");
//		count = 0;
//		System.out.println(countLCS("AGGTAB", "GXTXAYB") + " " + count + "\n");
		count = 0;
		System.out.println(countLCS("ABCD", "ACBAD") + " " + count + "\n");
//		count = 0;
//		System.out.println(countLCS("branch", "workattech") + " " + count + "\n");
//		count = 0;
//		System.out.println(countLCS("abcdef", "ghijkl") + " " + count + "\n");
//		count = 0;
//		System.out.println(countLCS("abc", "jkl") + " " + count + "\n");

	}

}