public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
	ListNode(int[] values) {
		build(values);
	}
	public void print() {
		ListNode tmp = this;
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
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
