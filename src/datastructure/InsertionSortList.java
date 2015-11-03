package datastructure;
/**
 * Sort a linked list using insertion sort.
 * @author VictorQian
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur=head;
        while (cur != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < cur.val) {
                node = node.next;
            }
            //find the insertion place.
            ListNode temp = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = temp;
        }

        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(new int[] { 2, 1,3,4});
		InsertionSortList a = new InsertionSortList();
		ListNode sorted = a.insertionSortList(l1);
		sorted.print();
	}
}
