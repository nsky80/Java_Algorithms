/**
 * https://leetcode.com/problems/gas-station/
 */
package com.greedy;

/**
 * @author Satish Kumar Yadav
 *
 */
public class GasStation {
	/**
	 * O(n^2), O(1): Check for every index, whether it is reaching end or not
	 */
	class BruteForce {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int index = 0;
			int n = gas.length;

			while (index < n) {
				int available = gas[index] - cost[index];
				if (available < 0) {
					index++;
					continue;
				}

				int i = (index + 1) % n;
				boolean flag = true;

				while (i != index) {
					available += gas[i];
					if (available >= cost[i]) {
						available -= cost[i];
					} else {
						flag = false;
						break;
					}
					i = (i + 1) % n;
				}

				if (flag)
					return index;
				index++;
			}

			return -1;
		}
	}

	/**
	 * O(n), O(1): This is 2 pass solution, which first check whether there is
	 * solution or not.
	 */
	class Greedy2Pass {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			// check whether enough gas is available or not
			int totalGas = 0;
			int totalCost = 0;
			for (int i = 0; i < gas.length; i++) {
				totalGas += gas[i];
				totalCost += cost[i];
			}

			if (totalGas < totalCost)
				return -1;

			// here if gas is available then we definately can loop
			// through the solution, target is find the index

			int index = 0;
			int n = gas.length;
			int ans = 0;

			while (index < n) {
				int available = gas[index] - cost[index];
				// we cannot go further
				if (available < 0) {
					index++;
					continue;
				}

				// this index can be potential candidate if it can reach end
				ans = index;
				index++;

				// keep increasing until it reach end or fuel get exahusted
				while (available >= 0 && index < n) {
					available += (gas[index] - cost[index]);
					index++;
				}
			}

			return ans;
		}
	}

	/**
	 * This is 1 Pass solution which runs in O(n), O(1) time and space.
	 */
	class Greedy1Pass {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int start = 0;
			// it will keep track of capacity of the tank
			int tank = 0;
			// it will keep track of total
			int total = 0;

			for (int i = 0; i < gas.length; i++) {
				tank += (gas[i] - cost[i]);
				// if it is negative, it means this is not the index from
				// which we would have started, so update it
				if (tank < 0) {
					// start from the next index
					start = i + 1;

					// but before resetting the tank, record the changes
					// so that it can be verify that available gas >= cost
					// which will complete 1 iteration.
					total += tank;
					tank = 0;
				}
			}

			// now if current status of tank + total is positive then
			// there is a solution exist.
			return (tank + total < 0) ? -1 : start;
		}
	}
}
