package datastructure.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author VictorQian
 * 
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if (l1 != null)
			pre.next = l1;
		else
			pre.next = l2;
		return dummy.next;
    }
	
	public static void main(String[] args) {
		MergeTwoSortedLists r = new MergeTwoSortedLists();
		ListNode l2 = new ListNode(new int[] { 1,1,5,7,9});
		ListNode l1 = new ListNode(new int[] { 2,4,8,9,20});
		ListNode ret = r.mergeTwoLists(l1, l2);
		ret.print();
	}
}
