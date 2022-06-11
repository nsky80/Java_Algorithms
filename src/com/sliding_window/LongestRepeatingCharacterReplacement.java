/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
package com.sliding_window;

/**
 * Create a window of size k, and keep increasing the size of the window as long
 * as the number of characters other than max frequency is less than or equals
 * to k. Otherwise slide the window, keep track of maximum in every step.
 * 
 * Time: O(n), Space: O(1)
 * 
 * @author satis
 *
 */
public class LongestRepeatingCharacterReplacement {
	class Solution {
		public int characterReplacement(String s, int k) {

			int l = 0;
			int r = 0;
			int n = s.length();
			int max = 1;
			int freq[] = new int[26];

			while (r < n) {
				freq[s.charAt(r) - 'A']++;
				int maxFreq = getMaxFreq(freq);
				int windowSize = r - l + 1;

				if (windowSize - maxFreq <= k) {
					max = Math.max(max, windowSize);
				} else {
					freq[s.charAt(l) - 'A']--;
					l++;
				}
				r++;
			}

			return max;
		}

		public int getMaxFreq(int freq[]) {
			int max = 1;
			for (int i : freq) {
				if (i > max)
					max = i;
			}
			return max;
		}

	}
}
