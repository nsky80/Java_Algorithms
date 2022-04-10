/**
 * https://leetcode.com/problems/surrounded-regions/
 */

package com.graph.grid;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {
    static final int [] dvr = {-1, 1, 0, 0};
    static final int [] dvc = {0, 0, -1, 1};
    int m;
    int n;
    
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        
        int [][] flipable = new int[m][n];
        boolean [][] visited = new boolean[m][n];
        
        // flipable(i, j) = 1 indicates this bit couldn't be flipped.
        // first and last row
        for(int c = 0; c < n; c++){
            if (board[0][c] == 'O')
                tryToVisit(0, c, flipable, visited, board);
            
            if (board[m - 1][c] == 'O')
                tryToVisit(m - 1, c, flipable, visited, board);
        }
        
        // first and last column
        for(int r = 1; r < m - 1; r++){
            if (board[r][0] == 'O')
                tryToVisit(r, 0, flipable, visited, board);
            
            
            if (board[r][n - 1] == 'O')
                tryToVisit(r, n - 1, flipable, visited, board);
        }
        
        // flip
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if (board[r][c] == 'O' && flipable[r][c] == 0){
                    board[r][c] = 'X';
                }
            }
        }
        
    }
    
    public void tryToVisit(int r, int c, int [][] flipable, boolean [][] visited, char[][] board){
        flipable[r][c] = 1;
        if (!visited[r][c]){
            bfs(board, visited, flipable, r, c);
        }
    }
    
    public void bfs(char [][] board, boolean [][] visited, int [][] flipable, int r, int c){
        Queue<Integer> rq = new ArrayDeque<>();
        Queue<Integer> cq = new ArrayDeque<>();
        
        rq.offer(r);
        cq.offer(c);
        visited[r][c] = true;
        
        while(!rq.isEmpty()){
            r = rq.poll();
            c = cq.poll();
            
            for(int d = 0; d < dvr.length; d++){
                int rr = dvr[d] + r;
                int cc = dvc[d] + c;

                if (!(rr < 0 || cc < 0 || rr >= m || cc >= n || board[rr][cc] != 'O' || visited[rr][cc])){
                    visited[rr][cc] = true;
                    rq.offer(rr);
                    cq.offer(cc);
                    flipable[rr][cc] = 1;
                }
            }
        }
    }
    
    public void dfs(char[][] board, boolean [][] visited, int [][] flipable, int r, int c){
        visited[r][c] = true;
        flipable[r][c] = 1;
        
        for(int d = 0; d < dvr.length; d++){
            int rr = dvr[d] + r;
            int cc = dvc[d] + c;
            
            if (!(rr < 0 || cc < 0 || rr >= m || cc >= n || board[rr][cc] != 'O' || visited[rr][cc])){
                dfs(board, visited, flipable, rr, cc);
            }
        }
    }
}