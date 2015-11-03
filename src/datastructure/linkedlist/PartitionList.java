package datastructure.linkedlist;
/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
 * @author VictorQian
 *
 */
public class PartitionList {
	//solution: 两个新链表，一个用来创建所有大于等于x的链表，一个用来创建所有小于x的链表。
	//遍历整个链表时，当当前node的val小于x时，接在小链表上，反之，接在大链表上。这样就保证了相对顺序没有改变，而仅仅对链表做了与x的比较判断。
	//最后，把小链表接在大链表上，别忘了把大链表的结尾赋成null。
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode l1 = new ListNode(-1);
		ListNode l2 = new ListNode(-1);
		ListNode dummy1 = l1;
		ListNode dummy2 = l2;
		while (head != null) {
			if (head.val < x) {
				l1.next = head;
				l1 = l1.next;
			} else {
				l2.next = head;
				l2 = l2.next;
			}
			head = head.next;
		}
		l2.next = null; //important
		l1.next = dummy2.next;
		return dummy1.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(new int[] {1,4,3,2,5,2});
		PartitionList a = new PartitionList();
		ListNode parted = a.partition(l1, 3);
		parted.print();
	}
}
