/**
 * https://leetcode.com/problems/subsets/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author satis
 *
 */
public class Subsets {
	/**
	 * Time complexity: O(N * 2^N)O(N×2 ^ N) to generate all subsets and then copy
	 * them into output list. Space complexity: O(N * 2^N) This is exactly the
	 * number of solutions for subsets multiplied by the number NN of elements to
	 * keep for each subset.
	 */
	class CascadingApproach {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> subList = new ArrayList<>();
			subList.add(new ArrayList<>());
			return addSubsets(subList, nums, 0);
		}

		private List<List<Integer>> addSubsets(List<List<Integer>> subList, int[] nums, int index) {
			if (index == nums.length)
				return subList;

			List<List<Integer>> temp = new ArrayList<>();

			for (List<Integer> sub : subList) {
				List<Integer> tuple = new ArrayList<>(sub);
				tuple.add(nums[index]);
				temp.add(tuple);
			}

			subList.addAll(temp);

			return addSubsets(subList, nums, index + 1);
		}
	}

	/**
	 * Time: O(n * 2 ^ n), Space: O(n)
	 */
	class Backtracking {
		List<List<Integer>> subList;

		public List<List<Integer>> subsets(int[] nums) {
			subList = new ArrayList<>();
			addSubsets(new ArrayList<>(), nums, 0);
			return subList;
		}

		private void addSubsets(List<Integer> current, int[] nums, int index) {
			if (index == nums.length) {
				subList.add(new ArrayList<>(current));
				return;
			}

			// include the current element
			current.add(nums[index]);
			addSubsets(current, nums, index + 1);

			// exclude the current element
			current.remove(current.size() - 1);
			addSubsets(current, nums, index + 1);
		}
	}
}
