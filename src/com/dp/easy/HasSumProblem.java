/**
* Write a function 'hasSum(targetSum, numbers)' that takes in a
* targetSum and an array of numbers as arguments and return element needed to 
* find the target sum else null if no solution exist.
* Minimul: Coin Change Problem
* Using: Memoization
*/
package com.dp.easy;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class HasSumProblem{
	static long count = 0;
	
	/**
	* Time complexity: O(n ^ targetSum) * targetSum 
	* Space Complexity: O(targetSum)
	*/
	public static List<Integer> hasSumRecursion(int targetSum, int arr[], int n){
		// base conditions
		count++;
		
		// if there is a solution then return an array
		if (targetSum == 0) return new ArrayList<Integer>();
		if (targetSum < 0)  return null;
		
		// create a reference of array for adding the values
		List<Integer> includedVal = null;
		
		
		// iterate and include each element and call
		for(int i = 0; i < n; i++){
			includedVal = hasSumRecursion(targetSum - arr[i], arr, n);
			if (includedVal != null){
				// if current value is giving a solution then add into array and return 
				includedVal.add(arr[i]);
				return includedVal;
			}
		}
		
		// if there is no solution it'll return null
		return includedVal;
	}
	
	public static List<Integer> hasSumDpTdHelper(int targetSum, int []arr, int n, Map<Integer, List<Integer>> memo){
		// base cases
		count++;

		if (targetSum == 0) return new ArrayList<Integer>();
		if (targetSum < 0 ) return null;
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		
		// now call the funtion recursively and find out subproblems
		for(int i = 0; i < n; i++){
			List<Integer> subSol = hasSumDpTdHelper(targetSum - arr[i], arr, n, memo);
			if(subSol != null){
				// add current element into a separate solution array and return 
				subSol = new ArrayList<Integer>(subSol);
				subSol.add(arr[i]);
				// add into memo
				memo.put(targetSum, subSol);
				return subSol;
			}
		}
		
		memo.put(targetSum, null);
		return null;
	}
	
	public static List<Integer> hasSumDpTd(int targetSum, int arr[], int n){
		Map<Integer, List<Integer>> memo = new HashMap<>();
		List<Integer> solution = hasSumDpTdHelper(targetSum, arr, n, memo);
		System.out.println(memo);
		return solution;
	}
	
	public static void main(String [] args){
		int arr1[] = {2, 3};
		int arr2[] = {2, 4};
		int arr3[] = {5, 3, 4, 7};
		int arr4[] = {2, 3, 5};
		int arr5[] = {7, 14};
		
		System.out.println("Brute Force: ");
		count = 0;
		System.out.println(hasSumRecursion(7, arr1, 2) + " " + 7 + " " + count);
		count = 0;
		System.out.println(hasSumRecursion(7, arr2, 2)+ " " + 7 + " " + count);
		count = 0;
		System.out.println(hasSumRecursion(7, arr3, 4)+ " " + 7 + " " + count);
		count = 0;
		System.out.println(hasSumRecursion(8, arr4, 3)+ " " + 8 + " " + count);
		count = 0;
		System.out.println(hasSumRecursion(300, arr5, 2)+ " " + 300 + " " + count);
		
		
		System.out.println("\nDP memoization: ");
		count = 0;
		System.out.println(hasSumDpTd(7, arr1, 2) + " " + 7 + " " + count + "\n");
		count = 0;
		System.out.println(hasSumDpTd(7, arr2, 2)+ " " + 7 + " " + count + "\n");
		count = 0;
		System.out.println(hasSumDpTd(7, arr3, 4)+ " " + 7 + " " + count + "\n");
		count = 0;
		System.out.println(hasSumDpTd(8, arr4, 3)+ " " + 8 + " " + count + "\n");
		count = 0;
		System.out.println(hasSumDpTd(300, arr5, 2)+ " " + 300 + " " + count + "\n");

	}
	
}