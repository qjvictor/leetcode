package datastructure.linkedlist;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author VictorQian
 * 
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		int carry = 0;
		ListNode dummy = new ListNode(-1);
		ListNode added = dummy;
		while (l1 != null || l2 != null || carry != 0) {
			int v1 = l1 == null ? 0 : l1.val;
			int v2 = l2 == null ? 0 : l2.val;
			int val = v1 + v2 + carry;
			int nodeVal = val % 10;
			carry = val / 10;
			added.next = new ListNode(nodeVal);
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			added = added.next;
		}
		return dummy.next;
    }
	
	public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
	    int carry = 0;
	    ListNode head = l1;
	    ListNode prev = l1;
	    while (l2 != null || carry != 0) {
	        if (l1 == null) {
	            l1 = new ListNode(0);
	            prev.next = l1;
	        }
	        if (l2 != null) {
	            l1.val += (l2.val + carry);
	            l2 = l2.next;
	        } else {
	            l1.val += carry;
	        }
	        carry = l1.val / 10;
	        l1.val %= 10;
	        prev = l1;
	        l1 = l1.next;
	    }
	    return head;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(new int[]{2,4,3});
		ListNode l2 = new ListNode(new int[]{5,6,9});
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode added = a.addTwoNumbers(l1, l2);
		added.print();
	}
}
