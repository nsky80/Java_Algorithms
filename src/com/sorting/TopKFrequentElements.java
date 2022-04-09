/**
 * URL: https://leetcode.com/problems/top-k-frequent-elements/
 */

package com.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	/**
	 * Using HashTable and Sorting. nlogn
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int num : nums) {
			cnt.put(num, cnt.getOrDefault(num, 0) + 1);
		}

		List<Entry<Integer, Integer>> list = new ArrayList<>(cnt.entrySet());
		System.out.println(list);
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		System.out.println(list);

		int kVal[] = new int[k];
		for (int i = 0; i < k; i++) {
			kVal[i] = list.get(i).getValue();
		}
		return kVal;
	}
	
	
	/**
	 * Using Heap
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int num : nums) {
			cnt.put(num, cnt.getOrDefault(num, 0) + 1);
		}
		
		// creating min heap
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Entry<Integer, Integer> e: cnt.entrySet()) {
			if (pq.size() < k) {
				pq.offer(e);
			}else {
				Entry<Integer, Integer> top = pq.peek();
				if (top.getValue() < e.getValue()) {
					pq.poll();
					pq.offer(e);
				}
			}
		}
		
		int kVal[] = new int[k];
		int t = k - 1;
		while(t >= 0) {
			kVal[t--] = pq.poll().getKey();
		}
		
		return kVal;
	}
	
	
	/**
	 * https://leetcode.com/problems/top-k-frequent-elements/discuss/740374/Python-5-lines-O(n)-buckets-solution-explained
	 * O(n) bucket sort solution
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int num : nums) {
			cnt.put(num, cnt.getOrDefault(num, 0) + 1);
		}

		int n = nums.length;

		
		List<List<Integer>> bucket= new ArrayList<>(n + 1);
		for(int i = 0; i <= n; i++) {
			bucket.add(new ArrayList<>());
		}
		
		
		// It'll add number at it's frequency 
		for(Entry<Integer, Integer> e: cnt.entrySet()) {
			int val = e.getKey();
			int freq = e.getValue();
			
			bucket.get(freq).add(val);
		}
//		System.out.println(bucket);
		// now get the k values from the vault
		int kVal[] = new int[k];
		int i = n;
		int t = 0;
		while(t < k) {
			List<Integer> arr = bucket.get(i--);
			if (arr.size() > 0) {
				for(int v = 0; v < arr.size() && t < k; v++){
					kVal[t++] = arr.get(v);
				}
			}
		}
		
		return kVal;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 2, 2, 3, 4, 4};
		TopKFrequentElements obj = new TopKFrequentElements();
		int []ans = obj.topKFrequent2(nums, 2);
		
		for(int v: ans) {
			System.out.println(v);
		}
	}

}
