package array;
/**
 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 

https://en.wikipedia.org/wiki/Digital_root

 * @author VictorQian
 *
 */
public class AddDigits {
	public int addDigits(int num) {
		return num == 0 ? 0 : (num % 9 == 0 ? 0 : num % 9);
	}

	public static void main(String[] args) {
		AddDigits a = new AddDigits();
		System.out.println(a.addDigits(38));
		System.out.println(a.addDigits(138));
		System.out.println(a.addDigits(535));
	}
}
