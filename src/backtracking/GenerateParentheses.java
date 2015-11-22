package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 
 * @author VictorQian
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<>();
		if (n == 0)
			return ret;
		helper(ret, n, n, "");
		return ret;
	}

	private void helper(List<String> ret, int left, int right, String str) {
		if (left > right)
			return;
		if (left < 0 || right < 0)
			return;
		if (left == 0 && right == 0) {
			ret.add(new String(str));
			return;
		}

		helper(ret, left - 1, right, str + "(");
		helper(ret, left, right - 1, str + ")");
	}

	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		System.out.println(g.generateParenthesis(2));
	}
}
