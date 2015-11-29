package sort;
import datastructure.linkedlist.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author VictorQian
 * 
 */
public class Merge2SortedLists {
	// iterate
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode dummy = new ListNode(-1);
		ListNode tmp = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		if (l1 != null)
			tmp.next = l1;
		if (l2 != null)
			tmp.next = l2;

		return dummy.next;
	}
	
	// recursive
	public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val > l2.val) {
			l2.next = mergeTwoListsRec(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoListsRec(l1.next, l2);
			return l1;
		}
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(new int[] { 4, 7, 9, 10, 12, 37 });
		ListNode l2 = new ListNode(new int[] { 3, 6, 8, 10, 11, 22, 36, 39, 49 });
		Merge2SortedLists m = new Merge2SortedLists();
		ListNode merged = m.mergeTwoLists(l1, l2);
		merged.print();
		
		l1 = new ListNode(new int[] { 4, 7, 9, 10, 12, 37 });
		l2 = new ListNode(new int[] { 3, 6, 8, 10, 11, 22, 36, 39, 49 });
		ListNode merged1 = m.mergeTwoListsRec(l1, l2);
		merged1.print();
	}
}
