package mathandbit;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a == null)
			return b;
		if (b == null)
			return a;
		int aLen = a.length() - 1;
		int bLen = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (aLen >= 0 || bLen >= 0 || carry != 0) {
			int aValue = aLen >= 0 ? (a.charAt(aLen) - '0') : 0;
			int bValue = bLen >= 0 ? (b.charAt(bLen) - '0') : 0;
			int sum = aValue + bValue + carry;
			sb.append(sum % 2);
			carry = sum / 2;
			aLen--;
			bLen--;
		}
		return sb.reverse().toString();
    }
}
