package graph;

import java.util.*;

/**
 *  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 *  write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3
     |          |
     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4
     |           |
     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges. 
 * @author VictorQian
 *
 */
public class NumberOfConnectedComponentsInAUndirectedGraph {
	public static void main(String[] args) {
		NumberOfConnectedComponentsInAUndirectedGraph n = new NumberOfConnectedComponentsInAUndirectedGraph();
		System.out.println(n.countComponents(5, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 3, 4 } }));
		System.out.println(n.countComponents(5, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } }));
		System.out.println(n.countComponents(5, new int[][] {new int[]{3,4}}));
		System.out.println(n.countComponents(3, new int[][] {new int[]{1,0},new int[]{0,2},new int[]{2,1}}));
		System.out.println(n.countComponents(2, new int[][] {new int[]{1,0}}));
	}

	public int countComponents(int n, int[][] edges) {
		if (n <= 0)
			return 0;
		List<Integer>[] outDegrees = new ArrayList[n];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			outDegrees[i] = new ArrayList<Integer>();
			list.add(i);
		}
		for (int[] edge : edges) {
			outDegrees[edge[0]].add(edge[1]);
			outDegrees[edge[1]].add(edge[0]);
		}

		int ret = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int val = queue.poll();
			list.remove((Integer) val);
			for (int out : outDegrees[val]) {
				if (list.contains((Integer) out)) //key, without this, it might cause infinite loop.
					queue.add(out);

			}
			if (queue.isEmpty() && !list.isEmpty()) {
				ret++;
				queue.add(list.get(0));
			}
		}
		return ret;
	}
}
