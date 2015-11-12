package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

 * @author VictorQian
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
	
	public boolean isSymmetric1(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.left == null || root.right == null)
			return false;
		LinkedList<TreeNode> leftQueue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> rightQueue = new LinkedList<TreeNode>();
		leftQueue.add(root.left);
		rightQueue.add(root.right);
		while(!leftQueue.isEmpty() && !rightQueue.isEmpty()){
			TreeNode left = leftQueue.poll();
			TreeNode right = rightQueue.poll();
			if (left == null && right == null) {
				continue;
			} else if (left == null || right == null) {
				return false;
			} else {
				if (left.val != right.val)
					return false;
				leftQueue.add(left.left);
				leftQueue.add(left.right);
				rightQueue.add(right.right);
				rightQueue.add(right.left);
			}
		}
		
		return leftQueue.isEmpty() && rightQueue.isEmpty();
	}
	
	public boolean isSymmetric2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.left == null || root.right == null)
			return false;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root.left);
		stk.push(root.right);
		while (!stk.isEmpty()) {
			TreeNode node1 = stk.pop();
			TreeNode node2 = stk.pop();
			if (node1.val != node2.val) {
				return false;
			}
			if ((node1.left == null && node2.right != null) || (node1.left != null && node2.right == null))
				return false;
			if ((node1.right == null && node2.left != null) || (node1.right != null && node2.left == null))
				return false;
			if (node1.left != null) {
				stk.push(node1.left);
				stk.push(node2.right);
			}
			if (node1.right != null) {
			    stk.push(node1.right);
				stk.push(node2.left);
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		//t.left.right = new TreeNode(4);
		t.right = new TreeNode(2);
		t.right.left = new TreeNode(4);
		t.right.right = new TreeNode(3);
		//t.right.right.left = new TreeNode(3);
		SymmetricTree c = new SymmetricTree();
		System.out.println(c.isSymmetric2(t));
	}
}
