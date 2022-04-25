/**
 * https://leetcode.com/problems/word-ladder/ 
 */
package com.graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author satis
 *
 */
public class WordLadder {
	// length of a single word
	int m;

	/**
	 * Time: O(n * m * m)
	 * Space: O(n * m)
	 * 
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// first try to create adjList, where the key would be n-1 char and 1 wild
		// card and it will contain all the words in adj which are differ by 1.
		m = beginWord.length();

		// if endWord is not available in endList
		boolean flag = false;
		for (String w : wordList) {
			if (w.equals(endWord)) {
				flag = true;
				break;
			}
		}
		if (!flag)
			return 0;

		// add the beginWord into set and prepare the adjacency list
		wordList.add(beginWord);
		Map<String, List<String>> adjList = prepareAdjList(wordList);

		int opr = 0;
		// apply bfs
		Deque<String> q = new ArrayDeque<>();
		q.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		while (!q.isEmpty()) {
			int size = q.size();
			opr++;
			for (int b = 0; b < size; b++) {
				String current = q.poll();

				if (current.equals(endWord))
					return opr;

				// get the neighbours of current node which differs by 1
				for (int i = 0; i < m; i++) {
					String pattern = current.substring(0, i) + "*" + current.substring(i + 1, m);
					for (String nei : adjList.get(pattern)) {
						if (!visited.contains(nei)) {
							// if (nei.equals(endWord))
							// return opr;
							q.offer(nei);
							visited.add(nei);
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * Time: O(n * m * m)
	 * 
	 * @param wordSet
	 * @return
	 */
	private Map<String, List<String>> prepareAdjList(List<String> wordSet) {
		Map<String, List<String>> adjList = new HashMap<>();

		/**
		 * It will look like: *ot: hot dot lot , h*t: hit hot
		 */
		for (String w : wordSet) {
			// replace all characters of w with wildcard * 1 by 1 and add
			// the word into the adjList.
			for (int i = 0; i < m; i++) {
				String wildStr = w.substring(0, i) + "*" + w.substring(i + 1, m);

				// now check if the key is not exist then allocate arrayList
				if (!adjList.containsKey(wildStr)) {
					adjList.put(wildStr, new ArrayList<>());
				}

				adjList.get(wildStr).add(w);
			}
		}
		return adjList;
	}

}
