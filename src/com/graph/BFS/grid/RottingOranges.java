/**
 * https://leetcode.com/problems/rotting-oranges/
 */
package com.graph.BFS.grid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author satis
 *
 */
public class RottingOranges {
	
	/**
	 * O(mn), O(mn): This solution keep track of total number of fresh oranges and decrement whenever
	 * any fresh orange get rotten, at the end if all the fresh oranges covered, then it return time.
	 */
	static class BFS2PassSolution {

	    static int[] dvr = {-1, 1, 0, 0};
	    static int[] dvc = {0, 0, -1, 1};
	    
	    public int orangesRotting(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        int totalFreshOranges = 0;
	        
	        Deque<Integer> rq = new ArrayDeque<>();
	        Deque<Integer> cq = new ArrayDeque<>();
	        
	        for(int r = 0; r < m; r++){
	            for(int c = 0; c < n; c++){
	                if (grid[r][c] == 2){
	                    rq.offer(r);
	                    cq.offer(c);
	                }else if (grid[r][c] == 1)
	                    totalFreshOranges++;
	            }
	        }
	        
	        int count = 0;
	        boolean visited[][] = new boolean[m][n];

	        while(!rq.isEmpty() && totalFreshOranges > 0){
	            count++;
	            int size = rq.size();
	            for(int i = 0; i < size; i++){
	                int r = rq.poll();
	                int c = cq.poll();
	                
	                for(int d = 0; d < dvr.length; d++){
	                    int rr = r + dvr[d];
	                    int cc = c + dvc[d];
	                    
	                    if (rr >= 0 && rr < m && cc >= 0 && cc < n && grid[rr][cc] == 1 && (!visited[rr][cc])){
	                        rq.offer(rr);
	                        cq.offer(cc);
	                        visited[rr][cc] = true;
	                        totalFreshOranges--;
	                    }
	                }
	            }
	            
	        }
	        
	        // no oranges at all
	        return totalFreshOranges == 0 ? count : -1;
	    }
	}
	
	
	/**
	 * O(mn), O(mn): This solution check explicitly whether all the fresh oranges rotten or not, for
	 * that it uses 1 more pass to check, this is not efficient approach.
	 */
	static class BFS3Pass {
	    int m;
	    int n;
	    static int[] dvr = {-1, 1, 0, 0};
	    static int[] dvc = {0, 0, -1, 1};
	    
	    public int orangesRotting(int[][] grid) {
	        m = grid.length;
	        n = grid[0].length;
	        
	        Deque<Integer> rq = new ArrayDeque<>();
	        Deque<Integer> cq = new ArrayDeque<>();
	        
	        for(int r = 0; r < m; r++){
	            for(int c = 0; c < n; c++){
	                if (grid[r][c] == 2){
	                    rq.offer(r);
	                    cq.offer(c);
	                }
	            }
	        }
	        
	        int count = -1;
	        boolean visited[][] = new boolean[m][n];

	        while(!rq.isEmpty()){
	            count++;
	            int size = rq.size();
	            for(int i = 0; i < size; i++){
	                int r = rq.poll();
	                int c = cq.poll();
	                
	                for(int d = 0; d < dvr.length; d++){
	                    int rr = r + dvr[d];
	                    int cc = c + dvc[d];
	                    
	                    if (rr >= 0 && rr < m && cc >= 0 && cc < n && grid[rr][cc] == 1 && (!visited[rr][cc])){
	                        rq.offer(rr);
	                        cq.offer(cc);
	                        visited[rr][cc] = true;
	                    }
	                }
	            }
	            
	        }
	        
	        for(int r = 0; r < m; r++){
	            for(int c = 0; c < n; c++){
	                if (grid[r][c] == 1 && !visited[r][c])
	                    return -1;
	            }
	        }
	        
	        // no oranges at all
	        return count == -1 ? 0 : count;
	    }
	}
}
