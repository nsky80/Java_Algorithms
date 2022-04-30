/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
package com.arrays;

/**
 * @author satis
 *
 */
public class ProductOfArrayExceptSelf {
	
	/**
	 * O(n), O(1) solution
	 */
	class Solution {
	    public int[] productExceptSelf(int[] nums) {        
	        int ans[] = new int[nums.length];
	        ans[0] = 1;
	        
	        // calculate the product from the left
	        // at ith position it contains the product
	        // of (i - 1) elements
	        for(int i = 1; i < nums.length; i++){
	            ans[i] = ans[i - 1] * nums[i - 1];
	        }
	        
	        // calculate the product from right side as well
	        int right = 1;
	        
	        for(int i = nums.length - 1; i >= 0; i--){
	            ans[i] *= right;
	            right *= nums[i];
	        }
	        
	        return ans;
	    }

	}
	
	/**
	 * O(n), O(n) solution 
	 */
	class AnotherSolution {
	    public int[] productExceptSelf(int[] nums) {
	        int n = nums.length;
	        int forward[] = new int[n + 2];
	        int backward[] = new int[n + 2];
	        
	        forward[0] = 1;
	        forward[n + 1] = 1;
	        backward[0] = 1;
	        backward[n + 1] = 1;
	        
	        for(int i = 1; i <= n; i++){
	            forward[i] = forward[i - 1] * nums[i - 1];
	            backward[n + 1 - i] = backward[n + 2 - i] * nums[n - i];
	        }
	        
	        int ans[] = new int[n];
	        
	        for(int i = 1; i <= n; i++){
	            ans[i - 1] = forward[i - 1] * backward[i + 1];
	        }
	        
	        return ans;
	    }

	}
}
