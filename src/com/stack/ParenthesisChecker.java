package com.stack;

import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

public class ParenthesisChecker{
	    static Map<Character, Character> getMapper(){
        Map<Character, Character> map = new HashMap<Character, Character>();
        
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        
        return map;
    }
    
    static boolean isOpening(char bracket){
        if (bracket == '[' || bracket == '{' || bracket == '(')
            return true;
        return false;
    }
    
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Deque<Character> stack = new ArrayDeque<>();
        
        Map<Character, Character> mapper = getMapper();
        
        boolean isBalanced = true;
        
        for(int i = 0; i < x.length(); i++){
            char current = x.charAt(i);
            if (stack.isEmpty() && !isOpening(current)){
                return false;
            }
            
            else if (stack.isEmpty() || isOpening(current)){
                stack.push(current);
            } else{
                char top = stack.pop();
                if (current != mapper.get(top)){
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()){
            isBalanced = false;
        }
        
        return isBalanced;
        
    }

	
}