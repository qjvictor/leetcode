package palindrome_permutation;
/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author VictorQian
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x < 10)
			return true;
		int pow = 1;
		while (pow <= x / 10) {
			pow *= 10;
		}
		while (x != 0) {
			int r = x % 10;
			int l = x / pow;
			if (l != r)
				return false;
			x = x % pow / 10;
			pow /= 10;
		}
		return true;
    }
	
	public static void main(String[] args){
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(-10));
		System.out.println(p.isPalindrome(101));
		System.out.println(p.isPalindrome(1001));
		System.out.println(p.isPalindrome(1000021));
	}
}
