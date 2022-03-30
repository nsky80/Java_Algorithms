// package com.dp.edit_distance;
// for IDE

public class EditDistanceRecursion{
	static int count;
	
	
	/**
	* This recursive solution solves the problem from the reverse,
	* we can also use forward, 2 more parameter required then.
	* Time complexity: O(3 ^ m)
	*
	*/
	public static int editDistance(String str1, String str2, int m, int n){
		count++;
		
		// base cases
		
		// if first string is ended, then we have to perform n insertion only
		if (m == 0) return n;
		
		// similarily, if string already created then we have to perform m removal only.
		if (n == 0) return m;
		
		// now check if strings are equal
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return editDistance(str1, str2, m - 1, n - 1);
		
		// otherwise perform all three operations and return the minimum + 1
		return Math.min(
			editDistance(str1, str2, m, n - 1), 
			Math.min(editDistance(str1, str2, m - 1, n), editDistance(str1, str2, m - 1, n - 1))
		) + 1;
	}
	
	public static void main(String [] args){
		count = 0;
		System.out.println(editDistance("abc", "xyz", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("geek", "gesek", 3, 3) + " " + count);
	}
}

