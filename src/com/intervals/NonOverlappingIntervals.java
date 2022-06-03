/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
package com.intervals;

import java.util.Arrays;

/**
 * This is a greedy solution where if we get any overlapping interval then we try to eliminate the large 
 * interval.
 * 
 * Time: O(nlogn), Space: O(n)
 * @author Satish
 *
 */
public class NonOverlappingIntervals {
	class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {
			int count = 0;

			Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

			// Here tries to remove the bigger interval if there is a conflict
			int prev = intervals[0][1];
			for (int i = 1; i < intervals.length; i++) {
				if (prev > intervals[i][0]) {
					count++;
					prev = Math.min(prev, intervals[i][1]);
				} else
					prev = intervals[i][1];
			}

			return count;
		}
	}
}
