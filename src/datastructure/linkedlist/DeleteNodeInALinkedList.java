package datastructure.linkedlist;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
 * with value 3, the linked list should become 1 -> 2 -> 4 after calling your
 * function.
 * 
 * @author VictorQian
 * 
 */
public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		if (node == null)
			return;
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		DeleteNodeInALinkedList a = new DeleteNodeInALinkedList();
		a.deleteNode(l1);
		l1.print();
	}
}
