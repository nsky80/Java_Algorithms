/**
* https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?page=4&category[]=Graph&category[]=DFS&category[]=BFS&sortBy=submissions
*
*
*/
package com.graph.common_problems;


import java.util.Arrays;

public class FindTheNumberofIslands{
	
	/**
	* This method checks whether current node is visited or not
	* and also checks whether it is 1 or 0.
	*/
	public static boolean checkStatus(char grid[][], boolean visited[][], int row, int col){
		if(grid[row][col] != '0' && !visited[row][col]){
			return true;
		}	
		
		return false;
	}
	
	/**
	* DFS: here adjacent nodes are nothing but neighouring 1's
	*/
	public static void traverseAllAdjIslandDFS(char [][]grid, boolean [][]visited, int row, int col, int m, int n){
		System.out.print(row + "," + col + " ");
		visited[row][col] = true;
		
		// now get adjacent and call DFS again
		
		// check adj at top
		if (row - 1 >= 0){
			if (col - 1 >= 0 && checkStatus(grid, visited, row - 1, col - 1))
				traverseAllAdjIslandDFS(grid, visited, row - 1, col - 1, m, n);
			
			if(checkStatus(grid, visited, row - 1, col))
				traverseAllAdjIslandDFS(grid, visited, row - 1, col, m, n);
			// adj right top
			if(col + 1 < n && checkStatus(grid, visited, row - 1, col + 1))
				traverseAllAdjIslandDFS(grid, visited, row - 1, col + 1, m, n);
		}
		
		// check left side 
		if (col - 1 >= 0 && checkStatus(grid, visited, row, col - 1))
			traverseAllAdjIslandDFS(grid, visited, row , col - 1, m, n);
		
		// check right side
		if (col + 1 < n && checkStatus(grid, visited, row, col + 1))
			traverseAllAdjIslandDFS(grid, visited, row , col + 1, m, n);
		
		// check adj at bottom
		if (row + 1 < m){
			if (col - 1 >= 0 && checkStatus(grid, visited, row + 1, col - 1))
				traverseAllAdjIslandDFS(grid, visited, row + 1, col - 1, m, n);
			
			if(checkStatus(grid, visited, row + 1, col))
				traverseAllAdjIslandDFS(grid, visited, row + 1, col, m, n);
			// adj right top
			if(col + 1 < n && checkStatus(grid, visited, row + 1, col + 1))
				traverseAllAdjIslandDFS(grid, visited, row + 1, col + 1, m, n);
		}

	}
	
	/**
	* This is DFT/BFT, it uses every element of grid as node and try to visit all 
	* of them.
	*/
    public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		
		// get the rows and columns
		int m = grid.length;
		int n = grid[0].length;
		
		boolean visited[][] = new boolean[m][n];
		
		// initializing the visited matrix as false
		for(int i = 0; i < m; i++){
			Arrays.fill(visited[i], false);
		}
		
		int count = 0;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if (checkStatus(grid, visited, i, j)){
					// count current island
					count++;
					traverseAllAdjIslandDFS(grid, visited, i, j, m, n);
					
					// for debug
					System.out.println("\n");
				}
			}
		}
		
		return count;
    }	
	
	
	public static void main(String[] args){
		char grid[][] = {{'0', '1', '1', '1', '0', '0', '0'}, {'0', '0', '1', '1', '0', '1', '0'}};
		System.out.println("Number of islands: " + numIslands(grid));
		
		char [][] grid2 = {{'1', '0', '0', '0', '0', '1', '0', '0', '0', '1'}, 
			{'1', '0', '1', '1', '1', '1', '1', '0', '0', '1'}, 
			{'1', '1', '1', '1', '1', '0', '0', '0', '1', '0'}, 
			{'1', '1', '1', '0', '1', '0', '0', '1', '0', '1'}, 
			{'0', '1', '0', '1', '0', '0', '0', '1', '0', '0'}, 
			{'0', '0', '0', '0', '0', '1', '1', '1', '1', '0'}, 
			{'0', '0', '1', '1', '0', '0', '0', '1', '0', '0'}
		};
		System.out.println("Number of islands: " + numIslands(grid2));

	}
}