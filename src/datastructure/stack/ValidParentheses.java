package datastructure.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author VictorQian
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stk = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stk.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stk.isEmpty())
					return false;
				char d = stk.pop();
				if ((c == ')' && d != '(') || (c == ']' && d != '[') || (c == '}' && d != '{')) {
					return false;
				}
			}
		}
		return stk.isEmpty();
    }
	
	public static void main(String[] args){
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("()()()())"));
		System.out.println(v.isValid("(((((()"));
		System.out.println(v.isValid(")()(()"));
		System.out.println(v.isValid("()[]{}"));
	}
}
