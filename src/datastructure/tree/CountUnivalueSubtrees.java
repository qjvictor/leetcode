package datastructure.tree;
/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5

return 4. 
 * @author VictorQian
 *
 */
public class CountUnivalueSubtrees {
	
	public int countUnivalSubtrees(TreeNode root) {
		// DFS
		int[] ret = new int[1];
		ret[0] = 0;
		IsUnivalue(root, ret);
		return ret[0];
	}

	// Return if this tree is Univalue
	private boolean IsUnivalue(TreeNode root, int[] ret) {
		if (root == null)
			return true;

		boolean isLeft = IsUnivalue(root.left, ret);
		boolean isRight = IsUnivalue(root.right, ret);
		if (!isLeft || !isRight)
			return false;

		if (root.left != null && root.val != root.left.val)
			return false;

		if (root.right != null && root.val != root.right.val)
			return false;

		ret[0] += 1;
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(5);
		t.left.left = new TreeNode(5);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(5);
		t.right.right = new TreeNode(5);
		CountUnivalueSubtrees c = new CountUnivalueSubtrees();
		System.out.println(c.countUnivalSubtrees(t));
		
		t = new TreeNode(5);
		t.left = new TreeNode(1);
		t.right = new TreeNode(4);
		c = new CountUnivalueSubtrees();
		System.out.println(c.countUnivalSubtrees(t));
	}
}
