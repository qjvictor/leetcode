package datastructure.tree;
/**
 *  Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree 
along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 
 * @author VictorQian
 *
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		int max = Integer.MIN_VALUE;
		int[] maxList = new int[] { max };
		helper(root, maxList);
		return maxList[0];
    }

	private int helper(TreeNode root, int[] maxList) {
		if (root == null)
	        return 0;
	    int left = helper(root.left, maxList);//左边一支儿（不算自己）
	    int right = helper(root.right, maxList);//右边一支儿（不算自己）
	    int arch = left + right + root.val; //穿过自己
	    int single = Math.max(root.val, Math.max(left, right) + root.val);//（算上自己）。
	    maxList[0] = Math.max(maxList[0], Math.max(arch, single));//update结果
	    return single;  //note:  return value can't be the 'arch'.
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(-4);
		t.right = new TreeNode(2);
		t.right.left = new TreeNode(4);
		BinaryTreeMaximumPathSum c = new BinaryTreeMaximumPathSum();
		System.out.println(c.maxPathSum(t));
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(-2);
		t1.right = new TreeNode(-2);
		
		System.out.println(c.maxPathSum(t1));
	}
}
