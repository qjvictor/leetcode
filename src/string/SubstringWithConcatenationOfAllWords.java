package string;

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
 * For example, given: s: "barfoofoothebarfootheman" words: ["foo", "bar", "the"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author VictorQian
 * 
 */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();
		if (s == null || words.length == 0)
			return ans;
		int n = words.length, wordLen = words[0].length();
		Map<String, Integer> hist = new HashMap<>();
		for (String w : words) {
			hist.put(w, hist.containsKey(w)?hist.get(w)+1:1);
		}
		Map<String, Integer> curHist = new HashMap<>();
		for (int i = 0; i <= s.length() - n * wordLen; i++) {
			if (hist.containsKey(s.substring(i, i + wordLen))) {//one matched, go further to find out all matched, break once a mismatched found. - DFS.
				curHist.clear();
				for (int j = 0; j < n; j++) {
					String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
					if (hist.containsKey(word)) {
						curHist.put(word, curHist.containsKey(word)?curHist.get(word)+1:1);
						if (curHist.get(word) > hist.get(word)) //without this check, still work, but no need to continue if found any mismatch.
							break;
					} else {
						break;
					}	
				}
				if (hist.equals(curHist)) //compare 2 maps.
					ans.add(i);
			}
		}
		return ans;
	}
	
	public static void main(String[] args){
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		System.out.println(s.findSubstring("barfoofoothebarfootheman", new String[]{"foo", "bar", "the"}));
		System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}
}
