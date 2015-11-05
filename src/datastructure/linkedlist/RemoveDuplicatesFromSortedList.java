package datastructure.linkedlist;
/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 
 * @author VictorQian
 *
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;//skip duplicated.
			} else {
				cur = cur.next;
			}
		}
		return head;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		ListNode head = new ListNode(new int[] { 0,1,1,1,2,2,2,2,3});
		ListNode ret = r.deleteDuplicates(head);
		ret.print();
	}
}
