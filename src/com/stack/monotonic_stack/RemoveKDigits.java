/**
 * https://leetcode.com/problems/remove-k-digits/
 */
package com.stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish Kumar Yadav
 *
 */
public class RemoveKDigits {

	/**
	 * Time: O(n), Space: O(n) -
	 */
	class Solution {
		public String removeKdigits(String num, int k) {

			int n = num.length();

			if (n == k)
				return "0";

			Deque<Character> stack = new ArrayDeque<>();
			int i = 0;
			int toRemove = k;

			while (toRemove > 0 && i < n) {
				// pop if a number x (x < stack.top) found and place it at its right place
				while (!stack.isEmpty() && toRemove > 0 && stack.peek() > num.charAt(i)) {
					toRemove--;
					stack.pop();
				}

				stack.push(num.charAt(i++));
			}

			// if numbers are in decreasing order and k values removed
			// then we have to add remaining values
			while (i < n) {
				stack.push(num.charAt(i++));
			}

			// if all k character haven't removed, this case come when numbers
			// are in increasing order
			while (toRemove-- > 0) {
				stack.pop();
			}

			// create the string
			StringBuilder sb = new StringBuilder(stack.size());

			for (Character ch : stack) {
				sb.append(ch);
			}
			sb = sb.reverse();

			// remove the leading zeros
			i = 0;
			int size = sb.length();

			// if all zeros then it should left atleast 1 value
			while (i < size - 1 && sb.charAt(i) == '0') {
				i++;
			}

			return new String(sb.substring(i));
		}
	}
}
