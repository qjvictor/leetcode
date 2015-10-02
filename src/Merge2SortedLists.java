/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author VictorQian
 * 
 */
public class Merge2SortedLists {
	// pointer manipulation only
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode tmp = null, prev = null, head = null;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tmp = l1;
				l1 = l1.next;
			} else {
				tmp = l2;
				l2 = l2.next;
			}
			
			if (prev != null) { //prev is not null, point to tmp which is the next node, and move the prev to next.
				prev.next = tmp;
				prev = prev.next;
			} else {  //prev is null, make head and prev point to same node, then never move head pointer.
				prev = tmp;
				head = prev;
			}
		}
		if (l1 != null)
			tmp.next = l1;
		if (l2 != null)
			tmp.next = l2;

		return head;
	}
	
	// simple solution, new ListNode created
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode tmp = new ListNode(-1);
		ListNode cur = tmp;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				cur.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		} else {
			cur.next = l2;
		}

		return tmp.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(new int[] { 4, 7, 9, 10, 12, 37 });
		ListNode l2 = new ListNode(new int[] { 3, 6, 8, 10, 11, 22, 36, 39, 49 });
		Merge2SortedLists m = new Merge2SortedLists();
		ListNode merged = m.mergeTwoLists(l1, l2);
		merged.print();
	}
}
