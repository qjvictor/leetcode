package datastructure.linkedlist;
/**
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 <= m <= n <= length of list. 
 * @author VictorQian
 *
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m<1 ||m>n)
        	return head;
        int i=1;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        //move until head is the mNode.
		while (i < m && head != null) {
			pre = pre.next;
			head = head.next;
			i++;
		}
        
        ListNode mNode = pre.next;  
        ListNode cur = mNode.next;  
        while(i<n && cur!=null){ 
        	ListNode tmp = cur.next;
        	//move current node to right after pre, and move pre's next pointer to current node.
        	cur.next=pre.next;
        	pre.next=cur;
        	//move current to the next.
        	cur=tmp;
        	//mNode always point to the next to connect the rest.
        	mNode.next = tmp;  
        	i++;
        }
        return dummy.next;
    }
    
    public ListNode _reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy; //pre is the node before orignal M
        ListNode M=head;    //M is after pre

        for(int i=1;i<m;i++){ //Move pre and M to orignal place
            pre=pre.next;
            M=M.next;
        }

        for(int i=m;i<n;i++){ 
        	//Both pre and M are all fixed, only current is assigned every time to M.next. M is pushed back 1 step everytime
            ListNode current=M.next; 
            M.next=current.next;  //M point to next, skip current.
            //Move current to the position after pre
            current.next=pre.next;
            pre.next=current;
        }

        return dummy.next;
    }
    
    
    public static void main(String[] args){
		ListNode node = new ListNode(new int[]{1,2,3,4,5,6,7});
		ReverseLinkedListII r = new ReverseLinkedListII();
		ListNode h = r._reverseBetween(node, 1,7);
		h.print();
		
	}
}
