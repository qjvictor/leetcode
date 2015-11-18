package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5

Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1

Longest consecutive sequence path is 2-3,not3-2-1, so return 2. 
 * @author VictorQian
 *
 */
public class BinaryTreeLongestConsecutiveSequence {
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.right = new TreeNode(3);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(4);
		t1.right.right.right = new TreeNode(5);
		BinaryTreeLongestConsecutiveSequence c = new BinaryTreeLongestConsecutiveSequence();
		System.out.println(c.longestConsecutive(t1));
		
		TreeNode t2 = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.right.left = new TreeNode(2);
		t2.right.left.left = new TreeNode(1);
		System.out.println(c.longestConsecutive(t2));
		
	}
	
	public int longestConsecutive(TreeNode root) {
		int[] max = new int[]{0};
        longestConsecutive(root, max);
        return max[0];
    }

	private int longestConsecutive(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int res = 1;
        int left = longestConsecutive(node.left, max);
        int right = longestConsecutive(node.right, max);
        if (node.left == null || node.val + 1 != node.left.val) {
            left = 0;
        }
        if (node.right == null || node.val + 1 != node.right.val) {
            right = 0;
        }
        res += Math.max(right, left);
        max[0] = Math.max(res, max[0]);
        return res;
    }
}
