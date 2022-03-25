package com.greedy;

import java.util.Arrays;

public class MaximumPlatforms {
	static int findPlatform(int arr[], int dep[], int n) {
		// add your code here
		Arrays.sort(arr);
		Arrays.sort(dep);

		int i = 0;
		int j = 0;

		int maxFoundTill = 0;
		int maxFound = 0;

		for (int k = 0; k < arr.length + dep.length; k++) {
			if (i == arr.length) {
				break;
			}
			if (arr[i] <= dep[j]) {
				maxFoundTill++;
				i++;
			} else {
				maxFoundTill--;
				j++;
			}
			if (maxFoundTill > maxFound) {
				maxFound = maxFoundTill;
			}
		}

		return maxFound;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(findPlatform(arr, dep, 0));

	}

}
