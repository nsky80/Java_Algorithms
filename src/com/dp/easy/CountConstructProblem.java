/**
This problem is extension to CanConstructProblem, here we are focusing on
number of ways by which we can create target string using given wordBank array of string.

CanConstruct Problem: 
	This is a decision based problem. 

	Write a function 'countConstructRecursion(target, wordBank)' that accepts a
	target string and an array of strings.

	The function should return a boolean indicating whether or not the 
	'target' can be contructed by concatenating elements of the 
	'wordBank' array.

	You may reuse elements of 'wordBank' as many time as needed.
*/
package com.dp.easy;

import java.util.HashMap;

public class CountConstructProblem{
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
	public static int countConstructRecursion(String target, String[] wordBank){
		count++;
		if (target.length() == 0) return 1;
		
		int numberOfWays = 0;
		
		for (int i = 0 ; i < wordBank.length; i++){
			
			// check if current string is prefix
			if( isPrefix(wordBank[i], target)){
				numberOfWays += countConstructRecursion(target.substring(wordBank[i].length()), wordBank);
			}
		}
		
		return numberOfWays;
	}
	
	public static int countConstructDpTdHelper(String target, String[] wordBank, HashMap<String, Integer> memo){
		count++;
		// check in DP
		if (memo.containsKey(target)) return memo.get(target);
		if (target.length() == 0) return 1;
		
		int numberOfWays = 0;
		
		for (int i = 0 ; i < wordBank.length; i++){
			
			// check if current string is prefix
			if( isPrefix(wordBank[i], target)){
				numberOfWays += countConstructDpTdHelper(target.substring(wordBank[i].length()), wordBank, memo);
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
	public static int countConstructDpTd(String target, String[] wordBank){
		HashMap<String, Integer> memo = new HashMap<>();
		int countConstruct = countConstructDpTdHelper(target, wordBank, memo);
		System.out.println(memo);
		return countConstruct;
	}

	
	
	public static void main(String [] args){
		count = 0;
		System.out.println(countConstructRecursion("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}) + " " + count); // true
		count = 0;
		System.out.println(countConstructRecursion("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}) + " " + count);  // false
		count = 0;
		System.out.println(countConstructRecursion("", new String[]{"ab", "abc", "cd"}) + " " + count);
		count = 0;
		System.out.println(countConstructRecursion("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}) + " " + count);
		count = 0;
		System.out.println(countConstructRecursion("eeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeee"}) + " " + count);
		count = 0;
		System.out.println(countConstructRecursion("purple", new String[]{"purp", "p", "ur", "le", "purpl"}) + " " + count + "\n");
	
		
		count = 0;
		System.out.println(countConstructDpTd("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}) + " " + count + "\n"); // true
		
		count = 0;
		System.out.println(countConstructDpTd("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}) + " " + count + "\n");  // false
		count = 0;
		System.out.println(countConstructDpTd("", new String[]{"ab", "abc", "cd"}) + " " + count + "\n");
		count = 0;
		System.out.println(countConstructDpTd("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}) + " " + count + "\n");
		count = 0;
		System.out.println(countConstructDpTd("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeee"}) + " " + count + "\n");
		count = 0;
		System.out.println(countConstructDpTd("purple", new String[]{"purp", "p", "ur", "le", "purpl"}) + " " + count + "\n");
		
	}
}