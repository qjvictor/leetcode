package datastructure.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author evicqia
 * 
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null && head.next != null) {
			ListNode tmp = head.next.next;
			ListNode next = head.next;
			next.next = pre.next;
			pre.next = next;
			head.next = tmp;
			pre = head;
			head = tmp;
		}
		return dummy.next;
    }
	
	public static void main(String[] args){
		SwapNodesInPairs s = new SwapNodesInPairs();
		ListNode head = new ListNode(new int[]{1,2,3,4,5,6});
		ListNode swapped = s.swapPairs(head);
		swapped.print();
		
	}
}
