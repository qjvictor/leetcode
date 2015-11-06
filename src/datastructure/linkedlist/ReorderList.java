package datastructure.linkedlist;

import java.util.Stack;

/**
 *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 * @author VictorQian
 *
 */
public class ReorderList {
	public void _reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {// key: if head's length is odd number, fast is not
							// null, need to move slow one more step.
			slow = slow.next;
		}

		Stack<ListNode> stk = new Stack<>();
		while (slow != null) {
			stk.push(slow);
			slow = slow.next;
		}

		fast = head;
		while (fast != null && !stk.isEmpty()) {
			ListNode n = fast.next;
			ListNode m = stk.pop();
			fast.next = m;
			m.next = n;
			fast = n;
		}
		fast.next = null;
		head.print();
    }
	
	//3 steps
	//1:  cut the list into 2 halves
	//2:  reverse the 2nd half
	//3:  merge the 2 halves into one.	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow=head;
		ListNode fast=head;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		ListNode second = slow.next;
		slow.next=null;//break the list into 2 halves.
		ListNode first=head;
		
		//reverse second half
		ListNode reversed=new ListNode(0);
		while(second!=null){
			ListNode tmp = second.next;
			second.next= reversed.next;
			reversed.next=second;
			second=tmp;
		}
		second=reversed.next;
		
		//Merge the second part back to first part with zigzag order.
	    ListNode dummy = new ListNode(0), merged = dummy;
	    while (first != null && second != null) {
	        merged.next = first; //append first 
	        first = first.next;
	        merged.next.next = second; //append second.
	        second = second.next;
	        merged = merged.next.next;
	    }
	    if (first != null || second != null)  //take care of the remaining node.
	        merged.next = (first != null)? first : second;
	    head =  dummy.next;
		head.print();
	}	
	

	public static void main(String[] args){
		ListNode node = new ListNode(new int[]{1,2,3,4});
		ReorderList r = new ReorderList();
		r.reorderList(node);
		
	}
	
}
