package com.dp.easy.fib;

import java.util.Arrays;

public class HouseRobber2 {
	static int count;

	/**
	 * It considers that n initially would be greater than 0 and < arr.length
	 */
	public int rob1RecHelper(int arr[], int n) {
		count++;
		if (n == 0)
			return arr[0];

		if (n < 0)
			return 0;

		return Math.max(arr[n] + rob1RecHelper(arr, n - 2), rob1RecHelper(arr, n - 1));

	}

	public void rob1Rec(int arr[]) {
		count = 0;
		System.out.println("REC: " + rob1RecHelper(arr, arr.length - 1) + " " + count);
	}

	public void rob1DP_TD(int arr[]) {
		int memo[] = new int[arr.length];
		Arrays.fill(memo, -1);
		count = 0;
		System.out.println("DPTD: " + rob1DPTDHelper(arr, arr.length - 1, memo) + " " + count);
	}

	private int rob1DPTDHelper(int[] arr, int n, int[] memo) {
		count++;
		if (n == 0)
			return arr[0];
		if (n < 0)
			return 0;
		if (memo[n] != -1)
			return memo[n];
		return memo[n] = Math.max(rob1DPTDHelper(arr, n - 2, memo) + arr[n], rob1DPTDHelper(arr, n - 1, memo));
	}

	private int rob1DPBU(int[] arr) {
		int dp[] = new int[arr.length + 1];
		dp[0] = 0;
		dp[1] = arr[0];

		for (int i = 2; i <= arr.length; i++) {
			count++;
			dp[i] = Math.max(dp[i - 2] + arr[i - 1], dp[i - 1]);
		}

		return dp[arr.length];
	}

	
	private int rob1DPBUOptimized(int[] arr) {
		int p1 = 0;
		int p2 = arr[0];
		int p3 = p2;
		
		for (int i = 1; i < arr.length; i++) {
			count++;
			p3 = Math.max(p1 + arr[i], p2);
			p1 = p2;
			p2 = p3;
		}
		
		return p3;
	}
	
	private void rob1DPBU_(int[] arr) {
		count = 0;
		System.out.println("DPBU: " + rob1DPBU(arr) + " " + count);
		count = 0;
		System.out.println("DPBUO: " + rob1DPBUOptimized(arr) + " " + count);
	}

	
    public int rob2Helper(int[] arr, int start, int end) {
		int p1 = 0;
		int p2 = arr[start];
		int p3 = p2;
		
		for (int i = start + 1; i < end; i++) {
			p3 = Math.max(p1 + arr[i], p2);
			p1 = p2;
			p2 = p3;
		}
		
		return p3;

    }
	
    /*
     * Actual solution
     */
    public int rob(int[] nums) {
    	if (nums.length == 1) return nums[0];
        // get max between excluding first index and excluding last index
    	return Math.max(rob2Helper(nums, 1, nums.length), rob2Helper(nums, 0, nums.length - 1));
    }
	
	
	
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 1 };
		int arr2[] = { 1, 2, 3 };
		int arr3[] = { 2, 3, 2 };
		int arr4[] = { 1, 2, 3, 1, 5, 6, 2, 1, 5, 7 };

		HouseRobber2 obj = new HouseRobber2();
		obj.rob1Rec(arr1);
		obj.rob1Rec(arr2);
		obj.rob1Rec(arr3);
		obj.rob1Rec(arr4);

		obj.rob1DP_TD(arr1);
		obj.rob1DP_TD(arr2);
		obj.rob1DP_TD(arr3);
		obj.rob1DP_TD(arr4);

		obj.rob1DPBU_(arr1);
		obj.rob1DPBU_(arr2);
		obj.rob1DPBU_(arr3);
		obj.rob1DPBU_(arr4);

	}
}
