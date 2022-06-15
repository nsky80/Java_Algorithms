/**
 * https://leetcode.com/problems/car-fleet/
 */
package com.stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * As there is single lane, which specifies that overtaking is not allowed, so
 * the car having position near to target will define fleet. Therefore sort the
 * array according the position and then get the fleet by using the time
 * required to reach the destination.
 * 
 * Time: O(nlogn), Space: O(n)
 * 
 * @author Satish
 *
 */
public class CarFleet {
	
	class SpaceOptimizedSolution {
	    public int carFleet(int target, int[] position, int[] speed) {
	        int n = position.length;
	        int car[][] = new int[n][];
	        
	        for(int i = 0; i < n; i++){
	            car[i] = new int[]{position[i], speed[i]};
	        }
	        
	        Arrays.sort(car, (x, y) -> (x[0] - y[0]));
	        
	        int fleet = 0;
	        float slowest = 0;
	        
	        // since cars cannot overtake, then even fastest car will follow the 
	        // slower car if slower cars position is ahead.
	        for(int i = n - 1; i >= 0; i--){
	            float destReachTime = (float)(target - car[i][0]) / car[i][1];
	            
	            // since a car cannot overtake other, so it have to join the fleet
	            // even if it is faster, this stack will contain the slowest cars time
	            // to reach the destination
	            if (destReachTime > slowest){
	                slowest = destReachTime;
	                fleet++;
	            }
	        }
	        
	        return fleet;
	    }
	}
	
	class SolutionUsingMonotonicStack {
	    public int carFleet(int target, int[] position, int[] speed) {
	        int n = position.length;
	        int car[][] = new int[n][];
	        
	        for(int i = 0; i < n; i++){
	            car[i] = new int[]{position[i], speed[i]};
	        }
	        
	        Arrays.sort(car, (x, y) -> (x[0] - y[0]));
	        
	        Deque<Float> stack = new ArrayDeque<>();
	        
	        for(int i = n - 1; i >= 0; i--){
	            float destReachTime = (float)(target - car[i][0]) / car[i][1];
	            
	            // since a car cannot overtake other, so it have to join the fleet
	            // even if it is faster
	            
	            // if current car is slower then add into the stack, so that
	            // upcoming cars can join the fleet if they are faster.
	            if (stack.isEmpty() || destReachTime > stack.peek()){
	                stack.push(destReachTime);
	            }
	        }
	        
	        return stack.size();
	    }
	}
}
