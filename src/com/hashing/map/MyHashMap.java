/**
 * https://leetcode.com/problems/design-hashmap/
 */
package com.hashing.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Questions: For simplicity, are the keys integers only? For collision
 * resolution, can we use chaining? Do we have to worry about load factors? Can
 * we assume inputs are valid or do we have to validate them? Can we assume this
 * fits memory?
 * 
 * Node of list, here key and value both are integer as question demands
 * 
 * @author Satish Kumar Yadav
 */
class HashNode {
	int key;
	int value;
	int hashCode;
	HashNode next;

	public HashNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

/**
 * @author Satish Kumar Yadav
 *
 */
public class MyHashMap {
	private int size;
	private int bucketSize;
	private final float LOAD_FACTOR = 0.7f;
	private final int INITIAL_BUCKET_SIZE = 50;
	private List<HashNode> bucketList;

	private int getBucketIndex(int key) {
		return key % bucketSize;
	}

	public MyHashMap() {
		bucketSize = INITIAL_BUCKET_SIZE;
		size = 0;
		bucketList = new ArrayList<>(bucketSize);

		// initializing the each bucket with null
		for (int i = 0; i < bucketSize; i++) {
			bucketList.add(null);
		}
	}

	public void put(int key, int value) {
		int index = getBucketIndex(key);

		// if current key already exist then update the corresponding value
		HashNode head = bucketList.get(index);

		// if key exists then add the update the value and return.
		while (head != null) {
			if (head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// otherwise increase the size and add the node
		size++;
		HashNode node = new HashNode(key, value);
		node.next = bucketList.get(index);
		bucketList.set(index, node);

		// If load factor goes beyond threshold, then double hash table size
		if ((size * 1.0) / bucketSize >= LOAD_FACTOR) {
			rehash();
		}
	}

	/**
	 * It copies the current bucket into a new bucket of size n.
	 */
	private void rehash() {
		List<HashNode> oldBucket = bucketList;
		bucketSize *= 2;
		size = 0;
		bucketList = new ArrayList<>(bucketSize);
		for (int i = 0; i < bucketSize; i++) {
			bucketList.add(null);
		}

		// now call for each value recursively and add into the new hash
		for (HashNode currentHead : oldBucket) {
			while (currentHead != null) {
				put(currentHead.key, currentHead.value);
				currentHead = currentHead.next;
			}
		}
	}

	public int get(int key) {
		HashNode head = bucketList.get(getBucketIndex(key));

		// check whether value present in the list or not
		while (head != null) {
			if (head.key == key)
				break;
			head = head.next;
		}
		// if key found then return value otherwise return -1
		return head == null ? -1 : head.value;
	}

	public void remove(int key) {
		// first try to get the node
		HashNode prev = null;
		int index = getBucketIndex(key);
		HashNode head = bucketList.get(index);

		while (head != null) {
			if (head.key == key)
				break;
			prev = head;
			head = head.next;
		}

		// if key is not available then return
		if (head == null)
			return;

		// decrease the size
		size--;

		// if this is first node then simply put the next node into the list
		if (prev == null) {
			bucketList.set(index, head.next);
		} else {
			// otherwise skip the element
			prev.next = head.next;
		}
	}

	public static void main(String[] args) {
//		["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//				[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
		MyHashMap map = new MyHashMap();
		map.put(1, 1);
		map.put(2, 2);
		System.out.println(map.get(1));
		System.out.println(map.get(3));
		map.put(2, 1);
		System.out.println(map.get(2));
		map.remove(2);
		System.out.println(map.get(2));

	}
}
