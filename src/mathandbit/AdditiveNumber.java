package mathandbit;
/**
 * Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.

1 + 99 = 100, 99 + 100 = 199

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers? 
 * @author evicqia
 *
 */
public class AdditiveNumber {
	public static void main(String[] args){
		AdditiveNumber a = new AdditiveNumber();
		System.out.println(a.isAdditiveNumber("199100199"));
	}
	//slower, but easier.
	public boolean _isAdditiveNumber(String num) {
		for (int i = 1; i < num.length(); i++) {
			for (int j = i + 1; j <num.length(); j++) {
				/* check if the second number starts with zero */
				if (num.charAt(j) == '0')
					continue;
				if (recur(num.substring(0, i), num.substring(i, j), num.substring(j)))
					return true;
			}
		}
		return false;
	}
	//best
	public boolean isAdditiveNumber(String num) {
		// the length of first number can't be more than half of the num.
		for (int i = 1; i <= num.length() / 2; i++) {
			// the length of first two numbers combined cannot be more than two third of the total length
			for (int j = i + 1; j <= 2 * num.length() / 3; j++) {
				/* check if the second number starts with zero */
				if (num.charAt(j) == '0')
					continue;
				if (recur(num.substring(0, i), num.substring(i, j), num.substring(j)))
					return true;
			}
		}
		return false;
	}

	public boolean recur(String num1, String num2, String num3) {
		String sum = add(num1, num2);
		if (sum.equals(num3))
			return true;
		if (sum.length() >= num3.length() || !sum.equals(num3.substring(0, sum.length())))
			return false;
		
		return recur(num2, sum, num3.substring(sum.length()));
	}
	
	//add 2 numbers, result in string format - to avoid Integer Overflow.
	public String add(String num1, String num2) {
		int carry = 0;
		String res = "";
		for (int i = 0; i < num1.length() || i < num2.length(); i++) {
			int tot = carry;
			if (i < num1.length())
				tot += num1.charAt(num1.length() - 1 - i) - '0';
			if (i < num2.length())
				tot += num2.charAt(num2.length() - 1 - i) - '0';
			res = tot % 10 + res;
			carry = tot / 10;
		}
		if (carry != 0)
			res = carry + res;
		return res;
	}
}
