package mathandbit;

public class Lcm_Gcd {
	// greatest common divider
	public int gcd(int v1, int v2) {
		if (v2 == 0)
			return v1;
		return gcd(v2, v1 % v2);
	}

	// least common multiplier
	public int lcm(int v1, int v2) {
		return v1 * v2 / gcd(v1, v2);
	}

	public static void main(String[] args) {
		Lcm_Gcd l = new Lcm_Gcd();
		System.out.println(l.gcd(1071, 462));
		System.out.println(l.lcm(1071, 462));
	}
}
