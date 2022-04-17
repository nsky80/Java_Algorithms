/**
 * https://leetcode.com/problems/best-sightseeing-pair/
 */
package com.dp.easy;

public class BestSightseeingPair {

	public int maxScoreSightseeingPair(int[] values) {
		// int n = values.length;
		// int maxPair = 0;
		// for(int i = 0; i < n; i++){
		// for(int j = i + 1; j < n; j++){
		// int currentPair = values[i] + values[j] + (i - j);
		// maxPair = Math.max(currentPair, maxPair);
		// }
		// }

//         int l = 0;
//         int r = n - 1;

//         while(l < r){
//             int cp = values[l] + values[r] + l - r;
//             maxPair = Math.max(cp, maxPair);

//             if(values[l] > values[r]){
//                 r--;
//             }else{
//                 l++;
//             }
//         }
		int maxSoFarI = values[0];
		int ans = 0;
		// divide the problem as: max(v[i] + i) + (v[j] - j) , i < j
		// for every iteration, try to maximize v[i]+i and according that
		// update the answer
		for (int j = 1; j < values.length; j++) {
			ans = Math.max(ans, maxSoFarI + values[j] - j);
			maxSoFarI = Math.max(maxSoFarI, values[j] + j);
		}
		return ans;
	}

}
