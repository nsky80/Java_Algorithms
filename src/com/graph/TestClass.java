package com.graph;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

4
2
5
7
9
4
2 9 2
7 2 3
7 9 7
9 5 1
7
9

Output: 5
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;

class TestClass {
	static class AdjListNode {
		int nextVertex, time;

		AdjListNode(int v, int w) {
			nextVertex = v;
			time = w;
		}

		int getNextVertex() {
			return nextVertex;
		}

		int getTime() {
			return time;
		}

	}

	public static int getMinDistance(int numberOfVertices, ArrayList<ArrayList<AdjListNode>> graph, int source, int destination) {
		int[] dist = new int[numberOfVertices];
		
		
		// put infinite
		for (int i = 0; i < numberOfVertices; i++)
			dist[i] = Integer.MAX_VALUE;
		
		dist[source] = 0;

		PriorityQueue<AdjListNode> pq = new PriorityQueue<>((v1, v2) -> v1.getTime() - v2.getTime());
		
		// putting the source into q with 0
		pq.add(new AdjListNode(source, 0));

		while (pq.size() > 0) {
			AdjListNode current = pq.poll();

			for (AdjListNode n : graph.get(current.getNextVertex())) {
				if (dist[current.getNextVertex()] + n.getTime() < dist[n.getNextVertex()]) {
					dist[n.getNextVertex()] = n.getTime() + dist[current.getNextVertex()];
					pq.add(new AdjListNode(n.getNextVertex(), dist[n.getNextVertex()]));
				}
			}
		}
		return dist[destination];
	}

	public static void main(String args[]) {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 * 
		 * //Scanner Scanner s = new Scanner(System.in); String name = s.nextLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); // Writing
		 * output to STDOUT
		 * 
		 */

		// Write your code here
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());

		ArrayList<ArrayList<AdjListNode>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		HashMap<Integer, Integer> mapper = new HashMap<>();
		HashMap<Integer, Integer> reverse = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int vertex = Integer.parseInt(s.nextLine());
			reverse.put(i, vertex);
			mapper.put(vertex, i);
		}

		int n_edges = Integer.parseInt(s.nextLine());

		for (int i = 0; i < n_edges; i++) {
			String in = s.nextLine();
			int pqt[] = new int[3];
			String str[] = in.split(" ");
			for (int j = 0; j < 3; j++) {
				pqt[j] = Integer.parseInt(str[j]);
			}

			graph.get(mapper.get(pqt[0])).add(new AdjListNode(mapper.get(pqt[1]), pqt[2]));

		}
		int src = mapper.get(Integer.parseInt(s.nextLine()));
		int des = mapper.get(Integer.parseInt(s.nextLine()));

		System.out.println(getMinDistance(n, graph, src, des));
		s.close();
	
	}
}
