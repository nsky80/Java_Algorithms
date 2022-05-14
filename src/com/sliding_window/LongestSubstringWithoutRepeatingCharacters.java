/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
package com.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Satish Kumar Yadav
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * It is somewhat space efficient approach, it maintains set of unique elements,
	 * as soon as a duplicate found, it removes all the elements left to
	 * duplicate(inclusive) to bound left pointer.
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class SolutionUsingHashSet {
		public int lengthOfLongestSubstring(String s) {
			int m = 0;
			Set<Character> charSet = new HashSet<>();

			for (int r = 0, l = 0; r < s.length(); r++) {

				// move the left pointer until the next bound found
				while (charSet.contains(s.charAt(r))) {
					charSet.remove(s.charAt(l));
					l += 1;
				}

				charSet.add(s.charAt(r));
				m = Math.max(m, r - l + 1);
			}

			return m;
		}

	}

	/**
	 * This solution is time efficient but consumes more space, Idea is define a
	 * left and right pointer , right pointer is always moving whereas left pointer
	 * gets updated whenever a duplicate found.
	 * 
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	class SolutionUsingHashMap {
		public int lengthOfLongestSubstring(String s) {
			int m = 0;
			Map<Character, Integer> pos = new HashMap<>();

			for (int r = 0, l = 0; r < s.length(); r++) {
				if (pos.containsKey(s.charAt(r))) {
					// "check for: abba"
					// Here left pointer, should be taken from nearest left.
					l = Math.max(l, pos.get(s.charAt(r)) + 1);
				}

				pos.put(s.charAt(r), r);
				m = Math.max(m, r - l + 1);
			}

			return m;
		}

	}
}
