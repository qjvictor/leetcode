package datastructure.tree;
/**
 *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node 
in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant 
of itself according to the LCA definition.
 * @author VictorQian
 *
 */
public class LowestCommonAncestorOfBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		if (root.val == p.val)
			return p;
		if (root.val == q.val)
			return q;
		if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) {
			return root;
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(5);
		t.left.left = new TreeNode(3);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(25);
		t.right.right = new TreeNode(35);
		LowestCommonAncestorOfBinarySearchTree c = new LowestCommonAncestorOfBinarySearchTree();
		System.out.println(c.lowestCommonAncestor(t, new TreeNode(3), new TreeNode(25)).val);
		System.out.println(c.lowestCommonAncestor(t, new TreeNode(3), new TreeNode(5)).val);

	}
}
