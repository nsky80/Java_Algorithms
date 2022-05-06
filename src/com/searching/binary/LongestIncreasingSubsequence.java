/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
package com.searching.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author satis
 *
 */
public class LongestIncreasingSubsequence {
	/**
	 * This is a O(nlogn), O(n) solution, which uses an array to keep track of numbers,
	 * Reference:
	 * https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308/C%2B%2BPython-DP-Binary-Search-BIT-Solutions-Picture-explain-O(NlogN)
	 */
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	        List<Integer> dp = new ArrayList<>();
	        dp.add(nums[0]);
	        
	        for(int i = 1; i < nums.length; i++){
	            if (dp.get(dp.size() - 1) < nums[i]){
	                dp.add(nums[i]);
	            }else{
	                // get the index of the number which is next >= nums[i]
	                // and replace that
	                dp.set(getIndex(dp, nums[i]), nums[i]);
	            }
	        }
	        
	        return dp.size();
	    }
	    
	    
	    // this is binary search
	    private int getIndex(List<Integer> arr, int val){
	        int s = 0;
	        int e = arr.size() - 1;
	        
	        while (s <= e){
	            int m = s + (e - s) / 2;
	            if (arr.get(m) == val)
	                return m;
	            
	            if (val > arr.get(m))
	                s = m + 1;
	            else 
	                e = m - 1;
	        }
	        
	        // instead of returning -1, it'll return the position 
	        // of next greater element
	        return s;
	    }
	}
}
