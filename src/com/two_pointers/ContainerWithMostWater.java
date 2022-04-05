/**
 * This problem solved using greedy approach as at every step we're greedy about height.
 * URL: https://leetcode.com/problems/container-with-most-water/
 */
package com.two_pointers;

public class ContainerWithMostWater {
	/**
	 * Time: O(n)
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int maxHeight = 0;

		while (l != r) {
			int currentHeight = (r - l) * Math.min(height[r], height[l]);
			maxHeight = Math.max(maxHeight, currentHeight);

			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxHeight;
	}

	/**
	 * Time: O(n ^ 2)
	 * @param height
	 * @return
	 */
	public static int maxAreaBruteForce(int[] height) {

		int maxHeight = Math.min(height[0], height[1]);

		for (int i = 2; i < height.length; i++) {

			for (int j = 0; j < i; j++) {
				int currentArea = Math.min(height[i], height[j]) * (i - j);
				maxHeight = Math.max(currentArea, maxHeight);
			}
		}
		return maxHeight;

	}

	public static void main(String[] args) {

	}

}
