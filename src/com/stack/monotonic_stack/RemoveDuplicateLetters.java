/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
package com.stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Satish Kumar Yadav
 *
 */
public class RemoveDuplicateLetters {
	/**
	 * Here, first we're counting the frequency of the characters and then constructing the string,
	 * It maintains a monotonic stack which contains the characters in increasing order, it pops 
	 * greater characters if they have more frequency, i.e. they're available in future.
	 * 
	 * Time: O(n), Space: O(n)
	 * @author satis
	 *
	 */
	class Solution {
	    public String removeDuplicateLetters(String s) {
	    	// included used to ensure whether present character is added into solution or not.
	        boolean [] included = new boolean[26];
	        
	        // It would be count the frequency
	        int [] freq = new int[26];
	        
	        // counting the frequency
	        for(int i = 0; i < s.length(); i++){
	            freq[s.charAt(i) - 'a'] += 1;
	        }
	        
	        Deque<Character> sb = new ArrayDeque<>();
	        
	        // now going through each and every character
	        for(int i = 0; i < s.length(); i++){
	            char current = s.charAt(i);
	            
	            // remove the top of the stack if it is greater than current element and having 
	            // available frequency in future, it also ensures, if current character already 
	            // included then simply discard this.
	            while (!sb.isEmpty() && sb.peekFirst() > current && !included[current - 'a'] && freq[sb.peekFirst() - 'a'] > 0){
	                included[sb.pop() - 'a'] = false;
	            }
	            
	            if (!included[current - 'a']){
	                sb.push(current);
	                included[current - 'a'] = true;
	            }
	            
	            freq[current - 'a'] -= 1;
	        }
	        
	        // create the string from the stack.
	        StringBuilder str = new StringBuilder(sb.size());
	        while(!sb.isEmpty()){
	            str.append(sb.pop());
	        }
	        
	        return new String(str.reverse());
	    }
	}
}
