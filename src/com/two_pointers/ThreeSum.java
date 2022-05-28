/**
 * https://leetcode.com/problems/3sum/
 */
package com.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The idea is to sort the input array and then run through all indices of a
 * possible first element of a triplet. For each possible first element we make
 * a standard bi-directional 2Sum sweep of the remaining part of the array. Also
 * we want to skip equal elements to avoid duplicates in the answer.
 * 
 * @author Satish Kumar Yadav
 *
 */
public class ThreeSum {
	/**
	 * This is time optimized solution.
	 * 
	 * Time: O(n * n), Space: O(n)
	 * 
	 * @author satis
	 *
	 */
	class OptimizedSolution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> pairs = new ArrayList<>();

			Arrays.sort(nums);

			for (int i = 0; i < nums.length; i++) {
				// A trick to improve performance: once nums[i] > 0, then break.
				// Since the nums is sorted, if first number is bigger than 0, it is impossible
				// to have a sum of 0.

				if (nums[i] > 0)
					break;

				if (i > 0 && nums[i] == nums[i - 1])
					continue;

				int left = i + 1;
				int right = nums.length - 1;
				while (left < right) {
					// take sum of all 3 - i, j and k
					int sum = nums[i] + nums[left] + nums[right];

					if (sum == 0) {
						pairs.add(Arrays.asList(nums[i], nums[left], nums[right]));
						left++;
						// increase left to avoid duplicates
						while (left < right && nums[left] == nums[left - 1])
							left++;
						right--;
						// decrement right to avoid duplicate.
						while (left < right && nums[right] == nums[right + 1])
							right--;
					} else if (sum < 0) {
						// sum is less we need to increase it
						left++;
					} else {
						// sum is greater than 0 so decrease the right pointer
						right--;
					}
				}
			}

			return pairs;
		}
	}

	/**
	 * It also uses the same logic but it keeps track of visited element in a set,
	 * time and space remains same.
	 * 
	 * @author satis
	 *
	 */
	class FirstSolution {
		public List<List<Integer>> threeSum(int[] nums) {
			Set<Integer> visited = new HashSet<>();
			List<List<Integer>> pairs = new ArrayList<>();

			Arrays.sort(nums);

			for (int i = 0; i < nums.length; i++) {

				if (visited.contains(nums[i]))
					continue;

				int left = i + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[left] + nums[right];

					if (sum == 0) {
						pairs.add(Arrays.asList(nums[i], nums[left], nums[right]));
						left++;
						// increase left to avoid duplicates
						while (left < right && nums[left - 1] == nums[left])
							left++;
					} else if (sum < 0) {
						left++;
					} else {
						right--;
					}
				}

				visited.add(nums[i]);

			}

			return pairs;
		}
	}
}
