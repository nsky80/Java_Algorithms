/*
 * https://leetcode.com/problems/perfect-squares/
 */

package com.dp.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {

	static List<Integer> perfectSquares(int l, int r) {
		List<Integer> perfectSqrt = new ArrayList<>();
		// For every element from the range
		for (int i = l; i <= r; i++) {

			// If current element is
			// a perfect square
			if (Math.sqrt(i) == (int) Math.sqrt(i))
				perfectSqrt.add(i);
		}
		return perfectSqrt;
	}

	public static int numSquaresDP(Map<Integer, Integer> memo, int sum, List<Integer> perfectSqrt) {
		if (sum == 0)
			return 0;

		if (memo.containsKey(sum))
			return memo.get(sum);

		int min = -1;

		for (int i = 0; i < perfectSqrt.size(); i++) {
			if (sum - perfectSqrt.get(i) >= 0) {
				int current = numSquaresDP(memo, sum - perfectSqrt.get(i), perfectSqrt);

				if (min == -1) {
					min = current;
				} else {
					min = Math.min(min, current);
				}
			}
		}

		memo.put(sum, min + 1);
		return min + 1;
	}

	public static int numSquares(int n) {
		List<Integer> perfectSqrt = perfectSquares(1, n);

		Map<Integer, Integer> memo = new HashMap<>();

		return numSquaresDP(memo, n, perfectSqrt);
	}
}

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution2.numSquares(2));
		System.out.println(Solution2.numSquares(12));
		System.out.println(Solution2.numSquares(13));
	}

}
