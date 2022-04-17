/**
 * 
 */
package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/**
 * https://leetcode.com/problems/word-break/
 */
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author satis
 *
 */
public class WordBreak {
	int n;
	Set<String> wordSet;
	Map<Integer, Boolean> memo;

	public boolean wordBreak(String s, List<String> wordDict) {
		n = s.length();
		wordSet = new HashSet<>(wordDict);
		memo = new HashMap<>();
//		boolean res = wordCheckRecursive(0, 1, s);
		boolean res = wordCheckRecursiveWithLoop(0, s);
		System.out.println("Here: " + memo);
		return res;
	}

	private boolean wordCheckRecursiveWithLoop(int start, String str) {
		// base case
		if (start == n)
			return true;
		if (memo.containsKey(start))
			return memo.get(start);
		if (wordSet.contains(str.substring(start)))
			return true;
		// create every possible word from current word
		for (int i = start + 1; i < n; i++) {
			String sub = str.substring(start, i);

			if (wordSet.contains(sub)) {
				if (wordCheckRecursiveWithLoop(i, str)) {
					memo.put(start, true);
					return true;
				}
			}
		}
		memo.put(start, false);
		return false;
	}

	/**
	 * Recursive solution has 2 ^ n * n complexity. Memoized solutions complexity is
	 * n^2 * n (for substring)
	 */
//	private boolean wordCheckRecursive(int s, int e, String str) {
//		System.out.println(s + " " + e);
//		if (s == n)
//			return true;
//		if (e > n)
//			return false;
//		String key = Integer.toString(s) + "," + Integer.toString(e);
//		if (memo.containsKey(key))
//			return memo.get(key);
//
//		String st = str.substring(s, e);
//		if (wordSet.contains(st)) {
//			memo.put(key, wordCheckRecursive(e, e + 1, str) || wordCheckRecursive(s, e + 1, str));
//			return memo.get(key);
//		}
//		memo.put(key, wordCheckRecursive(s, e + 1, str));
//		return memo.get(key);
//	}

	/**
	 * Time: O(n^2) excluding substring operation
	 */
	public boolean wordBreakDP_BU(String str, List<String> wordDict) {
		n = str.length();
		wordSet = new HashSet<>(wordDict);
		boolean dp[] = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			// get all the words possible before i
			for (int s = i - 1; s >= 0; s--) {
				// if any word from (0, s) is present, then check (s, i)
				if (dp[s]) {
					String sub = str.substring(s, i);
					if (wordSet.contains(sub)) {
						dp[i] = true;
						break;
					}
				}
			}
		}

		return dp[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
		System.out.println(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
		System.out.println(wb.wordBreak("catsanddog", Arrays.asList("cats", "dog", "and", "cat", "dogs")));
		System.out.println(wb.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
				Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
						"aaaaaaaaaa")));

	}

}
