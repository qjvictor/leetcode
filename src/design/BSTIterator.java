package design;

import java.util.Stack;

import datastructure.tree.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author VictorQian
 * 
 */
public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		pushToStack(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode cur = stack.pop();
		pushToStack(cur.right);
		return cur.val;
	}

	// When the root is given (constructor), we push its left subtree with only
	// left children into the stack. When next() is called, pop the current
	// value and push the right subtree into the stack (the left subtree in
	// right subtree).
	private void pushToStack(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(2);
		// t.left.left=new TreeNode(21);
		t.right = new TreeNode(30);
		t.right.left = new TreeNode(15);
		t.right.right = new TreeNode(50);
		BSTIterator b = new BSTIterator(t);
		while (b.hasNext()) {
			System.out.println(b.next());
		}

	}
}
