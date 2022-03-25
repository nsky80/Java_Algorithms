/**
 * 
 */
package com.dp;

/**
 * Implementation of Longest common subsequence in bottom up approach.
 * 
 * @author satis
 *
 */
public class LCSubSequenceBottomUp {

	public static void getLongestCommonSubSequence(String seq1, String seq2) {
		// getting the length of sequence
		int n = seq1.length();
		int m = seq2.length();

		int dp[][] = new int[n + 1][m + 1];

		int i, j; // looping variables

		// initializing the base
		// column 1 = 0
		for (i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}

		// row1 = 0
		for (j = 0; j <= m; j++) {
			dp[0][j] = 0;
		}

		// Now calculating the table of common sequence
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= m; j++) {
				// current characters are matching, increment the value by 1
				if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= m; j++) {
				System.out.print(" " + dp[i][j]);
			}
			System.out.println();
		}

		StringBuilder lcs = new StringBuilder();
		i = n;
		j = m;

		while (i > 0 || j > 0) {
			// check left side of dp array
			if (j > 0 && dp[i][j] == dp[i][j - 1]) {
				j--;
			} else if (i > 0 && dp[i][j] == dp[i - 1][j]) {
				// check at the top
				i--;
			} else {
				// go to diagonal and get the string
//				System.out.println(i + " " + j);
				lcs.append(seq1.charAt(i - 1));
				i--;
				j--;
			}
		}

		System.out.println(lcs.reverse());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String seq1 = "ABCBDAB";
		String seq2 = "BDCABA";

		getLongestCommonSubSequence(seq1, seq2);
	}

}
