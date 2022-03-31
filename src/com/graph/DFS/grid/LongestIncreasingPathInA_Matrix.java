/**
* Problem Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*/

package com.graph.DFS.grid;


public class LongestIncreasingPathInA_Matrix{
	
	public int longestIncreasingPath(int[][] matrix) {
        int track[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                if (track[r][c] == 0){
                    dfs(track, matrix, r, c);
                }
                
                max = Math.max(max, track[r][c]);
            }
        }
        
        return max;
    }
    
    public int dfs(int [][] track, int [][] mat, int r, int c){
        
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, 1, -1};
        
        track[r][c] = 1;
        
        int max = 0;
        
        for(int adj = 0; adj < dr.length; adj++){
            int rr = dr[adj] + r;
            int cc = dc[adj] + c;
            
            if (!(rr < 0 || cc < 0 || rr >= mat.length || cc >= mat[0].length) && mat[r][c] < mat[rr][cc]){
                int temp;
                if (track[rr][cc] == 0)
                     temp = dfs(track, mat, rr, cc);
                else
                    temp = track[rr][cc];
                
                if (temp >= max){
                    max = temp;
                }
            }
        }
            
        track[r][c] += max;

        return track[r][c];
        
    }
    
	
	
	
}


