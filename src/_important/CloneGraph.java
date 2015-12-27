package _important;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:

Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 * @author VictorQian
 *
 */
public class CloneGraph {
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	//BFS
	//create a mapping between original and cloned
	//a queue to traverse original nodes
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null) return null;
		//a queue to traverse.
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
	    q.add(node);
	    
	    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	    //a mapping.
	    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	    map.put(node, copy);
	    while (!q.isEmpty()) {
	        UndirectedGraphNode cur = q.poll();
	        for (UndirectedGraphNode neigh : cur.neighbors) {
	            if (map.containsKey(neigh))
	            	map.get(cur).neighbors.add(map.get(neigh));
	            else {
	                UndirectedGraphNode neighCopy = new UndirectedGraphNode(neigh.label);
	                map.put(neigh, neighCopy);
	                map.get(cur).neighbors.add(neighCopy);
	                q.add(neigh);
	            }
	        }
	    }
	    return copy;
	}
	//DFS
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null)
			return null;
		return clone(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(node))
			return map.get(node);
		UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
		map.put(node, cloned);
		for (UndirectedGraphNode n : node.neighbors)
			cloned.neighbors.add(clone(n,map));
		return cloned;
	}
	
	public static void main(String[] args){
		CloneGraph c = new CloneGraph();
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		neighbors.add(n2);
		neighbors.add(n3);
		n1.neighbors = neighbors;
		UndirectedGraphNode clonedBFS = c.cloneGraphBFS(n1);
		System.out.println(clonedBFS);
		UndirectedGraphNode clonedDFS = c.cloneGraphBFS(n1);
		System.out.println(clonedDFS);
	}
}
