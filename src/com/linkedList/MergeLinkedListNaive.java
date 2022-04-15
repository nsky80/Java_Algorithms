package com.linkedList;
import java.util.ArrayList;
/**
 * Definition for singly-linked list.
 */
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeLinkedListNaive {


	public static ListNode mergeKLists(ArrayList<ListNode> a) {
		ListNode fNode = a.get(0);
		
		for (int i = 1; i < a.size(); i++) {
			ListNode cpt = a.get(i);
			ListNode prev = null;
			ListNode ptr = fNode;

			while (cpt != null && ptr != null) {
				if (cpt.val < ptr.val) {
					if (prev == null) {
						fNode = cpt;
					} else {
						prev.next = cpt;
					}
					ListNode temp = cpt.next;
					cpt.next = ptr;
					prev = cpt;
					cpt = temp;
				} else {
					prev = ptr;
					ptr = ptr.next;
				}
			}
			if (cpt != null) {
				prev.next = cpt;
			}
		}
		return fNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		ListNode li = new ListNode(1);
		li.next = new ListNode(10);
		li.next.next = new ListNode(20);
		
		ListNode li1 = new ListNode(4);
		li1.next = new ListNode(11);
		li1.next.next = new ListNode(13);
		
//		ArrayList<Integer> arr = new ArrayList<>();
		
		
		
		ListNode li2 = new ListNode(3);
		li2.next = new ListNode(8);
		li2.next.next = new ListNode(9);
		
		ArrayList<ListNode> a = new ArrayList<>();
		a.add(li);
		a.add(li1);
		a.add(li2);
		
		ListNode check = mergeKLists(a);
		while (check != null) {
			System.out.println("  " + check.val);
			check = check.next;
		}
		
		
	}

}
