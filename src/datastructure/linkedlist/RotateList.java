package datastructure.linkedlist;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author evicqia
 * 
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k <= 0)
			return head;
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		k = k % len;
		if (k == 0)
			return head;
		 //use fast and slow pointers to find out the k-the position from end and rotate.
	    ListNode fast = head, slow = head, tail = null;
	    while (fast != null) {
	        if (k-- < 0) {
	            slow = slow.next;
	        }
	        tail = fast;
	        fast = fast.next;//fast goes to the end of the linklist.
	    }
	    tail.next = head; //join the first part.
	    head = slow.next; // record the new head.
	    slow.next = null; // make the new tail.
	    return head;
    }
	
	
	public ListNode _rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k <= 0)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		int len = 0;
		ListNode tail = null;
		while (head != null) {
			len++;
			if (head.next == null) {
				tail = head;
			}
			head = head.next;
		}
		k = k % len;
		if (k == 0)
			return dummy.next;

		tail.next = dummy.next;// connect as a cycle.

		head = dummy.next;
		int step = len - k - 1;

		while (step > 0) {
			head = head.next;
			step--;
		}
		dummy.next = head.next;
		head.next = null;
		return dummy.next;
    }
	
	public static void main(String[] args){
		ListNode node = new ListNode(new int[]{1,2,3,4,5,6,7});
		RotateList r = new RotateList();
		ListNode h = r._rotateRight(node,3);
		h.print();
		
	}
}
