/**
 * 
 */
package com.dp.string;

/**
 * @author Satish Kumar Yadav
 *
 */
public class InterleavingString {
	/**
	 * Time: O(mn), Space: O(mn) Space can be further optimized, but it's already a
	 * hard problem, so I'm not goint to do.
	 */
	class BottomUpDP {
		public boolean isInterleave(String s1, String s2, String s3) {
			if (s1.length() + s2.length() != s3.length())
				return false;

			boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
			// if both the strings are emptyr then it would be true
			dp[0][0] = true;

			for (int i = 0; i <= s1.length(); i++) {
				for (int j = 0; j <= s2.length(); j++) {
					// now check if the character is matching in s1 as well as the previous
					// characters in s1 was matching
					if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
						dp[i][j] = true;

					// if subsequent character is matching in the string
					if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])
						dp[i][j] = true;

					// dp is false by default if any one of them isn't executed
				}
			}

			return dp[s1.length()][s2.length()];
		}

	}

	/**
	 * This check the string against the first string, and then checks against the
	 * second string. As, the length of s3 would be equal to the sum of length of s1
	 * and s2, so using that property to track the third string.
	 * 
	 * Time: O(mn), Space: O(mn)
	 */
	class TopDownDP {
		Boolean[][] memo;

		public boolean isInterleave(String s1, String s2, String s3) {
			if (s1.length() + s2.length() != s3.length())
				return false;
			memo = new Boolean[s1.length() + 1][s2.length() + 1];

			return helper(s1, s2, s3, 0, 0);
		}

		public boolean helper(String s1, String s2, String s3, int p1, int p2) {
			if (p1 + p2 == s3.length())
				return true;

			if (memo[p1][p2] != null)
				return memo[p1][p2];

			if (p1 < s1.length() && s3.charAt(p1 + p2) == s1.charAt(p1)) {
				if (helper(s1, s2, s3, p1 + 1, p2))
					return memo[p1][p2] = true;
			}

			if (p2 < s2.length() && s3.charAt(p1 + p2) == s2.charAt(p2)) {
				if (helper(s1, s2, s3, p1, p2 + 1))
					return memo[p1][p2] = true;
			}

			return memo[p1][p2] = false;
		}
	}
}
