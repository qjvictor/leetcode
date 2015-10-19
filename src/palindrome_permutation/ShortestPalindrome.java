package palindrome_permutation;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author VictorQian
 * 
 */
public class ShortestPalindrome {
	public static void main(String[] args){
		ShortestPalindrome s = new ShortestPalindrome();
		System.out.println(s.shortestPalindrome("aacecaaa"));
		System.out.println(s.shortestPalindrome("abcd"));
	}
	//time out
	public String shortestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		if (isParlindrome(s))
			return s;
		int right = s.length();
		while (right > 0) {
			if (isParlindrome(s.substring(0, right))) {
				break;
			}
			right--;
		}
		StringBuilder sb = new StringBuilder(s.substring(right, s.length()));
		return sb.reverse().toString() + s;
    }
	private boolean isParlindrome(String s){
		if(s.length()<=1) return true;
		int left=0, right=s.length()-1;
		while(left<right){
			if(s.charAt(left)!=s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	//accept.
	public String _shortestPalindrome(String s) {
        int n = s.length();
        if(n<=1){
            return s;
        }
        int idx = 0;
        for(int center = n/2; center>=0; center--){
            if(valid(s, center, 1)){   //is the longest valid palindrome? (assume length is even)
                idx = 2*center+1;
                break;
            }
            if(valid(s, center, 0)){  //assume length is odd
                idx = 2*center;
                break;
            }
    
        }
        String suffix = s.substring(idx+1);
        StringBuilder b = new StringBuilder(suffix);
        return b.reverse().toString()+s;
    }

	private boolean valid(String s, int center, int shift) {
		int i = center, j = center + shift;
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
			i--;
			j++;
		}
		return i < 0;
	}
}
