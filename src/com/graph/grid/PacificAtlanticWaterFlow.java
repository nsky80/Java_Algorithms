package com.graph.grid;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class PacificAtlanticWaterFlow {
	public final static int P = 1;
	public final static int A = 2;
	public final static int[] dvr = { 0, -1, 0, 1 };
	public final static int[] dvc = { -1, 0, 1, 0 };
	int m;
	int n;

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		m = heights.length;
		n = heights[0].length;

		int [][] tracker = new int[m][n];
		
		boolean visitedPacific[][] = new boolean[m][n];
		boolean visitedAtlantic[][] = new boolean[m][n];

		// visit w.r.t. to first and last row
		for (int c = 0; c < n; c++) {
			// pacific
			if (!visitedPacific[0][c])
				exploreOceanUpdated(heights, tracker, 0, c, visitedPacific);
			if (!visitedAtlantic[m - 1][c])
				exploreOceanUpdated(heights, tracker, m - 1, c, visitedAtlantic);
		}

		// explore ocean w.r.t to first and last column
		for (int r = 0; r < m; r++) {
			if (!visitedPacific[r][0])
				exploreOceanUpdated(heights, tracker, r, 0, visitedPacific);
			if (!visitedAtlantic[r][n - 1])
				exploreOceanUpdated(heights, tracker, r, n - 1, visitedAtlantic);
		}
		
		List<List<Integer>> ans = new ArrayList<>();

		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				if (tracker[r][c] == 2) {
					ans.add(Arrays.asList(r, c));
				}
			}
		}
		
		return ans;
	}
	
	public void exploreOceanUpdated(int heights[][], int[][] tracker, int r, int c, boolean visited[][]) {
		visited[r][c] = true;
		tracker[r][c] += 1;

		// explore child
		for (int d = 0; d < dvr.length; d++) {
			int rr = dvr[d] + r;
			int cc = dvc[d] + c;

			if (isSafe(heights, r, c, rr, cc, visited)) {
				exploreOceanUpdated(heights, tracker, rr, cc, visited);
			}
		}
	}

	
	public List<List<Integer>> pacificAtlantic1(int[][] heights) {
		m = heights.length;
		n = heights[0].length;

		// It will keep track the reach of each island
		List<List<Set<Integer>>> tracker = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			List<Set<Integer>> li = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				li.add(new HashSet<>());
			}
			tracker.add(li);
		}

		// now initialize the pacific and Atlantic for first and last column
		for (int r = 0; r < m; r++) {
			List<Set<Integer>> row = tracker.get(r);
			row.get(0).add(P);
			row.get(n - 1).add(A);
		}

		List<Set<Integer>> fRow = tracker.get(0);
		List<Set<Integer>> lRow = tracker.get(m - 1);
		// first and last row with P and A
		for (int c = 0; c < n; c++) {
			fRow.get(c).add(P);
			lRow.get(c).add(A);
		}

		boolean visitedPacific[][] = new boolean[m][n];
		boolean visitedAtlantic[][] = new boolean[m][n];

		// visit w.r.t. to first and last row
		for (int c = 0; c < n; c++) {
			// pacific
			if (!visitedPacific[0][c])
				exploreOcean(heights, tracker, 0, c, visitedPacific, P);
			if (!visitedAtlantic[m - 1][c])
				exploreOcean(heights, tracker, m - 1, c, visitedAtlantic, A);
		}

		// explore ocean w.r.t to first and last column
		for (int r = 0; r < m; r++) {
			if (!visitedPacific[r][0])
				exploreOcean(heights, tracker, r, 0, visitedPacific, P);
			if (!visitedAtlantic[r][n - 1])
				exploreOcean(heights, tracker, r, n - 1, visitedAtlantic, A);
		}

		List<List<Integer>> ans = new ArrayList<>();
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (tracker.get(r).get(c).size() == 2)
					ans.add(Arrays.asList(r, c));
			}
		}

		return ans;
	}

	public void exploreOcean(int heights[][], List<List<Set<Integer>>> tracker, int r, int c, boolean visited[][],
			int ocean) {
		visited[r][c] = true;
		tracker.get(r).get(c).add(ocean);

		// explore child
		for (int d = 0; d < dvr.length; d++) {
			int rr = dvr[d] + r;
			int cc = dvc[d] + c;

			if (isSafe(heights, r, c, rr, cc, visited)) {
				exploreOcean(heights, tracker, rr, cc, visited, ocean);
			}
		}
	}

	public boolean isSafe(int h[][], int sr, int sc, int r, int c, boolean[][] v) {
		if (r < 0 || c < 0 || r >= m || c >= n || v[r][c] || h[r][c] < h[sr][sc])
			return false;
		return true;
	}

	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		System.out.println(obj.pacificAtlantic(heights));
		int[][] h2 = { { 2, 1 }, { 1, 2 } };
		System.out.println(obj.pacificAtlantic(h2));

	}
}