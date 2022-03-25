
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrayRecursion {

	public static List<Integer> merge(List<Integer> lArr, List<Integer> rArr) {
		ArrayList<Integer> mergedArr = new ArrayList<Integer>();
		// pointers
		int l = 0;
		int r = 0;
		int ln = lArr.size();
		int rn = rArr.size();

		for (int i = 0; i < ln + rn; i++) {
			if (l < ln && r < rn) {
				if (lArr.get(l) < rArr.get(r)) {
					mergedArr.add(lArr.get(l));
					l++;
				} else {
					mergedArr.add(rArr.get(r));
					r++;
				}
			} else if (l == ln) {
				mergedArr.add(rArr.get(r));
				r++;
			} else {
				mergedArr.add(lArr.get(l));
				l++;
			}
		}
		return mergedArr;
	}

	public static List<Integer> divide(List<List<Integer>> arr, int s, int e) {
		int k = s + (e - s) / 2;
		System.out.println("" + arr + " " + s + " " + e);
		if (e - s > 1) {
			return merge(divide(arr, s, k), divide(arr, k, e));
		}

		return arr.get(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr1[] = {1, 2, 5, 8};
//		int arr2[] = {3, 4, 6};

//		List<Integer> mergedArr = merge(Arrays.asList(1, 2, 5, 8), Arrays.asList(3, 4, 6));
//		
//		for(int i: mergedArr) {
//			System.out.print(" " + i);
//		}
		List<List<Integer>> mArr = new ArrayList<>();
		mArr.add(Arrays.asList(1, 2, 5, 8));
		mArr.add(Arrays.asList(3, 4, 6));
		mArr.add(Arrays.asList(3, 9, 13));
		mArr.add(Arrays.asList(7, 29, 89));

		List<Integer> combinedList = divide(mArr, 0, mArr.size());
		System.out.println("Combined list: " + combinedList);
	}

}
