package com.searching.binary;

public class SearchA2DMatrix {
	/**
	 * Time complexity: O(log(m * n)) Space complexity: max(logm, logn)
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixRecursion(int[][] matrix, int target) {
		int row = getRowIterative(matrix, 0, matrix.length - 1, target);

		if (row == -1)
			return false;

		int col = getColIterative(matrix, row, 0, matrix[row].length - 1, target);
//		System.out.println(row + " " + col);
		return col == -1 ? false : true;
	}

	public int getRow(int[][] mat, int s, int m, int x) {
		System.out.println(s + "  " + m);
		if (s > m)
			return -1;

		int mid = (m + s) / 2;

		if (x < mat[mid][0])
			return getRow(mat, s, mid - 1, x);
		else if (x > mat[mid][mat[0].length - 1])
			return getRow(mat, mid + 1, m, x);
		return mid;
	}

	public int getCol(int[][] mat, int row, int s, int n, int x) {
		if (s > n)
			return -1;

		int mid = (s + n) / 2;

		if (x == mat[row][mid])
			return mid;
		if (x < mat[row][mid])
			return getCol(mat, row, s, mid - 1, x);
		else
			return getCol(mat, row, mid + 1, n, x);

	}

	public boolean searchMatrixIterative(int[][] matrix, int target) {
		int row = getRowIterative(matrix, 0, matrix.length - 1, target);

		if (row == -1)
			return false;

		int col = getColIterative(matrix, row, 0, matrix[row].length - 1, target);
//		System.out.println(row + " " + col);
		return col == -1 ? false : true;
	}

	private int getRowIterative(int[][] mat, int s, int m, int target) {
		while (s <= m) {
			int mid = (s + m) / 2;
			if (target < mat[mid][0])
				m = mid - 1;
			else if (target > mat[mid][mat[0].length - 1])
				s = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	private int getColIterative(int[][] mat, int row, int s, int n, int target) {
		while (s <= n) {
			int mid = (s + n) / 2;
			if (target == mat[row][mid]) 
				return mid;
			if (target < mat[row][mid])
				n = mid - 1;
			else
				s = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int element = 130;
		SearchA2DMatrix obj = new SearchA2DMatrix();
		System.out.println(obj.searchMatrixRecursion(arr, element));
		int a;
	}

}
