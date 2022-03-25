import java.util.PriorityQueue;

public class GetKLargestElement {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 23, 12, 9, 30, 2, 50 };
		int k = 3;
		kLargest(arr, k);

		int[] prim_array = { 1, 23, 12, 9, 30, 2, 50 };
		System.out.print(kLargest(prim_array, 3));

	}

	private static int[] kLargest(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
//		heap.addAll(arr);
		return null;

	}

}
