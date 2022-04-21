/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
package com.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author satis
 *
 */
public class UglyNumberII {

	/**
	 * An ugly number can be represent as (2^a * 3 ^ b * 5 ^ c) where a, b, c >= 0
	 * Time: O(nlogn)
	 * 
	 */
	public int nthUglyNumber(int n) {

		int count = 1;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.offer(1l);
		Set<Long> set = new HashSet<>();
		set.add(1l);

		while (count < n) {
			long current = pq.poll();
			long a = current * 2;
			long b = current * 3;
			long c = current * 5;

			if (!set.contains(a)) {
				set.add(a);
				pq.offer(a);
			}

			if (!set.contains(b)) {
				set.add(b);
				pq.offer(b);
			}

			if (!set.contains(c)) {
				set.add(c);
				pq.offer(c);
			}

			count++;
		}

		return (int) (long) pq.poll();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumberII obj = new UglyNumberII();
		System.out.println(obj.nthUglyNumber(1407));
	}

}
