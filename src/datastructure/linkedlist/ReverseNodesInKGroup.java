package datastructure.linkedlist;
/**
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 
 * @author evicqia
 *
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) return null;
        if (k <= 1) return head;
        ListNode runner = head;
        int i = 1;
        while (runner != null && i < k){
            runner = runner.next;
            i++;
        }
        if (runner == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head.next;
        i = 1;
        while (i < k){
            ListNode tmp = dummy.next;
            dummy.next = start;
            start = start.next;
            dummy.next.next = tmp;
            i++;
        }

        head.next = reverseKGroup(start, k);
        return dummy.next;
    }
	
	public static void main(String[] args){
		ListNode node = new ListNode(new int[]{1,2,3,4,5,6,7});
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode h = r.reverseKGroup(node,5);
		h.print();
		
	}
}
