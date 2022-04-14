/**
 * https://leetcode.com/problems/shift-2d-grid/
 */
package com.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    	int m = grid.length;
    	int n = grid[0].length;
        List<List<Integer>> arr = new ArrayList<>(m);
        for(int r = 0; r < m; r++) {
        	arr.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }
    	        
        for(int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int r = i;
        		int c = j + k;
        		if (c >= n) {
        			r = (r + (c / n)) % m;
        			c = c % n;
        		}
        		arr.get(r).set(c, grid[i][j]);
        	}
        }
    	
    	return arr;
    }
	
	
	public static void main(String[] args) {
		int grid[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		Shift2DGrid obj = new Shift2DGrid();
		obj.shiftGrid(grid, 1);
		int grid2[][] = {{3,8,1,9}, {19,7,2,5}, {4,6,11,10}, {12,0,21,13}};
		obj.shiftGrid(grid2, 4);
	}

}
