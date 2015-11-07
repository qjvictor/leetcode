package datastructure.linkedlist;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. 
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author VictorQian
 * 
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				int tmp = head.val;
				while (head != null && head.val == tmp)
					head = head.next;
			} else {
				pre.next = head;
				pre = pre.next;
				head = head.next;
			}
		}
		pre.next = null; //important
		return dummy.next;

	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII s = new RemoveDuplicatesFromSortedListII();
		ListNode head = new ListNode(new int[] { 1, 1, 1, 2, 4 });
		ListNode sorted = s.deleteDuplicates(head);
		sorted.print();
	}
}
