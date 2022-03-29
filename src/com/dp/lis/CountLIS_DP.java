/**
* This class only calculates the maximum possible increasing subsequence.
*/
// package com.dp.lis;

import java.util.Arrays;

public class CountLIS_DP{
	public static long count;
	
	/*
		LIS(i) = 1 if i == 1
		LIS(i) = max(LIS(j)) + 1 if 0 < j < i and a[i] < a[j]
		Time Complexity: O(n ^ 2)  --- Loop + recusion stack
		Space: O(n)
	
	*/
	public static int countLIS_DP_TD_Helper(int [] seq, int n, int memo[]){
		count++;
		// if the length of the subarray is 1
		if (n == 0) return 1;
		
		if (memo[n] != 0) return memo[n];
		
		int maxTillNow = 1;
		
		for(int j = n - 1; j >= 0; j--){
			// get the LIS of previous sub-array
			int currentLIS = countLIS_DP_TD_Helper(seq, j, memo);
			if (seq[n] >= seq[j]){
				currentLIS += 1;
			}
			
			if (maxTillNow  < currentLIS){
				maxTillNow = currentLIS;
			}
		}
		
		memo[n] = maxTillNow;
		
		return maxTillNow;
		
	}
	
	/**
	* This is bottom-up DP implementation but it uses same concept as used in TD approach.
	* It starts in reverse order.
	*
	*/
	public static int countLIS_DP_BU_TD(int [] seq, int n){
		int lis[] = new int[n];
		Arrays.fill(lis, 1);
		
		// from the end of array
		for(int i = n - 1; i >= 0; i--){
			// go forward ((i + 1) the position)from current position 
			for(int j = i + 1; j < n; j++){
				// get the longest sequence from Jth index
				int maxForJ = lis[j];
				count++;
				// compare if current element is less than Jth 
				if (seq[i] < seq[j]){
					maxForJ += 1;
				}
				
				// update the maximum sequence in Ith position
				lis[i] = Math.max(maxForJ, lis[i]);
			}
		}
		
		return lis[0];
	}
	
		
	/**
	* This is bottom-up DP implementation but it uses same concept as used in TD approach.
	* It starts in reverse order.
	*
	*/
	public static int countLIS_DP_BU_BU(int [] seq, int n){
		int lis[] = new int[n];
		Arrays.fill(lis, 1);
				
		// from the end of array
		for(int i = 0; i < n; i++){
			// go forward ((i + 1) the position)from current position 
			for(int j = 0; j < i; j++){
				// get the longest sequence from Jth index
				int maxOnJ = lis[j];
				count++;
				// compare if current element is greater than previous Jth sequence
				if (seq[i] > seq[j]){
					maxOnJ += 1;
				}
				
				// update the maximum sequence in Ith position
				lis[i] = Math.max(maxOnJ, lis[i]);
			}
		}
				printArr(lis);

		return lis[n - 1];
	}
	

	
	public static int countLIS_DP_TD(int [] seq){
		int memo[] = new int[seq.length];
		int lis = countLIS_DP_TD_Helper(seq, seq.length - 1, memo);
		
		for(int i: memo){
			System.out.print(i + ", ");
		}
		System.out.println();
		return lis;
	}
	
	public static void printArr(int arr[]){
		for(int i: arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	    // driver program to test above functions
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
		
		//count = 0;
        //System.out.println("GFG: Length of lis is " + lis(arr, n)+ ", " + count +"\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_TD(arr)+ ", " + count + "\n");
		count = 0;
		System.out.println("SKY: Length of lis is " + countLIS_DP_BU_TD(arr, n)+ ", " + count + "\n");
		count = 0;
		System.out.println("SKY: Length of lis is " + countLIS_DP_BU_BU(arr, n)+ ", " + count + "\n");

		arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		n = arr.length;
		
		// count = 0;
        // System.out.println("GFG: Length of lis is " + lis(arr, n)+ ", " + count +"\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_TD(arr)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_TD(arr, arr.length)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_BU(arr, arr.length)+ ", " + count + "\n");
		
		
		arr = new int[]{5, 3, 2, 6, 7, 8, 2, 4, 1};
		n = arr.length;
		
		// count = 0;
        // System.out.println("GFG: Length of lis is " + lis(arr, n)+ ", " + count +"\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_TD(arr)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_TD(arr, arr.length)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_BU(arr, arr.length)+ ", " + count + "\n");
		
		arr = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
		n = arr.length;
		
		// count = 0;
        // System.out.println("GFG: Length of lis is " + lis(arr, n)+ ", " + count +"\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_TD(arr)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_TD(arr, arr.length)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_BU(arr, arr.length)+ ", " + count + "\n");
		
		arr = new int[]{1};
		n = arr.length;
		
		// count = 0;
        // System.out.println("GFG: Length of lis is " + lis(arr, n)+ ", " + count +"\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_TD(arr)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_TD(arr, arr.length)+ ", " + count + "\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_BU_BU(arr, arr.length)+ ", " + count + "\n");
    }
	

}