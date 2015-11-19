package datastructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * @author VictorQian
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }
	
	private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
		if(inStart>inEnd || postStart>postEnd) return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inRoot = inMap.get(postorder[postEnd]);
		int numInRight = inEnd-inRoot;
		root.left = build(inorder, inStart, inRoot-1, postorder, postStart, postEnd-numInRight-1, inMap);
		root.right = build(inorder, inRoot+1, inRoot+numInRight, postorder, postEnd-numInRight, postEnd-1, inMap);
		return root;
	}
	
	public static void main(String[] args){
		ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		int[] postorder = new int[]{3,4,2,6,7,5,1};
		int[] inorder = new int[]{3,2,4,1,6,5,7};
		TreeNode t = c.buildTree(inorder,postorder);
		System.out.println(t);
		
	}
}
