package design;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty.
 * 
 * Notes:
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid. Depending on
 * your language, stack may not be supported natively. You may simulate a stack
 * by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a stack. You may assume that all operations are valid
 * (for example, no pop or peek operations will be called on an empty queue).
 * 
 * @author VictorQian
 * 
 */
public class ImplementQueueUsingStacks {
	Stack<Integer> push = new Stack<>();
	Stack<Integer> pop = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		push.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!pop.empty()) { // first pop from pop stack.
			pop.pop();
			return;
		}

		while (!push.empty()) { // then if push stack is not empty, load into
								// pop stack
			pop.push(push.pop());
		}

		pop.pop();
	}

	// Get the front element.
	public int peek() {
		if (!pop.empty()) {
			return pop.peek();
		}

		while (!push.empty()) {
			pop.push(push.pop());
		}

		return pop.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return push.isEmpty() && pop.isEmpty();
	}

	public static void main(String[] args) {
		ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
		for (int i = 1; i <= 5; i++) {
			queue.push(i);
		}
		System.out.println(queue.peek());
		for (int i = 6; i <= 10; i++) {
			queue.push(i);
		}

		while (!queue.empty()) {
			System.out.println(queue.peek());
			queue.pop();
		}
	}
}
