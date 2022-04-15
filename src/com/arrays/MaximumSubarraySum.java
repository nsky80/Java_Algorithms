/**
 * https://leetcode.com/problems/maximum-subarray/
 */
package com.arrays;

public class MaximumSubarraySum {
	/**
	 * Time: O(n)
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        // update maxSum at every step
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
}
