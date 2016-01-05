package dp;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character 
 * b) Delete a character 
 * c) Replace a character
 * 
 * @author evicqia
 * 
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		if (word1 == null || word1.length() == 0)
			return word2.length();
		if (word2 == null || word2.length() == 0)
			return word1.length();
		int len1 = word1.length();
		int len2 = word2.length();
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= len1; i++) {
			char c1 = word1.charAt(i - 1);
			for (int j = 1; j <= len2; j++) {
				char c2 = word2.charAt(j - 1);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
				}
			}
		}
		return dp[len1][len2];
    }
	
	public static void main(String[] args){
		EditDistance e = new EditDistance();
		System.out.println(e.minDistance("system", "ssytem"));
		System.out.println(e.minDistance("systdafem", "ssytedafm"));
	}
}
