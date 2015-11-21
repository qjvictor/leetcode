package datastructure.stack;

import java.util.Stack;

/**
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 * @author VictorQian
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		Stack<Integer> stk = new Stack<>();

		for (String s : tokens) {
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				int v1 = stk.pop();
				int v2 = stk.pop();
				if (s.equals("+")) {
					stk.push(v1 + v2);
				} else if (s.equals("-")) {
					stk.push(v2 - v1);
				} else if (s.equals("*")) {
					stk.push(v1 * v2);
				} else {
					stk.push(v2 / v1);
				}
			} else {
				stk.push(Integer.parseInt(s));
			}
		}
		return stk.isEmpty() ? 0 : stk.peek();
    }
	
	public static void main(String[] args){
		EvaluateReversePolishNotation v = new EvaluateReversePolishNotation();
		System.out.println(v.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(v.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
}
