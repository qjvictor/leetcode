package mathandbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * @author VictorQian
 * 
 */
public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	private List<String> helper(int cur, int max) {
		if (cur == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if (cur == 1)
			return new ArrayList<String>(Arrays.asList("1", "8", "0"));

		List<String> rst = new ArrayList<String>();
		List<String> center = helper(cur - 2, max);

		for (int i = 0; i < center.size(); i++) {
			String tmp = center.get(i);
			if (cur != max)
				rst.add("0" + tmp + "0");
			rst.add("1" + tmp + "1");
			rst.add("6" + tmp + "9");
			rst.add("8" + tmp + "8");
			rst.add("9" + tmp + "6");
		}
		return rst;
	}

	public List<String> _findStrobogrammatic(int n) {
		List<String> ret = new ArrayList<>();
		if (n <= 0)
			return ret;
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		char[] cs = new char[] { '0', '1', '6', '8', '9' };
		helper(ret, cs, map, n / 2, n % 2 == 0, "");
		return ret;
	}

	private void helper(List<String> ret, char[] cs, Map<Character, Character> map, int len, boolean even, String firstHalf) {
		if (firstHalf.length() == len) {
			String secondHalf = "";
			for (int i = len - 1; i >= 0; i--) {
				secondHalf += map.get(firstHalf.charAt(i));
			}
			if (even) {
				ret.add(firstHalf + secondHalf);
			} else { // 0, 1, 8.
				ret.add(firstHalf + "0" + secondHalf);
				ret.add(firstHalf + "1" + secondHalf);
				ret.add(firstHalf + "8" + secondHalf);
			}
			return;
		}

		for (int i = 0; i < cs.length; i++) {
			if (firstHalf.length() == 0 && i == 0)
				continue; // can't start with 0;
			helper(ret, cs, map, len, even, firstHalf + cs[i]);
		}
	}

	public static void main(String[] args) {
		StrobogrammaticNumberII s = new StrobogrammaticNumberII();
		System.out.println(s.findStrobogrammatic(2));
		System.out.println(s.findStrobogrammatic(5));
	}
}
