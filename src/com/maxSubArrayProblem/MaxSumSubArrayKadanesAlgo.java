package com.maxSubArrayProblem;

public class MaxSumSubArrayKadanesAlgo {
	
	
	public static int getMaxSum(int arr[]) {
		// It will contain the maximum contiguous array found
		int maxSoFar = Integer.MAX_VALUE;
		
		// It will sum each positive parts
		int maxEndingHere = 0;
		
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			
			// if this sub-array is greater than max sum sub array then update
			if(maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			} 
			
			// If current value is negative, start adding again
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
		}
		
		return maxSoFar;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-1, 3, 4, -5, 9, -2};
		System.out.println(getMaxSum(arr));
	}

}
