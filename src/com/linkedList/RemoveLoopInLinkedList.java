package com.linkedList;
import java.util.HashSet;

class Node1 {
	int data;
	Node1 next;

	Node1(int data) {
		this.data = data;
		next = null;
	}
}

public class RemoveLoopInLinkedList {

	/**
	 * Function to remove a loop in the linked list. Brute Force Time Complexity:
	 * O(n^2)
	 */
	public static int removeLoopBruteForce(Node1 head) {
		// code here
		// remove the loop without losing any Node1s

		// it will keep track of previous Node1 so that if there is any loop
		// then it can break the path
		Node1 pathBreaker = head;
		boolean flag = false;

		Node1 current = head;
		Node1 prev = null;

		// It will keep count of number of Node1 scanned till now
		// for reverse comparison
		int count = 0;

		while (!flag && current != null) {
			count++;
			// it'll start comparison from the start
			prev = head;
			pathBreaker = current;
			current = current.next;

			int temp = count;

			// compare the address from start to current - 1 Node1
			while (temp > 0) {
				if (prev == current) {
					flag = true;
					break;
				}
				temp--;
				prev = prev.next;
			}

		}

		if (flag) {
			pathBreaker.next = null;
			return 1;
		} else {
			return 0;
		}
	}
	
	
	/**
	* This method used a Hash to keep track of visited node.
	* It's amortized complexity would be O(n)
	*/
	public static int removeLoopHash(Node1 head) {
		HashSet<Node1> hash = new HashSet<Node1>();
		
		// to keep track of previous node
		Node1 pathBreaker = head;
		Node1 current = head;
		
		// adding the first element into the hash
		hash.add(head);
		
		boolean flag = false;
		
		while(current != null){
			pathBreaker = current;
			current = current.next;
			
			if(hash.contains(current)){
				pathBreaker.next = null;
				flag = true;
				break;
			}else{
				hash.add(current);
			}
		}
		
		return flag ? 1: 0;
	}

	public static void printList(Node1 head) {
		while (head != null) {
			System.out.print(" " + head.data);
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node1 head1 = new Node1(1);
		head1.next = new Node1(2);
		head1.next.next = new Node1(3);
//		head1.next.next.next = head1.next;

		System.out.println(removeLoopHash(head1));
		printList(head1);
	}

}