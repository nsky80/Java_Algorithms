package com.linkedList;

class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public void printList() {
		Node head = this;
		while (head != null) {
			System.out.print(" " + head);
			head = head.next;
		}
		System.out.println();
	}

	public String toString() {
		return "" + this.data;
	}

}

public class LinkedListReverseWithPosition {
	/**
	 * This method takes the linked list head and reverse the list and then returns
	 * the new head
	 * 
	 * @param head
	 * @return head of reversed list
	 */
	public static Node reverseList(Node head) {
		Node prev = null;
		Node current = head;

		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	public static Node getPositionalReverse(Node head, int k) {
		if (head == null) {
			return null;
		}

		// it will keep track of number of element traversed and < k
		int i = 0;
		// it'll keep track of kth element
		Node prev = null;
		// it'll keep track of k + 1 th element for next call
		Node current = head;

		// now get the list with k element
		while (i < k && current != null) {
			prev = current;
			current = current.next;
			i++;
		}

		// creating a new list with first k element and de-linking it from the main list
		prev.next = null;

		// reverse the first part of the list
		Node newHead = reverseList(head);

		// if this is not last k (or < k) element then reverse next part also
		if (current != null) {
			// it will link the next reversed list into current list
			head.next = getPositionalReverse(current, k);
		}

		return newHead;
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
		list = getPositionalReverse(list, 4);
		list.printList();

//		LNode li1 = new LNode(1);
//		li1 = reverseList(li1);
//		li1.printList();
	}

}
