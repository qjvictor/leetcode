package mathandbit;
/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 * @author VictorQian
 *
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
			return "";
		int m = num1.length();
		int n = num2.length();
		int[] pos = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];
				pos[p1] += sum / 10;
				pos[p2] = sum % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pos.length; i++) {
			if (pos[i] == 0 && sb.length() == 0) //ignore the first 0s.
				continue;
			sb.append(pos[i]);
		}
		return sb.length() == 0 ? "0" : sb.toString();
    }
	
	public static void main(String[] args){
		MultiplyStrings m = new MultiplyStrings();
		System.out.println(m.multiply("326", "1254"));
	}
}
