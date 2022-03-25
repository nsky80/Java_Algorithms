package com.maxSubArrayProblem;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaxProdSubArray {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int maxProduct(final List<Integer> A) {
		int maxProduct = A.get(0);
		for (int i : A) {
			if (i > maxProduct) {
				maxProduct = i;
			}
		}

		int maxTillNow = 1;
		int minTillNow = 1;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == 0) {
				maxTillNow = 1;
				minTillNow = 1;
				continue;
			}

			int current = Math.max(A.get(i), Math.max(maxTillNow * A.get(i), minTillNow * A.get(i)));
			minTillNow = Math.min(A.get(i), Math.min(maxTillNow * A.get(i), minTillNow * A.get(i)));
			maxTillNow = current;

			maxProduct = Math.max(maxProduct, maxTillNow);
		}

		return maxProduct;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr [] = {0, 2, -1, 4, -2};
//		System.out.println(maxProduct(Arrays.asList(0, 2, -1, 4, -2)));
//		System.out.println(maxProduct(Arrays.asList(-2, 3, 4, 5, -1)));
//		System.out.println(maxProduct(Arrays.asList(0, -4, 0, -8)));
//		System.out.println(maxProduct(Arrays.asList(-1, 4, 5, 6, 8)));
//		
		Map<Integer, Integer> map = new TreeMap<>();
		map.put(1, 2);
		map.put(2, 1);
		ArrayList<Integer> arr = new ArrayList<Integer>( map.values());
		System.out.println(arr);
	}

}
