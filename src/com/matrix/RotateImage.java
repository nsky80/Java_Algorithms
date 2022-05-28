/**
 * https://leetcode.com/problems/rotate-image/
 */
package com.matrix;

/**
 * @author satis
 *
 */
public class RotateImage {
	/**
	 * Time: O(n * n), Space: O(1).
	 * 
	 * The idea is pick 1 position and rotate all 4.
	 * @author satis
	 *
	 */
	class Solution {
	    public void rotate(int[][] matrix) {
	        int n = matrix.length;
	        for(int i = 0; i < n / 2; i++){
	            for(int j = i; j < n - i - 1; j++){
	                
	                // for first row
	                int r = j;
	                int c = n - i - 1;
	                int backup = matrix[r][c];
	                matrix[r][c] = matrix[i][j];
	                
	                // for last column
	                int nr = c;
	                int nc = n - r - 1;
	                int backup2 = matrix[nr][nc];
	                matrix[nr][nc] = backup;
	                
	                // for last row
	                r = nc;
	                c = i;
	                backup = matrix[r][c];
	                matrix[r][c] = backup2;
	                
	                // for first column
	                nr = i;
	                nc = n - r - 1;
	                matrix[nr][nc] = backup;
	            }
	        }
	        
	    }
	}
}
