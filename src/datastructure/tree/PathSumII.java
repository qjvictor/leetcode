package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 * @author VictorQian
 *
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        helper(root, sum, ret, list);
        return ret;
    }
	
	private void helper(TreeNode node, int sum, List<List<Integer>> ret, List<Integer> list) {
		if (sum == node.val && node.left == null && node.right == null) {
			ret.add(new ArrayList<>(list));
			return;
		}
		if (node.left != null) {
			list.add(node.left.val);
			helper(node.left, sum - node.val, ret, list);
			list.remove(list.size() - 1);
		}
		if (node.right != null) {
			list.add(node.right.val);
			helper(node.right, sum - node.val, ret, list);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(0);
		t1.left = new TreeNode(1);
		t1.right = new TreeNode(1);
		PathSumII c = new PathSumII();
		System.out.println(c.pathSum(t1, 1));
	}
}
