package com.maxSubArrayProblem;

public class MaxSumSubArrayKadanesAlgo {
	
	
	public static int getMaxSum(int arr[]) {
		// It will contain the maximum contiguous array found
		int maxSoFar = Integer.MIN_VALUE;
		int prevMaxPtr = 0;
		
		// It will sum each positive parts
		int maxEndingHere = 0;
		int ptrStartsHere = 0;
		
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			
			// if this sub-array is greater than max sum sub array then update
			if(maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
				prevMaxPtr = ptrStartsHere;
			} 
			
			// If current value is negative, start adding again
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				ptrStartsHere = i + 1;
			}
		}
		
		System.out.println(prevMaxPtr);
		return maxSoFar;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-1, 3, 4, -5, 9, -2};
		System.out.println(getMaxSum(arr));
	}

}
