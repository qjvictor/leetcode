package datastructure.linkedlist;
/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 * @author evicqia
 *
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode dummy = new ListNode(-1);
		dummy.next = slow;
		while (fast != null && n > 0) {
			fast = fast.next;
			n--;
		}
		if (fast == null) // n>=the length of the list.
			return slow.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
    }
	
	
	public static void main(String[] args){
		RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
		ListNode head = new ListNode(new int[]{1,2});
		ListNode ret = r.removeNthFromEnd(head, 1);
		ret.print();
	}
}
