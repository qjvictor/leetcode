package datastructure.tree;
/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author VictorQian
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;
		return helper(nums, 0, nums.length - 1);
    }

	private TreeNode helper(int[] nums, int i, int j) {
		if (i > j)
			return null;
		if (i == j)
			return new TreeNode(nums[i]);
		int m = (i + j) / 2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = helper(nums, i, m - 1);
		root.right = helper(nums, m + 1, j);
		return root;
	}
	
	public static void main(String[] args){
		ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
		TreeNode t = c.sortedArrayToBST(new int[]{1,2,3,4,5,6});
		System.out.println(t);
		
		t = c.sortedArrayToBST(new int[]{1,2,3,4,5});
		System.out.println(t);
		
		t = c.sortedArrayToBST(new int[]{1,2});
		System.out.println(t);
	}
	
	
}
