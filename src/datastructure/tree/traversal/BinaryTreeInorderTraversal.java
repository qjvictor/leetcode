package datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.tree.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author VictorQian
 *
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null){
            if(root!=null){
                stk.push(root);
                root=root.left;
            }else{
                TreeNode t = stk.pop();
                ret.add(t.val);
                root = t.right;
            }
        }
        return ret;
    }
	
	public List<Integer> _inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
	}
	
	private void helper(TreeNode node, List<Integer> list){
		if(node==null) return;
		helper(node.left, list);
		list.add(node.val);
		helper(node.right, list);
	}
}
