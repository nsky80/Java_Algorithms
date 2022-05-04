/**
 * https://leetcode.com/problems/combination-sum/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Satish Kumar Yadav
 *
 */
public class CombinationSum {
	/**
	 * O(2 ^ mn), O(mn)
	 */
	class Solution {
		List<List<Integer>> result;

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			result = new ArrayList<>();
			getUniqueCombinations(candidates, target, 0, new ArrayList<>());
			return result;
		}

		private void getUniqueCombinations(int[] candidates, int target, int index, List<Integer> tracker) {
			if (target == 0) {
				result.add(new ArrayList<>(tracker));
				return;
			}

			if (target < 0 || index >= candidates.length)
				return;

			// add current value into the tracker
			tracker.add(candidates[index]);
			getUniqueCombinations(candidates, target - candidates[index], index, tracker);

			// backtrack
			tracker.remove(tracker.size() - 1);
			getUniqueCombinations(candidates, target, index + 1, tracker);
		}
	}
}
