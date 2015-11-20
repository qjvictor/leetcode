package datastructure.tree;

import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. Note: A solution using O(n)
 * space is pretty straight forward. Could you devise a constant space solution?
 * 
 * @author VictorQian
 * 
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
        if(root==null) return;
        TreeNode[] errors = new TreeNode[2];
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode pre=null;
        
        while(!stk.isEmpty() || root!=null){
        	if(root!=null){
        		stk.push(root);
        		root=root.left;
        	}else{
        		TreeNode node = stk.pop();
        		if(pre!=null){
        			if(node.val<pre.val){
        				if(errors[0]==null){
        					errors[0]=pre;
        					errors[1]=node;
        				}else{
        					errors[1]=node;
        					break;
        				}
        			}
        		}
        		pre=node;
        		root=node.right;
        	}
        }
        
        if(errors[0]!=null && errors[1]!=null){
        	int v = errors[1].val;
        	errors[1].val=errors[0].val;
        	errors[0].val=v;
        }
    }

	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(5);
		t.left.left = new TreeNode(20);
		t.right = new TreeNode(25);
		t.right.left = new TreeNode(3);
		t.right.right = new TreeNode(35);
		RecoverBinarySearchTree c = new RecoverBinarySearchTree();
		c.recoverTree(t);
		System.out.println(t);

	}

}



