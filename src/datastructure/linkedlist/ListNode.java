package datastructure.linkedlist;
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
	}
	public ListNode(int[] values) {
		build(values);
	}
	public void print() {
		ListNode tmp = this;
		while (tmp != null) {
			System.out.print(tmp.val + "->");
			tmp = tmp.next;
		}
		System.out.print("NULL");
		System.out.println();
	}

	private void build(int[] values) {
		if(values==null || values.length==0) return;
		ListNode tmp = this;
		val = values[0];
		for (int i = 1; i < values.length; i++) {
			tmp.next = new ListNode(values[i]);
			tmp = tmp.next;
		}
	}
}
