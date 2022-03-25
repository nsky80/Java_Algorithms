package com.dp.lis;

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
	
	
	
	
	
	
	public static int countLIS_DP_TD(int [] seq){
		int memo[] = new int[seq.length];
		int lis = countLIS_DP_TD_Helper(seq, seq.length - 1, memo);
		
		for(int i: memo){
			System.out.print(i + ", ");
		}
		System.out.println();
		return lis;
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
		
		arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		n = arr.length;
		
		// count = 0;
        // System.out.println("GFG: Length of lis is " + lis(arr, n)+ ", " + count +"\n");
		count = 0;
        System.out.println("SKY: Length of lis is " + countLIS_DP_TD(arr)+ ", " + count + "\n");
    }
	

}