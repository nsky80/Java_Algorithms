/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
package com.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author satis
 *
 */
public class IntersectionOfTwoLinkedLists {

	/**
	 * It uses 2 pointers to scan both the list, as soon as a list gets exhausted,
	 * it switches it's pointer to other list, by this once both the lists scanned 1
	 * round, they will become equi-distance from the end.
	 * 
	 * Time: O(m + n), Space: O(1)
	 * 
	 * @author satis
	 *
	 */
	public class SolutionUsingPointers {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode p1 = headA;
			ListNode p2 = headB;

			while (p1 != p2) {
				p1 = p1 == null ? headB : p1.next;
				p2 = p2 == null ? headA : p2.next;

			}

			return p1;
		}

	}

//	 Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * Keep all the nodes of first list into the HashSet and start scanning second
	 * list, as soon as, any node of second list found in the hash, return; as it is
	 * the first node which is common in both the lists.
	 * 
	 * Time: O(m + n), Space: O(1)
	 * 
	 * @author Satish
	 *
	 */
	public class SolutionUsingHash {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			Set<ListNode> set = new HashSet<>();
			ListNode temp = headA;

			while (temp != null) {
				set.add(temp);
				temp = temp.next;
			}

			temp = headB;

			while (temp != null) {
				if (set.contains(temp))
					return temp;
				temp = temp.next;
			}

			return null;
		}

	}
}
