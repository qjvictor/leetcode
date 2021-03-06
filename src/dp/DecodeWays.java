package dp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author VictorQian
 * 
 */
public class DecodeWays {
	public int _numDecodings(String s) {
		if (s.isEmpty() || s.charAt(0) == '0')
			return 0;
		
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        dp[0] = 1;
        for (int i = 1; i < c.length; i++) {
            // Calculate the value of number of current and previous digits
            int sum = c[i] - '0' + (c[i - 1] - '0') * 10;
            if (c[i] == '0') {
               // If numbers like 00, 30, 40.... occur, rule out.
                if (sum == 0 || sum >= 30)
                    return 0;
                else  // A 0 must be bounded with its previous digit, so the dp value is equal to previous of previous dp value.
                    dp[i] = i > 1 ? dp[i - 2] : 1;
            } else if (sum < 27 && c[i - 1] != '0') { // Current digit is not 0 and can be combined with previous digit to form a 1~26 number.
                dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
            } else {
                dp[i] = dp[i - 1];
            }    
        }
        return dp[dp.length - 1];
    }
	
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;
		int[] ret = new int[s.length()];
		ret[0] = 1;
		char[] chars = s.toCharArray();
		for (int i = 1; i < s.length(); i++) {
			char pre = chars[i - 1];
			char cur = chars[i];
			if (cur == '0') {
				if (pre == '0' || pre >= '3') {
					return 0;
				} else if (i == 1) {
					ret[i] = 1;
				} else {
					ret[i] = ret[i - 2];
				}
			} else if (pre == '0' || pre >= '3' || (pre == '2' && cur >= '7')) {
				ret[i] = ret[i - 1];
			} else {
				ret[i] = ret[i - 1] + (i > 1 ? ret[i - 2] : 1);
			}
		}
		return ret[s.length() - 1];
    }
	
	public static void main(String[] args){
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("0"));
		System.out.println(d._numDecodings("0"));
		System.out.println(d.numDecodings("127"));
		System.out.println(d.numDecodings("107"));
		System.out.println(d.numDecodings("1307"));
	}
}
