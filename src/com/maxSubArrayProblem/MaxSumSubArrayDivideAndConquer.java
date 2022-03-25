package com.maxSubArrayProblem;

public class MaxSumSubArrayDivideAndConquer {

	// Find the maximum possible sum in arr[]
	// such that arr[m] is part of it
	static int maxCrossingSum(int arr[], int l, int m, int h) {
		// Include elements on left of mid.
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--) {
			sum = sum + arr[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		// Include elements on right of mid
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + arr[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		// Return sum of elements on left
		// and right of mid
		// returning only left_sum + right_sum will fail for
		// [-2, 1]
		System.out.println("Left sum=" + left_sum + ", right sum = " + right_sum + ", result="
				+ Math.max(left_sum + right_sum, Math.max(left_sum, right_sum)));
		return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
	}

	/**
	 * My solution to get crossover sum element
	 * @param arr
	 * @param p
	 * @param q
	 * @param r
	 * @return
	 */
	public static int maxCrossing(int arr[], int p, int q, int r) {
		int sumOfLeft = Integer.MIN_VALUE;
		int sum = 0;

		// calculate the max sum for left side
		for (int i = q; i >= p; i--) {
			sum += arr[i];

			if (sum > sumOfLeft) {
				sumOfLeft = sum;
			}
		}

		// calculate the max sum for right side
		sum = 0;
		int sumOfRight = Integer.MIN_VALUE;

		for (int i = q + 1; i <= r; i++) {
			sum += arr[i];

			if (sum > sumOfRight) {
				sumOfRight = sum;
			}
		}
		System.out.println(sumOfLeft + " " + sumOfRight);
		// Here sumOfLeft and sumOfRight sum has covered sum of all the array
		return Math.max(sumOfLeft + sumOfRight, Math.max(sumOfRight, sumOfLeft));
	}

	// Returns sum of maximum sum subarray
	// in aa[l..h]
	static int maxSubArraySum(int arr[], int l, int h) {
		for (int i = l; i <= h; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println(" [p = " + l + ", r=" + h + "]");

		// Base Case: Only one element
		if (l == h)
			return arr[l];

		// Find middle point
		int m = (l + h) / 2;

		/*
		 * Return maximum of following three possible cases: a) Maximum subarray sum in
		 * left half b) Maximum subarray sum in right half c) Maximum subarray sum such
		 * that the subarray crosses the midpoint
		 */
		return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m + 1, h)),
				maxCrossing(arr, l, m, h));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int arr[] = { -1, 3, 4 };
		// System.out.println(maxCrossingSum(arr, 0, 1, 2));
		// System.out.println(maxCrossing(arr, 0, 1, 2));
		// int[] arr1 = { -2, 1 };
		// System.out.println(maxCrossingSum(arr1, 0, 1, 1));
		// System.out.println(maxCrossing(arr1, 0, 1, 1));
		//
		// int[] arr2 = { -5, 9, -2 };
		// System.out.println(maxCrossingSum(arr2, 0, 1, 2));
		// System.out.println(maxCrossing(arr2, 0, 1, 2));
		int arr3[] = { -1, 3, 4, -5, 9, -2 };

		System.out.println(maxSubArraySum(arr3, 0, 5));
	}

}
