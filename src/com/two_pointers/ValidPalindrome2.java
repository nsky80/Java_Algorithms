/**
 * Problem Link: https://leetcode.com/problems/valid-palindrome-ii/submissions/
 */
package com.two_pointers;

/**
 * @author Satish
 *
 */
public class ValidPalindrome2 {

	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * @param s
	 * @return
	 */
	public boolean validPalindrome(String s) {
		int f = 0;
		int b = s.length() - 1;

		while (b - f >= 0) {
			if (s.charAt(b) == s.charAt(f)) {
				b--;
				f++;
			} else {
				return checkP(s, f, b - 1) || checkP(s, f + 1, b);
			}
		}
		return true;
	}

	public boolean checkP(String s, int f, int b) {
		while (b - f >= 0) {
			if (!(s.charAt(f) == s.charAt(b))) {
				return false;
			}
			b--;
			f++;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
