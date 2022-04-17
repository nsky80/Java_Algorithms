/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
package com.two_pointers;

/**
 * @author satis
 *
 */
public class TrappingRainWater {
	/**
	 * Dynamic O(n), O(n) solution
	 */
    public int trap(int[] height) {
        // O(n) space solution
        int n = height.length;
        if (n == 1) return 0;
        
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];        
        
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int total = 0;
        for(int i = 0; i < n; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (water > 0)
                total += water;
        }
        
        return total;
    }
	
    
    /**
     * O(n) O(1) solution
     * @param height
     * @return
     */
    public int trap2Pointers(int[] height) {
    	int total = 0;
    	int l = 0;
    	int r = height.length - 1;
    	int lmax = l;
    	int rmax = r;
    	
    	while (l <= r) {
    		int water = 0;
    		
    		// bottleneck is left pointer so get the current water
    		if (height[l] <= height[r]) {
    			water = height[lmax] - height[l];
    			if (height[l] > height[lmax]) {
    				lmax = l;
    			}
    			l++;
    		}else {
    			water = height[rmax] - height[r];
    			if (height[r] > height[rmax]) {
    				rmax = r;
    			}
    			r--;
    		}
    		
    		if (water > 0)
    			total += water;
    	}
    	
    	return total;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
