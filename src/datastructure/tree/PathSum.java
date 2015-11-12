package datastructure.tree;
/**
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
 *  that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author VictorQian
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null && root.right==null) return sum==root.val;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(4);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(7);
		PathSum c = new PathSum();
		System.out.println(c.hasPathSum(t1, 5));
		System.out.println(c.hasPathSum(t1, 6));
		System.out.println(c.hasPathSum(t1, 12));
	}
}
