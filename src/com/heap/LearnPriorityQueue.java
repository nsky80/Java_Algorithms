package com.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LearnPriorityQueue {

	public static void main(String[] args) {
//		int arr[] = { 1, 9, 8, 7, 13, 5 };
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return 1;
				else 
					return -1;
			}

		});
		q.addAll(Arrays.asList(1, 9, 8, 7, 13, 5));

		System.out.println(q);
		demonstrateCustomComparator();
	}

	public static void demonstrateCustomComparator() {
		// A custom comparator that compares two Strings by their length.
		Comparator<String> customComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};

		// Create a Priority Queue with a custom Comparator
		PriorityQueue<String> colorsPriorityQueue = new PriorityQueue<>(customComparator);

		// Add items to a Priority Queue
		colorsPriorityQueue.add("Green");
		colorsPriorityQueue.add("Cyan");
		colorsPriorityQueue.add("Magenta");
		colorsPriorityQueue.add("Yellow");
		colorsPriorityQueue.add("Blue");
		colorsPriorityQueue.add("Red");

// Printing all elements 
		System.out.println("\nThe PriorityQueue elements with custom Comparator:");
		System.out.println(colorsPriorityQueue);
//        Iterator iter1 = colorsPriorityQueue.iterator(); 
//        while (iter1.hasNext()) 
//            System.out.print(iter1.next() + " "); 
	}

}
