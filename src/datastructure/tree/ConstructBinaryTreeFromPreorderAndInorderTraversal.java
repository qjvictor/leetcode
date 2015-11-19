package datastructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author VictorQian
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length)
			return null;
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	}

	private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
		if (preStart > preEnd || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int inRoot = inMap.get(preorder[preStart]);
		int numsInLeft = inRoot - inStart;//key.
		root.left = build(preorder, preStart + 1, preStart + numsInLeft, inorder, inStart, inRoot - 1, inMap);
		root.right = build(preorder, preStart + numsInLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
		return root;
	}
	
	public static void main(String[] args){
		ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = new int[]{1,2,3,4,5,6,7};
		int[] inorder = new int[]{3,2,4,1,6,5,7};
		TreeNode t = c.buildTree(preorder, inorder);
		System.out.println(t);
		
	}
}
