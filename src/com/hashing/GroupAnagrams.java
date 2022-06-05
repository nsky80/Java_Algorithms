/**
 * https://leetcode.com/problems/group-anagrams/
 */
package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Satish Kumar Yadav
 *
 */
public class GroupAnagrams {
	/**
	 * Time: O(n * m), Space: O(m)
	 */
	class SolutionUsingCounting {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> map = new HashMap<>();

			for (String s : strs) {
				// count the frequency using counting sort
				char[] freq = new char[26];

				for (int i = 0; i < s.length(); i++) {
					freq[s.charAt(i) - 'a']++;
				}

				String newWord = new String(freq);
				List<String> ref = map.getOrDefault(newWord, new ArrayList<>());
				ref.add(s);
				map.put(newWord, ref);
			}

			return new ArrayList<>(map.values());
		}
	}

	/**
	 * Time: O(n*mlogm), Space: O(m)
	 */
	class SolutionUsingSorting {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> map = new HashMap<>();

			for (String s : strs) {
				// sort and create the key
				char str[] = s.toCharArray();
				Arrays.sort(str);
				String newWord = new String(str);
				List<String> ref = map.getOrDefault(newWord, new ArrayList<>());
				ref.add(s);
				map.put(newWord, ref);
			}

			return new ArrayList<>(map.values());
		}
	}
}
