package datastructure;
/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
 * @author evicqia
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null) {
			if (head.val == val)
				pre.next = head.next; // remove element
			else
				pre = pre.next;
			head = head.next; // move to next
		}
		return dummy.next;
		
    }
	
	public static void main(String[] args) {
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		ListNode head = new ListNode(new int[] { 3,1,1,2});
		ListNode ret = r.removeElements(head, 1);
		ret.print();
	}
}
