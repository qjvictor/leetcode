package datastructure.tree;

import java.util.LinkedList;

/**
 *  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 * @author VictorQian
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.right != null) { // put the right part to list.
				list.push(cur.right);
			}
			if (cur.left != null) {
				cur.right = cur.left;
				cur.left = null; // important.
			} else if (!list.isEmpty()) {
				cur.right = list.poll();
			}
			cur = cur.right;
		}
    }

	public void _flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.left); //flat the left.
		flatten(root.right);//flat the right.

		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null; // important.
		root.right = left; // connect to the left part.
		while (root.right != null) // move to the end.
			root = root.right;
		root.right = right; // connect to the right part.
	}
}
