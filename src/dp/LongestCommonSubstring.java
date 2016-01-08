package dp;

public class LongestCommonSubstring {
	public int lengthOfLongestCommonSubstring(String str1, String str2) {
		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
			return 0;
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] len = new int[len1 + 1][len2 + 1];
		int ret = 0;
		for (int i = 1; i <= len1; i++) {
			char c1 = str1.charAt(i - 1);
			for (int j = 1; j <= len2; j++) {
				char c2 = str2.charAt(j - 1);
				if (c1 == c2) {
					len[i][j] = 1 + len[i - 1][j - 1];
					ret = Math.max(ret, len[i][j]);
				} else {
					len[i][j] = 0;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		LongestCommonSubstring l = new LongestCommonSubstring();
		System.out.println(l.lengthOfLongestCommonSubstring("abcdef", "acbcf"));
		System.out.println(l.lengthOfLongestCommonSubstring("exr", "hurrre"));
		System.out.println(l.lengthOfLongestCommonSubstring("", "tyu"));
	}
}
