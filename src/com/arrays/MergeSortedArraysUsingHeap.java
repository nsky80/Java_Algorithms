package com.arrays;

class MinHeapNode {
	int val; // The element to be stored

	// index of the array from
	// which the element is taken
	int arrPos;

	// index of the next element
	// to be picked from array
	int nextEle;

	public MinHeapNode(int element, int arrPos, int nextEle) {
		this.val = element;
		this.arrPos = arrPos;
		this.nextEle = nextEle;
	}

	@Override
	public String toString() {
		return "[val=" + val + ", Array Position=" + arrPos + ", Next Element=" + nextEle + "]";
	}

};

class MinHeap {
	MinHeapNode[] hArr; // Array of elements in heap
	int heap_size; // Current number of elements in min heap

	// Constructor: Builds a heap from
	// a given array a[] of given size
	public MinHeap(MinHeapNode a[], int size) {
		hArr = a;
		heap_size = size;

		for (int i = size / 2 - 1; i >= 0; i--) {
			minHeapify(i);
		}
	}

	public void minHeapify(int k) {
		int left = 2 * k + 1;
		int right = 2 * k + 2;
		int ind = k;

		if (left < heap_size && hArr[left].val < hArr[ind].val) {
			ind = left;
		}

		if (right < heap_size && hArr[right].val < hArr[ind].val) {
			ind = right;
		}

		if (ind != k) {
			MinHeapNode temp = hArr[ind];
			hArr[ind] = hArr[k];
			hArr[k] = temp;
			minHeapify(ind);
		}
	}

	public MinHeapNode getMin() {
//		// get the first element and swap it with last element
//		// and decrease the size of heap by 1
//		MinHeapNode temp = hArr[0];
//		hArr[0] = hArr[--heap_size];
//		hArr[heap_size] = temp;
//
//		// adjust the heap
//		minHeapify(hArr, 0);
//
//		// return the minimum element
//		return temp;
		if (heap_size <= 0) {
			System.out.println("Heap underflow");
			return null;
		}
		return hArr[0];

	}

	// to replace root with new node
	// "root" and heapify() new root
	void replaceMin(MinHeapNode root) {
		hArr[0] = root;
		minHeapify(0);
	}

}

public class MergeSortedArraysUsingHeap {

	public static int[] mergeSortedArray(int arr[][]) {
		int[] sortedArray;
		int resultSize = 0;
		int n = arr.length;
		// initializing the array so that it can store 1 element from every sub-array
		MinHeapNode nodeArray[] = new MinHeapNode[n];

		// adding the first value of every sub-array into the heap
		for (int i = 0; i < n; i++) {
			nodeArray[i] = new MinHeapNode(arr[i][0], i, 1);
			resultSize += arr[i].length;
		}

		// declaring array for result
		sortedArray = new int[resultSize];

		// printing the array with first element
		for (MinHeapNode i : nodeArray) {
			System.out.println(i);
		}

		// creating the minHeap from the first element of the array
		MinHeap heap = new MinHeap(nodeArray, n);

		// printing the heap
		System.out.println();
		for (MinHeapNode i : heap.hArr) {
			System.out.println(i);
		}

		System.out.println();
		// Run a loop until the size of MinHeap is greater than zero.
		for (int i = 0; i < resultSize; i++) {
			System.out.println("Minimum fetched node: " + heap.getMin());

			// fetch the min element
			MinHeapNode min = heap.getMin();

			// add the element into sorted array
			sortedArray[i] = min.val;

			// if the array has some elements then replace the root with new node
			if (min.nextEle < arr[min.arrPos].length) {
				min.val = arr[min.arrPos][min.nextEle];
				min.nextEle++;
			} else {
				min.val = Integer.MAX_VALUE;
			}
			heap.replaceMin(min);
			//
		}

		return sortedArray;
		
	}

	public static void main(String[] args) {

		int[][] arr1 = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 34, 90, 2000 } };

		int[] sortedArray = mergeSortedArray(arr1);

		System.out.println("\nSorted Array");
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(" " + sortedArray[i]);
		}

		// TODO Auto-generated method stub
//		MinHeapNode arr[] = { new MinHeapNode(4, 0, 0), new MinHeapNode(3, 0, 0), new MinHeapNode(5, 0, 1),
//				new MinHeapNode(8, 0, 2), new MinHeapNode(6, 0, 3), new MinHeapNode(3, 0, 4),
//				new MinHeapNode(2, 0, 5) };
//
//		MinHeap heap = new MinHeap(arr, 7);
//
//		for (MinHeapNode i : heap.hArr) {
//			System.out.print(" " + i);
//		}
	}

}
