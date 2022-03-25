  package com.dp.easy;
import java.util.Arrays;
//import java.util.Stack;

public class MinimumNumberOfJumps {
	static int searchMinCost(int[] arr, int start, int end) {
		int min = Integer.MAX_VALUE;

		for (int i = start; i <= end; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	static int minJumps(int[] arr) {
		// your code here
		int n = arr.length;
		int counter = 0;

		int minCost[] = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == 0) {
				if (i == n - 1) {
					minCost[i] = 0;
				} else {
					minCost[i] = Integer.MAX_VALUE;
				}
			} else if (arr[i] >= counter) {
				minCost[i] = 1;
			} else {
				int min = searchMinCost(minCost, n - counter, n - counter - 1 + arr[i]);

				if (min == Integer.MAX_VALUE) {
					minCost[i] = min;
				} else {
					minCost[i] = min + 1;
				}
			}
			counter++;
		}

		return minCost[0] != Integer.MAX_VALUE ? minCost[0] : -1;

	}

	/**
	* This is another O(n^2) solution
	*
	*/
	static int minJumpsUsingConventionalDP(int [] arr){
		int n = arr.length;
		int minJump[] = new int[n];
		int tracker[] = new int[n];
		
		// initializing the base condition
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[0] = 0;
		tracker[0] = 0;
		
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				// check reachability
				if(j + arr[j] >= i){
					if(minJump[j] + 1 < minJump[i]){
						minJump[i] = minJump[j] + 1;
						tracker[i] = j;
					}
				}
			}
		}
		
		return minJump[n - 1] == Integer.MAX_VALUE ? -1 : minJump[n - 1];
	}
	
	/**
	* This is O(n) solution with O(1) space.
	*/
	static int minJumpsUsingOptimal(int [] arr){
		// check for the base case
		if(arr.length <= 1)
			return 0;
		
		// we cannot move further
		if(arr[0] == 0)
			return -1;
		
		// initializing the variables
		// it'll keep track the maximum reachability from ith index
		int maxReach = arr[0];
		int jump = 1;
		// it'll keep track of possible steps we can take for next move
		// from previous jump
		int steps = arr[0];  
		
		int n = arr.length;
		
		// iterating for solution
		for(int i = 1; i < n; i++){
			// check if we reached at end
			if(i == n - 1)
				break;
			
			// update the maxReach from the ith element
			maxReach = Math.max(maxReach, i + arr[i]);
			
			// decrement the steps
			steps--;
			
			// check whether steps exhausted or not
			if(steps == 0){
				// till ith we can reach from previous
				steps = maxReach - i;
				jump++;
			}
			
			// if we cannot reach end, i.e. maxReach exhausted
			if(i >= maxReach){
				jump = -1;
				break;
			}
		}
		
		return jump;
		
	}
	
	
	public static void main(String[] args) {
//		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		 int arr[] = {1, 0, 0};
		System.out.println(minJumpsUsingOptimal(arr));
//		Stack<Integer> s;
		
	}
}
