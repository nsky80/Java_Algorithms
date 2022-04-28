/**
 * https://leetcode.com/problems/two-sum/
 */
package com.two_pointers;

public class TwoSumII {
	/**
	 * Time: O(n), Space: O(1)
	 */
	class TwoPointers {
	    public int[] twoSum(int[] numbers, int target) {
	        int left = 0;
	        int right = numbers.length - 1;
	        while(left < right){
	            int sum = numbers[left] + numbers[right];
	            if (sum == target)
	                return new int[]{left + 1, right + 1};
	            if (sum > target)
	                right--;
	            else
	                left++;
	        }
	        
	        return null;
	    }
	}
	
	
	/**
	 * Time: O(nlogn), Space: O(1)
	 */
	class BinarySearch {
	    public int[] twoSum(int[] numbers, int target) {
	        for(int i = 0; i < numbers.length; i++){
	            int ind = binarySearch(numbers, i, target - numbers[i]);
	            if (ind != -1){
	                return i > ind ? new int[]{ind + 1, i + 1} : new int[]{i + 1, ind + 1};
	            }
	        }
	        
	        return null;
	    }
	    
	    private int binarySearch(int [] arr, int avoidIndex, int target){
	        int start = 0;
	        int end = arr.length;
	        
	        while(start < end){
	            int mid = (start + end) / 2;
	            
	            if (arr[mid] == target && mid != avoidIndex)
	                return mid;
	            
	            if (arr[mid] < target)
	                start = mid + 1;
	            else
	                end = mid;
	        }
	        
	        return -1;
	    }
	}
}
