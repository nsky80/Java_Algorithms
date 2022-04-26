/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
package com.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {

	/**
	 * This method reverse linked-list without recursion and without using any extra
	 * space. Time: O(n) Space: O(1)
	 * 
	 * @param head
	 * @return
	 */
	public static Node reverseOriginal(Node head) {
		if (head == null)
			return null;

		Node previous = head;
		Node current = head.next;

		while (current != null) {
			// It would keep track of next to next node for swapping
			Node nextPtr = current.next;
			current.next = previous;
			previous = current;
			current = nextPtr;
		}

		// make the next of head as null because, it is last element
		head.next = null;

		return previous;

	}

	ListNode rNode;

	/**
	 * Reverse Linked list recursively O(n), O(n)
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		reverse(head);
		return rNode;
	}

	public ListNode reverse(ListNode head) {
		if (head.next == null) {
			rNode = head;
			return head;
		}

		ListNode temp = reverse(head.next);
		temp.next = head;
		head.next = null;

		return head;
	}

	/**
	 * Reversing a linked-list using stack. Time: O(n) Space: O(n)
	 * 
	 * @param head
	 * @return
	 */
	public static Node reverseLinkedListStack(Node head) {
		if (head == null)
			return null;

		Deque<Node> stack = new ArrayDeque<>();
		Node ptr = head;
//		stack.push(head);
		while (ptr != null) {
			stack.push(ptr);
			ptr = ptr.next;
		}

		Node firstNode = stack.peek();
		ptr = stack.poll();

		while (!stack.isEmpty()) {
			ptr.next = stack.poll();
			ptr = ptr.next;
		}

		head.next = null;
		head = firstNode;
		return head;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.next = new Node(2);
		list.next.next = new Node(2);
		list.next.next.next = new Node(4);
		list.next.next.next.next = new Node(5);
		list.next.next.next.next.next = new Node(8);
		list.next.next.next.next.next.next = new Node(9);
		list.next.next.next.next.next.next.next = new Node(10);
		list.next.next.next.next.next.next.next.next = new Node(11);
		list.next.next.next.next.next.next.next.next.next = new Node(12);

		list.printList();
		list = reverseLinkedListStack(list);
		list.printList();

//		LNode li1 = new LNode(1);
//		li1 = reverseList(li1);
//		li1.printList();
	}

}
