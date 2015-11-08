package datastructure.linkedlist;

/**
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list. 
 */
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public static class RandomListNode {
		int label;
		RandomListNode next, random;

		public RandomListNode(int x) {
			this.label = x;
		}
	}
	
	//O(2*n)=O(n)
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode newHead = new RandomListNode(head.label);
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(head, newHead);
		head = head.next;
		
		while (head != null) {
			RandomListNode copy = new RandomListNode(head.label);
			map.put(newHead, copy);
			head = head.next;
		}

		for (RandomListNode node : map.keySet()) {
			if (node.next != null)
				map.get(node).next = map.get(node.next);
			if (node.random != null)
				map.get(node).random = map.get(node.random);
		}
		return newHead;
	}
	
	//O(2*n)=O(n)
	public RandomListNode copyRandomList1(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode newHead = new RandomListNode(head.label);
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(head, newHead);
		RandomListNode pre = newHead;
		RandomListNode node = head.next; 
		while (node != null) {
			RandomListNode copy = new RandomListNode(node.label);
			map.put(node, copy);
			pre.next = copy;
			pre=pre.next;
			node = node.next;
		}
		
		node = head;
		RandomListNode copyNode = newHead;  
		while (node != null) {
			copyNode.random = map.get(node.random);
			copyNode = copyNode.next;
			node = node.next;
		}
		return newHead;
	}
	
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode p=head;
		//step 1: copy the original node, and insert after the original node.
		//1->2->3   ===>   1->1'->2->2'->3-3'
		while(p!=null){
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next=copy;
			copy.next=next;
			p=next;
		}
		p=head;
		//step 2: copy the random pointer
		while (p != null) {
			p.next.random = p.random == null ? null : p.random.next;
			p = p.next.next;
		}
		p=head;
		// step 3: create the copied list.
		RandomListNode newHead = head.next;
		p = head;
		while (p != null) {
			RandomListNode newNode = p.next;
			p.next = newNode.next;
			if (newNode.next != null)
				newNode.next = newNode.next.next;
			p = p.next;
		}
		return newHead;
	}
	
	
	public static void main(String[] args){
		CopyListWithRandomPointer cp = new CopyListWithRandomPointer();
		RandomListNode r1 = new RandomListNode(1);
		RandomListNode r2 = new RandomListNode(2);
		RandomListNode r3 = new RandomListNode(3);
		RandomListNode r4 = new RandomListNode(4);
		r1.next=r2;
		r2.next=r3;
		r3.next=r4;
		r1.random = r3;
		r2.random=r2;
		r4.random=r1;
		RandomListNode r = cp.copyRandomList2(r1);
		System.out.println(r);
	}
}
