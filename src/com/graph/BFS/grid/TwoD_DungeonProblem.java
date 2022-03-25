package com.graph.BFS.grid;


import java.util.Deque;
import java.util.ArrayDeque;

public class TwoD_DungeonProblem {
	char [][] grid;
	int R;
	int C;
	
	TwoD_DungeonProblem(char grid[][], int R, int C){
		this.grid = grid;
		this.R = R;
		this.C = C;
	}
	
	
	public void exploreNeighbours(Deque<Integer> rq, Deque<Integer> cq, int r, int c, boolean visited[][]){
		int [] dvr = {-1, 1, 0, 0};
		int [] dvc = {0, 0, 1, -1};
				
		// check safety
		for (int i = 0; i < dvr.length; i++){
			int rr = r + dvr[i];
			int cc = c + dvc[i];
			
			// check safety for over/under-flow
			if (rr < 0 || cc < 0 || rr >= R || cc >= C){
				continue;
			}
			
			// check whether node is visited or is it a stone
			if ( grid[rr][cc] == '#' || visited[rr][cc]){
				continue;
			}
			
			visited[rr][cc] = true;
			rq.add(rr);
			cq.add(cc);
		}
	}
	
	
	/**
	* Time complexity: O(R * C)
	* @param sr : source row
	* @param sc : source column
	*/
	public boolean isPossibleToEscape(int sr, int sc){
		boolean visited[][] = new boolean[R][C];
		
		Deque<Integer> rq = new ArrayDeque<Integer>();
		Deque<Integer> cq = new ArrayDeque<Integer>();
		
		// initializing the algo primitives
		rq.add(sr);
		cq.add(sc);
		visited[sr][sc] = true;
		
		boolean isEndingFound = false;
		
		// cq.isEmpty() can be used as well
		while( !rq.isEmpty()) {
			int r = rq.poll();
			int c = cq.poll();
			
			// check whether current node is destination node
			if (grid[r][c] == 'E'){
				isEndingFound = true;
				break;
			}
			
			exploreNeighbours(rq, cq, r, c, visited);
		}
		
		return isEndingFound;
	}
	
	
	
	
	public int exploreNeighboursInSteps(Deque<Integer> rq, Deque<Integer> cq, int r, int c, boolean visited[][]){
		int [] dvr = {-1, 1, 0, 0};
		int [] dvc = {0, 0, 1, -1};
		int nodeToVisitedNext = 0;
				
		// check safety
		for (int i = 0; i < dvr.length; i++){
			int rr = r + dvr[i];
			int cc = c + dvc[i];
			
			// check safety for over/under-flow
			if (rr < 0 || cc < 0 || rr >= R || cc >= C){
				continue;
			}
			
			// check whether node is visited or is it a stone
			if ( grid[rr][cc] == '#' || visited[rr][cc]){
				continue;
			}
			
			visited[rr][cc] = true;
			rq.add(rr);
			cq.add(cc);
			nodeToVisitedNext++;
		}
		
		return nodeToVisitedNext;
	}
	

	
	/**
	* Time complexity: O(R * C)
	* @param sr : source row
	* @param sc : source column
	* @return steps if 'E' found and possible to escape otherwise -1.
	*/
	public int stepsToEscape(int sr, int sc){
		boolean visited[][] = new boolean[R][C];
		
		Deque<Integer> rq = new ArrayDeque<Integer>();
		Deque<Integer> cq = new ArrayDeque<Integer>();
		
		// initializing the algo primitives
		rq.add(sr);
		cq.add(sc);
		visited[sr][sc] = true;
		
		boolean isEndingFound = false;
		
		// initializing the trackers
		// it initialized to 1 as in first step we have only 1 node for BFS(root)
		int numberOfNodesToBeVisited = 1;
		
		// it keep tracks the number of node to be visited in next BFS(level)
		int numberOfNodesNextToVisit = 0; 
		
		int steps = 0;
		
		// cq.isEmpty() can be used as well
		while( !rq.isEmpty()) {
			int r = rq.poll();
			int c = cq.poll();
			
			// check whether current node is destination node
			if (grid[r][c] == 'E'){
				isEndingFound = true;
				break;
			}
			
			// keep track of all the nodes which has to be visited in next
			// level of BFS
			numberOfNodesNextToVisit += exploreNeighboursInSteps(rq, cq, r, c, visited);
			
			// decrease the number of nodes to be visited by 1 
			numberOfNodesToBeVisited--;
			
			// if this node was last node in this level of BFS
			if (numberOfNodesToBeVisited == 0){
				numberOfNodesToBeVisited = numberOfNodesNextToVisit;
				numberOfNodesNextToVisit = 0;
				steps++;
			}
		}
		
		return isEndingFound ? steps : -1;
	}
	
	
	public void print(){
		for(char [] ar: grid){
			for(char c: ar){
				System.out.print(c + " " );
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args){
		
		char [][] dungeon = {
			{'#', '.', '.', '#', '.', '.', 'S'},
			{'.', '#', '.', '.', '.', '#', '.'},
			{'.', '#', '.', '.', '.', '.', '.'},
			{'E', '.', '#', '#', '.', '.', '.'},
			{'#', '.', '.', '.', '.', '#', '.'}
		};
		TwoD_DungeonProblem obj = new TwoD_DungeonProblem(dungeon, dungeon.length, dungeon[0].length);
		obj.print();
		System.out.println("Is possible to escape: " + obj.isPossibleToEscape(0, 6));
		System.out.println("Steps taken to escape: " + obj.stepsToEscape(0, 6));

	}
	
}