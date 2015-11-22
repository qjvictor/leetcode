package datastructure.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 * @author VictorQian
 *
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int start = 0;
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {// )
				if (stack.isEmpty()) {
					start = i + 1; //key
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						ret = Math.max(ret, i - start + 1);
					} else {
						ret = Math.max(ret, i - stack.peek());
					}
				}
			}
		}
		return ret;
    }
	
	public static void main(String[] args){
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println(l.longestValidParentheses(")()())"));
		System.out.println(l.longestValidParentheses("()()"));
		System.out.println(l.longestValidParentheses("()())()())"));
		System.out.println(l.longestValidParentheses(")(((()())"));
		
	}
}
