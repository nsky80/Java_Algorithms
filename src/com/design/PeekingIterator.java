/**
 * https://leetcode.com/problems/peeking-iterator/
 */
package com.design;

import java.util.Iterator;
import java.util.NoSuchElementException;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iter;
	boolean noMoreAvailable;
	Integer nextElement;

	private void movePointer() {
		if (iter.hasNext()) {
			nextElement = iter.next();
		} else {
			noMoreAvailable = true;
			nextElement = null;

		}
	}

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		noMoreAvailable = false;
		movePointer();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return nextElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (noMoreAvailable)
			throw new NoSuchElementException();
		Integer res = nextElement;
		movePointer();
		return res;
	}

	@Override
	public boolean hasNext() {
		return !noMoreAvailable;
	}

	public static void main(String[] args) {

	}
}