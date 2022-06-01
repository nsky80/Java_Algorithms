/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */
package com.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * The maximum number of binary pairs of size K would be 2^K, so we need to
 * check whether all 2^K distinct binary substring present in the given
 * subsequence or not.
 * 
 * @author Satish
 *
 */
public class CheckStringContainsAllBinaryCodesOfSizeK {

	/**
	 * It maintains an array of size 2^k to keep track of all pairs, instead of
	 * putting into a hash set for every substring, it calculates hash by using
	 * rolling Hash technique, which uses the hash value of previous hash.
	 * 
	 * Time: O(n), Space: O(2 ^ K)
	 * 
	 * @author satis
	 *
	 */
	class SolutionUsingRollingHash {
		public boolean hasAllCodes(String s, int k) {
			int n = s.length();
			if (n < k)
				return false;

			int need = 1 << k;
			boolean found[] = new boolean[need];

			// It will keep track of hash value
			int hash = 0;
			
			// it would be used to generate next hash value where it will eliminate
			// most significant bit of current hash.
			int allOne = need - 1;

			for (int i = 0; i < n; i++) {
				// left shift the most significant bit
				hash = hash << 1;

				// first part eliminates the MSB and second part adds the value
				// at the current index in string at LSB.
				hash = (hash & allOne) | (s.charAt(i) - '0');

				// check if this is a new string pair with size K
				if (i >= k - 1 && !found[hash]) {
					need--;

					if (need == 0)
						return true;

					found[hash] = true;
				}

			}

			return false;
		}
	}

	/**
	 * This technique stores every possible pair into the hash and as soon as it
	 * gets 2^k substring, it returns true otherwise false.
	 * 
	 * Time: O(n * k), Space: O(n * k)
	 * 
	 * @author Satish
	 *
	 */
	class SolutionUsingHashing {
		public boolean hasAllCodes(String s, int k) {
			int n = s.length();

			if (n < k)
				return false;

			Set<String> nums = new HashSet<>();

			int len = 1 << k;

			for (int i = 0; i <= n - k && nums.size() < len; i++) {
				nums.add(s.substring(i, i + k));
			}

			return nums.size() == len;
		}
	}
}
