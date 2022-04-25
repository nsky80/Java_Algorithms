/**
 * https://leetcode.com/problems/open-the-lock/
 */
package com.graph.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author satis
 *
 */
public class OpenTheLock {
	/**
	 * Time: O(10000)
	 * Space: O(10000) visited can grew as large as 10000.
	 */
	class SpaceOptimizedSolution {
		public int openLock(String[] deadends, String target) {
			int len = target.length();
			char[] temp = new char[len];
			Arrays.fill(temp, '0');
			String startStr = String.valueOf(temp);

			if (startStr.equals(target))
				return 0;

			// for fast comparison
			Set<String> deadEndSet = new HashSet<>();
			for (String end : deadends) {
				deadEndSet.add(end);
			}

			if (deadEndSet.contains(startStr))
				return -1;

			Deque<String> q = new ArrayDeque<>();
			q.offer(startStr);
			// this will be used as visited set
			deadEndSet.add(startStr);

			int opr = 0;
			while (!q.isEmpty()) {
				// System.out.println(q);

				opr++;
				int size = q.size();

				while (size-- > 0) {
					// System.out.println("Here: " + q);

					char[] currChar = q.poll().toCharArray();
					// make 2 changes for every char
					for (int pos = 0; pos < currChar.length; pos++) {
						// create two string by making chages
						char backup = currChar[pos];

						// now create the string
						currChar[pos] = (char) (backup + 1 > 57 ? 48 : backup + 1);
						String str = String.valueOf(currChar);

						if (!deadEndSet.contains(str)) {
							if (str.equals(target))
								return opr;
							q.offer(str);
							deadEndSet.add(str);
						}

						// for backward flip
						currChar[pos] = (char) (backup - 1 < 48 ? 57 : backup - 1);
						str = String.valueOf(currChar);

						if (!deadEndSet.contains(str)) {
							if (str.equals(target))
								return opr;
							q.offer(str);
							deadEndSet.add(str);
						}

						// overwriting the changes
						currChar[pos] = backup;
					}
				}
			}

			return -1;
		}
	}
	
	
	class MyFirstSolution {
	    public int openLock(String[] deadends, String target) {
	        int len = target.length();
	        char[] temp = new char[len];
	        Arrays.fill(temp, '0');
	        String startStr = String.valueOf(temp);
	        
	        if (startStr.equals(target))
	            return 0;
	        
	        // for fast comparison
	        Set<String> deadEndSet = new HashSet<>();
	        for(String end: deadends){
	            deadEndSet.add(end);
	        }
	        
	        if (deadEndSet.contains(startStr))
	            return -1;
	        
	        Set<String> visited = new HashSet<>();
	        Deque<String> q = new ArrayDeque<>();
	        q.offer(startStr);
	        visited.add(startStr);
	        
	        int opr = 0;
	        while(!q.isEmpty()){
	            // System.out.println(q);

	            opr++;
	            int size = q.size();
	            
	            while(size-- > 0){
	                // System.out.println("Here: " + q);

	                char [] currChar = q.poll().toCharArray();
	                // make 2 changes for every char
	                for(int pos = 0; pos < currChar.length; pos++){
	                    // create two string by making chages
	                    char backup = currChar[pos];
	                    
	                    // now create the string
	                    currChar[pos] = (char)(backup + 1 > 57 ? 48 : backup + 1);
	                    String str = String.valueOf(currChar);
	                    
	                    if (!visited.contains(str)){
	                        if (str.equals(target))
	                            return opr;
	                        if (!deadEndSet.contains(str)){
	                            q.offer(str);
	                            visited.add(str);

	                        }
	                    }
	                    
	                    // for backward flip
	                    currChar[pos] = (char)(backup - 1 < 48 ? 57 : backup - 1);
	                    str = String.valueOf(currChar);
	                    
	                    if(!visited.contains(str)){
	                        if (str.equals(target))
	                            return opr;
	                        if (!deadEndSet.contains(str)){
	                            q.offer(str);
	                            visited.add(str);

	                        }
	                    }
	                    
	                    // overwriting the changes
	                    currChar[pos] = backup;
	                }
	            }
	        }
	        
	        
	        return -1;
	    }
	}
}
