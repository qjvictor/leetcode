package datastructure.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

    Given target value is a floating point.
    You may assume k is always valid, that is: k ≤ total nodes.
    You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)? 
 */
public class ClosestBinarySearchTreeValueII {
	 //O(nlogn + n):  not use binary search tree property,   deal it as binary tree.
	 public List<Integer> _closestKValues(TreeNode root, double target, int k) {
		List<Integer> list = new ArrayList<Integer>();
		final double targetValue = target;
		Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (Math.abs(arg0 - targetValue) > Math.abs(arg1 - targetValue))
					return 1;
				else if (Math.abs(arg0 - targetValue) < Math.abs(arg1 - targetValue))
					return -1;
				else
					return 0;
			}
		});
		addToHeap(root, heap);
		for(int i=0; i<k; i++) {
            list.add(heap.poll());
        }
		return list;
	}

	public void addToHeap(TreeNode root, Queue<Integer> heap) {
		if (root == null)
			return;
		heap.offer(root.val);
		addToHeap(root.left, heap);
		addToHeap(root.right, heap);
	}
	
	//best answer.
	public List<Integer> closestKValues_best(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPredecessor(pred);
        }
        while(k-- > 0) {
            if(succ.isEmpty()) {
                ret.add(getNextPredecessor(pred));
            } else if(pred.isEmpty()) {
                ret.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double)succ.peek().val - target);
                double pred_diff = Math.abs((double)pred.peek().val - target);
                if(succ_diff < pred_diff) {
                    ret.add(getNextSuccessor(succ));
                } else {
                    ret.add(getNextPredecessor(pred));
                }
            }
        }
        return ret;
    }

    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while(root != null) {
            if(root.val == target) {
                succ.push(root);
                break;
            } else if(root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while(root != null){
            if(root.val == target){
                pred.push(root);
                break;
            } else if(root.val < target){
                pred.push(root);
                root = root.right;
            } else{
                root = root.left;
            }
        }
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int ret = curr.val;
        curr = curr.right;
        while(curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return ret;
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int ret = curr.val;
        curr = curr.left;
        while(curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return ret;
    }
	
	//in-order traversal, maintain a K size list.
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Queue<Integer> list = new LinkedList<>();
		Stack<TreeNode> stk = new Stack<>();
		while (!stk.isEmpty() || root != null) {
			if (root != null) {
				stk.push(root);
				root = root.left;
			} else {
				TreeNode node = stk.pop();
				if (list.size() < k) {
					list.add(node.val);
				} else {
					int val = list.peek();
					if (Math.abs(val - target) > Math.abs(node.val - target)) {
						list.poll();
						list.add(node.val);
					}
				}
				root = node.right;
			}
		}
		return new ArrayList<>(list);
	}
	

	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(5);
		t.left.left = new TreeNode(3);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(25);
		t.right.right = new TreeNode(35);
		ClosestBinarySearchTreeValueII c = new ClosestBinarySearchTreeValueII();
		System.out.println(c.closestKValues(t, 11.3, 3));


	}
}
