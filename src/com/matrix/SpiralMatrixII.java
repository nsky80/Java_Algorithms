/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
package com.matrix;

public class SpiralMatrixII {
	
	    public int[][] generateMatrix(int n) {
	        int prev = 0;
	        int arr[][] = new int[n][n];
	        for(int t = 0; t < (int)Math.ceil((float)n / 2); t++){
	            int i;
	            // first row
	            for(i = t; i < n - t; i++){
	                arr[t][i] = ++prev;
	            }
	            
	            // last col
	            for(i = t + 1; i < n - t; i++){
	                arr[i][n - t - 1] = ++prev;
	            }
	            
	            // for last row
	            for(i = t + 1; i < n - t; i++){
	                arr[n - t - 1][n - 1 -i] = ++prev;
	            }
	            
	            // first column
	            for(i = t + 1; i < n - t - 1; i++){
	                arr[n - 1 - i][t] = ++prev;
	            }
	        }
	        
	        return arr;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
