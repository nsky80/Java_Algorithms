/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
package com.linkedList;

/**
 * @author Satish Kumar Yadav
 *
 */
public class RemoveNthNodeFromEndOfList {

//	  Definition for singly-linked list.
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
	 * This is one pass constant space solution, it uses 2 pointers, where slow
	 * pointer placed at the beginning of the list and second pointer placed at nth
	 * position and then they gets incremented relatively.
	 * 
	 * Time: O(n), Space: O(1)
	 */
	class OnePassConstantSpaceSolution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null)
				return null;

			// it points to a dummy node
			ListNode slow = new ListNode(-1);
			ListNode fast = head;

			// add dummy node to the front of the list
			slow.next = head;
			// update the head to dummy node
			head = slow;

			// put the fast pointer at nth position
			// when it reaches at nth position, then both pointers will move
			// relatively
			while (fast != null) {
				fast = fast.next;
				if (n-- <= 0) {
					slow = slow.next;
				}
			}

			// delete the node.
			slow.next = slow.next.next;

			return head.next;
		}
	}

	/**
	 * This is also 1 pass solution but it takes O(n) space, it traverse whole list
	 * and then backtrack.
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * @author satis
	 *
	 */
	class RecursiveSolution {
		int n;

		public ListNode removeNthFromEnd(ListNode head, int n) {
			this.n = n;
			return dfs(head);
		}

		public ListNode dfs(ListNode head) {
			if (head == null)
				return null;

			ListNode next = dfs(head.next);
			n--;

			if (n == 0) {
				return head.next;
			}

			head.next = next;

			return head;
		}
	}
}
