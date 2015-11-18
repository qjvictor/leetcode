package datastructure.tree;

import java.util.*;


/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 
 * @author VictorQian
 *
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if(root==null) return ret;
		Queue<TreeNode> list = new LinkedList<>();
		list.add(root);
		int len = 1;
		while (!list.isEmpty()) {
			TreeNode node = list.poll();
			len--;
			if (node.left != null)
				list.offer(node.left);
			if (node.right != null)
				list.offer(node.right);
			if (len == 0) {
				ret.add(node.val);
				len = list.size();
			}
		}
		return ret;
    }
	
	public List<Integer> _rightSideView(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		rightSideView(root, 0, list);
		return list;
	}

	public void rightSideView(TreeNode root, int level, ArrayList<Integer> list) {
		if (root == null)
			return;
		if (list.size() == level)
			list.add(root.val);
		rightSideView(root.right, level + 1, list);// try right.
		rightSideView(root.left, level + 1, list);// try left.
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.right.left = new TreeNode(4);
		t1.right.right = new TreeNode(5);
		t1.left.left = new TreeNode(21);
		t1.left.right = new TreeNode(22);
		t1.left.left.left = new TreeNode(23);
		BinaryTreeRightSideView c = new BinaryTreeRightSideView();
		System.out.println(c._rightSideView(t1));
	}
}
