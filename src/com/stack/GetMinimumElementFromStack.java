package com.stack;

import java.util.Stack;

class GetMinimumElementFromStack
{
    int minEle;
    Stack<Integer> s;
	
    GetMinimumElementFromStack(){
        s = new Stack<Integer>();
    }
	
    /*returns min element from stack*/
    int getMin()
    {
        if(s.size() == 0){
	        return -1;
	    }
	    return minEle;
        
    }
    
    /*returns popped element from stack*/
    int pop()
    {
//    	System.out.print("Pop: Before: " + s);
	    if(s.size() == 0){
	        return -1;
	    }
	    
		// pop the top element for comparison
		int top = s.pop();
		
		// it top element is the minimum element
	    if (top < minEle){
			// update minEle to previous minimum
			int temp = 2 * minEle - top;
			top = minEle;
			minEle = temp;
	    } 
//    	System.out.println(", after: " + s);

	    return top;
    }

    /*push element x into the stack*/
    void push(int x)
    {
//    	System.out.print("Push: Before: " + s);
    	// if stack is empty directly push and make it as minEle
	    if(s.size() == 0){
	        minEle = x;
			s.push(x);
	    }else{
	    	// if new element less than minEle then, update minEle
	    	// and keep track of previous minEle
	        if (x < minEle){
				s.push(2 * x - minEle);
				minEle = x;
			}else{
				// else directly add into the stack
				s.push(x);
			}
	    } 
//    	System.out.println(", after: " + s);

    }	
	
	
	public static void main(String [] args){
		GetMinimumElementFromStack st = new GetMinimumElementFromStack();
		st.push(1);
		st.push(79);
		st.push(3);
		st.push(1);
		System.out.println("Min: " + st.getMin());

		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());
//		st.push(1);
		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());
		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());
		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());
		
		
		st.push(4);
		st.push(3);
		st.push(3);
		st.push(1);
		System.out.println("Here!");
		System.out.println("Min: " + st.getMin());
		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());
		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());
		System.out.println("pop: " + st.pop());
		System.out.println("Min: " + st.getMin());


	}
}

