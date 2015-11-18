package datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import datastructure.tree.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 * 
 * @author VictorQian
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null)
			return ret;

		Queue<TreeNode> nodeList = new LinkedList<>();
		nodeList.offer(root);
		boolean leftToRight = true;
		while (!nodeList.isEmpty()) {
			List<Integer> valueList = new ArrayList<>();
			int len = nodeList.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = nodeList.poll();
				if (leftToRight) {
					valueList.add(node.val);
				} else {
					valueList.add(0, node.val);
				}
				if (node.left != null)
					nodeList.offer(node.left);
				if (node.right != null)
					nodeList.offer(node.right);
			}
			leftToRight = !leftToRight;
			ret.add(valueList);
		}
		return ret;
    }
	
	public List<List<Integer>> _zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null)
			return ret;
		List<Integer> valueList = new ArrayList<>();
		Stack<TreeNode> nodeList = new Stack<>();
		Stack<TreeNode> nextNodeList = new Stack<>();
		nodeList.push(root);
		boolean leftToRight = false;
		while (!nodeList.isEmpty()) {
			TreeNode node = nodeList.pop();
			valueList.add(node.val);
			if (!leftToRight) {
				if (node.left != null) {
					nextNodeList.push(node.left);
				}
				if (node.right != null) {
					nextNodeList.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextNodeList.push(node.right);
				}
				if (node.left != null) {
					nextNodeList.push(node.left);
				}
			}
			if (nodeList.isEmpty()) {
				nodeList = new Stack<TreeNode>();
				nodeList.addAll(nextNodeList);
				nextNodeList = new Stack<TreeNode>();
				leftToRight = !leftToRight;
				ret.add(new ArrayList<>(valueList));
				valueList = new ArrayList<>();
			}
		}
		return ret;
    }
	
	
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.left.right.left = new TreeNode(10);
		t.left.right.right = new TreeNode(15);
		t.right = new TreeNode(5);
		t.right.left = new TreeNode(6);
		t.right.right = new TreeNode(7);
		BinaryTreeZigzagLevelOrderTraversal c = new BinaryTreeZigzagLevelOrderTraversal();
		System.out.println( c._zigzagLevelOrder(t));
	}
}
