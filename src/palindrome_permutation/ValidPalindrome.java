package palindrome_permutation;
/**
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
 * @author evicqia
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() < 2)
			return true;
		int l = 0, r = s.length() - 1;
		s = s.toLowerCase();
		while (l < r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			} else {
				if (s.charAt(l) != s.charAt(r)) {
					return false;
				}
				l++;
				r--;
			}
		}
		return true;
    }
	
	public static void main(String[] args){
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome(""));
		System.out.println(v.isPalindrome("aba"));
		System.out.println(v.isPalindrome(" A b c   d B   a   "));
	}
	
}
