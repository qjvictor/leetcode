package datastructure.tree;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author VictorQian
 * 
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		//t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(4);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(7);
		MaximumDepthOfBinaryTree c = new MaximumDepthOfBinaryTree();
		System.out.println(c.maxDepth(t1));
	}
}
