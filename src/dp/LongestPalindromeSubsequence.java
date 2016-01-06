package dp;

public class LongestPalindromeSubsequence {
	//If last and first characters of X are same, 
		//then L(0, n-1) = L(1, n-2) + 2.
	//Else L(0, n-1) = MAX (L(1, n-1), L(0, n-2)). 
	public int lengthOfLongestPalindromeSubsequence(String input){
		if (input == null || input.length() == 0)
			return 0;
		int[][] len = new int[input.length()][input.length()];
		for (int i = input.length() - 1; i >= 0; i--) {
			for (int j = i; j < input.length(); j++) {
				if (i == j) {
					len[i][j] = 1;
				} else {
					if (input.charAt(i) == input.charAt(j)) {
						len[i][j] = 2 + len[i + 1][j - 1];
					} else {
						len[i][j] = Math.max(len[i + 1][j], len[i][j - 1]);
					}

				}
			}
		}
		return len[0][input.length() - 1];
	}
	
	public int lengthOfLongestPalindromeSubsequence2(String input){
		if(input==null || input.length()==0) return 0;
		StringBuilder inputReverse = new StringBuilder(input).reverse();
		return lengthOfLongestCommonSequence(input, inputReverse.toString());
	}
	
	public int lengthOfLongestCommonSequence(String str1, String str2){
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return 0;
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] lens = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			char c1 = str1.charAt(i - 1);
			for (int j = 1; j <= len2; j++) {
				char c2 = str2.charAt(j - 1);
				if (c1 == c2) {
					lens[i][j] = 1 + lens[i - 1][j - 1];
				} else {
					lens[i][j] = Math.max(lens[i][j - 1], lens[i - 1][j]);
				}
			}
		}
		return lens[len1][len2];
	}

	public static void main(String[] args){
		LongestPalindromeSubsequence l = new LongestPalindromeSubsequence();
		System.out.println(l.lengthOfLongestPalindromeSubsequence("agbdba"));
		System.out.println(l.lengthOfLongestPalindromeSubsequence2("agbdba"));
		System.out.println(l.lengthOfLongestPalindromeSubsequence2("ACBAC"));
	}
}
