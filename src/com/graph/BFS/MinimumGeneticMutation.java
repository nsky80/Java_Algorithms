/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
package com.graph.BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author satis
 *
 */
public class MinimumGeneticMutation {

	/**
	 * Time: O(n * 8 * 4)
	 * Space: O(n2)
	 */
	static class SpaceOptimizedSolution {
		static final char[] CHAR_SET = { 'A', 'C', 'G', 'T' };

		public int minMutation(String start, String end, String[] bank) {
			// first check whether end present in bank or not
			Set<String> bankSet = new HashSet<>();
			boolean flag = false;
			for (String b : bank) {
				bankSet.add(b);
				if (b.equals(end))
					flag = true;
			}
			if (!flag)
				return -1;

			// apply BFS and calculate the shortest path
			int opr = 0;
			Deque<String> q = new ArrayDeque<>();
			q.offer(start);

			while (!q.isEmpty()) {
				int size = q.size();
				opr++;

				for (int tt = 0; tt < size; tt++) {
					char[] current = q.poll().toCharArray();

					// now get the adjacent of current string
					// by changing all the 8 chars by 4 available choices
					for (int c = 0; c < current.length; c++) {

						char backup = current[c];

						for (char mutation : CHAR_SET) {
							current[c] = mutation;
							String mutatedGene = String.valueOf(current);

							// now check whether it is a valid sequence.
							if (bankSet.contains(mutatedGene)) {
								if (mutatedGene.equals(end))
									return opr;

								// mark it as visited
								bankSet.remove(mutatedGene);
								q.offer(mutatedGene);
							}
						}

						// reverse the mutation
						current[c] = backup;
					}

				}
			}

			return -1;
		}

	}

	/**
	 * Time: O(n * 8 * 4)
	 * Space: O(n)
	 */
	static class SolutionWithAdjList {
		static final char[] CHAR_SET = { 'A', 'C', 'G', 'T' };
		static final int GENE_LENGTH = 8;

		public int minMutation(String start, String end, String[] bank) {
			// first check whether end present in bank or not
			Set<String> bankSet = new HashSet<>();
			boolean flag = false;
			for (String b : bank) {
				bankSet.add(b);
				if (b.equals(end))
					flag = true;
			}
			if (!flag)
				return -1;

			// add start into the set and create adj List
			bankSet.add(start);
			Map<String, Set<String>> adjList = createAdjList(bankSet);

			// apply BFS and calculate the shortest path
			int opr = 0;
			Deque<String> q = new ArrayDeque<>();
			Set<String> visited = new HashSet<>();
			q.offer(start);
			visited.add(start);

			while (!q.isEmpty()) {
				int size = q.size();
				opr++;

				for (int tt = 0; tt < size; tt++) {
					String current = q.poll();

					for (String adj : adjList.get(current)) {
						if (!visited.contains(adj)) {
							if (adj.equals(end))
								return opr;

							visited.add(adj);
							q.offer(adj);
						}
					}
				}
			}

			return -1;
		}

		// The core of this problem is preparation of adjList.
		private Map<String, Set<String>> createAdjList(Set<String> bankSet) {
			Map<String, Set<String>> adjList = new HashMap<>();

			for (String gene : bankSet) {
				adjList.put(gene, new HashSet<>());
				char[] mutableGene = gene.toCharArray();
				// make 4 changes for all 8 positions and check whether it is
				// part of set, if yes add into list
				for (int c = 0; c < GENE_LENGTH; c++) {
					char backup = mutableGene[c];

					// replace with all available four options
					for (char mutation : CHAR_SET) {
						mutableGene[c] = mutation;
						String mutatedGene = String.valueOf(mutableGene);

						// if this is a valid mutation
						if (bankSet.contains(mutatedGene)) {
							// add this into the adjList of the current word
							adjList.get(gene).add(mutatedGene);
						}
					}

					mutableGene[c] = backup;
				}
			}

			return adjList;
		}
	}
}
