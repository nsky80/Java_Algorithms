package com.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DeleteandEarn {
	static int count;

	static class Wrap {
		Integer count;
		Integer value;
		Integer weight;

		Wrap(Integer v, Integer c) {
			count = c;
			value = v;
			weight = c * v;
		}

		@Override
		public String toString() {
			return "[c=" + count + ", v=" + value + ", w=" + weight + "]";
		}

	}

	/**
	 * Greedy fails for : int[] arr3 = {5, 5, 5, 6, 6, 6, 6, 7, 7};
	 * 
	 * @param nums
	 * @return
	 */
	public int deleteAndEarnGreedy(int[] nums) {
		Map<Integer, Integer> counter = new HashMap<>();

		for (int n : nums) {
			counter.put(n, counter.getOrDefault(n, 0) + 1);
		}

		Wrap w[] = new Wrap[counter.size()];
		int c = 0;
		for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
			w[c++] = new Wrap(e.getKey(), e.getValue());
		}

		Arrays.sort(w, new Comparator<Wrap>() {
			public int compare(Wrap o1, Wrap o2) {
				return o2.weight - o1.weight;
			}
		});
		System.out.println(counter);
		for (Wrap obj : w) {
			System.out.print(obj);
		}
		System.out.println();

		int ans = 0;
		Set<Integer> deleted = new HashSet<>();
		for (Wrap obj : w) {
			if (deleted.contains(obj.value)) {
				continue;
			} else {
				System.out.println(obj);
				ans += obj.weight;
				if (counter.containsKey(obj.value - 1)) {
					deleted.add(obj.value - 1);
				}
				if (counter.containsKey(obj.value + 1)) {
					deleted.add(obj.value + 1);
				}
			}
		}

		return ans;
	}

	public int deleteAndEarnRecursive(int[] nums) {
		Map<Integer, Integer> counter = new HashMap<>();

		for (int n : nums) {
			counter.put(n, counter.getOrDefault(n, 0) + 1);
		}

		Set<Integer> keys = new HashSet<>(counter.keySet());

		int count = 0;
		count = getMax(keys, counter, keys.iterator().next());

		return count;
	}

	private int getMax(Set<Integer> keys, Map<Integer, Integer> counter, Integer current) {
		count++;
		if (keys.isEmpty())
			return 0;
		int sumByIncl = current * counter.get(current);
		int sumByExcl = 0;

		// include current into the solution
		keys.remove(current);
		boolean flag1 = keys.remove(current - 1);
		boolean flag2 = keys.remove(current + 1);
		Iterator<Integer> itr = keys.iterator();
		if (itr.hasNext())
			sumByIncl += getMax(keys, counter, itr.next());

		// exclude current from the solution
		// as we're leaving current key so if flags are set then add them into the set
		if (flag1)
			keys.add(current - 1);
		if (flag2)
			keys.add(current + 1);
		Iterator<Integer> itr2 = keys.iterator();
		if (itr2.hasNext())
			sumByExcl += getMax(keys, counter, itr2.next());
		return Math.max(sumByIncl, sumByExcl);
	}

	public int deleteAndEarnTD_DP(int[] nums) {
		Map<Integer, Integer> counter = new HashMap<>();

		for (int n : nums) {
			counter.put(n, counter.getOrDefault(n, 0) + 1);
		}

		Set<Integer> keys = new HashSet<>(counter.keySet());
		Map<Integer, Integer> memo = new HashMap<>();
		int count = 0;
		count = getMaxTD_DP(keys, counter, keys.iterator().next(), memo);

		return count;
	}

	private int getMaxTD_DP(Set<Integer> keys, Map<Integer, Integer> counter, Integer current,
			Map<Integer, Integer> memo) {
//		count++;
		if (keys.isEmpty())
			return 0;

		if (memo.containsKey(current))
			return memo.get(current);

		int sumByIncl = current * counter.get(current);
		int sumByExcl = 0;

		// include current into the solution
		keys.remove(current);
		boolean flag1 = keys.remove(current - 1);
		boolean flag2 = keys.remove(current + 1);
		Iterator<Integer> itr = keys.iterator();
		if (itr.hasNext())
			sumByIncl += getMaxTD_DP(keys, counter, itr.next(), memo);

		// exclude current from the solution
		// as we're leaving current key so if flags are set then add them into the set
		if (flag1)
			keys.add(current - 1);
		if (flag2)
			keys.add(current + 1);
		Iterator<Integer> itr2 = keys.iterator();
		if (itr2.hasNext())
			sumByExcl += getMaxTD_DP(keys, counter, itr2.next(), memo);
		memo.put(current, Math.max(sumByIncl, sumByExcl));
		return memo.get(current);
	}

	public static void main(String[] args) {
		DeleteandEarn obj = new DeleteandEarn();
		int[] arr1 = { 2, 2, 3, 3, 3, 4 };
		int[] arr2 = { 8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4 };
		int[] arr4 = { 34, 35, 36, 101, 104, 105, 106, 107, 108, 109, 78, 45, 23, 88, 89, 38, 39, 1, 4, 3, 2, 5, 9, 1,
				4, 66, 3, 1, 3, 4, 22, 3 };
		int[] arr3 = { 5, 5, 5, 6, 6, 6, 6, 7, 7 };
		int[] arr5 = { 8, 7, 3, 8, 1, 4, 10, 10, 10, 2 };
		count = 0;
		System.out.println(obj.deleteAndEarnRecursive(arr1) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnRecursive(arr2) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnRecursive(arr3) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnRecursive(arr4) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnRecursive(arr5) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnTD_DP(arr1) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnTD_DP(arr2) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnTD_DP(arr3) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnTD_DP(arr4) + " " + count);
		count = 0;
		System.out.println(obj.deleteAndEarnTD_DP(arr5) + " " + count);
	}

}
