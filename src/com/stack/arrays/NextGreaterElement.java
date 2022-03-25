package com.stack.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {

	    //Function to find the next greater element for each element of the array.
	    public static long[] nextLargerElement(long[] arr, int n)
	    { 
	        // Your code here
	        Deque<Integer> stack = new ArrayDeque<Integer>();
	        long nextLarge[] = new long[n];
	        
	        // put the index of last element into the stack
	        stack.add(n - 1);
	        
	        // next large for last element is always going to be -1
	        nextLarge[n - 1] = -1;
	        
	        for(int i = n - 2; i  >= 0; i--){
	            int j = i + 1;
	            if(arr[i] < arr[j]){
	                nextLarge[i] = arr[j];
	                if(stack.peekLast() != j){
	                    stack.add(j);
	                }
	            }else{
	                while(!stack.isEmpty()){
	                    int current = stack.pollLast();
	                    if(arr[i] < arr[current]){
	                        nextLarge[i] = arr[current];
	                        stack.add(current);
	                        break;
	                    }
	                }
	                if(stack.isEmpty()){
	                    stack.add(i);
	                    nextLarge[i] = -1;
	                }
	            }
	        }
	        
	        return nextLarge;
	    } 
	public static void main(String[] args) {
		long arr[] = {8, 2, 7, 3, 1, 0, 4, 5};
		long larger []= nextLargerElement(arr, 8);
//		String a  = "";
		
		for(long i: larger) {
			System.out.print(" " + i);
		}
		System.out.println();
		
	}
}
