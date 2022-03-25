package com.graph.common_problems;


import java.util.Deque;
import java.util.ArrayDeque;

class NumberOfIslands {
    public static boolean isSafe(char grid[][], boolean visited[][], int row, int col){
        if (row < 0 || row >= grid.length) return false;
        if (col < 0 || col >= grid[row].length) return false;
        if (grid[row][col] == '1' && !visited[row][col] ) return true;
        return false;
    }
    
    
    public static void DFS(char grid[][], boolean visited[][], int row, int col){
        int rv[] = {0, -1, 0, 1};
        int cv[] = {-1, 0, 1, 0};
        
        visited[row][col] = true;
        
        // visiting adjacent nodes
        for(int w = 0; w < rv.length; w++){
            if (isSafe(grid, visited, row + rv[w], col + cv[w])){
                DFS(grid, visited, row + rv[w], col + cv[w]);
            }
        }
        
        
    }
    
    public static void BFS(char grid[][], boolean visited[][], int row, int col){
        int rv[] = {0, -1, 0, 1};
        int cv[] = {-1, 0, 1, 0};
        
        visited[row][col] = true;
        Deque<int []> q = new ArrayDeque<>();
        
        q.add(new int[]{row, col});
        
        while(!q.isEmpty()){
            int [] current = q.poll();
            
            for(int w = 0; w < rv.length; w++){
                int r = current[0] + rv[w];
                int c = current[1] + cv[w];
                
                if (isSafe(grid, visited, r, c)){
                    visited[r][c] = true;
                    q.add(new int[]{r, c});
                }
                
            }
        }
        
    }
    
    /**
		Time: O(m * n)
		Space: O(m * n)
	
	*/
    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        int islandCount = 0;
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if (grid[r][c] == '1' && !visited[r][c]){
                    islandCount++;
                    BFS(grid, visited, r, c);
                }
            }
        }
        return islandCount;
    }
}