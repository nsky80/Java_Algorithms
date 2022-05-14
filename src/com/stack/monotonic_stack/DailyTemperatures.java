/**
 * https://leetcode.com/problems/daily-temperatures/
 */
package com.stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish Kumar Yadav
 *
 */
public class DailyTemperatures {

	/**
	 * This is space optimized version, it uses answer array as reference to next
	 * greater element, i.e., to get the next greater element, it uses ans as dp
	 * array.
	 * 
	 * Time: O(n), Space: O(1)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class SolutionUsingArray {
		public int[] dailyTemperatures(int[] t) {
			int ans[] = new int[t.length];

			for (int day = t.length - 2; day >= 0; day--) {
				int nextDay = day + 1;

				// getting the next warmer day by using answers of previous days
				// here 3rd condition is used to avoid the cycle, if ans = 0
				while (nextDay < t.length && t[nextDay] <= t[day] && ans[nextDay] != 0) {
					// get the next warmer day
					nextDay += ans[nextDay];
				}

				// if there is any warmer day or it could be the end
				if (t[nextDay] > t[day])
					ans[day] = nextDay - day;

			}

			return ans;
		}
	}

	/**
	 * It'll keep the temperatures in increasing order inside the stack, to get the
	 * next greater element. Time: O(n), Space: O(n)
	 * 
	 * @author satis
	 *
	 */
	class SolutionUsingStack {
		public int[] dailyTemperatures(int[] t) {
			int ans[] = new int[t.length];
			Deque<Integer> stack = new ArrayDeque<>();

			for (int i = t.length - 1; i >= 0; i--) {

				// pop until a warmer day found from current day
				while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
					stack.pop();
				}

				// if there is any higher temp available then answer found
				if (!stack.isEmpty()) {
					ans[i] = stack.peek() - i;
				} else {
					ans[i] = 0;
				}

				stack.push(i);
			}

			return ans;
		}
	}

}
