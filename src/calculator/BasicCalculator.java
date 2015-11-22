package calculator;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "1 + 1" = 2 " 2-1 + 2 " = 3 "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * @author VictorQian
 * 
 * (1+(4+5+2)+(-3))+(6+8)
 */
public class BasicCalculator {
	/**
	 *      Use a stack to store the sign (+ or -) for the enclosing ()
		    Use a variable to mark the sign right before a number or a ‘(‘
		    for e.g., 8 – ( 5 – ( 7 + 6 ) )
		    for ‘(‘, push  -1 * -1 = 1 into the stack; for ‘6’, add 1 * 1 * 6 to the result.
	 */
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>(); //store the signs for the '('
        stack.push(1); //invisible '+' before the (whole string)
        int res = 0;
        int sign = 1; //the operator before num (default: '+')
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                sign = c == '+' ? 1: -1;
            } else if (c == '(') {
                stack.push(stack.peek() * sign); //stack.peek() is the sign before the enclosing '()' of this '('; sign : the operator before this '('; 
                sign = 1; //default sign = '+' for a digit right after a '('
            } else if (c == ')') {
                stack.pop();
            } else if (Character.isDigit(c)) {
                int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
                i--;
                res += stack.peek() * sign * num; //stack.peek() is the sign before the enclosing '()' of this num; sign : the operator before num; 
            }
        }
        return res;
    }
	
	
	public int calculate2(String s){
		if (s == null || s.length() == 0)
			return 0;
		Stack<String> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ')
				continue;
			if (c >= '0' && c <= '9') {
				StringBuilder num = new StringBuilder();
				while (i < s.length()
						&& (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
					num.append(s.charAt(i++));
				}
				i = i - 1;
				helper(stk, num.toString());
			} else if (c=='+' || c=='-' || c=='(') {
				stk.push(c+"");
			} else {// )
				String num = stk.pop();
				stk.pop();// pop '('
				helper(stk, num);
			}
		}
		return Integer.parseInt(stk.pop());
	}
	
	private void helper(Stack<String> stk, String num) {
		if (stk.isEmpty() || stk.peek().equals("(")) {
			stk.push(num);
		} else {
			String oper = stk.pop();
			int curNum = Integer.parseInt(num);
			int lastNum = Integer.parseInt(stk.pop());
			int newNum = 0;
			if (oper.equals("+")) {
				newNum = curNum + lastNum;
			} else {
				newNum = lastNum - curNum;
			}
			stk.push(newNum + "");
		}
	}
	
	
	public static void main(String[] args){
		BasicCalculator b = new BasicCalculator();
		System.out.println(b.calculate2("2-1 + 2 "));
		System.out.println(b.calculate2("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(b.calculate2("1 + 1"));
		
		
	}
}
