/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
package com.bit_manipulation;

/**
 * Time: O(n * (n + N)), Space: O(n)
 * N = max(len(words[i]))
 * @author Satish
 *
 */
public class MaximumProductOfWordLengths {

	/**
	 * It is same as 2nd solution but instead of calculating the bitmask in advance,
	 * it calculates at the time of comparison.
	 * 
	 */
	class SolutionUsingBitMask {
		public int maxProduct(String[] words) {
			int n = words.length;
			int values[] = new int[n];

			int max = 0;

			for (int i = 0; i < n; i++) {

				String word = words[i];
				// It will set a bit for a particular character
				for (int j = 0; j < word.length(); j++) {
					values[i] |= 1 << (word.charAt(j) - 'a');
				}

				for (int j = 0; j < i; j++) {
					// if it doesn't have any common character
					if ((values[i] & values[j]) == 0) {
						max = Math.max(max, words[i].length() * words[j].length());
					}
				}
			}

			return max;
		}
	}

	/**
	 * It uses left shift operator to place a 1 when a character is present. It
	 * needs a 32-bit integer to represent all 26 possible characters.
	 * 
	 * @author Satish
	 *
	 */
	class SolutionUsingExternalBitMask {
		public int maxProduct(String[] words) {
			int n = words.length;
			int values[] = new int[n];

			// It will set a bit for a particular character
			for (int i = 0; i < n; i++) {
				String word = words[i];

				for (int j = 0; j < word.length(); j++) {
					values[i] |= 1 << (word.charAt(j) - 'a');
				}
			}

			int max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					// if it doesn't have any common character
					if ((values[i] & values[j]) == 0) {
						max = Math.max(max, words[i].length() * words[j].length());
					}
				}
			}

			return max;
		}
	}

	/**
	 * It uses a boolean array of size 26 to keep track characters present in the
	 * array.
	 */
	class SolutionUsingHashMap {
		public int maxProduct(String[] words) {
			int n = words.length;
			boolean wordCount[][] = new boolean[n][26];

			for (int i = 0; i < n; i++) {
				String word = words[i];
				boolean arr[] = wordCount[i];

				for (int j = 0; j < word.length(); j++) {
					arr[word.charAt(j) - 'a'] = true;
				}
			}

			int max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (!isCommon(wordCount[i], wordCount[j])) {
						max = Math.max(max, words[i].length() * words[j].length());
					}
				}
			}

			return max;
		}

		public boolean isCommon(boolean[] w1, boolean[] w2) {
			for (int i = 0; i < 26; i++) {
				if (w1[i] && w2[i])
					return true;
			}

			return false;
		}
	}
}
