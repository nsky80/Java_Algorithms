/**
 * https://leetcode.com/problems/permutations/
 */
package com.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Satish
 *
 */
public class Permutations {
	/**
	 * In this approach, it swaps the 2 elements and get the permutation and then swap it back
	 * iteratively.
	 * 
	 * Time: n * n! time function permutations being called, and then each n! time base case gets 
	 * executed which takes n time to copy the array, so overall time would be:
	 * O(n^2 * n!)
	 */
	class Approach1 {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			permutations(nums, 0, result);
			return result;
		}

		public void permutations(int[] nums, int begin, List<List<Integer>> result) {

			// make this modified nums array as permutation
			if (begin >= nums.length) {
				List<Integer> perm = new ArrayList<>(nums.length);
				for (int element : nums)
					perm.add(element);
				result.add(perm);
				return;
			}

			// for every number present in the nums
			for (int i = begin; i < nums.length; i++) {
				// swap the begin and ith element and get the permutation
				swap(nums, begin, i);

				permutations(nums, begin + 1, result);

				// now reset the swapping - backtrack
				swap(nums, begin, i);
			}
		}

		private void swap(int[] arr, int s, int d) {
			int temp = arr[d];
			arr[d] = arr[s];
			arr[s] = temp;
		}

	}

	/**
	 * In this approach remove 1 element from the front and get the permutation, and
	 * then append it back, it is somewhat costly as we are performing push and pop
	 * operation too frequently.
	 */
	class Approch2 {
		public List<List<Integer>> permute(int[] nums) {
			Deque<Integer> arr = new ArrayDeque<>();

			for (int num : nums)
				arr.offer(num);

			List<List<Integer>> result = permutations(arr);

			return result;
		}

		public List<List<Integer>> permutations(Deque<Integer> nums) {
			List<List<Integer>> result = new ArrayList<>();

			if (nums.size() == 1) {
				List<Integer> perm = new ArrayList<>();
				perm.add(nums.peek());
				result.add(perm);
				return result;
			}

			// for every number present in the nums
			for (int i = 0; i < nums.size(); i++) {
				// remove the first element get all the pairs and then add it to back
				int current = nums.poll();

				List<List<Integer>> currentPerms = permutations(nums);
				// now add current element at the end of each permutations
				for (List<Integer> perm : currentPerms) {
					perm.add(current);
				}

				// now add back (backtrack) the popped number
				nums.offer(current);

				// now add all the permutation to result array
				result.addAll(currentPerms);
			}
			return result;
		}

	}
}
