package com.greedy;

public class JumpGameII {
	/**
	 * O(n), O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int reach = 0;
		int end = 0;
		int n = nums.length;
		int jmp = 0;

		// here end pointer is used to prevent the
		// Repetition .
		while (reach < n - 1) {
			reach += nums[reach];

			// If it reaches to the end
			if (reach >= n - 1) {
				jmp++;
				break;
			}

			int s = end + 1;

			int maxInd = reach;
			int maxReach = reach;

			for (int i = s; i <= reach && i < n; i++) {
				if (maxReach < i + nums[i]) {
					maxInd = i;
					maxReach = i + nums[i];
				}
			}
			// It specifies that from next iteration, start comparison from here.
			end = reach;
			jmp++;
			reach = maxInd;
		}

		return jmp;
	}

	/**
	 * It has same time complexity but less complication
	 * 
	 * @param nums
	 * @return
	 */
	public int jumpBFS(int[] nums) {
		int n = nums.length;
		int i = 0;
		int lastReachPos = 0;
		int maxReachable = 0;
		int jmp = 0;
		// kind of BFS
		while (lastReachPos < n - 1) {
			// get the max jump element in current level
			maxReachable = Math.max(maxReachable, i + nums[i]);

			// if 1 level traversed
			if (i == lastReachPos) {
				jmp++;
				lastReachPos = maxReachable;
				maxReachable = 0;
			}

			i++;
		}

		return jmp;
	}
}
