package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]
 * @author VictorQian
 *
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ret = new ArrayList<>();
		if (root == null)
			return ret;
		helper(root, ret, root.val + "");
		return ret;
    }
	
	private void helper(TreeNode root, List<String> ret, String sb){
		if (root.left == null && root.right == null) {
			ret.add(sb);
			return;
		}
		if (root.left != null) {
			helper(root.left, ret, sb + "->" + root.left.val);
		}
		if (root.right != null) {
			helper(root.right, ret, sb + "->" + root.right.val);
		}
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.right = new TreeNode(4);
		t.right = new TreeNode(5);
		BinaryTreePaths c = new BinaryTreePaths();
		System.out.println( c.binaryTreePaths(t));
	}
}
