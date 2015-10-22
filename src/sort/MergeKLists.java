package sort;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import datastructure.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author VictorQian
 * 
 */
public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		// create a heap, using a custom comparator, which is using 'natural'
		// order of ListNode's value.
		Queue<ListNode> heap = new PriorityQueue<>(10, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}

		});

		// add the first node of each ListNode into heap.
		for (ListNode l : lists) {
			if (l != null) {
				heap.offer(l);
			}
		}
		// get the first one (smallest) from heap, append into the new ListNode,
		// and add the smallest's next into heap.
		ListNode dummy = new ListNode(-1);
		ListNode newList = dummy;
		while (!heap.isEmpty()) {
			ListNode smallest = heap.poll();
			newList.next = new ListNode(smallest.val);
			newList = newList.next;
			if (smallest.next != null)
				heap.offer(smallest.next);
		}
		return dummy.next;
	}
	
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(new int[]{2,7,17,28});
		ListNode l2 = new ListNode(new int[]{1,4,7,15});
		ListNode l3 = new ListNode(new int[]{3,27,155});
		MergeKLists m = new MergeKLists();
		ListNode lRet = m.mergeKLists(new ListNode[]{l1, l2, l3});
		lRet.print();
	}
}
