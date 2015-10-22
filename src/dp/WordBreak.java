package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author VictorQian
 * 
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;
		int n = s.length();
		// dp[i] represents whether s[0...i-1] can be formed by dict
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				String sub = s.substring(j, i);
				if (wordDict.contains(sub) && dp[j]) { // Explain: dp[j] - 0-(j-1) can be formed by dict,
														// and substring from j->i also in wordDict,
														// so the dp[i] is true;
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		WordBreak w = new WordBreak();

		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(w.wordBreak("leetcode", dict));
		System.out.println(w.wordBreak("leetcodes", dict));

		dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		System.out.println(w.wordBreak("catsanddog", dict));
	}
}
