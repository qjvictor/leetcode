package datastructure.tree;
/**
 *  Given a binary tree where all the right nodes are either leaf nodes with a sibling
 *   (a left node that shares the same parent node) or empty, flip it upside down and turn it into a 
 *   tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  

 * @author VictorQian
 *
 */
public class BinaryTreeUpsideDown {
	//把左子树继续颠倒，颠倒完后，原来的那个左孩子的左右孩子指针分别指向原来的根节点以及原来的右兄弟节点即可
	//It is actually very similar to the algorithm in reversing a linked list.
	//node's left pointer to its parent's right, node's right point to parent.
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		TreeNode node = root, parent = null, parentRight = null;  
	    while (node != null) {  
	        TreeNode left = node.left;  
	        node.left = parentRight;  
	        parentRight = node.right;  
	        node.right = parent;  
	        parent = node;  
	        node = left;  
	    }  
	    return parent;  
    }
}
