/**
 * https://leetcode.com/problems/contains-duplicate/
 */
package com.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author satis
 *
 */
public class ContainsDuplicate {
	class Solution {
		public boolean containsDuplicate(int[] nums) {
			Set<Integer> set = new HashSet<>();
			for (int n : nums) {
				if (set.contains(n))
					return true;
				set.add(n);
			}

			return false;

		}
	}
}
