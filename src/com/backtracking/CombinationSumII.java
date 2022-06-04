/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * It uses the concepts of backtracking with index, where first we sort the
 * array and then try to create pairs which may lead us to a solution, but in a
 * single iteration, we also try to ignore the repeated numbers.
 * 
 * Time: O(2^n), Space: O(n)
 * 
 * @author Satish Kumar Yadav
 *
 */
public class CombinationSumII {
	class Solution {
		// Backtracking with Index
		List<List<Integer>> combinations = new ArrayList<>();

		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			Arrays.sort(candidates);
			generateSum(new LinkedList<>(), candidates, target, -1);
			return combinations;
		}

		public void generateSum(LinkedList<Integer> current, int[] arr, int sum, int index) {
			if (sum == 0) {
				combinations.add(new ArrayList<>(current));
				return;
			}

			for (int i = index + 1; i < arr.length; i++) {
				if (i > index + 1 && arr[i] == arr[i - 1])
					continue;

				// as array is sorted so we're not going check further
				if (sum - arr[i] < 0)
					return;

				current.addLast(arr[i]);
				generateSum(current, arr, sum - arr[i], i);

				// backtrack
				current.removeLast();
			}
		}
	}
}
