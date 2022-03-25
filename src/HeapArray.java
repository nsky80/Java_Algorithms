
public class HeapArray {
	static int heap_size;
	
	public static void createHeap(int[] arr) {
		heap_size = arr.length;
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, i);
		}
	}

	private static void heapify(int[] arr, int k) {
		int l = 2 * k + 1;
		int r = 2 * k + 2;

		int ind = k;
		int n = heap_size;
//		System.out.println(l + " " + r);
		if (l < n && arr[ind] > arr[l]) {
			ind = l;
		}

		if (r < n && arr[ind] > arr[r]) {
			ind = r;
		}

		if (ind != k){
			int temp = arr[ind];
			arr[ind] = arr[k];
			arr[k] = temp;
			heapify(arr, ind);
		}
	}

	public static int getMin(int[] arr) {
		// get the root element
		int temp = arr[0];
		arr[0] = arr[heap_size - 1];
		arr[heap_size - 1] = temp;
		heap_size--;
		heapify(arr, 0);
		return temp;
	}

	public static void printHeap(int arr[]) {
		System.out.println("Consider heap size: " + heap_size);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = { 4, 3, 5, 8, 6, 3, 2 };
		printHeap(arr);
		
		createHeap(arr);

		printHeap(arr);
		System.out.println();
		for (int i = 0; i < 7; i++) {
			System.out.println(" " + getMin(arr));
			printHeap(arr);
		}
	}

}
