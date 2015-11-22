package datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.tree.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author VictorQian
 *
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null)
			return ret;
		Stack<TreeNode> stk = new Stack<>();
		TreeNode lastVisited = null;
		while (!stk.isEmpty() || root != null) {
			if (root != null) {
				stk.push(root);
				root = root.left;
			} else {
				TreeNode peek = stk.peek();
				if (peek.right != null && peek.right != lastVisited) {
					root = peek.right;
				} else {
					stk.pop();
					ret.add(peek.val);
					lastVisited = peek;
				}
			}
		}
		return ret;
    }
}
