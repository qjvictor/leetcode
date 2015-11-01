package datastructure;
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
		while (l1 != null || l2 != null) {
			if (l1 != null)
				l1 = l1.next;
			else
				l1 = headB;

			if (l2 != null)
				l2 = l2.next;
			else
				l2 = headA;
			if (l1 == l2) // might point to NULL or point to the start of the
							// intersection. (if no intersection, will point to
							// NULL at same time).
				return l1;
		}
		return null;
    }
	
	
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists r = new IntersectionOfTwoLinkedLists();
		ListNode headA = new ListNode(new int[] { 1,2});
		ListNode headB = new ListNode(new int[] { 11});
		ListNode ret = r.getIntersectionNode(headA, headB);
		ret.print();
	}
}
