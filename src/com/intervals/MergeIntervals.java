/**
 * https://leetcode.com/problems/merge-intervals/
 */
package com.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Satish Kumar Yadav
 *
 */
public class MergeIntervals {
	/**
	 * Time: O(nlogn), Space: O(n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class Solution {
		public int[][] merge(int[][] intervals) {
			Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

			List<int[]> merged = new ArrayList<>();

			// add the first interval into the answer
			merged.add(intervals[0]);

			// check other intervals, whether they're overlapping or not
			for (int i = 1; i < intervals.length; i++) {
				int current[] = intervals[i];
				int prev[] = merged.get(merged.size() - 1);

				// if previous interval and current are overlapping then put
				// ending as maximum of both
				if (current[0] <= prev[1]) {
					prev[1] = Math.max(current[1], prev[1]);
				} else {
					// otherwise add the current interval.
					merged.add(current);
				}
			}

			return merged.toArray(new int[merged.size()][]);
		}
	}
}
