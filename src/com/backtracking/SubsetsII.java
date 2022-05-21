/**
 * https://leetcode.com/problems/subsets-ii/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Time: O(n.2^n), Space: O(n)
 * 
 * @author Satish Kumar Yadav
 *
 */
public class SubsetsII {
	class Solution {
		List<List<Integer>> ans;

		public List<List<Integer>> subsetsWithDup(int[] nums) {
			ans = new ArrayList<>();

			// sort the array in ascending order so that we can skip equal values easily
			Arrays.sort(nums);
			generate(nums, 0, new LinkedList<>());
			return ans;
		}

		public void generate(int[] nums, int index, LinkedList<Integer> currentSub) {
			if (index == nums.length) {
				ans.add(new ArrayList<>(currentSub));
				return;
			}

			// now include the current value
			currentSub.add(nums[index]);
			// generate next recursively
			generate(nums, index + 1, currentSub);
			// backtrack
			currentSub.removeLast();

			// generate by excluding the current element along with it's repetitions
			int j = index;
			// skipping repeated values
			while (j < nums.length && nums[index] == nums[j])
				j++;
			// exclude the current element and it's repetitions
			generate(nums, j, currentSub);

		}
	}
}
