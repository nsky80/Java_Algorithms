/**
 * https://leetcode.com/problems/decode-ways/submissions/
 */
package com.dp.easy.fib;

import java.util.Arrays;

/**
 * @author satis
 *
 */
public class DecodeWays {
	static int count;

	// helper utility function to check the strings compatibility
	public boolean isCompatible(String s) {
		if (s.charAt(0) == '0')
			return false;
		int temp = Integer.parseInt(s);
		if (temp <= 0 || temp > 26)
			return false;
		return true;
	}

	public int numDecodingsRecursive(String s) {
		int n = s.length();
		if (n == 1)
			return isCompatible(s) ? 1 : 0;
		return helperRecursive(s, n);
	}

	public int helperRecursive(String s, int n) {
		count++;
		if (n == 0)
			return 1;

		int total = 0;

		// for string of length 1
		if (isCompatible(s.substring(n - 1, n))) {
			total += helperRecursive(s, n - 1);
		}

		if (n >= 2 && isCompatible(s.substring(n - 2, n))) {
			total += helperRecursive(s, n - 2);
		}

		return total;
	}

	/**
	 * Time complexity: O(n) Space: O(n)
	 */
	public int numDecodingsDPTD(String s) {
		int n = s.length();
		if (n == 1)
			return isCompatible(s) ? 1 : 0;

		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return helperDPTD(s, n, memo);
	}

	public int helperDPTD(String s, int n, int[] memo) {
		count++;
		if (n == 0)
			return 1;

		if (memo[n] != -1)
			return memo[n];

		int total = 0;

		// for string of length 1
		if (isCompatible(s.substring(n - 1, n))) {
			total += helperDPTD(s, n - 1, memo);
		}

		if (n >= 2 && isCompatible(s.substring(n - 2, n))) {
			total += helperDPTD(s, n - 2, memo);
		}
		return memo[n] = total;
	}

	public int numDecodingsDPBU(String s) {
		int n = s.length();
		// early return
		if (n == 1)
			return isCompatible(s) ? 1 : 0;
		if (s.charAt(0) == '0')
			return 0;

		int dp[] = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (isCompatible(s.substring(i - 1, i))) {
				dp[i] += dp[i - 1];
			}

			if (i > 1 && isCompatible(s.substring(i - 2, i))) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		count = 0;
		System.out.println("11106: " + dw.numDecodingsRecursive("11106") + " " + count);
		count = 0;
		System.out.println("06: " + dw.numDecodingsRecursive("06") + " " + count);
		count = 0;
		System.out.println("226: " + dw.numDecodingsRecursive("226") + " " + count);
		count = 0;
		System.out.println("111111111111: " + dw.numDecodingsRecursive("111111111111") + " " + count);
		count = 0;
		System.out.println("11106: " + dw.numDecodingsDPTD("11106") + " " + count);
		count = 0;
		System.out.println("06: " + dw.numDecodingsDPTD("06") + " " + count);
		count = 0;
		System.out.println("226: " + dw.numDecodingsDPTD("226") + " " + count);
		count = 0;
		System.out.println("111111111111: " + dw.numDecodingsDPTD("111111111111") + " " + count);
		count = 0;
		System.out.println("11106: " + dw.numDecodingsDPBU("11106") + " " + count);
		count = 0;
		System.out.println("06: " + dw.numDecodingsDPBU("06") + " " + count);
		count = 0;
		System.out.println("226: " + dw.numDecodingsDPBU("226") + " " + count);
		count = 0;
		System.out.println("111111111111: " + dw.numDecodingsDPBU("111111111111") + " " + count);
	}

}
