/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author satis
 *
 */
public class PascalsTriangleII {
	class Solution {

		/**
		 * O(n2), O(1)
		 * 
		 * @param rowIndex
		 * @return
		 */
		public List<Integer> getRowSpaceOptimized(int rowIndex) {
			List<Integer> ans = new ArrayList<>(rowIndex + 1);

			for (int i = 0; i < rowIndex + 1; i++) {
				ans.add(0);
			}

			ans.set(0, 1);

			for (int i = 1; i <= rowIndex; i++) {
				for (int j = i; j >= 1; j--) {
					// arr[j] += arr[j - 1];
					ans.set(j, ans.get(j) + ans.get(j - 1));
				}
			}

			return ans;

		}

		/**
		 * O(n2), O(n)
		 * 
		 * @param rowIndex
		 * @return
		 */
		public List<Integer> getRow(int rowIndex) {
			int arr[] = new int[rowIndex + 1];

			arr[0] = 1;

			for (int i = 1; i <= rowIndex; i++) {
				for (int j = i; j >= 1; j--) {
					arr[j] += arr[j - 1];
				}
			}

			List<Integer> ans = new ArrayList<>(rowIndex + 1);
			for (int i : arr) {
				ans.add(i);
			}

			return ans;

//	         List<Integer> prev = null;
//	         List<Integer> current = null;

//	         for(int i = 0; i <= rowIndex; i++){
//	             current = new ArrayList<>();

//	             current.add(1);

//	             for(int j = 1; j < i; j++){
//	                 current.add(prev.get(j - 1) + prev.get(j));
//	             }

//	             if(i > 0)
//	                 current.add(1);
//	             prev = current;
//	         }

//	         return current;

		}
	}
}
