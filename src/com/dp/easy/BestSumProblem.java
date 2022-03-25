package com.dp.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSumProblem{
	public static long count;
	
	
	/**
	* Recursive solution to the problem
	* Time: O(n ^ targetSum)
	* As we are copying 
	* Space: O(targetSum * targetSum)
	* As we are maintaining an array of size targetSum in worst case.
	*/
	public static ArrayList<Integer> bestSumRecursion(int targetSum, int [] arr, int n){
		count++;
		// base case
		// if there is no solution
		if (targetSum < 0) return null;
		
		// if there is a solution
		if (targetSum == 0) return new ArrayList<Integer>();
		
		ArrayList<Integer> bestSum = null;

		// now get the best sum
		for(int i = 0; i < n; i++){
			ArrayList<Integer> currentSum = bestSumRecursion(targetSum - arr[i], arr, n);
			
			// check the feasibility of currentSum
			if (currentSum != null){
				// including current element is giving a solution
				currentSum.add(arr[i]);
				
				// if this is first solution
				if (bestSum == null){
					bestSum = currentSum;
				} else{
					// if current solution is better than older solution
					if (currentSum.size() < bestSum.size()){
						bestSum = currentSum;
					}
				}
			}
		}

		return bestSum;
	}
	
	
	/**
	* Helper function for 
	*/
	public static ArrayList<Integer> bestSumTdDpHelper(int targetSum, int [] arr, int n, HashMap<Integer, ArrayList<Integer>> memo){
	
		count++;
		// base case
		// if there is no solution
		if (targetSum < 0) return null;
		
		// if there is a solution
		if (targetSum == 0) return new ArrayList<Integer>();
		
		// check in memo
		if (memo.containsKey(targetSum)){
			// If there is a solution then return it's copy
			return memo.get(targetSum);
			
		}
		
		ArrayList<Integer> bestSum = null;

		// now get the best sum
		for(int i = 0; i < n; i++){
			ArrayList<Integer> currentSum = bestSumTdDpHelper(targetSum - arr[i], arr, n, memo);
			
			// check the feasibility of currentSum
			if (currentSum != null){
				// make a copy
				currentSum = new ArrayList<Integer>(currentSum);

				// including current element is giving a solution
				currentSum.add(arr[i]);
				
				// if this is first solution
				if (bestSum == null){
					bestSum = currentSum;
				} else{
					// if current solution is better than older solution
					if (currentSum.size() < bestSum.size()){
						bestSum = currentSum;
					}
				}
			}
		}
		
		// add bestSum in memo
		memo.put(targetSum, bestSum);

		return bestSum;

	}

	
	/**
	* Top down DP approach
	*
	*/
	public static ArrayList<Integer> bestSumTdDp(int targetSum, int [] arr, int n){
		HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
		// storing here for debug
		ArrayList<Integer> solution = bestSumTdDpHelper(targetSum, arr, n, memo);
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
		System.out.println("Best Sum: " + bestSumRecursion(7, arr1, 2) + " " + 7 + " " + count);
		count = 0;
		System.out.println("Best Sum: " + bestSumRecursion(7, arr2, 2)+ " " + 7 + " " + count);
		count = 0;
		System.out.println("Best Sum: " + bestSumRecursion(7, arr3, 4)+ " " + 7 + " " + count);
		count = 0;
		System.out.println("Best Sum: " + bestSumRecursion(8, arr4, 3)+ " " + 8 + " " + count);
		count = 0;
		System.out.println("Best Sum: " + bestSumRecursion(300, arr5, 2)+ " " + 300 + " " + count);
		
		
		System.out.println("\nDP memoization: ");
		count = 0;
		System.out.println(printArray(arr1) + "Best Sum: " + bestSumTdDp(7, arr1, 2) + " " + 7 + " " + count + "\n");
		count = 0;
		System.out.println(printArray(arr2) + "Best Sum: " + bestSumTdDp(7, arr2, 2)+ " " + 7 + " " + count + "\n");
		count = 0;
		System.out.println(printArray(arr3) + "Best Sum: " + bestSumTdDp(7, arr3, 4)+ " " + 7 + " " + count + "\n");
		count = 0;
		System.out.println(printArray(arr4) + "Best Sum: " + bestSumTdDp(8, arr4, 3)+ " " + 8 + " " + count + "\n");
		count = 0;
		System.out.println(printArray(arr5) + "Best Sum: " + bestSumTdDp(300, arr5, 2)+ " " + 300 + " " + count + "\n");

	}
		
	
	public static String printArray(int [] arr){
		String arrStr = "[";
		for(int i = 0; i < arr.length; i++){
			arrStr += Integer.toString(arr[i]);
			if (i < arr.length - 1){
				arrStr += ", ";
			}
		}
		
		return arrStr + "] ";
	}
}
