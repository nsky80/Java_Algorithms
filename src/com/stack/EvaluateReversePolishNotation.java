/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish Kumar Yadav
 *
 */
public class EvaluateReversePolishNotation {

	/**
	 * Time: O(n), Space: O(n)
	 * @author Satish Kumar Yadav
	 *
	 */
	class Solution {
		public int evalRPN(String[] tokens) {
			Deque<Integer> stack = new ArrayDeque<>();

			for (String token : tokens) {
				char opr = token.charAt(token.length() - 1);
				if (opr == '+' || opr == '*' || opr == '-' || opr == '/') {
					int opr2 = stack.pop();
					int opr1 = stack.pop();
					switch (opr) {
					case '+':
						stack.push(opr1 + opr2);
						break;
					case '-':
						stack.push(opr1 - opr2);
						break;
					case '*':
						stack.push(opr1 * opr2);
						break;
					case '/':
						stack.push(opr1 / opr2);
						break;
					}
				} else {
					stack.push(Integer.parseInt(token));
				}
			}

			return stack.pop();
		}
	}
}
