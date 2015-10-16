package design;

import java.util.*;

/**
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid. Depending
 * on your language, queue may not be supported natively. You may simulate a
 * queue by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a queue. You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 * 
 * @author VictorQian
 * 
 */
public class ImplementStackUsingQueues {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	// Push element x onto stack.
    public void push(int x) {
    	q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(q1.isEmpty()){
        	while(q2.size()>1){
        		q1.offer(q2.poll());
        	}
        	q2.poll();
        	return;
        }
        if(q2.isEmpty()){
        	while(q1.size()>1){
        		q2.offer(q1.poll());
        	}
        	q1.poll();
        }
    }

    // Get the top element.
    public int top() {
    	int top=0;
    	if(!q1.isEmpty()){
        	while(q1.size()>1){
        		q2.offer(q1.poll());
        	}
        	top =q1.poll();
        	q2.offer(top);
        	return top;
        }
        if(!q2.isEmpty()){
        	while(q2.size()>1){
        		q1.offer(q2.poll());
        	}
        	top =q2.poll();
        	q1.offer(top);
        	return top;
        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
    
    public static void main(String[] args) {
    	ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}
		System.out.println(stack.top());
		for (int i = 6; i <= 10; i++) {
			stack.push(i);
		}

		while (!stack.empty()) {
			System.out.println(stack.top());
			stack.pop();
		}
	}
}
