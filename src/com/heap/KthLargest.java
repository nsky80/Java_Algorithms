/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
package com.heap;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if (pq.size() < k){
            pq.offer(val);
        }else{
            if (pq.peek() < val){
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}

// *
//  * Your KthLargest object will be instantiated and called as such:
//  * KthLargest obj = new KthLargest(k, nums);
//  * int param_1 = obj.add(val);
