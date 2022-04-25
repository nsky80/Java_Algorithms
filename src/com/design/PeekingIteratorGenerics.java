package com.design;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

public class PeekingIteratorGenerics<E> implements Iterator<E> {
	Iterator<E> iter;
	private boolean noMoreAvailable;
	private E nextElement;

	private void movePointer() {
		if (iter.hasNext()) {
			nextElement = iter.next();
		} else {
			noMoreAvailable = true;
			nextElement = null;
		}
	}

	public PeekingIteratorGenerics(Iterator<E> iterator) {
		// initialize any member here.
		iter = iterator;
		noMoreAvailable = false;
		movePointer();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public E peek() {
		return nextElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public E next() {
		if (noMoreAvailable)
			throw new NoSuchElementException();
		E res = nextElement;
		movePointer();
		return res;
	}

	@Override
	public boolean hasNext() {
		return !noMoreAvailable;
	}

	public static void main(String[] args) {
		List<String> arr = Arrays.asList("Hello", "World");
		Iterator<String> iter = arr.listIterator();
		PeekingIteratorGenerics<String> myIter = new PeekingIteratorGenerics<>(iter);
		while(myIter.hasNext()) {
			System.out.println(myIter.next());
			System.out.println(myIter.peek());
		}
	}
}