package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Examples:
 * 
 * "()())()" -> ["()()()", "(())()"] "(a)())()" -> ["(a)()()", "(a())()"] ")("
 * -> [""]
 * 
 * @author evicqia
 * 
 */
public class RemoveInvalidParentheses {
	/**
	 * 
	 First find out the minimum number of parentheses to be removed by
	 * scanning the string. Explore all combinations of the strings by DFS and
	 * add to the result if the parentheses are balanced and valid, return the
	 * current recursion call early if either of the following happens: (1) The
	 * number of removed parentheses have exceeded the minimum number
	 * calculated. (2) Both "(" and ")" have occurred and the remaining
	 * combinations of the current recursion are duplicates.
	 */
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			res.add("");
			return res;
		}
		StringBuilder sb = new StringBuilder();
		int target = 0; // minimum number to be removed
		int leftCnt = 0; // count of "("
		// calculate minimum number to be removed
		// by counting the numbers of matching pairs "()", ")(" doesn't count
		for (int i = 0; i < s.length(); i++) {
			if (leftCnt > 0 && s.charAt(i) == ')') {
				target--;
				leftCnt--;
			} else if (s.charAt(i) == ')')
				target++;
			else if (s.charAt(i) == '(') {
				target++;
				leftCnt++;
			}
		}
		Helper(s, sb, 0, 0, 0, target, res);
		return res;
	}

	private void Helper(String s, StringBuilder sb, int start, int count,
			int removeNum, int target, List<String> res) {
		if (start >= s.length() && count == 0) {// check if "(", ")" are
												// balanced
			res.add(sb.toString());
			return;
		}
		// used to store if both "(" and ")" have occurred
		HashSet<Character> set = new HashSet<>();
		// The last character might be removed to form valid parentheses
		// that's when i == s.length()
		for (int i = start; i <= s.length(); i++) {
			if (count == 0 && i < s.length() && s.charAt(i) == ')')
				continue;
			// At the nth recursion, if both '(' and ')' have occurred, return
			// early
			// to eliminate duplicate paths
			if (i < s.length() && set.contains(s.charAt(i))) {
				if (set.size() == 2)
					return;
				else
					continue;
			} else {
				if (i < s.length())
					set.add(s.charAt(i));
			}
			int temp1 = count;
			int temp2 = removeNum;
			if (i < s.length() && s.charAt(i) == '(')
				count++;
			else if (i < s.length() && s.charAt(i) == ')')
				count--;
			removeNum = removeNum + (i - start);
			if (removeNum > target) // return early if parentheses removed
									// exceeds target
				return;
			if (i < s.length())
				sb.append(s.charAt(i));
			Helper(s, sb, i + 1, count, removeNum, target, res);
			if (i < s.length())
				sb.deleteCharAt(sb.length() - 1);
			count = temp1;
			removeNum = temp2;
		}
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses r = new RemoveInvalidParentheses();
		System.out.println(r.removeInvalidParentheses("(a)())()"));
		System.out.println(r.removeInvalidParentheses("()())()"));
		System.out.println(r.removeInvalidParentheses(")("));
	}
}
