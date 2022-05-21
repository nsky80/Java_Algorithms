/**
 * https://leetcode.com/problems/permutations-ii/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Satish Kumar Yadav
 *
 */
public class PermutationsII {

	/**
	 * This approach uses linked list to store a intermediate combination in which
	 * insertion and deletion is being done at the end for every recursive call
	 * which makes it better than arrays.
	 * 
	 * Time: O(n.n!), Space: O(n) - Here time is upper bound, exact time will vary,
	 * it is worst case time, when all the elements are unique.
	 * 
	 * @author satis
	 *
	 */
	class OptimizedSolutionLinkedList {
		List<List<Integer>> list;
		int n;

		public List<List<Integer>> permuteUnique(int[] nums) {
			list = new ArrayList<>();
			n = nums.length;
			Map<Integer, Integer> counter = new HashMap<>();

			for (int num : nums) {
				counter.put(num, counter.getOrDefault(num, 0) + 1);
			}

			backtrack(counter, new LinkedList<>());
			return list;
		}

		public void backtrack(Map<Integer, Integer> counter, LinkedList<Integer> current) {
			if (current.size() == n) {
				list.add(new ArrayList<>(current));
				return;
			}

			// iterate through all available keys
			for (int key : counter.keySet()) {
				// get the frequency corresponding to that key
				int val = counter.get(key);

				if (val > 0) {
					// add the current key into the list
					current.addLast(key);
					counter.put(key, val - 1);

					// recurse
					backtrack(counter, current);

					// backtrack
					counter.put(key, val);
					current.removeLast();
				}
			}
		}

	}

	/**
	 * It uses arraylist to track the intermediate combination, time and space
	 * remain same.
	 * 
	 * @author satis
	 *
	 */
	class SameAboveSolutionArrayList {
		List<List<Integer>> list;
		int n;

		public List<List<Integer>> permuteUnique(int[] nums) {
			list = new ArrayList<>();
			n = nums.length;
			Map<Integer, Integer> counter = new HashMap<>();

			for (int num : nums) {
				counter.put(num, counter.getOrDefault(num, 0) + 1);
			}

			backtrack(counter, new ArrayList<>(counter.size()));
			return list;
		}

		public void backtrack(Map<Integer, Integer> counter, List<Integer> current) {
			if (current.size() == n) {
				list.add(new ArrayList<>(current));
				return;
			}

			// iterate through all available keys
			for (int key : counter.keySet()) {
				// get the frequency corresponding to that key
				int val = counter.get(key);

				if (val > 0) {
					// add the current key into the list
					current.add(key);
					counter.put(key, val - 1);

					// recurse
					backtrack(counter, current);

					// backtrack
					counter.put(key, val);
					current.remove(current.size() - 1);
				}
			}
		}
	}

	
	/**
	 * This solution make changes in the counter hash map itself, so instead of iterating through all the 
	 * elements, it iterate only those which are available to make a combination
	 * 
	 * Time and space still remain same, but it would not perform better when all elements are unique.
	 * @author satis
	 *
	 */
	class Solution {
		List<List<Integer>> list;

		public List<List<Integer>> permuteUnique(int[] nums) {
			list = new ArrayList<>();
			Map<Integer, Integer> counter = new HashMap<>();

			for (int num : nums) {
				counter.put(num, counter.getOrDefault(num, 0) + 1);
			}

			backtrack(counter, new ArrayList<>(counter.size()));
			return list;
		}

		public void backtrack(Map<Integer, Integer> counter, List<Integer> current) {
			if (counter.isEmpty()) {
				list.add(new ArrayList<>(current));
				return;
			}

			// create a copy of unique keys, as map will change in runtime
			Set<Integer> keys = new HashSet<>(counter.keySet());

			// iterate through all available keys
			for (int key : keys) {
				// get the frequency corresponding to that key
				int val = counter.get(key);

				// removing the count / pair itself
				if (val > 1) {
					counter.put(key, val - 1);
				} else {
					// if the freq becomes 0 then it should be removed for next iteration
					counter.remove(key);
				}

				// add the current key into the list
				current.add(key);

				// recurse
				backtrack(counter, current);

				// backtrack
				counter.put(key, val);
				current.remove(current.size() - 1);
			}
		}

	}
}
