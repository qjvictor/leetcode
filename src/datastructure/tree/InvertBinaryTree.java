package datastructure.tree;
/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * @author VictorQian
 *
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root==null || (root.left==null && root.right==null)) return root;
		TreeNode tmp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = tmp;
		return root;
    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.right = new TreeNode(4);
		t.right.left = new TreeNode(5);
		t.right.right = new TreeNode(6);
		InvertBinaryTree c = new InvertBinaryTree();
		TreeNode t1 = c.invertTree(t);
		System.out.println(t1);
	}
}
