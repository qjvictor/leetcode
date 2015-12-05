package _important;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author VictorQian
 * 
 */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<>();
		if (s == null || words == null || words.length == 0) {
			return ret;
		}
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}

		int len = words[0].length();
		int totalLen = len * words.length;
		int left = 0;
		while (left < s.length() - totalLen + 1) {
			String cand = s.substring(left, left + len);
			if (map.containsKey(cand)) {
				Map<String, Integer> newMap = new HashMap<>(map);
				int i = 0;
				while (i < totalLen) {
					cand = s.substring(i + left, i + left + len);
					if (!newMap.containsKey(cand)) {
						break;
					} else {
						int c = newMap.get(cand) - 1;
						if (c == 0) {
							newMap.remove(cand);
						} else {
							newMap.put(cand, c);
						}
					}
					i += len;
				}
				if (newMap.isEmpty()) {
					ret.add(left);
				}
			}
			left++;
		}
		return ret;
    }
	
	public static void main(String[] args){
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		System.out.println(s.findSubstring("barfoothefoobarmanbarfoobar", new String[]{"bar","foo"}));
	}
}
