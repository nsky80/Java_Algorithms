/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
package com.sorting;

import java.util.PriorityQueue;

/**
 * @author Satish Kumar Yadav
 *
 */
public class KthLargestElementInAnArray {

	/**
	 * This approach uses quick sort, where we select a pivot and try to find out
	 * it's exact position, if the pivot placed at (n - k)th index then it is answer
	 * otherwise if pivot less than n - k search in right sub-array otherwise keep
	 * searching in left sub-array.
	 * 
	 * Time: Avg. - O(n), Worst Case - O(n ^ 2), Space: O(1)
	 * 
	 * @author satis
	 *
	 */
	class SolutionUsingQuickSelect {
		public int findKthLargest(int[] nums, int k) {
			int n = nums.length;
			int left = 0;
			int right = n - 1;

			while (left < right) {
				// get the index of pivot element
				int p = quickSelect(nums, left, right);

				// if pivot is kth index then it is already placed at it's exact position, so return
				if (p == n - k)
					break;
				else if (p < n - k)
					// search in right sub-array
					left = p + 1;
				else
					// search in left sub-array
					right -= 1;
			}

			return nums[n - k];
		}

		public int quickSelect(int[] nums, int left, int right) {
			int p = left;

			while (left < right) {
				if (nums[left] < nums[right]) {
					// swap with p and increment the p pointer
					int temp = nums[left];
					nums[left] = nums[p];
					nums[p] = temp;
					p++;
				}

				left++;
			}

			// place pivot to it's position
			int temp = nums[right];
			nums[right] = nums[p];
			nums[p] = temp;

			return p;
		}
	}

	/**
	 * It maintains a min heap of size K in which we replace the root as soon as we
	 * get any element greater than the root element.
	 * 
	 * Time: O(nlogk), Space: O(k)
	 * 
	 * @author satis
	 *
	 */
	class SolutionUsingPriorityQueue {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (int num : nums) {
				if (pq.size() == k) {
					if (pq.peek() < num) {
						pq.poll();
						pq.offer(num);
					}
				} else {
					pq.offer(num);
				}
			}

			return pq.poll();
		}
	}
}
