package _important;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		if (n < 0)
			return 0;
		int[] ret = new int[n + 1];
		ret[0] = 1;
		ret[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				ret[i] += ret[j] * ret[i - j - 1];
			}
		}
		return ret[n];
    }
	
	
	/**
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3

	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
		if (n < 0)
			return new ArrayList<TreeNode>();
		return helper(1, n);
    }
	
	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> ret = new ArrayList<>();
		if (start > end) { // that's the key.
			ret.add(null);
		} else if (start == end) {
			ret.add(new TreeNode(start));
		} else {
			for (int i = start; i <= end; i++) {
				List<TreeNode> left = helper(start, i - 1); // generate the left sub tree.
				List<TreeNode> right = helper(i + 1, end);  // generate the right sub tree.
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode n = new TreeNode(i); // i as root, generate the left+root+right combination.
						n.left = l;
						n.right = r;
						ret.add(n);
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		List<TreeNode> ret = u.generateTrees(3);
		System.out.println(ret);
		System.out.println(u.numTrees(3));
	}
}
