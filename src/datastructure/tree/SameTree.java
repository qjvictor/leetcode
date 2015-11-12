package datastructure.tree;
/**
 *  Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 * @author VictorQian
 *
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.right.left = new TreeNode(4);
		t1.right.right = new TreeNode(3);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.left.left = new TreeNode(3);
		t2.right = new TreeNode(2);
		t2.right.left = new TreeNode(4);
		t2.right.right = new TreeNode(3);
		SameTree c = new SameTree();
		System.out.println(c.isSameTree(t1, t2));
	}
}
