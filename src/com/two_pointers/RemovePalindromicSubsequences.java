/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */
package com.two_pointers;

/**
 * Check if string is palindrome, if it is then we won't require to make any
 * changes, otherwise we can remove same type of characters in 1 go which
 * requires 2 operation.
 * 
 * Time: O(n), Space: O(1)
 * 
 * @author Satish
 *
 */
public class RemovePalindromicSubsequences {

	class Solution {
		public int removePalindromeSub(String s) {
			int start = 0;
			int end = s.length() - 1;

			while (start < end) {
				if (s.charAt(start) != s.charAt(end))
					return 2;
				start++;
				end--;
			}

			return 1;
		}
	}
}
