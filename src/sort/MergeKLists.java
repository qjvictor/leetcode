package sort;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import datastructure.linkedlist.ListNode;

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
		// create a heap, using a custom comparator, which is using 'natural' order of ListNode's value.
		Queue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
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
			if (smallest.next != null)
				heap.offer(smallest.next);
			newList.next = smallest;
			newList = newList.next;
		}
		return dummy.next;
	}
	
	
	//merge sort, better.
	public ListNode _mergeKLists(ListNode[] lists) {
	    if(lists.length == 0){
	        return null;
	    }
	    return mergeLists(lists, 0 , lists.length - 1);
	}
	public ListNode mergeLists(ListNode[] lists, int left, int right){
	    if(left == right){
	        return lists[left];
	    }
	    else{
	        int mid = (left + right) / 2;
	        ListNode p1 = mergeLists(lists, left, mid);
	        ListNode p2 = mergeLists(lists, mid + 1, right);
	        return mergeTwo(p1, p2);
	    }
	}
	public ListNode mergeTwo(ListNode l1, ListNode l2){
	    if(l1 == null){
	        return l2;
	    }
	    if(l2 == null){
	        return l1;
	    }
	    if(l1.val > l2.val){
	        l2.next = mergeTwo(l1, l2.next);
	        return l2;
	    }
	    else{
	        l1.next = mergeTwo(l1.next, l2);
	        return l1;
	    }
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
