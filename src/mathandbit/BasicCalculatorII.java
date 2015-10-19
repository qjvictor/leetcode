package mathandbit;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "3+2*2" = 7 
 * " 3/2 " = 1 
 * " 3+5 / 2 " = 5
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * @author VictorQian
 * 
 */
public class BasicCalculatorII {
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int operator = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') { // put the number into stack.
				int num=c-'0';
				i++;
				while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				i--;
				stack.push(num * operator);
			} else if (c == '+' || c == '-') {
				operator = c == '+' ? 1 : -1;
			} else if (c == '*' || c == '/') {
				i++;
				while (i < s.length() && s.charAt(i) == ' ') { // trim the space
					i++;
				}
				int curNum=0;
				while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
					curNum = curNum * 10 + (s.charAt(i) - '0');
					i++;
				}
				i--;
				int preNum = stack.pop();
				if (c == '*') {
					stack.push(preNum * curNum);
				} else {
					stack.push(preNum / curNum);
				}
			}
		}
		int ret = 0;
		while (!stack.isEmpty()) {
			ret += stack.pop();
		}
		return ret;
    }
	
	public static void main(String[] args){
		BasicCalculatorII b = new BasicCalculatorII();
		System.out.println(b.calculate(" 3+5 / 2 "));
		System.out.println(b.calculate(" 3 +2 * 2"));
		System.out.println(b.calculate(" 3/2 "));
		System.out.println(b.calculate(" 0 "));
	}
}
