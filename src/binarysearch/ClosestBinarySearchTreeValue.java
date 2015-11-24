package binarysearch;

import datastructure.tree.TreeNode;

/**
 *  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target. 
 *  Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

 * @author VictorQian
 *
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		if (root == null)
			return -1;
		int closest = root.val;
		while (root != null) {
			closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
			root = target < root.val ? root.left : root.right;
		}
		return closest;
    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(5);
		t.left.left = new TreeNode(3);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(25);
		t.right.right = new TreeNode(35);
		ClosestBinarySearchTreeValue c = new ClosestBinarySearchTreeValue();
		System.out.println(c.closestValue(t, 22.3));

		TreeNode t1 = new TreeNode(0);
		System.out.println(c.closestValue(t1, 2147483648.0));
	}
}
