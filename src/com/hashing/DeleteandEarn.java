package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class DeleteandEarn {
	// this count here used for complexity analysis
	static int count = 0;
	Map<Integer, Integer> points;
	Map<Integer, Integer> memo;

	/**
	 * Time: O(n + m) where m is the maximum element present Space: O(k + m) where k
	 * is the number of unique element
	 * 
	 * @param nums
	 * @return
	 */
	public int deleteAndEarn_TD_DP(int[] nums) {
		// assign the memory
		points = new HashMap<>();
		memo = new HashMap<>();
		int max = nums[0];

		// calculate the hash
		for (int element : nums) {
			points.put(element, points.getOrDefault(element, 0) + 1);
			max = Math.max(max, element);
		}

		return findMax(max);
	}

	public int deleteAndEarn_DP_BU(int[] nums) {
		// assign the memory
		points = new HashMap<>();
		int n = nums[0];

		// calculate the hash
		for (int element : nums) {
			points.put(element, points.getOrDefault(element, 0) + 1);
			n = Math.max(n, element);
		}

		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = points.getOrDefault(1, 0);
		for (int i = 2; i <= n; i++) {
			int gain = i * points.getOrDefault(i, 0);
			dp[i] = Math.max(gain + dp[i - 2], dp[i - 1]);
		}

		return dp[n];
	}

	private int findMax(int n) {
		if (n <= 0)
			return 0;

		if (memo.containsKey(n))
			return memo.get(n);

		// max points can be gained by including current element
		int currentMax = 0;
		// if it is available in points, i.e. it is part of array then
		if (points.containsKey(n)) {
			currentMax += n * points.get(n);
		}

		// put the result into memo and return
		memo.put(n, Math.max(currentMax + findMax(n - 2), findMax(n - 1)));
		return memo.get(n);
	}

	public static void main(String[] args) {
		DeleteandEarn obj = new DeleteandEarn();
		int[] arr1 = { 2, 2, 3, 3, 3, 4 };
		int[] arr2 = { 8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4 };
		int[] arr4 = { 34, 35, 36, 101, 104, 105, 106, 107, 108, 109, 78, 45, 23, 88, 89, 38, 39, 1, 4, 3, 2, 5, 9, 1,
				4, 66, 3, 1, 3, 4, 22, 3 };
		int[] arr3 = { 5, 5, 5, 6, 6, 6, 6, 7, 7 };
		int[] arr5 = { 8, 7, 3, 8, 1, 4, 10, 10, 10, 2 };
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr1) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr2) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr3) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr4) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr5) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr1) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr2) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr3) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr4) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarn_TD_DP(arr5) + " " + count);
	}

}
