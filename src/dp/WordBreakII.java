package dp;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"]
 * 
 * @author evicqia
 * 
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ret = new ArrayList<>();
		if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty())
			return ret;
		helper(s, wordDict, ret, "");
		return ret;
	}

	private void helper(String s, Set<String> wordDict, List<String> ret, String tmp) {
		if (s.length() <= 0) {
			ret.add(tmp);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			if (wordDict.contains(sub)) {
				helper(s.substring(i + 1), wordDict, ret, tmp.equals("") ? sub : tmp + " " + sub);
			}
		}
	}

	public static void main(String[] args) {
		WordBreakII w = new WordBreakII();
		String[] words = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> dict = new HashSet<String>(Arrays.asList(words)); 
		System.out.println(w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
		
	}
}
