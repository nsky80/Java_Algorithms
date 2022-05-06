/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish
 *
 */
public class RemoveAllAdjacentDuplicatesInStringII {
	static class Pair{
	    char chr;
	    int freq;
	    
	    Pair(char c){
	        chr = c;
	        freq = 1;
	    }
	}

	/**
	 * This is stack based solution which keeps the frequency of each element,
	 * as soon as the frequency of the top element equals to k, it pops that element out.
	 * At last, using stack create a new string.
	 */
	class Solution {
	    public String removeDuplicates(String s, int k) {
	        Deque<Pair> stack = new ArrayDeque<>();
	        
	        for(int i = 0; i < s.length(); i++){
	            // if the current element is already present in stack
	            if (!stack.isEmpty() && stack.peek().chr == s.charAt(i)){
	                    stack.peek().freq++;
	            }
	            else{
	                stack.offerFirst(new Pair(s.charAt(i)));
	            }
	            
	            // 
	            if (stack.peek().freq == k)
	                stack.pop();
	        }
	        
	        // create a new string from the available characters
	        StringBuilder br = new StringBuilder();
	        while(!stack.isEmpty()){
	            Pair top = stack.pollLast();
	            // there might be a case where a character could have
	            // present multiple times.
	            for(int i = 0; i < top.freq; i++){
	                br.append(top.chr);
	            }
	        }
	        
	        return new String(br);
	    }
	}
}
