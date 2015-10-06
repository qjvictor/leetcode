package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:

    Both pattern and str contains only lowercase alphabetical letters.
    Both pattern and str do not have leading or trailing spaces.
    Each word in str is separated by a single space.
    Each letter in pattern must map to a word with length that is at least 1.

 * @author VictorQian
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0)
			return false;
		if (str == null || str.length() == 0)
			return false;

		Map<Character, String> map = new HashMap<>();
		String[] strs = str.split(" ");
		char[] patterns = pattern.toCharArray();
		if (strs.length != patterns.length)
			return false;

		for (int i = 0; i < patterns.length; i++) {
			if (i >= strs.length)
				return false;
			char c = patterns[i];
			if (!map.containsKey(c)) {
				if (map.containsValue(strs[i])) // this is the key - the string also can't map to different pattern
					return false;
				map.put(c, strs[i]);
			} else {
				if (!map.get(c).equals(strs[i]))
					return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args){
		WordPattern w = new WordPattern();
		System.out.println(w.wordPattern("abba", "dog cat cat dog"));
		System.out.println(w.wordPattern("abba", "dog cat cat fish"));
		System.out.println(w.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(w.wordPattern("abba", "dog dog dog dog"));
		
	}
}
