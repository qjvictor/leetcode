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
	
	public static void main(String[] args){
		ListNode node = new ListNode(new int[]{1,2,3,4,5});
		RotateList r = new RotateList();
		ListNode h = r.rotateRight(node,2);
		h.print();
		
	}
}
