/**
 * URL: https://leetcode.com/problems/longest-palindromic-substring/
 */
package com.dp.string;

/**
 * @author Satish Kumar Yadav
 *
 */
public class LongestPalindromicSubstring {

	/**
	 * This is Expand Around Center technique, it's not DP.
	 * Time: O(n^2)
	 * Space: O(1)
	 * @param s
	 * @return
	 */
    public String longestPalindrome(String s) {
        int n = s.length();

        int start = 0;
    	int end = 0;
    	int maxLen = 1;
        // choose every character and expand it
        for(int i = 0; i < n; i++) {
        	// pointers for odd length
        	int f = i - 1;
        	int b = i + 1;
        	while (f >= 0 && b < n) {
        		if (s.charAt(f) == s.charAt(b)) {
        			f--;
        			b++;
        		}else {
        			break;
        		}
        	}
        	
        	if ((b - f - 1) > maxLen) {
        		maxLen = b - f - 1;
        		start = ++f;
        		end = --b;
        	}
        	
        	// pointers for even length
        	f = i;
        	b = i + 1;
        	while (f >= 0 && b < n) {
        		if (s.charAt(f) == s.charAt(b)) {
        			f--;
        			b++;
        		}else {
        			break;
        		}
        	}
        	if ((b - f - 1) > maxLen) {
        		maxLen = b - f - 1;
        		start = ++f;
        		end = --b;
        	}


        }
        end++;
//        System.out.println(s.substring(start, end));
        
    	return s.substring(start, end);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		
		obj.longestPalindrome("abccba");
		obj.longestPalindrome("babad");
		obj.longestPalindrome("cbbd");
		obj.longestPalindrome("abb");
	}

}
