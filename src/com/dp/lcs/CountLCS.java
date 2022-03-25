package com.dp.lcs;


public class CountLCS{
	public static long count = 0;
	
	/**
	* Time complexity = O(2 ^ (m + n))
	* Space complexity = O(m + n)
	*/
	public static int countLCS_Recursive(String s1, int m, String s2, int n){
		count++;
		// base case 
		if ( m == s1.length() || n == s2.length()) return 0;
		
		// if both the current matching then go forward
		if ( s1.charAt(m) == s2.charAt(n)){
			return countLCS_Recursive(s1, m + 1, s2, n + 1) + 1;
		}else{
		
			int left = countLCS_Recursive(s1, m + 1, s2, n);
			int right = countLCS_Recursive(s1, m, s2, n + 1);
			
			return Math.max(left, right);
		}
	}
	
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs( char[] X, char[] Y, int m, int n )
	{
		count++;
		if (m == 0 || n == 0) return 0;
		
		if (X[m-1] == Y[n-1])
		return 1 + lcs(X, Y, m-1, n-1);
		else
		return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
	}
 
	
	public static int countLCS(String s1, String s2){
		 // return countLCS_Recursive(s1, 0, s2, 0);
		 return lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
	}
	
	public static void main(String[] args){
		String str1 = "abc";
		String str2 = "ac";
		
		count = 0;
		System.out.println(countLCS(str1, str2) + " " + count);
		count = 0;
		System.out.println(countLCS("abcd", "ac") + " " + count);
		count = 0;
		System.out.println(countLCS("abcdef", "adbcf") + " " + count);
		count = 0;
		System.out.println(countLCS("AGGTAB", "GXTXAYB") + " " + count);
		count = 0;
		System.out.println(countLCS("ABCD", "ACBAD") + " " + count);
		count = 0;
		System.out.println(countLCS("branch", "workattech") + " " + count);

	}
	
	
}