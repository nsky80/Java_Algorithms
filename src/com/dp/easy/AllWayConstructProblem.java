/**
This problem is extension to CountConstructProblem and CanConstructProblem.

CanConstruct Problem: 
	This is a decision based problem. 

	Write a function 'allConstructRecursion(target, wordBank)' that accepts a
	target string and an array of strings.

	The function should return a boolean indicating whether or not the 
	'target' can be contructed by concatenating elements of the 
	'wordBank' array.

	You may reuse elements of 'wordBank' as many time as needed.
*/
package com.dp.easy;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class AllWayConstructProblem{

	static long count;
	
	public static boolean isPrefix(String prefix, String str){
		return str.startsWith(prefix);
	}
	
	
	/**
	* m = target.length
	* n = wordBank.length
	* - Time Complexity : O(n ^ m * m)
	* Here extra m for the prefix check and copy i.e. making substring of string
	*
	*
	* Space: O(m * m) - As there is a copy of string i.e. substring which is extra
	* and it would be available in every stack call.
	*/
	public static ArrayList<ArrayList<String>> allConstructRecursionHelper(String target, String[] wordBank){
		count++;
		ArrayList<ArrayList<String>> numberOfWays = new ArrayList<ArrayList<String>>();
		
		if (target.length() == 0) {
			numberOfWays = new ArrayList<ArrayList<String>>();
			numberOfWays.add(new ArrayList<String>());
		}
		// for iteration purpose
		ArrayList<ArrayList<String>> temp = null;
		
		for (int i = 0 ; i < wordBank.length; i++){
			
			// check if current string is prefix
			if( isPrefix(wordBank[i], target)){
				temp = allConstructRecursionHelper(target.substring(wordBank[i].length()), wordBank);
				
				if(temp.size() != 0){
					
					// add current word into copy of array
					// although for recursive version, deep copy is not required.
					for (int j = 0; j < temp.size(); j++){
						ArrayList<String> deepCopy = new ArrayList<String>();
						deepCopy.add(wordBank[i]);
						deepCopy.addAll(new ArrayList<String>(temp.get(j)));
												
						// put the deep copy into numberOfWays 
						numberOfWays.add(deepCopy);
					}
				}
			}
		}
		
		return numberOfWays;
	}
	
	public static ArrayList<ArrayList<String>> allConstructRecursion(String target, String[] wordBank){
		ArrayList<ArrayList<String>> solution = allConstructRecursionHelper(target, wordBank);
				
		// if (solution != null){
			// for(int i = 0; i < solution.size(); i++){
				// Collections.reverse(solution.get(i));
			// }
		// }
		
		return solution;
	}
	
	public static int allConstructDpTdHelper(String target, String[] wordBank, HashMap<String, Integer> memo){
		count++;
		// check in DP
		if (memo.containsKey(target)) return memo.get(target);
		if (target.length() == 0) return 1;
		
		int numberOfWays = 0;
		
		for (int i = 0 ; i < wordBank.length; i++){
			
			// check if current string is prefix
			if( isPrefix(wordBank[i], target)){
				numberOfWays += allConstructDpTdHelper(target.substring(wordBank[i].length()), wordBank, memo);
			}
		}
		
			
		memo.put(target, numberOfWays);
		return numberOfWays;
	}
	
	
	/**
	* Here Time complexity reduced to O(m^2 * n)
	* m - for stack calls- each stack has a overhead of n and for every n there is a overhead of m
	* for prefix comparision
	*
	* Space complexity O(m ^ 2 + m) => O(m^2)
	* Memo object
	*
	*/
	public static int allConstructDpTd(String target, String[] wordBank){
		HashMap<String, Integer> memo = new HashMap<>();
		int allConstruct = allConstructDpTdHelper(target, wordBank, memo);
		System.out.println(memo);
		return allConstruct;
	}

	
	
	public static void main(String [] args){
		count = 0;
		System.out.println(allConstructRecursion("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}) + " " + count); // true
		count = 0;
		System.out.println(allConstructRecursion("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}) + " " + count);  // false
		count = 0;
		System.out.println(allConstructRecursion("", new String[]{"ab", "abc", "cd"}) + " " + count);
		count = 0;
		System.out.println(allConstructRecursion("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}) + " " + count);
		count = 0;
		System.out.println(allConstructRecursion("eeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeee"}) + " " + count);
		count = 0;
		System.out.println(allConstructRecursion("purple", new String[]{"purp", "p", "ur", "le", "purpl"}) + " " + count + "\n");
	
		
		/*
		count = 0;
		System.out.println(allConstructDpTd("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}) + " " + count + "\n"); // true
		
		count = 0;
		System.out.println(allConstructDpTd("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}) + " " + count + "\n");  // false
		count = 0;
		System.out.println(allConstructDpTd("", new String[]{"ab", "abc", "cd"}) + " " + count + "\n");
		count = 0;
		System.out.println(allConstructDpTd("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}) + " " + count + "\n");
		count = 0;
		System.out.println(allConstructDpTd("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeee"}) + " " + count + "\n");
		count = 0;
		System.out.println(allConstructDpTd("purple", new String[]{"purp", "p", "ur", "le", "purpl"}) + " " + count + "\n");
		*/
	}

	
}