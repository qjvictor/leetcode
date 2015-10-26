package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a substring in str.
 * 
 * Examples:
 * 
 * pattern = "abab", str = "redblueredblue" should return true. pattern =
 * "aaaa", str = "asdasdasdasd" should return true. pattern = "aabb", str =
 * "xyzabcxzyabc" should return false.
 * 
 * Notes: You may assume both pattern and str contains only lowercase letters.
 * 
 * @author VictorQian
 * 
 */
public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern == null || pattern.length() == 0)
			return false;
		if (str == null || str.length() == 0)
			return false;
		Map<Character, String> map = new HashMap<>();
		return helper(pattern, str, map, 0, 0);
	}

	private boolean helper(String pattern, String str, Map<Character, String> map, int pIndex, int strIndex) {
		if (strIndex >= str.length())
			return false;
		if (pIndex == pattern.length() - 1) {// last char.
			char p = pattern.charAt(pIndex);
			if (map.containsKey(p) && map.get(p).equals(str.substring(strIndex))) {
				return true;
			} else if (!map.containsKey(p) && !map.values().contains(str.substring(strIndex))) {
				return true;
			} else {
				return false;
			}
		}
		char pChar = pattern.charAt(pIndex);
		if (map.containsKey(pChar)) {
			String s = map.get(pChar);
			if (strIndex + s.length() >= str.length())
				return false;
			if (!str.substring(strIndex, strIndex + s.length()).equals(s)) {
				return false;
			} else {
				return helper(pattern, str, map, pIndex + 1, strIndex + s.length());
			}
		} else {
			for (int i = strIndex + 1; strIndex + i <= str.length(); i++) {
				map.put(pChar, str.substring(strIndex, i));
				boolean ret = helper(pattern, str, map, pIndex + 1, i);
				if (ret)
					return ret;
				map.remove(pChar);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WordPatternII w = new WordPatternII();
		System.out.println(w.wordPatternMatch("itwasthebestoftimes", "ittwaastthhebesttoofttimes"));//t->tt, a-->aa, h->hh
		System.out.println(w.wordPatternMatch("abab", "redblueredblue"));
		System.out.println(w.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(w.wordPatternMatch("aabb", "xyzabcxzyabc"));
	}

}
