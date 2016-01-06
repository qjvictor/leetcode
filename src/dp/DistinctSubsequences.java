package dp;

import java.util.Arrays;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author VictorQian
 * 
 */
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || s.length() == 0)
			return 0;
		if (t == null || t.length() == 0)
			return 1;
		int len1 = t.length();
		int len2 = s.length();

		int[][] len = new int[len1 + 1][len2 + 1];
		Arrays.fill(len[0], 1);

		for (int i = 1; i <= len1; i++) {
			char c1 = t.charAt(i - 1);
			for (int j = 1; j <= len2; j++) {
				char c2 = s.charAt(j - 1);
				if (c1 == c2) {
					len[i][j] = len[i][j - 1] + len[i - 1][j - 1];
				} else {
					len[i][j] = len[i][j - 1];
				}
			}
		}
		return len[len1][len2];
	}
	
	public static void main(String[] args){
		DistinctSubsequences d = new DistinctSubsequences();
		System.out.println(d.numDistinct("rabbbit", "rabbit"));
	}
}
