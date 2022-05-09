/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Satish Kumar Yadav
 *
 */
public class LetterCombinationsOfPhoneNumber {

	/**
	 * Time: O(4 ^ N * N), Space: O(N), here N for copying the string and 4 ^ N
	 * times the function generateWord gets called.
	 */
	static class RecursiveSolution {
		static String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		public List<String> letterCombinations(String digits) {
			List<String> combinations = new ArrayList<>();
			if (digits.length() < 1)
				return combinations;

			generateWord(combinations, digits, new StringBuilder(digits.length()), 0);
			return combinations;
		}

		private void generateWord(List<String> combinations, String digits, StringBuilder word, int currentIndex) {

			if (currentIndex == digits.length()) {
				combinations.add(new String(word));
				return;
			}

			// create the word
			int digit = Integer.parseInt(digits.substring(currentIndex, currentIndex + 1));
			for (int i = 0; i < mapping[digit].length(); i++) {
				// add current word
				word.append(mapping[digit].charAt(i));

				// recurse the combination
				generateWord(combinations, digits, word, currentIndex + 1);

				// backtrack
				word.delete(word.length() - 1, word.length());
			}
		}
	}

	/**
	 * Time would be same as recursive version, but it'll take more space in temp
	 * list.
	 */
	static class IterativeSolution {
		static String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		public List<String> letterCombinations(String digits) {
			List<String> ans = new ArrayList<>();
			if (digits.length() < 1)
				return ans;

			// create an empty string
			ans.add("");

			for (int i = 0; i < digits.length(); i++) {
				List<String> temp = new ArrayList<>();

				int digit = Character.getNumericValue(digits.charAt(i));

				// add all the characters of current digit to all available combinations.
				for (String word : ans) {
					for (int c = 0; c < mapping[digit].length(); c++) {
						temp.add(word + Character.toString(mapping[digit].charAt(c)));
					}
				}

				// swap the temp with all new combinations to ans for next iteration
				ans = temp;
			}

			return ans;
		}
	}

}
