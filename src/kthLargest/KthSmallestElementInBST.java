package kthLargest;
import java.util.Stack;

import datastructure.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 <= k <= BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author VictorQian
 * 
 */
public class KthSmallestElementInBST {
	// in-order solution.
	// simple, but it is O(n).
	public int kthSmallest2(TreeNode root, int k) {
		if (root == null)
			return -1;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				TreeNode t = s.pop();
				k--;
				if (k == 0)
					return t.val;
				root = t.right;
			}
		}
		return -1;
	}
	//count the nodes.
	//drawback: duplicated calculation of node count.
	public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
	
	
	public static void main(String[] args){
		TreeNode t = new TreeNode(10);
		t.left=new TreeNode(7);
		t.left.left=new TreeNode(4);
		t.left.right=new TreeNode(8);
		t.right=new TreeNode(16);
		t.right.left=new TreeNode(12);
		t.right.right=new TreeNode(19);
		KthSmallestElementInBST m = new KthSmallestElementInBST();
		System.out.println(m.kthSmallest(t, 6));
		System.out.println(m.kthSmallest2(t, 6));
	}
}
