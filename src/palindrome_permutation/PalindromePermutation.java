package palindrome_permutation;
/**
 * Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True. 
 * @author VictorQian
 *
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		int[] bitMap = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (bitMap[s.charAt(i)] == 0) {
				bitMap[s.charAt(i)] = 1;
			} else {
				bitMap[s.charAt(i)] = 0;
			}
		}
		int ret = 0;
		for (int i = 0; i < 256; i++) {
			ret += bitMap[i];
		}
		return ret == 1 || ret == 0;
	}

	public static void main(String[] args) {
		PalindromePermutation p = new PalindromePermutation();
		System.out.println(p.canPermutePalindrome("code"));
		System.out.println(p.canPermutePalindrome("aab"));
		System.out.println(p.canPermutePalindrome("carerac"));
	}
}
