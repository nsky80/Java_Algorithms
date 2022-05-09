/**
 * https://leetcode.com/problems/generate-parentheses/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Satish Kumar Yadav
 *
 */
public class GenerateParentheses {
	/**
	 * This is having a weird time complexity(copied from the LeetCode, I haven't analyzed).
	 * Time and Space: O(4^n / sqrt(n))
	 */
	class Solution {
		int n;

		public List<String> generateParenthesis(int n) {
			this.n = n;
			
			// create empty list to store the valid combinations
			List<String> combinations = new ArrayList<>();
			
			// generate the combinations
			generate(combinations, 0, 0, new StringBuilder());
			return combinations;
		}

		public void generate(List<String> list, int open, int close, StringBuilder par) {
			if (open == n && close == n) {
				list.add(new String(par));
			}

			// add open parentheses
			if (open < n) {
				generate(list, open + 1, close, par.append('('));
				// now backtrack
				par.deleteCharAt(par.length() - 1);
			}

			// if there is enough open parentheses available then call close as well
			if (close < open) {
				generate(list, open, close + 1, par.append(')'));
				// backtrack
				par.deleteCharAt(par.length() - 1);
			}
		}
	}
}
