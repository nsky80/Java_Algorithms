package com.dp;

public class KnapsackProblem01BruteForce {
	static int count = 0;;
	static int knapSack(int W, int wt[], int val[], int start, int n) {
		count++;
		System.out.println(start + " " + W);
		if (W == 0 || start >= n || W - wt[start] < 0) {
			return 0;
		}

		return Math.max(knapSack(W - wt[start], wt, val, start + 1, n) + val[start],
				knapSack(W, wt, val, start + 1, n));
	}

	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		
//		int wt[] = {1, 1, 1};
//		int W = 2;
//		int val[] = {10, 20, 30};

		int n = val.length;
		System.out.println(knapSack(W, wt, val, 0, n));
		System.out.println(count);
		
	}

}
