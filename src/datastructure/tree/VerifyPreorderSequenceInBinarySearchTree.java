package datastructure.tree;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * @author VictorQian
 * 
 */
public class VerifyPreorderSequenceInBinarySearchTree {
	/**
	 * Kinda simulate the traversal, keeping a stack of nodes (just their
	 * values) of which we're still in the left subtree. If the next number is
	 * smaller than the last stack value, then we're still in the left subtree
	 * of all stack nodes, so just push the new one onto the stack. But before
	 * that, pop all smaller ancestor values, as we must now be in their right
	 * subtrees (or even further, in the right subtree of an ancestor). Also,
	 * use the popped values as a lower bound, since being in their right
	 * subtree means we must never come across a smaller number anymore.
	 */
	public boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE;
		Stack<Integer> path = new Stack<>();
		for (int p : preorder) {
			if (p < low)
				return false;
			while (!path.empty() && p > path.peek())
				low = path.pop();
			path.push(p);
		}
		return true;
	}
	
	public boolean verifyPostorder(int[] nums) {
		int i = nums.length;
		int root = Integer.MAX_VALUE;
		for (int j = nums.length - 1; j >= 0; j--) {
			if (nums[j] > root)
				return false;
			while (i <= nums.length - 1 && nums[j] > nums[i])
				root = nums[i++];
			nums[--i] = nums[j];
		}
		return true;
	}

	public static void main(String[] args) {
		VerifyPreorderSequenceInBinarySearchTree v = new VerifyPreorderSequenceInBinarySearchTree();
		System.out.println(v.verifyPreorder(new int[] { 10, 5, 7, 15, 12, 18 }));
	}
}
