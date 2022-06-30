/**
 * https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 */
package com.greedy;

/**
 * Time: O(n), Space: O(1)
 * 
 * @author satis
 *
 */
public class MergeTripletsToFormTargetTriplet {

	/*
	 * This solution would iterate O(n) times even if there no solution exist,
	 * although it is iterating only once, it would be suitable if the probability
	 * of getting answer is high.
	 */
	class SingleIterationSolution {
		public boolean mergeTriplets(int[][] triplets, int[] target) {
			int n = triplets.length;
			int ans[] = new int[3];

			for (int t = 0; t < n; t++) {
				int triple[] = triplets[t];

				if (triple[0] > target[0] || triple[1] > target[1] || triple[2] > target[2])
					continue;

				for (int i = 0; i < 3; i++) {
					if (triple[i] == target[i])
						ans[i]++;
				}
			}

			return ans[0] > 0 && ans[1] > 0 && ans[2] > 0;

		}
	}

	/**
	 * This solution check each value one by one as soon as it found a value it
	 * stops and start searching for other, if there is no solution exist, then it
	 * terminates quickly.
	 */
	class MoreReadableSolution {
		public boolean mergeTriplets(int[][] triplets, int[] target) {
			return checkTriplets(triplets, target, 0) && checkTriplets(triplets, target, 1)
					&& checkTriplets(triplets, target, 2);
		}

		public boolean checkTriplets(int[][] triplets, int[] target, int j) {
			int a = (j + 1) % 3;
			int b = (j + 2) % 3;
			for (int i = 0; i < triplets.length; i++) {
				if (triplets[i][a] <= target[a] && triplets[i][b] <= target[b] && triplets[i][j] == target[j]) {
					return true;
				}
			}
			return false;
		}
	}

	class LongIterativeSolution {
		public boolean mergeTriplets(int[][] triplets, int[] target) {
			int n = triplets.length;
			boolean found = false;

			for (int i = 0; i < n; i++) {
				if (triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
					found = true;
					break;
				}
			}

			if (!found)
				return false;

			found = false;

			for (int i = 0; i < n; i++) {
				if (triplets[i][0] <= target[0] && triplets[i][1] == target[1] && triplets[i][2] <= target[2]) {
					found = true;
					break;
				}
			}

			if (!found)
				return false;

			found = false;
			for (int i = 0; i < n; i++) {
				if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] == target[2]) {
					found = true;
					break;
				}
			}

			return found;

		}
	}
}
