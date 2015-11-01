package datastructure;
/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author VictorQian
 *
 */
public class PalindromeLinkedList {
	//find the mid, reverse the half and compare.
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		int len = 1;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			len++;
			fast = fast.next;
		}
		fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (len % 2 == 0)
			slow = slow.next;

		// reverse the second half.
		ListNode tmp = new ListNode(-1);
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = tmp.next;
			tmp.next = slow;
			slow = next;
		}

		fast = head;
		slow = tmp.next;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
    }
	
	public static void main(String[] args) {
		PalindromeLinkedList r = new PalindromeLinkedList();
		System.out.println(r.isPalindrome(new ListNode(new int[] { 0,1,1,1,2,2,2,2,3})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,5, 2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,5, 5, 2,1})));
		System.out.println(r.isPalindrome(new ListNode(new int[] { 1,2,5, 5, 2,1,0})));
	}
}
