/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
package com.maths.prime;

/**
 * @author satis
 *
 */
public class UglyNumberII {

	/**
	 * An ugly number can be represent as (2^a * 3 ^ b * 5 ^ c) where a, b, c >= 0
	 * Heap Time: O(nlogn) This solution is having O(n) time
	 * 
	 */
	public int nthUglyNumber(int n) {

		int ans[] = new int[n];
		// base case
		ans[0] = 1;

		// these will keep track of indices in which the factor is going to multiply,
		// initially all 3 is going to multiplied to first index that is 1.
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		for (int i = 1; i < n; i++) {
			int v2 = 2 * ans[i2];
			int v3 = 3 * ans[i3];
			int v5 = 5 * ans[i5];

			int current = Math.min(v2, Math.min(v3, v5));
			ans[i] = current;

			// now according to the selection update the value of pointers

			// 2 is selected
			if (current == v2) {
				i2++;
			}

			if (current == v3) {
				i3++;
			}

			if (current == v5) {
				i5++;
			}
		}

		return ans[n - 1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UglyNumberII obj = new UglyNumberII();
		System.out.println(obj.nthUglyNumber(1407));
		
	}

}
