package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	//too slow.
	public List<String> _removeInvalidParentheses(String s) {
		List<String> ret = new ArrayList<>();
		if (s == null || s.length() == 0) {
			ret.add("");
			return ret;
		}
		int minRemove = 0; // minimum number to be removed
		int leftCnt = 0; // count of "("
		// calculate minimum number to be removed
		// by counting the numbers of matching pairs "()", ")(" doesn't count
		for (int i = 0; i < s.length(); i++) {
			if (leftCnt > 0 && s.charAt(i) == ')') {
				minRemove--;
				leftCnt--;
			} else if (s.charAt(i) == ')')
				minRemove++;
			else if (s.charAt(i) == '(') {
				minRemove++;
				leftCnt++;
			}
		}
		Set<String> st = new HashSet<>();
		helper(st, 0, minRemove, "",s);
		if (st.isEmpty()) {
			st.add("");
		}
		ret.addAll(st);
		return ret;
	}

	private void helper(Set<String> ret, int i, int minRemove, String str, String s) {
		String newStr = str+s.substring(i);
		if(minRemove==0 && isValid(newStr)){
			ret.add(newStr);
			return;
		}
		
		if(minRemove==0) {
			return;
		}
		if(i>=s.length()) return;
		
		//ignore current char.
		if(s.charAt(i)=='(' || s.charAt(i)==')' ){
			helper(ret, i+1, minRemove-1, str, s);
		} 
		helper(ret, i+1, minRemove, str+s.charAt(i), s);
	}
	
	private boolean isValid(String str){
		int n = 0;
		for(char c:str.toCharArray()){
			if(c=='('){
				n++;
			}else if(c==')'){
				n--;
			}
			if(n<0) return false;
		}
		return n==0;
	}

	
	public List<String> removeInvalidParentheses(String s) {
	    List<String> res = new ArrayList<>();
	    dfs(res, s, 0, new StringBuilder(), 0);
	    return res;
	}

	private void dfs(List<String> res, String s, int start, StringBuilder path, int open) {
		if (open < 0) // invalid.
			return; 
		if (!res.isEmpty() && path.length() + s.length() - start < res.get(0).length()) // not the min.
			return; 
		if (start == s.length()) {
			if (open == 0 && (res.size() == 0 || path.length() == res.get(0).length()))
				res.add(path.toString());
			return;
		}

		path.append(s.charAt(start));
		if (s.charAt(start) != '(' && s.charAt(start) != ')')
			dfs(res, s, start + 1, path, open);
		else {
			dfs(res, s, start + 1, path, open + (s.charAt(start) == '(' ? 1 : -1));
			while (start < s.length() - 1 && s.charAt(start) == s.charAt(start + 1))
				start++;
		}
		path.deleteCharAt(path.length() - 1);

		dfs(res, s, start + 1, path, open);
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses r = new RemoveInvalidParentheses();
		System.out.println(r.removeInvalidParentheses(")a("));
		System.out.println(r.removeInvalidParentheses("()())()"));
		System.out.println(r.removeInvalidParentheses(""));
		System.out.println(r.removeInvalidParentheses(")("));
	}
}
