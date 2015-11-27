package binarysearch;

import datastructure.tree.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author VictorQian
 * 
 */
public class KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;
		int leftAndRoot = countNodes(root.left) + 1;
		if (leftAndRoot == k) {
			return root.val;
		} else if (leftAndRoot < k) {
			return kthSmallest(root.right, k - leftAndRoot);
		} else {
			return kthSmallest(root.left, k);
		}
    }
	
	private int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		t1.left = new TreeNode(5);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(25);
		KthSmallestElementInBST c = new KthSmallestElementInBST();
		System.out.println(c.kthSmallest(t1, 5));
	}
}
