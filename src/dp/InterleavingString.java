package dp;
/**
 *  Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
 * @author evicqia
 *
 */
public class InterleavingString {
	public static void main(String[] args){
		InterleavingString i = new InterleavingString();
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(i.isInterleave("", "dbbca", "dbbca"));
		System.out.println(i.isInterleave("dbbca", "", "dbbca"));
		System.out.println(i.isInterleave("db", "b", "cbb"));
	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
		
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3)
			return false;

		boolean[][] ret = new boolean[len1 + 1][len2 + 1];
		for (int i = 0; i < len1 + 1; i++) {
			for (int j = 0; j < len2 + 1; j++) {
				if (i == 0 && j == 0) {
					ret[i][j] = true;
				} else {
					char c3 = s3.charAt(i + j - 1);
					if (i == 0) {
						ret[i][j]= c3 == s2.charAt(j - 1) && ret[i][j - 1];
					} else if (j == 0) {
						ret[i][j]= c3 == s1.charAt(i - 1) && ret[i - 1][j];
					} else {
						ret[i][j]= (c3 == s2.charAt(j - 1) && ret[i][j - 1]) || (c3 == s1.charAt(i - 1) && ret[i - 1][j]);
					}
				}
			}
		}
		return ret[len1][len2];
    }
}
