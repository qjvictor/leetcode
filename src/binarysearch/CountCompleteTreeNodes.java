package binarysearch;

import datastructure.tree.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author VictorQian
 * 
 */
public class CountCompleteTreeNodes {
	//O(n) - TLE
	public int _countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = countNodes(root.left);
		if (left != 0) {
			return 1 + left + countNodes(root.right);
		}
		return 1;
    }
	
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode left = root;
		TreeNode right = root;
		int leftLen = 0;
		while (left != null) {
			left = left.left;
			leftLen++;
		}
		int rightLen = 0;
		while (right != null) {
			right = right.right;
			rightLen++;
		}
		if (leftLen == rightLen) {
			return (1 << leftLen) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
		
	}
	
	public static void main(String[] args){
		CountCompleteTreeNodes c = new CountCompleteTreeNodes();
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(2);
		root.right.left=new TreeNode(2);
		System.out.println(c.countNodes(root));
	}
}
