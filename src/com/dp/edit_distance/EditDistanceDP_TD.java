 package com.dp.edit_distance;
// for IDE

import java.util.Arrays;


public class EditDistanceDP_TD{
	static int count;
	
	
	/**
	* This recursive solution solves the problem from the reverse,
	* we can also use forward, 2 more parameter required then.
	* Time complexity: O(m * n)
	*
	*/
	public static int editDistanceHelper(String str1, String str2, int m, int n, int memo[][]){
		count++;
				
		// base cases
		
		// if first string is ended, then we have to perform n insertion only
		if (m == 0) return n;
		
		// similarily, if string already created then we have to perform m removal only.
		if (n == 0) return m;
		
		if(memo[m][n] != -1) return memo[m][n];
		
		// now check if strings are equal
		if (str1.charAt(m - 1) == str2.charAt(n - 1)){
			if (memo[m - 1][n - 1] != -1){
				memo[m][n] = memo[m - 1][n - 1];
			}else{
				memo[m][n] = editDistanceHelper(str1, str2, m - 1, n - 1, memo);
			}
			return memo[m][n];
		}
		// otherwise perform all three operations and return the minimum + 1
		else{
			int insert, remove, replace;
			
			// calculate the minDistance by inserting
			if (memo[m][n - 1] != -1){
				insert = memo[m][n - 1];
			}else{
				insert = editDistanceHelper(str1, str2, m, n - 1, memo);
				// memo[m][n - 1] = insert;
			}
			
			// for remove
			if (memo[m - 1][n] != -1){
				remove = memo[m - 1][n];
			} else {
				remove = editDistanceHelper(str1, str2, m - 1, n, memo);
			}
			
			// for replace
			if (memo[m - 1][n - 1] != -1){
				replace = memo[m - 1][n - 1];
			}
			else{
				replace = editDistanceHelper(str1, str2, m - 1, n - 1, memo);
			}
			
			memo[m][n] = Math.min(insert, Math.min(replace, remove)) + 1;
		}
		
		
		return memo[m][n];
	}
	
	public static int editDistance(String str1, String str2, int m, int n){
		int [][] memo = new int[m + 1][n + 1];
		for(int i = 0; i < m + 1; i++){
			Arrays.fill(memo[i], -1);
		}
		
		return editDistanceHelper(str1, str2, m, n, memo);
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
		count = 0;
		System.out.println(editDistance("voldemort", "dumbledore", 3, 3) + " " + count);
		count = 0;
		System.out.println(editDistance("sksdflsjfwwiejlksdjdfklJSFKL", "SKFDOIOJSksdflksjfsfdislaflksddk", 28, 32) + " " + count);

		count = 0;
		System.out.println(minDistanceGFG("abc", "xyz", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("cat", "cut", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("geek", "gesek", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("voldemort", "dumbledore", 3, 3) + " " + count);
		count = 0;
		System.out.println(minDistanceGFG("sksdflsjfwwiejlksdjdfklJSFKL", "SKFDOIOJSksdflksjfsfdislaflksddk", 28, 32) + " " + count);

	}
	
	
	
	
	
	static int minDis(String s1, String s2,
                  int n, int m, int[][]dp)
{
        count++; 
  // If any String is empty,
  // return the remaining characters of other String
  if(n == 0)   
    return m; 
  if(m == 0)   
    return n;
              
  // To check if the recursive tree
  // for given n & m has already been executed
  if(dp[n][m] != -1)   
    return dp[n][m];
                 
  // If characters are equal, execute
  // recursive function for n-1, m-1
  if(s1.charAt(n - 1) == s2.charAt(m - 1))
  {          
    if(dp[n - 1][m - 1] == -1)
    {              
      return dp[n][m] = minDis(s1, s2, n - 1, m - 1, dp);          
    }       
    else
      return dp[n][m] = dp[n - 1][m - 1];  
  }
   
  // If characters are nt equal, we need to
           
  // find the minimum cost out of all 3 operations.     
  else
  {          
    int m1, m2, m3;        // temp variables  
    if(dp[n-1][m] != -1)
    {   
      m1 = dp[n - 1][m];     
    }          
    else
    {  
      m1 = minDis(s1, s2, n - 1, m, dp);     
    }           
             
    if(dp[n][m - 1] != -1)
    {               
      m2 = dp[n][m - 1];           
    }           
    else
    {   
      m2 = minDis(s1, s2, n, m - 1, dp);     
    }                                  
    
    if(dp[n - 1][m - 1] != -1)
    {   
      m3 = dp[n - 1][m - 1];     
    }  
    else
    {  
      m3 = minDis(s1, s2, n - 1, m - 1, dp);      
    }    
    return dp[n][m] = 1 + Math.min(m1, Math.min(m2, m3));       
  }
}
 
	// Driver program
	public static int minDistanceGFG (String str1, String str2, int n, int m)
	{
	  int[][] dp = new int[n + 1][m + 1];
	  for(int i = 0; i < n + 1; i++)
	  Arrays.fill(dp[i], -1);               
	  return minDis(str1, str2, n, m, dp);
	}
}

