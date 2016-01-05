package dp;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSequence {
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
	
	public List<String> printLongestCommonSequence(String str1, String str2){
		List<String> ret = new ArrayList<>();
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return ret;
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
		
		int lcs = lens[len1][len2];
		
		for (int i = len1; i > 0; i--) {
			for (int j = len2; j > 0; j--) {
				if (lens[i][j] == lcs) {
					ret.add(helper(str1, str2, i, j, lens));
				}
			}
		}
		return ret;
	}
	
	private String helper(String str1, String str2, int i, int j, int[][] lens) {
		String str = "";
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				str = str1.charAt(i - 1) + str;
				i--;
				j--;
			} else {
				if (lens[i - 1][j] > lens[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return str;
	}

	public static void main(String[] args){
		LongestCommonSequence l = new LongestCommonSequence();
		System.out.println(l.lengthOfLongestCommonSequence("abcdef", "acbcf"));
		System.out.println(l.printLongestCommonSequence("abcdef", "acbcf"));
		System.out.println(l.lengthOfLongestCommonSequence("abcdef", "tyu"));
		System.out.println(l.lengthOfLongestCommonSequence("exr", "hurrre"));
		System.out.println(l.lengthOfLongestCommonSequence("", "tyu"));
	}
}
