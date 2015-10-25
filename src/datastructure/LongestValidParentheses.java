package datastructure;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author VictorQian
 * 
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		Stack<Integer> stk = new Stack<>();
		int max = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stk.push(i);
			} else {
				if (stk.isEmpty()) {
					start = i + 1; //reset the start.
				} else {
					stk.pop();
					max = stk.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stk.peek());
					//note:  if stk is empty, valid sequence starts from 'start', if not empty, valid sequence starts from the top element of the stack. 
				}
			}
		}
		return max;
		
    }
	
	public int longestValidParenthesesDP(String s) {
		if (s == null || s.length() < 2)
			return 0;
		int[] dp = new int[s.length()];
		char[] c = s.toCharArray();
		int max = 0, cand;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ')' && i > 0 && (cand = i - dp[i - 1] - 1) >= 0) {
				if (c[cand] == '(') {
					dp[i] = 2 + dp[i - 1] + (cand > 0 ? dp[cand - 1] : 0);
				}
			}
			max = max < dp[i] ? dp[i] : max;
		}

		return max;
    }
	
	public static void main(String[] args){
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println(l.longestValidParentheses("((()))())"));
		System.out.println(l.longestValidParentheses("((((((())()(("));
		System.out.println(l.longestValidParentheses(")()())"));
		System.out.println(l.longestValidParentheses(")()()()()()()()())"));
		System.out.println(l.longestValidParentheses(")()()())()))"));
		System.out.println(l.longestValidParentheses(")()(((())))())()))"));
	}
}
