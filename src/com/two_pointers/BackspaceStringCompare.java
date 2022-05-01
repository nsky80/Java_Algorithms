/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
package com.two_pointers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class BackspaceStringCompare {
	/**
	 * Here, it scans the string from back and skips the characters which are bounded to #.
	 * Time: O(n + m), space: O(1) 
	 */
	class TwoPointerSolution {
	    public boolean backspaceCompare(String s, String t) {
	        int i = s.length() - 1;
	        int j = t.length() - 1;
	        
	        int skipS = 0;
	        int skipT = 0;
	        
	        // iterate in reverse order and skip the characters
	        // having backtracked
	        while(i >= 0 || j >= 0){
	            
	            // skip i while it has backspace
	            while(i >= 0){
	                // get the count of consecutive backspaces
	                if (s.charAt(i) == '#'){
	                    skipS++;
	                    i--;
	                } else if(skipS > 0){
	                    // now skip the alphabet
	                    skipS--;
	                    i--;
	                }else{
	                    break;
	                }
	            }
	            
	            // same thing for 2nd string
	            while(j >= 0){
	                if (t.charAt(j) == '#'){
	                    skipT++;
	                    j--;
	                }else if(skipT > 0){
	                    skipT--;
	                    j--;
	                }else
	                    break;
	            }
	            
	            // now if none of them is zero 
	            if (i >= 0 && j >= 0){
	                if (s.charAt(i) != t.charAt(j))
	                    return false;
	            }
	            
	            // if one of the string is empty
	            if ((i >= 0 && j < 0) || (j >= 0 && i < 0))
	                return false;
	            
	            i--;
	            j--;
	        }
	        
	        return true;
	    }
	}
	
	
	/**
	 * Stack solution:
	 * Time: O(n + m), space: O(n + m)
	 */
	class SolutionWithStack {
	    public boolean backspaceCompare(String s, String t) {
	        Deque<Character> s1 = new ArrayDeque<>();
	        Deque<Character> s2 = new ArrayDeque<>();
	        
	        for(int i = 0; i < s.length(); i++){
	            if (s.charAt(i) == '#')
	                s1.poll();
	            else
	                s1.offerFirst(s.charAt(i));
	        }
	        
	        for(int i = 0; i < t.length(); i++){
	            if (t.charAt(i) == '#')
	                s2.poll();
	            else
	                s2.offerFirst(t.charAt(i));
	        }
	        
	        if (s1.size() != s2.size())
	            return false;
	        
	        while(!s1.isEmpty()){
	            if (s1.poll() != s2.poll())
	                return false;
	        }
	        
	        return true;
	    }
	}
}
