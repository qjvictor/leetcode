package datastructure;
/**
 * Reverse a singly linked list.
 * @author VictorQian
 *
 */
public class ReverseLinkedList {
	public ListNode _reverseList(ListNode head) {
		if(head==null || head.next==null) return head;
        ListNode next = head.next;
        head.next = null;
        while(next!=null){
            ListNode tmp = next.next;
            next.next=head;
            head = next;
            next = tmp;
        }
        return head;
    }
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		while (head != null) {
			ListNode tmp = head.next;// keep the next as tmp
			head.next = dummy.next; // head point to dummy's next, which is the new head.
			dummy.next = head; // change the dummy's next to head, head becomesthe new head.
			head = tmp; // move head to the tmp
		}
		return dummy.next;
	}
	
	public static void main(String[] args){
		ListNode node = new ListNode(new int[]{1,2,3,4});
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode h = r.reverseList(node);
		h.print();
		
	}
}
