/**
This is a decision based problem. 

Write a function 'canConstructRecursion(target, wordBank)' that accepts a
target string and an array of strings.

The function should return a boolean indicating whether or not the 
'target' can be constructed by concatenating elements of the 
'wordBank' array.

You may reuse elements of 'wordBank' as many time as needed.
*/
package com.dp.easy;

import java.util.HashMap;

public class CanConstructProblem{
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
	public static boolean canConstructRecursion(String target, String[] wordBank){
		count++;
		if (target.length() == 0) return true;
		
		for (int i = 0 ; i < wordBank.length; i++){
			
			// check if current string is prefix
			if( isPrefix(wordBank[i], target)){
				if (canConstructRecursion(target.substring(wordBank[i].length()), wordBank)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean canConstructDpTdHelper(String target, String[] wordBank, HashMap<String, Boolean> memo){
		count++;
		// check in DP
		if (memo.containsKey(target)) return memo.get(target);
		if (target.length() == 0) return true;
		
		for (int i = 0 ; i < wordBank.length; i++){
			
			// check if current string is prefix
			if( isPrefix(wordBank[i], target)){
				if (canConstructDpTdHelper(target.substring(wordBank[i].length()), wordBank, memo)){
					memo.put(target, true);
					return true;
				}
			}
		}
			
		memo.put(target, false);
		return false;
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
	public static boolean canConstructDpTd(String target, String[] wordBank){
		HashMap<String, Boolean> memo = new HashMap<>();
		boolean canConstruct = canConstructDpTdHelper(target, wordBank, memo);
		System.out.println(memo);
		return canConstruct;
	}

	
	
	public static void main(String [] args){
		count = 0;
		System.out.println(canConstructRecursion("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}) + " " + count); // true
		count = 0;
		System.out.println(canConstructRecursion("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}) + " " + count);  // false
		count = 0;
		System.out.println(canConstructRecursion("", new String[]{"ab", "abc", "cd"}) + " " + count);
		count = 0;
		System.out.println(canConstructRecursion("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}) + " " + count);
		count = 0;
		System.out.println(canConstructRecursion("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeee"}) + " " + count);
	
		count = 0;
		System.out.println(canConstructDpTd("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}) + " " + count + "\n"); // true
		count = 0;
		System.out.println(canConstructDpTd("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}) + " " + count + " " + count + "\n");  // false
		count = 0;
		System.out.println(canConstructDpTd("", new String[]{"ab", "abc", "cd"}) + " " + count + " " + count + "\n");
		count = 0;
		System.out.println(canConstructDpTd("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}) + " " + count + " " + count + "\n");
		count = 0;
		System.out.println(canConstructDpTd("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeeee", "eeeeeee"}) + " " + count + " " + count + "\n");

	}
}