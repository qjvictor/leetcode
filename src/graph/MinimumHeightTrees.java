package graph;

import java.util.*;

/**
 *  For a undirected graph with tree characteristics, we can choose any node as the root. 
 *  The result graph is then a rooted tree. Among all possible rooted trees, 
 *  those with minimum height are called minimum height trees (MHTs). Given such a graph, 
 *  write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. 
You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3

return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5

return [3, 4]

Hint:

    How many MHTs can a graph have at most?

 * @author VictorQian
 *
 */
public class MinimumHeightTrees {
	
	public static void main(String[] args) {
		MinimumHeightTrees c2 = new MinimumHeightTrees();
		System.out.println(c2.findMinHeightTrees(4, new int[][] { new int[] { 1, 0 }, new int[] { 1, 2 }, new int[] { 1, 3 } }));
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<>();
		if (n <= 1) {
			leaves.add(0);
			return leaves;
		}

		// To quickly get adjencent nodes
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++)
			graph.put(i, new ArrayList<Integer>());

		// To quickly find and remove leaf
		int[] neighbors = new int[n];
		for (int[] e : edges) {
			neighbors[e[0]]++;
			neighbors[e[1]]++;
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		// Add leaves (leave has 1 neighbor)
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] == 1)
				leaves.add(i);
		}

		// Remove leaves level by level
		while (n > 2) {
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				n--;
				for (int nb : graph.get(leaf)) {
					if (neighbors[nb] == 2)
						newLeaves.add(nb);
					neighbors[nb]--;
				}
			}
			leaves = newLeaves;
		}
		return leaves;
	}
}
