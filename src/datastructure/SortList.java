package datastructure;
/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author evicqia
 */
public class SortList {
	public ListNode sortList(ListNode head) {
       return divideAndConque(head);
    }
	
	private ListNode divideAndConque(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = slow.next;
		slow.next = null; // that's the key, it makes the original head break
							// down into 2 half.
		ListNode head1 = divideAndConque(head);
		head2 = divideAndConque(head2);
		return merge(head1, head2);
	}
	
	private ListNode merge(ListNode head1, ListNode head2){
		if(head1==null) return head2;
		if(head2==null) return head1;
		ListNode dummy = new ListNode(-1);
		ListNode pre=dummy;
		while(head1!=null && head2!=null){
			if(head1.val<=head2.val){
				pre.next = head1;
				head1=head1.next;
			} else{
				pre.next = head2;
				head2=head2.next;
			}
			pre=pre.next;
		}
		if(head1!=null)
			pre.next = head1;
		else
			pre.next = head2;
		
		return dummy.next;
	}
	
	
	public static void main(String[] args){
		SortList s = new SortList();
		ListNode head = new ListNode(new int[]{10,2,34,14,25,6});
		ListNode sorted = s.sortList(head);
		sorted.print();
	}
	
}
