/**
 * 
 */
package com.maths.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Satish Kumar Yadav
 *
 */
public class ThreeSumWithMultiplicity {

	public int threeSumMulti(int[] arr, int target) {
		Map<Integer, Long> frequency = new HashMap<>();
		for (int i : arr) {
			long freq = frequency.getOrDefault(i, 0l);
			frequency.put(i, freq + 1l);
		}

		long ans = 0;
		for (Integer x : frequency.keySet()) {
			for (Integer y : frequency.keySet()) {
				int z = target - x - y;
				if (frequency.containsKey(z)) {
					long xfreq = frequency.get(x);
					long yfreq = frequency.get(y);
					long zfreq = frequency.get(z);

					if (x == y && x == z) {
						ans += ((xfreq) * (xfreq - 1) * (xfreq - 2)) / 6;
					} else if (x == y && x != z) {
						ans += ((xfreq) * (xfreq - 1)) / 2 * zfreq;
					} else if (x < y && y < z) {
						ans += ((xfreq * yfreq * zfreq));
					}

				}
				ans = ans % 1000000007;
			}
		}
		return (int) ans;
	}

	
    public int threeSumMulti2(int[] arr, int target) {
        // Brute Force
//         int count = 0;
//         int n = arr.length;
//         Arrays.sort(arr);
//         for(int i = 0; i < n; i++){
//             for(int j = i + 1; j < n; j++){
//                 for(int k = j + 1; k < n; k++){
//                     if ((arr[i] + arr[j] + arr[k]) == target) count++;
//                 }
//             }
//         }
        
//         return count % ((int)Math.pow(10, 9) + 7);
        
        // Time optimized solution
        Map<Integer, Long> freq = new HashMap<>();
        
        // count the frequency of the elements
        for(int ele: arr){
            if (freq.containsKey(ele)){
                freq.put(ele, freq.get(ele) + 1);
            }else{
                freq.put(ele, 1l);
            }
        }
        
        // now calculate the pairs 
        long count = 0;
        
        for(Integer i : freq.keySet()){
            for(Integer j: freq.keySet()){
                int k = target - i - j;
                
                // now check whether target exists in freq
                if (freq.containsKey(k)){
                    // there is a solution i.e. k which sums up to target
                    
                    // now according to the values of i, j, k increment the count
                    // get all the freq.
                    long ifreq = freq.get(i);
                    long jfreq = freq.get(j);
                    long kfreq = freq.get(k);
                    
                    // if all three are same, apply nCr i.e. out of all available 
                    // select any 3
                    if (i == j && i == k){
                        // in this case at first place 3 possibility and 
                        // at second place there is 2 possibilty
                        // Here division by 6 is r! which would be 3 * 2
                        count += (((ifreq) * (ifreq - 1) * (ifreq - 2)) / 6);
                    } else if (i == j && i != k){
                        // this case is important here
                        // if we apply || or here then it include multiple 
                        // reverse cases as well.
                        // as above
                        count+= ((ifreq * (ifreq - 1) / 2) * kfreq);
                    } else if (i < j && j < k){
                        // if all three are different
                        count += (ifreq * jfreq * kfreq);
                    }
                }
                count = count % 1000000007;
            }
        }
        
        return (int) count;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 2};
		ThreeSumWithMultiplicity obj = new ThreeSumWithMultiplicity();
		System.out.println(obj.threeSumMulti2(arr, 5));
	}

}
