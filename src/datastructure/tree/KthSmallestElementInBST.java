package datastructure.tree;

import java.util.HashMap;
import java.util.Stack;

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
	//in-order, when reaching k, return it.
	public int _kthSmallest(TreeNode root, int k) {
		if (root == null)
			return -1;
		if (k <= 0)
			return -1;
		Stack<TreeNode> stk = new Stack<>();
		int index = 0;
		while (!stk.isEmpty() || root != null) {
			if (root != null) {
				stk.push(root);
				root = root.left;
			} else {
				TreeNode cur = stk.pop();
				index++;
				if (index == k) {
					return cur.val;
				}
				root = cur.right;
			}
		}
		return -1;
	}
	
	public int kthSmallest(TreeNode root, int k) {
		int leftCount = countNodes(root.left) + 1; // left count = left sub tree
													// nodes + currnt root node.
		if (leftCount == k) {
			return root.val;
		} else if (leftCount > k) { // go left.
			return kthSmallest(root.left, k);
		} else { // go right.
			return kthSmallest(root.right, k - leftCount);
		}
	}

	private int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	public int kthSmallest1(TreeNode root, int k) {
		if (root == null)
			return -1;
		if (k <= 0)
			return -1;
		if(map.isEmpty())
			findCount(root);
		return findK(root, k);
	}
	
	private int findK(TreeNode root, int k){
		int count = map.get(root);
		if (count == k) {
			return root.val;
		} else {
			return findK(count > k? root.left:root.right, k);
		} 
	}
	HashMap<TreeNode, Integer> map = new HashMap<>();
	private void findCount(TreeNode root){
		if(!map.isEmpty()) return;
		Stack<TreeNode> stk = new Stack<>();
		int index = 0;
		while (!stk.isEmpty() || root != null) {
			if (root != null) {
				stk.push(root);
				root = root.left;
			} else {
				TreeNode cur = stk.pop();
				index++;
				map.put(cur, index);
				root = cur.right;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		t1.left = new TreeNode(5);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(25);
		KthSmallestElementInBST c = new KthSmallestElementInBST();
		System.out.println(c.kthSmallest1(t1, 5));
	}
	
}
