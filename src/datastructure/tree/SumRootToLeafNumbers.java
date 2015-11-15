package datastructure.tree;
/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13. 
 * @author VictorQian
 *
 */
public class SumRootToLeafNumbers {
	public int _sumNumbers(TreeNode root) {
        if(root==null) return 0;
        int ret=root.val;
        int left=sumNumbers(root.left);
        if(left!=0){
        	ret=root.val*10+left;
        }
        int right=sumNumbers(root.right);
        if(right!=0){
        	ret+=root.val*10+right;
        }
        return ret;
    }
	
	public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
	
	private int helper(TreeNode node, int val) {
		if (node == null)
			return 0;
		int sum = 10 * val + node.val;
		if (node.left == null && node.right == null)
			return sum;
		int left = helper(node.left, sum);
		int right = helper(node.right, sum);
		return left + right;
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(0);
		t.left.left = new TreeNode(8);
		t.right = new TreeNode(3);
		SumRootToLeafNumbers c = new SumRootToLeafNumbers();
		System.out.println(c.sumNumbers(t));
	}
}
