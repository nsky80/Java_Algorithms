/**
 * https://leetcode.com/problems/reorder-list/
 */
package com.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class ReorderList {

	// Definition for singly-linked list.
	static class ListNode {
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
	 * <h4>Idea:</h4> Divide the list into 2 halves and reverse the second part
	 * after that merge them together.
	 * <dt>Time: O(n), Space: O(1)</dt>
	 */
	class ThirdAndOptimalSolution {

		public void reorderList(ListNode head) {
			ListNode second = head;
			ListNode middle = head;

			while (second != null && second.next != null) {
				middle = middle.next;
				second = second.next.next;
			}

			// dividing the list into two parts
			second = middle.next;
			middle.next = null;

			// now reverse the second part of the list
			second = reverse(second);

			// now merge first and second part
			ListNode first = head;

			while (second != null) {
				ListNode nodeToInsert = second;
				second = second.next;

				nodeToInsert.next = first.next;
				first.next = nodeToInsert;
				first = nodeToInsert.next;
			}

		}

		public ListNode reverse(ListNode head) {
			ListNode prev = null;

			while (head != null) {
				ListNode nextNode = head.next;
				head.next = prev;
				prev = head;
				head = nextNode;
			}

			return prev;
		}

	}

	/**
	 * <dt>Time: O(n), Space: O(n)</dt>
	 * <h4>Idea:</h4> Here, get the middle and goto the depth of the list and the
	 * backtrack and make necessary changes, it is still not the optimal way of
	 * solving.
	 */
	class SecondWay {
		boolean isMiddleFound;
		ListNode middle;
		ListNode tracker;

		public void reorderList(ListNode head) {
			middle = head;
			ListNode fast = head;

			// get the middle of the list
			while (fast != null && fast.next != null) {
				middle = middle.next;
				fast = fast.next.next;
			}

			tracker = head;

			reorder(head);
		}

		public void reorder(ListNode head) {
			if (head == null)
				return;
			reorder(head.next);

			// if this is middle it means, list is sorted, now make it's next as null
			// to avoid the cycle
			if (head == middle) {
				head.next = null;
				isMiddleFound = true;
				return;
			}

			// if middle already found then it means these are first half node, ignore them
			if (!isMiddleFound) {
				// join first and last, as tracker is global pointer
				ListNode backup = tracker.next;
				tracker.next = head;
				head.next = backup;
				tracker = backup;
			}
		}
	}

	/**
	 * Time: O(n), Space: O(n)
	 * <h4>Idea:</h4> Create a deque and put all the element into that and pop first
	 * and last element from the deque and join them.
	 */
	class FirstWay {
		public void reorderList(ListNode head) {

			Deque<ListNode> dq = new ArrayDeque<>();
			ListNode cpt = head;

			while (cpt != null) {
				dq.offerLast(cpt);
				cpt = cpt.next;
			}

			cpt = null;

			// take first and last of the deque and join them and finally add it into the
			// list.
			while (dq.size() >= 2) {
				ListNode f = dq.pollFirst();
				ListNode l = dq.pollLast();
				f.next = l;

				if (cpt != null) {
					cpt.next = f;
				}

				cpt = l;
				cpt.next = null;
			}

			if (!dq.isEmpty() && cpt != null) {
				cpt.next = dq.poll();
				cpt.next.next = null;
			}
		}
	}
}
