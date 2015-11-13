package datastructure.tree;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note:
 * 
 * Given target value is a floating point. You are guaranteed to have only one
 * unique value in the BST that is closest to the target.
 * 
 * @author VictorQian
 * 
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		while (root != null) {
			// 如果该节点的离目标更近，则更新到目前为止的最近值
			closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
			// 二叉搜索
			root = target < root.val ? root.left : root.right;
		}
		return closest;
	}

	public int _closestValue(TreeNode root, double target) {
		// 选出子树的根节点
		TreeNode child = target < root.val ? root.left : root.right;
		// 如果没有子树，也就是递归到底时，直接返回当前节点值
		if (child == null)
			return root.val;
		// 找出子树中最近的那个节点
		int closest = closestValue(child, target);
		// 返回根节点和子树最近节点中，更近的那个节点
		return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(5);
		t.left.left = new TreeNode(3);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(25);
		t.right.right = new TreeNode(35);
		ClosestBinarySearchTreeValue c = new ClosestBinarySearchTreeValue();
		System.out.println(c.closestValue(t, 22.3));

		TreeNode t1 = new TreeNode(0);
		System.out.println(c.closestValue(t1, 2147483648.0));
	}
}
