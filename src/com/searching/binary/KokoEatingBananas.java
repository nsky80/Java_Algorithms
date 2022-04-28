/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
package com.searching.binary;

/**
 * @author satis
 *
 */
public class KokoEatingBananas {
	class Solution {
		public int minEatingSpeed(int[] piles, int h) {
			int min = 1;
			int max = 1;
			int n = piles.length;
			for (int i = 0; i < n; i++) {
				max = Math.max(piles[i], max);
			}

			while (min < max) {
				int m = (max + min) / 2;

				int total = 0;
				for (int i = 0; i < n; i++) {
					total += Math.ceil((double) piles[i] / m);
				}

				if (total <= h) {
					max = m;
				} else {
					min = m + 1;
				}
			}

			return max;
		}
	}
}
