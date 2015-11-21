package datastructure.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.
Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 * @author VictorQian
 *1. 等于“/”，跳过，直接开始寻找下一个element
2. 等于“.”，什么都不需要干，直接开始寻找下一个element
3. 等于“..”，弹出栈顶元素，寻找下一个element
4. 等于其他，插入当前elemnt为新的栈顶，寻找下一个element

 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return path;
		Stack<String> stk = new Stack<String>();
		String[] dirs = path.split("/");
		for (String dir : dirs) {
			if (dir.equals(".") || dir.trim().equals("")) {
				continue;
			} else if (dir.equals("..")) {
				if (!stk.isEmpty())
					stk.pop();
			} else {
				stk.push(dir);
			}
		}
		if (stk.isEmpty())
			return "/";
		StringBuilder ret = new StringBuilder();
		while (!stk.isEmpty()) {
			ret.insert(0, "/" + stk.pop());
		}
		return ret.toString();
    }
	
	public static void main(String[] args){
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/home/"));
		System.out.println(s.simplifyPath("/a/./b/../../c/"));
		System.out.println(s.simplifyPath("/../"));
		System.out.println(s.simplifyPath("/home//foo/"));
		System.out.println(s.simplifyPath("../a/c/"));
	}
}
