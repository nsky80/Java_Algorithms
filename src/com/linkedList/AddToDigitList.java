package com.linkedList;


public class AddToDigitList {

	static Node reverse(Node head) {
		if (head == null) {
			return null;
		}
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

	static Node addMore(Node current, Node last, int carry) {
		int sum = 0;
		while (current != null) {
			sum = current.data + carry;
			carry = sum / 10;
			last.next = new Node(sum % 10);
			current = current.next;
			last = last.next;
		}
		
		if(carry != 0) {
			last.next = new Node(carry);
			last = last.next;
		}
		
		return last;
	}

	// Function to add two numbers represented by linked list.
	static Node addTwoLists(Node first, Node second) {
		// code here
		// return head of sum list
		Node current1 = reverse(first);
		Node current2 = reverse(second);

		current1.printList();
		current2.printList();
		
		Node head;
		Node last = new Node(0);

		head = last;

		int sum = 0;
		int carry = 0;

		while (current1 != null && current2 != null) {
			sum = current1.data + current2.data + carry;
			carry = sum / 10;
			last.next = new Node(sum % 10);
			last = last.next;
			current1 = current1.next;
			current2 = current2.next;
		}

		if (current1 != null) {
			last = addMore(current1, last, carry);
			carry = 0;
		}

		if (current2 != null) {
			last = addMore(current2, last, carry);
			carry = 0;
		}

		if(carry != 0) {
			last.next = new Node(carry);
			last = last.next;
		}
		
		// leaving out first element which is empty
		return reverse(head.next);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node li1 = new Node(4);
		li1.next = new Node(5);
		
		Node li2 = new Node(3);
		li2.next = new Node(4);
		li2.next.next = new Node(5);
		
		Node sum = addTwoLists(li1, li2);
		sum.printList();
	}

}
