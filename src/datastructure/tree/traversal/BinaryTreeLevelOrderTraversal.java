package datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.tree.SameTree;
import datastructure.tree.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

 * @author VictorQian
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if(root==null) return ret;
		List<Integer> list = new ArrayList<>();
		int count = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			count--;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			if (count == 0) {
				ret.add(new ArrayList<>(list));
				list = new ArrayList<>();
				count = queue.size();
			}
		}
		return ret;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(4);
		t1.right.left = new TreeNode(5);
		t1.right.right = new TreeNode(6);
		BinaryTreeLevelOrderTraversal c = new BinaryTreeLevelOrderTraversal();
		System.out.println(c.levelOrder(t1));
	}
}
