/**
 * https://leetcode.com/problems/add-two-numbers/
 */
package com.linkedList;

/**
 * It adds two numbers, keep track of carry- It can be simulated in single while
 * loop with multiple if-else statement which will reduce the number of lines in
 * code.
 * 
 * Time: O(max(m, n)), Space: O(1)
 * 
 * @author Satish
 *
 */
public class AddTwoNumbers {

//	 * Definition for singly-linked list.
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

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;

			ListNode head = new ListNode();
			ListNode current = head;
			int carry = 0;

			while (l1 != null && l2 != null) {
				int sum = l1.val + l2.val + carry;
				carry = sum / 10;
				sum = sum % 10;
				l1 = l1.next;
				l2 = l2.next;

				ListNode currentNode = new ListNode(sum);
				current.next = currentNode;
				current = currentNode;
			}

			while (l1 != null) {
				int sum = l1.val + carry;
				carry = sum / 10;
				sum %= 10;

				current.next = new ListNode(sum);
				l1 = l1.next;
				current = current.next;
			}

			while (l2 != null) {
				int sum = l2.val + carry;
				carry = sum / 10;
				sum %= 10;

				current.next = new ListNode(sum);
				l2 = l2.next;
				current = current.next;
			}

			if (carry != 0) {
				current.next = new ListNode(carry);
			}

			return head.next;
		}
	}
}
