package com.greedy;

public class JumpGame {

	/**
	 * O(n), O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int maxRange = 0;
		int n = nums.length;
		int i = 0;
		// start from first index, and get the range of jump,
		// on next iteration, if current element is giving more jump
		// then update the maxRange in greedy manner.

		for (; i < n && i <= maxRange; i++) {
			maxRange = Math.max(maxRange, i + nums[i]);
		}

		return i == n;
//	         while(pos < n - 1){
//	             int maxRange = pos + nums[pos];

//	             if (maxRange == pos) return false;

//	             int maxTillNow = pos;

//	             for(int i = pos + 1; i < maxRange && i < n; i++){
//	                 if (maxRange < i + nums[i]){
//	                     maxRange = i + nums[i];
//	                     maxTillNow = i;
//	                 }
//	             }

//	             pos = maxTillNow + (maxTillNow == pos ? nums[pos] : 0);
//	         }

		// return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
