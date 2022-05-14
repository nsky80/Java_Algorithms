/**
 * 
 */
package com.design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class FlattenNestedListIterator {

	/**
	 * This solution holds all the nestedList element and unroll only for 1 level,
	 * if the list is already unrolled then it's space can grow O(n).
	 * 
	 * @author Satish Kumar Yadav
	 *
	 */
	public class NestedIterator implements Iterator<Integer> {
		Deque<NestedInteger> stack;

		// check first tempList, if available then
		public NestedIterator(List<NestedInteger> nestedList) {
			stack = new ArrayDeque<>();
			unroll(nestedList);
		}

		@Override
		public Integer next() {
			return stack.pop().getInteger();
		}

		// It adds the value of current list into the stack
		public void unroll(List<NestedInteger> nestedList) {
			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}

		@Override
		public boolean hasNext() {
			// it checks whether 1 integer is accessible or not
			while (!stack.isEmpty() && !stack.peek().isInteger()) {
				unroll(stack.pop().getList());
			}
			return !stack.isEmpty(); // || ptr < nestedList.size();
		}
	}

	/**
	 * This approach has a space complexity of O(n), it is static solution, which
	 * will unroll all the values in 1 go and store it, this is not a reliable
	 * solution, specially when user have to perform 2 -4 next() and multiple
	 * hasNext() operation.
	 * 
	 * @author satis
	 *
	 */
	public class NestedIterator2 implements Iterator<Integer> {
		int tempPtr;
		List<Integer> tempList;
		int ptr;
		List<NestedInteger> nestedList;

		// check first tempList, if available then
		public NestedIterator2(List<NestedInteger> nestedList) {
			ptr = 0;
			tempPtr = 0;
			tempList = new ArrayList<>();
			for (int i = 0; i < nestedList.size(); i++) {
				tempList.addAll(unroll(nestedList.get(i)));
			}
			this.nestedList = nestedList;
		}

		@Override
		public Integer next() {
//	         while (tempPtr == tempList.size() && ptr < nestedList.size()){
//	             tempList = unroll(nestedList.get(ptr++));
//	             tempPtr = 0;
//	             // System.out.println(tempList);
//	         } 

//	         if (hasNext())
			return tempList.get(tempPtr++);
		}

		public List<Integer> unroll(NestedInteger ni) {
			List<Integer> li = new ArrayList<>();
			if (ni.isInteger()) {
				li.add(ni.getInteger());
				return li;
			}

			List<NestedInteger> cur = ni.getList();

			for (int i = 0; i < cur.size(); i++) {
				li.addAll(unroll(cur.get(i)));
			}

			return li;
		}

		@Override
		public boolean hasNext() {
			return tempPtr < tempList.size(); // || ptr < nestedList.size();
		}
	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
	 * = i.next();
	 */

	public static void main(String args[]) {
		/**
		 * Your NestedIterator object will be instantiated and called as such:
		 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
		 * = i.next();
		 */
	}

}
