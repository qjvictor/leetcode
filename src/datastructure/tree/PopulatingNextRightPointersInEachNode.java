package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * @author VictorQian
 *
 */
public class PopulatingNextRightPointersInEachNode {
	public void _connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> list = new LinkedList<>();
		Queue<TreeLinkNode> nextList = new LinkedList<>();
		list.offer(root);
		root.next = null;
		while (!list.isEmpty()) {
			TreeLinkNode cur = list.poll();
			if (cur.left != null)
				nextList.offer(cur.left);
			if (cur.right != null)
				nextList.offer(cur.right);
			if (list.isEmpty()) {
				while (!nextList.isEmpty()) {
					TreeLinkNode t1 = nextList.poll();
					list.offer(t1);
					t1.next = nextList.isEmpty() ? null : nextList.peek();
				}
			}
		}
    }
	
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		link(root.left, root.right);
	}

	private void link(TreeLinkNode node1, TreeLinkNode node2) {
		if (node1 == null && node2 == null)
			return;
		node1.next = node2;
		link(node1.left, node1.right);
		link(node1.right, node2.left);
		link(node2.left, node2.right);
	}
	
	
	public static void main(String[] args){
		TreeLinkNode t = new TreeLinkNode(10);
		t.left = new TreeLinkNode(5);
		t.left.left = new TreeLinkNode(3);
		t.left.right = new TreeLinkNode(4);
		t.right = new TreeLinkNode(20);
		t.right.left = new TreeLinkNode(25);
		t.right.right = new TreeLinkNode(35);
		PopulatingNextRightPointersInEachNode p = new PopulatingNextRightPointersInEachNode();
		p.connect(t);
		System.out.println(t);
	}
}
