package datastructure.tree;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author VictorQian
 * 
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode left = root;
		TreeNode right = root;
		int leftLen = 0;
		while (left != null) {
			left = left.left;
			leftLen++;
		}
		int rightLen = 0;
		while (right != null) {
			right = right.right;
			rightLen++;
		}
		if (leftLen == rightLen) {
			return (1 << leftLen) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
    }
	
	public int _countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode left = root;
		TreeNode right = root;
		
		int rightLen = 0;
		while (right != null) {
			right = right.right;
			rightLen++;
		}
		
		int leftLen = rightLen;
		while (leftLen>0) {
			left = left.left;
			leftLen--;
		}
		
		if (left==null) {
			return (1 << rightLen) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right = new TreeNode(2);
		t.right.left = new TreeNode(4);
		//t.right.right = new TreeNode(3);
		//t.right.right.left = new TreeNode(3);
		CountCompleteTreeNodes c = new CountCompleteTreeNodes();
		System.out.println(c._countNodes(t));
	}
}
