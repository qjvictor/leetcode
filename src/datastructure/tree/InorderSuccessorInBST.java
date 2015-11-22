package datastructure.tree;

/**
 *  Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null. 
 * @author evicqia
 *
 */
public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode cand = null; // smallest node which is larger than p, or the last left-turn node  
        while (root != null) {  
            if (root.val <= p.val) {  
                root = root.right;  
            } else {  
                cand = root;  
                root = root.left;  
            }  
        }  
        return cand;  
    }
	
	public TreeNode _inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		if (p.right != null) { // if p's right is not null, find the leftmost in its right subtree.
			succ = p.right;
			while (succ.left != null) {
				succ = succ.left;
			}
			return succ;
		}
		while (root != null) { // if p's right is null, 
			if (root.val > p.val) {  //p is in the left, keep the root as succ (parent).
				succ = root;  // root is a candidate succ.
				root = root.left;
			} else if (root.val < p.val)  //p is in the right.
				root = root.right;
			else
				break;
		}
	    return succ;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.right = new TreeNode(4);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(7);
		InorderSuccessorInBST c = new InorderSuccessorInBST();
		TreeNode t = c._inorderSuccessor(t1, t1.right.left);
		System.out.println(t==null?null:t.val);
	}	
}
