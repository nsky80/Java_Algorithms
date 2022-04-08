package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int element: stones) {
        	pq.add(element);
        }
        
        while (pq.size() >= 2) {
        	int e1 = pq.poll();
        	int e2 = pq.poll();
        	if (e1 - e2 != 0) {
        		pq.add(Math.abs(e1 - e2));
        	}
        }
        
        
        return pq.poll();
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
