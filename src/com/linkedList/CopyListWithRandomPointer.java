/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package com.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Satish Kumar Yadav
 *
 */
public class CopyListWithRandomPointer {

	// Definition for a Node.
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	/**
	 * Approach: Here, we're creating a duplicate node and attaching it to the next
	 * of same node in first pass.
	 * 
	 * e.g., - a -> b -> c === a -> a' -> b -> b' -> c -> c'
	 * 
	 * After that in second pass update the random pointer if it is not null for all
	 * newly created nodes.
	 * 
	 * In third pass segregate both the lists.
	 * 
	 * Time: O(n), Space: O(1)
	 * 
	 * @author Satish
	 *
	 */
	class SpaceOptimizedSolution {
		public Node copyRandomList(Node head) {
			if (head == null)
				return null;

			Node cpt = head;

			// adding a duplicate node to each node
			while (cpt != null) {
				Node newNode = new Node(cpt.val);
				newNode.next = cpt.next;
				newNode.random = cpt.random;

				// now add this newNode
				Node backup = cpt.next;
				cpt.next = newNode;
				cpt = backup;
			}

			// now update the random pointer for all newly created node
			cpt = head.next;
			while (cpt.next != null) {
				Node random = cpt.random;

				// random pointer might be null
				if (random != null) {
					cpt.random = random.next;
				}

				// as we're updating only for newly created nodes
				cpt = cpt.next.next;
			}
			// update the last node
			cpt.random = cpt.random != null ? cpt.random.next : null;

			// now segregate both the lists.
			Node newHead = head.next;

			cpt = head;
			// last node is already covered in the link
			while (cpt.next != null) {
				Node backup = cpt.next;
				cpt.next = cpt.next.next;
				cpt = backup;
			}

			return newHead;
		}
	}

	/**
	 * In this approach, first create a hashMap and map newly created nodes to older
	 * node as value in first pass.
	 * 
	 * In second pass, update the next and random pointer.
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class SolutionUsingHashTable {
		public Node copyRandomList(Node head) {
			if (head == null)
				return null;

			Map<Node, Node> map = new HashMap<>();

			Node temp = head;

			while (temp != null) {
				map.put(temp, new Node(temp.val));
				temp = temp.next;
			}

			temp = head;
			while (temp != null) {
				Node current = map.get(temp);
				current.next = map.get(temp.next);
				current.random = map.get(temp.random);
				temp = temp.next;
			}

			return map.get(head);
		}
	}

}
