/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
package com.sorting;

import java.util.PriorityQueue;

/**
 * @author Satish Kumar Yadav
 *
 */
public class MergeK_SortedLists {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	/**
	 * Divide the array and merge it, it also not require to visit all n-nodes.
	 * Time: O(nlogk), Space: O(logk) - Recursion Stack.
	 */
	class SolutionUsingMergeSort {
		public ListNode mergeKLists(ListNode[] lists) {
			return mergeSort(lists, 0, lists.length - 1);
		}

		// Here r is inclusive
		public ListNode mergeSort(ListNode[] lists, int l, int r) {
			// divide
			if (l < r) {
				int mid = l + (r - l) / 2;

				ListNode left = mergeSort(lists, l, mid);
				ListNode right = mergeSort(lists, mid + 1, r);
				return merge(left, right);
			} else if (l == r) {
				// if it has only 1 node
				return lists[l];
			} else {
				// if left/right overflows
				return null;
			}
		}

		public ListNode merge(ListNode left, ListNode right) {
			// base case: if any of them is null then return - early exit
			if (left == null)
				return right;
			if (right == null)
				return left;

			// head is head pointer and cpt is current pointer
			ListNode cpt = null;
			ListNode head = null;

			// designate the head and cpt pointer
			if (left.val < right.val) {
				cpt = left;
				head = left;
				left = left.next;
			} else {
				cpt = right;
				head = right;
				right = right.next;
			}

			// merge until both the list have some element
			while (left != null && right != null) {
				if (left.val < right.val) {
					cpt.next = left;
					left = left.next;
				} else {
					cpt.next = right;
					right = right.next;
				}
				cpt = cpt.next;
			}

			// if any one of them is still have some elements
			if (left != null) {
				cpt.next = left;
			} else if (right != null) {
				cpt.next = right;
			}

			return head;
		}

	}

	/**
	 * Put all the list head into the pq and get the minimum in each iteration and
	 * increase the pointer. Time: O(nlogk), Space: O(k)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class SolutionUsingPriorityQueue {
		public ListNode mergeKLists(ListNode[] lists) {
			PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> (x.val - y.val));

			// add each ListNode into the pq
			for (ListNode node : lists) {
				if (node != null) {
					pq.offer(node);
				}
			}

			ListNode head = null;
			ListNode cpt = null;

			while (!pq.isEmpty()) {
				// get the minimum
				ListNode current = pq.poll();
				if (cpt == null) {
					cpt = current;
					head = current;
				} else {
					cpt.next = current;
					cpt = cpt.next;
				}

				if (current.next != null)
					pq.offer(current.next);
			}

			return head;
		}
	}
}
