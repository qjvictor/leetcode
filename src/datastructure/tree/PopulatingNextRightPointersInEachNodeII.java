package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL


 * @author VictorQian
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
	public void _connect(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
	    TreeLinkNode pre = dummyHead;
	    while (root != null) {
	        if (root.left != null) {
	            pre.next = root.left;
	            pre = pre.next;
	        }
	        if (root.right != null) {
	            pre.next = root.right;
	            pre = pre.next;
	        }
	        root = root.next;
	        if (root == null) {
	            pre = dummyHead;
	            root = dummyHead.next;
	            dummyHead.next = null;
	        }
	    }
    }
	
	public static void main(String[] args){
		TreeLinkNode t = new TreeLinkNode(10);
		t.left = new TreeLinkNode(5);
		//t.left.left = new TreeLinkNode(3);
		t.left.right = new TreeLinkNode(4);
		t.right = new TreeLinkNode(20);
		t.right.left = new TreeLinkNode(25);
		//t.right.right = new TreeLinkNode(35);
		PopulatingNextRightPointersInEachNodeII p = new PopulatingNextRightPointersInEachNodeII();
		p._connect(t);
		System.out.println(t);
	}
}
