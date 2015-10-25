package dp;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 * 
 * @author VictorQian
 * 
 */
public class WildcardMatching {
	
	public boolean isMatchDP(String s, String p) {
		if (p.length() == 0) return s.length() == 0;
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				for (int i = s.length() - 1; i >= 0; i--) {
					dp[i + 1] = dp[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
				}
			} else {
				int i = 0;
				while (i <= s.length() && !dp[i])
					i++;
				for (; i <= s.length(); i++) {
					dp[i] = true;
				}
			}
			dp[0] = dp[0] && p.charAt(j) == '*';
		}
		return dp[s.length()];
	}
	
	
	//OJ TLE.
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (s.length() == 0) {
			int i = 0;
			while (i < p.length()) {
				if (p.charAt(i) != '*')
					return false;
				i++;
			}
			return true;
		}	

		char pChar = p.charAt(0);
		char sChar = s.charAt(0);
		if (pChar != '*') {
			return (pChar == sChar || pChar == '?') && isMatch(s.substring(1), p.substring(1));
		} else {
			if (s.length() == 1 || p.length() == 1)
				return true; // '*' is the last char of p, could match any s.
			for (int i = 1; i < s.length(); i++) {
				if (isMatch(s.substring(i), p.substring(1)) == true)
					return true;
			}
			
			return false;
		}
	}
	
	//Greedy
	public boolean isMatchGreedy(String s, String p) {
        int sPos = 0; // cursor for traversal in str.
        int pPos = 0; // cursor for traversal in pattern.
        int starIdx = -1; // once we found a star, we want to record the place of the star.
        int match = 0; // once we found a star, we want to start to match the rest of pattern with str, starting from match; this is for remembering the place where we need to start.
         
        // we check and match every char for str.
        while (sPos < s.length()){
            // 1. case 1: we are not currently at any *, 
            if (pPos < p.length() && (p.charAt(pPos) == s.charAt(sPos) || p.charAt(pPos) == '?')){
                pPos++;
                sPos++;
            }// 2. case 2: we are currently at a '*'
            else if (pPos < p.length() && p.charAt(pPos) == '*' ){
                starIdx = pPos;
                pPos++;
                match = sPos;
            } // 3. case 3: they do not match, we do not currently at a *, but the last matched is a *
            else if (starIdx != -1){
                match++;
                sPos = match;
                pPos = starIdx + 1;
            } // 4. case 4: they do not match, do not currently at a *, and last matched is not a *, then the answer is false;
            else{
                return false;
            }
        }
        // when we finish matching all characters in str, is pattern also finished? we could only allow '*' at the rest of pattern
        while (pPos < p.length() && p.charAt(pPos) == '*')
        	pPos++;
   
        return pPos == p.length();
    }
	

	public static void main(String[] args) {
		WildcardMatching w = new WildcardMatching();
		System.out.println(w.isMatchDP("a", "a*"));
		System.out.println(w.isMatchGreedy("", "*"));
		System.out.println(w.isMatch("", "*"));
//		System.out.println(w.isMatch("aaa", "aa"));
//		System.out.println(w.isMatch("aa", "*"));
//		System.out.println(w.isMatch("aa", "a*"));
//		System.out.println(w.isMatch("aa", "a*"));
//		System.out.println(w.isMatch("ab", "?*"));
//		System.out.println(w.isMatch("aab", "c*a*b"));
		System.out.print(w.isMatchGreedy(
                "abbabaaabbabbaababbabbbbbabbbabbbabaaaaabababab"
                + "bbabababaabbababaabbbbbbaaaabababbbaabbbbaabbb"
                + "bababababbaabbaababaabbbababababbbbaaabbbbbabaa"
                + "aabbababbbbaababaabbababbbbbababbbabaaaaaaaabbb"
                + "bbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb"));
	}
}
