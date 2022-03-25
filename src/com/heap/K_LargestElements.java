package com.heap;

class Heap {
	public int heapsize;
	public int[] heapArray;

	public Heap(int hs, int arr[]) {
		heapsize = hs;
		heapArray = arr;

		for (int i = hs / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}

	private void heapify(int node) {
		int l = node * 2 + 1;
		int r = node * 2 + 2;

		int max = node;

		if (l < heapsize && heapArray[max] < heapArray[l]) {
			max = l;
		}

		if (r < heapsize && heapArray[max] < heapArray[r]) {
			max = r;
		}

		if (max != node) {
			int temp = heapArray[max];
			heapArray[max] = heapArray[node];
			heapArray[node] = temp;

			heapify(max);
		}
	}

	public int extractMax() {
		int last = heapArray[heapsize - 1];
		int first = heapArray[0];

		heapArray[0] = last;

		heapArray[heapsize - 1] = -1;

		heapsize--;
		heapify(0);
//		printHeap();
		return first;
	}

	public void printHeap() {
		for (int ele : heapArray) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
}

class Solution {
	int[] kLargest(int[] arr, int n, int k) {
		int kArr[] = new int[k];
		Heap heap = new Heap(n, arr);

		for (int i = 0; i < k; i++) {
			kArr[i] = heap.extractMax();
		}

		return kArr;
		// code here
	}
}

public class K_LargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 4, 6, 6, 2, 9, 3, 8 };

		Heap h = new Heap(8, arr);
		h.printHeap();
		System.out.println(h.extractMax());
		System.out.println(h.extractMax());
		System.out.println(h.extractMax());
		System.out.println(h.extractMax());
	}

}
