package datastructure.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.tree.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3]. 
 * @author VictorQian
 *
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
        	TreeNode node = stk.pop();
        	ret.add(node.val);
        	if(node.right!=null){
        		stk.push(node.right);
        	}
        	if(node.left!=null){
        		stk.push(node.left);
        	}
        }
        return ret;
    }
	
	public List<Integer> _preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
	}
	
	private void helper(TreeNode node, List<Integer> list){
		if(node==null) return;
		list.add(node.val);
		helper(node.left, list);
		helper(node.right, list);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(4);
		t1.right.left = new TreeNode(5);
		t1.right.right = new TreeNode(6);
		BinaryTreePreorderTraversal c = new BinaryTreePreorderTraversal();
		System.out.println(c.preorderTraversal(t1));
		System.out.println(c._preorderTraversal(t1));
	}
}
