/**
 * https://leetcode.com/problems/valid-sudoku/
 */
package com.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author satis
 *
 */
public class ValidSudoku {
	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        Set<Character> rowSet = new HashSet<>();
	        Set<Character> colSet = new HashSet<>();

	        for(int i = 0; i < 9; i++){
	            
	            for(int j = 0; j < 9; j++){
	                
	                // check row
	                char row = board[i][j];
	                if (row != '.'){
	                    if (rowSet.contains(row))
	                        return false;
	                    rowSet.add(row);
	                }
	                
	                // check col
	                char col = board[j][i];
	                if(col != '.'){
	                    if (colSet.contains(col))
	                        return false;
	                    colSet.add(col);
	                }
	                
	                // check boxes
	                if (i % 3 == 0 && j % 3 == 0){
	                    Set<Character> box = new HashSet<>();
	                    for(int r = i; r < i + 3; r++){
	                        for(int c = j; c < j + 3; c++){
	                            char val = board[r][c];
	                            if (val != '.'){
	                                if (box.contains(val))
	                                    return false;
	                                box.add(val);
	                            }
	                        }
	                    }
	                }
	            }
	            
	            rowSet.clear();
	            colSet.clear();
	        }
	        
	        return true;
	    }
	}
}
