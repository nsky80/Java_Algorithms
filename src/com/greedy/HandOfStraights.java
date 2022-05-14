/**
 * https://leetcode.com/problems/hand-of-straights/
 */
package com.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author satis
 *
 */
public class HandOfStraights {

	/**
	 * Time: O(nlogn), Space: O(set(hand))
	 * 
	 * This approach uses treeMap instead of hashMap, it eliminates the need of sorting, loop also
	 * gets optimized when there is so many repeating numbers.
	 */
	class OptimizedShortSolution {
		public boolean isNStraightHand(int[] hand, int groupSize) {
			int n = hand.length;

			// if we would not be able to divide the array into parts of size groupSize
			if (n % groupSize != 0)
				return false;

			// it is sorted
			Map<Integer, Integer> counter = new TreeMap<>();

			for (int num : hand) {
				counter.put(num, counter.getOrDefault(num, 0) + 1);
			}

			for (int current : counter.keySet()) {
				// if it is not utilized
				if (counter.get(current) > 0) {
					// now check whether it is possible to create
					int ck = 0;
					int freq = counter.get(current);

					// if current number forming a group
					while (counter.getOrDefault(current, -1) >= freq && ck < groupSize) {
						counter.put(current, counter.get(current) - freq);
						current++;
						ck++;
					}

					// if group isn't formed then return
					if (ck != groupSize)
						return false;
				}
			}

			return true;
		}
	}

	/**
	 * It uses hashmap and sorts the given input array in-order to get the groups.
	 * Time: O(nlogn), Space: O(n)
	 */
	class OptimizedFirstSolution {
		public boolean isNStraightHand(int[] hand, int groupSize) {
			int n = hand.length;

			// if we would not be able to divide the array into parts of size groupsize
			if (n % groupSize != 0)
				return false;

			Map<Integer, Integer> counter = new HashMap<>();
			// sort the array as it would need to scan the value in non-decreasing order
			Arrays.sort(hand);

			for (int num : hand) {
				counter.put(num, counter.getOrDefault(num, 0) + 1);
			}

			// check group for every number
			for (int current : hand) {

				int ck = 0;

				// if current number forming a group
				while (counter.containsKey(current) && ck < groupSize) {
					int freq = counter.get(current) - 1;

					if (freq == 0)
						counter.remove(current);
					else
						counter.put(current, freq);

					current++;
					ck++;
				}

				// if this number is already included in some other group
				// or it is formed a group then ignore, otherwise return false.
				if (ck != 0 && ck != groupSize) {
					// it means a group is not formed, then return false
					return false;
				}

			}

			return true;
		}
	}

	/**
	 * Time: O(nlogn), Space: O(n)
	 */
	class NaiveFirstSolution {
		public boolean isNStraightHand(int[] hand, int groupSize) {
			Map<Integer, Integer> counter = new HashMap<>();
			Arrays.sort(hand);

			for (int num : hand) {
				counter.put(num, counter.getOrDefault(num, 0) + 1);
			}

			for (int current : hand) {
				int ck = groupSize;
				int curTemp = current;
				while (counter.containsKey(current) && ck > 0) {
					current++;
					ck--;
				}

				if (ck == 0) {
					// it means a group found, then remove the frequency
					current = curTemp;
					ck = groupSize;
					while (ck > 0) {
						int freq = counter.get(current) - 1;

						if (freq == 0)
							counter.remove(current);
						else
							counter.put(current, freq);
						ck--;
						current++;
					}
				}

			}

			return counter.isEmpty();

		}
	}
}
