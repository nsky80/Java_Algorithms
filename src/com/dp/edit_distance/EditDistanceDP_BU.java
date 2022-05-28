/**
 * https://leetcode.com/problems/edit-distance/
 */
package com.dp.edit_distance;

import java.util.Arrays;

public class EditDistanceDP_BU {
	static int count;

	/**
	 * Space Optimized Edit distance Time: O(m * n), Space: O(n)
	 * 
	 * @author satis
	 *
	 */
	class Solution {
		public int minDistance(String word1, String word2) {
			// as at a time, it is referring only top-left-diagonal, so we can use 2 arrays
			int dp1[] = new int[word2.length() + 1];
			int dp2[] = new int[word2.length() + 1];

			// initializing the first array, i.e. if there is no element present in the
			// first string
			// then we have to add all
			for (int i = 0; i <= word2.length(); i++)
				dp1[i] = i;

			for (int i = 1; i <= word1.length(); i++) {
				// if there is no element present in the target, then we have to delete all
				dp2[0] = i;

				// now calculate the minimum
				for (int j = 1; j <= word2.length(); j++) {
					if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
						dp2[j] = dp1[j - 1];
					} else {
						dp2[j] = Math.min(dp1[j - 1], Math.min(dp2[j - 1], dp1[j])) + 1;
					}
				}

				// swap the arrays
				int[] temp = dp1;
				dp1 = dp2;
				Arrays.fill(temp, 0);
				dp2 = temp;

			}
			return dp1[word2.length()];
		}

	}

	/**
	 * Time complexity of this solution is always going to be O(m * n) Space
	 * Complexity: O(m * n)
	 */
	public static int editDistance(String str1, String str2, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];

		// initializing the dp array
		// first row - it means that str1 is empty we need to insert all
		// the n characters
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}

		// first column - it means that str2 is emtpy and we need to remove
		// all the characters from str1.
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		// now calculate the whole DP array
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// if both characters are equal
				count++;
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
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
		System.out.println(
				editDistance("sksdflsjfwwiejlksdjdfklJSFKL", "SKFDOIOJSksdflksjfsfdislaflksddk", 28, 32) + " " + count);

		/**
		 * count = 0; System.out.println(minDistanceGFG("abc", "xyz", 3, 3) + " " +
		 * count); count = 0; System.out.println(minDistanceGFG("cat", "cut", 3, 3) + "
		 * " + count); count = 0; System.out.println(minDistanceGFG("cat", "cut", 3, 3)
		 * + " " + count); count = 0; System.out.println(minDistanceGFG("geek", "gesek",
		 * 3, 3) + " " + count); count = 0;
		 * System.out.println(minDistanceGFG("voldemort", "dumbledore", 3, 3) + " " +
		 * count); count = 0;
		 * System.out.println(minDistanceGFG("sksdflsjfwwiejlksdjdfklJSFKL",
		 * "SKFDOIOJSksdflksjfsfdislaflksddk", 28, 32) + " " + count);
		 */
	}

}