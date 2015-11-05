package datastructure.linkedlist;
/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author VictorQian
 *
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//key:  if fast is null, length is even number, slow is in the beginning of second half.
		//		ie:  1->2->3->4    fast is null, slow is in 3.
		//		if fast is not null, length is odd number, slow is in previous node of second half beginning.
		//		ie:  1->2->3->4->5  fast is not null, in 5,  slow is in 3, need to move one more step.
		if (fast != null)
			slow = slow.next;
		
		ListNode reversed = new ListNode(-1);
		while (slow != null) {
			ListNode tmp = slow.next;
			slow.next = reversed.next;
			reversed.next = slow;
			slow = tmp;
		}
		
		fast = head;
		slow = reversed.next;
		while (slow != null) {
			if (fast.val != slow.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		PalindromeLinkedList r = new PalindromeLinkedList();
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,3,4,5})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,5, 2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,5, 5, 2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,5, 5, 2,1,0})));
	}
}
