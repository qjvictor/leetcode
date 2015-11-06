package datastructure.linkedlist;
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                  	↘
                     c1 → c2 → c3
                   	↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

 * @author VictorQian
 *
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode l1 = headA;
		ListNode l2 = headB;
		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (l1 != l2) {
			// for the end of first iteration, we just reset the pointer to the
			// head of another linkedlist
			l1 = l1 == null ? headB : l1.next;
			l2 = l2 == null ? headA : l2.next;
		}
		return l1;
    }
	
	
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists r = new IntersectionOfTwoLinkedLists();
		ListNode l1 = new ListNode(new int[] { 1});
		ListNode headA = l1;
		ListNode headB = l1;
		ListNode ret = r.getIntersectionNode(headA, headB);
		ret.print();
	}
}
