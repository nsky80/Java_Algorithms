/**
 * 
 */
package com.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the way to store the min-heap
 * 
 * @author satis
 *
 */
class MinHeap {
	private int heapSize;
	private List<Integer> heapArray;

	/**
	 * Default constructor
	 */
	public MinHeap() {
		heapArray = new ArrayList<>();
		heapSize = 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param arr
	 */
	public MinHeap(int[] arr) {
		heapArray = new ArrayList<>();
		heapSize = arr.length;
		for (int i = 0; i < heapSize; i++) {
			heapArray.add(arr[i]);
		}

		// create the heap from here
		for (int i = (heapSize / 2) - 1; i >= 0; i--) {
			minHeapify(i);
		}
	}

	/**
	 * This method heapify the heap as per given index
	 * 
	 * @param i
	 */
	private void minHeapify(int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		int current = i;

		// check left key
		if (left < heapSize && heapArray.get(left) < heapArray.get(current)) {
			current = left;
		}

		// check the right key
		if (right < heapSize && heapArray.get(right) < heapArray.get(current)) {
			current = right;
		}

		if (current != i) {
			// swap the values
			int temp = heapArray.get(i);
			heapArray.set(i, heapArray.get(current));
			heapArray.set(current, temp);

			// call heapify with newly swapped node
			minHeapify(current);
		}
	}

	/**
	 * Returns the minimum from the else throw exception
	 * 
	 * @return minimum
	 * @throws Exception
	 */
	public int extractMin() throws Exception {
		if (heapSize <= 0) {
			throw new Exception("Heap Underflow");
		}
		// swap first and last value
		int min = heapArray.get(0);
		heapArray.set(0, heapArray.get(heapSize - 1));

		// decrease the size of the heap
		heapSize--;
		// remove the last element from the heap
		heapArray.remove(heapSize);

		// heapify
		minHeapify(0);
		return min;
	}

	/**
	 * This method returns the heapSize
	 * 
	 * @return size of the heap
	 */
	public int getHeapSize() {
		return heapSize;
	}

	/**
	 * This method decreases the key by given value
	 * 
	 * @param key
	 * @param index
	 * @return true if decreases successfully else false
	 */
	public boolean decreaseKey(int key, int index) {
		// checking safety of parameters
		// As we are decreasing the key, so it should be less
		if (heapSize <= 0 || index < 0 || index >= heapSize || key > heapArray.get(index)) {
			return false;
		}

		// change the value
		heapArray.set(index, key);

		// get the parent of given node
		int parent = (int) (Math.ceil((double) index / 2) - 1);

		int current = index;

		// balance the heap
		while (parent >= 0 && heapArray.get(parent) > heapArray.get(current)) {
			// swap the values
			int temp = heapArray.get(parent);
			heapArray.set(parent, heapArray.get(current));
			heapArray.set(current, temp);

			// for next iteration
			current = parent;
			parent = (int) (Math.ceil((double) parent / 2) - 1);
		}

		return true;
	}

	/**
	 * This method adds the given value in the heap
	 * 
	 * @param value
	 * @return
	 */
	public boolean add(int value) {
		// add maximum possible value in the heap
		heapArray.add(Integer.MAX_VALUE);

		// increase the heap size
		heapSize++;

		// now decrease this key with the given value
		return decreaseKey(value, heapSize - 1);
	}

	@Override
	public String toString() {
		return "MinHeap: " + heapArray;
	}
}

/**
 * @author satis
 *
 */
public class MinHeapUtil {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int arr[] = { 1, 9, 8, 7, 13, 5 };
//		MinHeap heap = new MinHeap(arr);
//		System.out.println(heap);
//
//		System.out.println(heap.extractMin());
//		System.out.println(heap);
//		System.out.println(heap.extractMin());
//		System.out.println(heap);
//
//		System.out.println(heap.decreaseKey(2, 2));
//
		MinHeap heap2 = new MinHeap();
		System.out.println(heap2);

		for (int i : arr) {
			heap2.add(i);
			System.out.println(heap2);
		}
	}

}
