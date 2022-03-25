/**
* Write a function 'canSum(targetSum, numbers)' that takes in a
* targetSum and an array of numbers as arguments.
* Minimul: Coin Change Problem
* Using: Memoization
*/
package com.dp.easy;

import java.util.Map;
import java.util.HashMap;

public class CanSumProblem{
	static int count = 0;
	
	/**
	* Time complexity: O(n ^ targetSum)
	* Space Complexity: O(targetSum)
	*/
	public static boolean canSumRecursion(int targetSum, int arr[], int n){
		// base conditions
		count++;
		if (targetSum == 0) return true;
		if (targetSum < 0)  return false;
		
		// iterate and include each element and call
		for(int i = 0; i < n; i++){
			if (canSumRecursion(targetSum - arr[i], arr, n)){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean canSumDpTdHelper(int targetSum, int []arr, int n, Map<Integer, Boolean> memo){
		// base cases
		count++;

		if (targetSum == 0) return true;
		if (targetSum < 0 ) return false;
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		
		// now call the funtion recursively and find out subproblems
		for(int i = 0; i < n; i++){
			if(canSumDpTdHelper(targetSum - arr[i], arr, n, memo)){
				memo.put(targetSum, true);
				return true;
			}
		}
		
		memo.put(targetSum, false);
		return false;
	}
	
	/**
	* Time: O(n * targetSum)
	* Space: O(targetSum)
	*/
	public static boolean canSumDpTd(int targetSum, int arr[], int n){
		Map<Integer, Boolean> memo = new HashMap<>();
		boolean flag = canSumDpTdHelper(targetSum, arr, n, memo);
		System.out.println(memo);
		return flag;
	}
	
	public static void main(String [] args){
		int arr[] = {2, 3};
		int arr1[] = {2, 4};
		int arr2[] = {5, 3, 4, 7};
		int arr3[] = {2, 3, 5};
		int arr4[] = {7, 14};
		
		System.out.println("Brute Force: ");
		count = 0;
		System.out.println(canSumRecursion(7, arr, 2) + " " + count);
		count = 0;
		System.out.println(canSumRecursion(7, arr1, 2)+ " " + count);
		count = 0;
		System.out.println(canSumRecursion(7, arr2, 4)+ " " + count);
		count = 0;
		System.out.println(canSumRecursion(8, arr3, 3)+ " " + count);
		count = 0;
		System.out.println(canSumRecursion(300, arr4, 2)+ " " + count);
		
		System.out.println("\nDP memoization: ");
		count = 0;
		System.out.println(canSumDpTd(7, arr, 2) + " " + count + "\n");
		count = 0;
		System.out.println(canSumDpTd(7, arr1, 2)+ " " + count + "\n");
		count = 0;
		System.out.println(canSumDpTd(7, arr2, 4)+ " " + count + "\n");
		count = 0;
		System.out.println(canSumDpTd(8, arr3, 3)+ " " + count + "\n");
		count = 0;
		System.out.println(canSumDpTd(300, arr4, 2)+ " " + count + "\n");

	}
	
}