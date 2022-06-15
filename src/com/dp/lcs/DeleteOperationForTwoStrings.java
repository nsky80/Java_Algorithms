/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
package com.dp.lcs;

/**
 * @author Satish
 *
 */
public class DeleteOperationForTwoStrings {
	/**
	 * Uses the same concept as the below solution but it is space optimized
	 * solution.
	 * 
	 * Time: O(nm), space: O(m)
	 * 
	 * @author satis
	 *
	 */
	class SpaceOptimizedSolutionUsingEditDistance {
		public int minDistance(String word1, String word2) {
			int n = word1.length();
			int m = word2.length();

			int dp[] = new int[m + 1];

			for (int i = 0; i <= m; i++) {
				dp[i] = i;
			}

			for (int i = 1; i <= n; i++) {

				// saving/updating the diagonal and length of second string.
				int prevDia = i - 1;
				dp[0] = i;
				
				for (int j = 1; j <= m; j++) {
					int backup = dp[j];

					if (word1.charAt(i - 1) == word2.charAt(j - 1))
						dp[j] = prevDia;
					else
						dp[j] = Math.min(dp[j - 1], dp[j]) + 1;

					prevDia = backup;
				}

			}

			return dp[m];
		}

	}

	/**
	 * It uses edit distance pattern, where if characters are matching then increase
	 * the pointer, otherwise dynamically finds the minimum.
	 * 
	 * Time: O(mn), Space: O(mn)
	 * 
	 * @author Satish
	 *
	 */
	class SolutionUsingEditDistance {
		public int minDistance(String word1, String word2) {
			int n = word1.length();
			int m = word2.length();

			int dp[][] = new int[n + 1][m + 1];

			for (int i = 0; i <= m; i++) {
				dp[0][i] = i;
			}

			for (int i = 0; i <= n; i++) {
				dp[i][0] = i;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {

					if (word1.charAt(i - 1) == word2.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];
					else
						dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;

				}

			}

			return dp[n][m];
		}

	}

	/**
	 * This solution finds the longest common subsequences between words and then
	 * returns the remaining characters in both the strings which need to be
	 * deleted.
	 * 
	 * Time: O(n * m), Space: O(m)
	 * 
	 * @author satis
	 *
	 */
	class SolutionUsingLCS {
		public int minDistance(String word1, String word2) {
			int n = word1.length();
			int m = word2.length();

			int dp[] = new int[m + 1];

			for (int i = 1; i <= n; i++) {
				int prevDia = 0;
				for (int j = 1; j <= m; j++) {
					int backup = dp[j];

					if (word1.charAt(i - 1) == word2.charAt(j - 1))
						dp[j] = prevDia + 1;
					else
						dp[j] = Math.max(dp[j - 1], dp[j]);

					prevDia = backup;
				}

			}

			return m + n - dp[m] * 2;
		}

	}
}
