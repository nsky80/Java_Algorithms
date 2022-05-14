/**
 * https://leetcode.com/problems/distinct-subsequences/
 */
package com.dp.lcs;

import java.util.Arrays;

/**
 * @author Satish Kumar Yadav
 *
 */
public class DistinctSubsequences {
	/**
	 * Time: O(m * n), Space: O(m * n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class BottomUpDP {
		public int numDistinct(String s, String t) {
			if (t.length() > s.length())
				return 0;

			int dp[][] = new int[s.length() + 1][t.length() + 1];
			// if both the strings are empty then we have 1 way
			dp[0][0] = 1;

			for (int i = 1; i <= s.length(); i++) {
				// if the t is empty then we have 1 way
				dp[i][0] = 1;
				for (int j = 1; j <= t.length(); j++) {
					// characters are matching, take the count from the diagonal
					if (s.charAt(i - 1) == t.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];
					// compulsory case
					dp[i][j] += dp[i - 1][j];
				}
			}

			return dp[s.length()][t.length()];
		}
	}

	/**
	 * Here, if 2 characters are matching then we have 2 possibilities take i - 1, j
	 * - 1 and i - 1, j; if they are not matching then we can go with i - 1, j only.
	 * 
	 * Time: O(m * n), Space: O(m * n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class TopDownDP {
		int memo[][];

		public int numDistinct(String s, String t) {
			memo = new int[s.length()][t.length() + 1];
			for (int i = 0; i < s.length(); i++)
				Arrays.fill(memo[i], -1);

			return countSub(s, t, s.length(), t.length());
		}

		public int countSub(String s, String t, int m, int n) {
			// if the second string is empty then return 1 as solution found
			if (n == 0)
				return 1;

			// if first string is empty and second is still have some then
			// solution cannot be possible
			if (m <= 0)
				return 0;

			if (memo[m - 1][n] != -1)
				return memo[m - 1][n];

			// if strings are equal
			int equal = 0;
			if (n > 0 && s.charAt(m - 1) == t.charAt(n - 1))
				equal = countSub(s, t, m - 1, n - 1);

			// leave the equal, or it would be always gets executed.
			int leave = countSub(s, t, m - 1, n);

			return memo[m - 1][n] = equal + leave;
		}
	}
}
