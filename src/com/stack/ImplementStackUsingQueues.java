/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
package com.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * The idea here is put newly inserted element at the front of queue,
 * which causes O(n) time for push() operation.
 * @author Satish
 *
 */
public class ImplementStackUsingQueues {
	/**
	 * Push: O(n)
	 * Pop: O(1)
	 * Top: O(1)
	 */
	class MyStack {
		Queue<Integer> q;

		public MyStack() {
			q = new ArrayDeque<>();
		}

		public void push(int x) {
			q.offer(x);

			// put this element at the front of queue
			for (int i = 0; i < q.size() - 1; i++) {
				q.offer(q.poll());
			}

		}

		public int pop() {
			return q.poll();
		}

		public int top() {
			return q.peek();
		}

		public boolean empty() {
			return q.isEmpty();
		}
	}

	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
