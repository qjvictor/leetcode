package mathandbit;

import java.util.*;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * @author VictorQian
 *
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0)
			return true;
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');

		int l = 0;
		int r = num.length() - 1;
		while (l <= r) {
			char lChar = num.charAt(l);
			char rChar = num.charAt(r);
			if (!map.containsKey(lChar) || !map.containsKey(rChar))
				return false;
			if (map.get(lChar) != rChar || map.get(rChar) != lChar)
				return false;
			l++;
			r--;
		}
		return true;
    }
    
    public static void main(String[] args){
    	StrobogrammaticNumber s = new StrobogrammaticNumber();
    	System.out.println(s.isStrobogrammatic("101"));
    	System.out.println(s.isStrobogrammatic("9"));
    	System.out.println(s.isStrobogrammatic("818"));
    	System.out.println(s.isStrobogrammatic("789"));
    	System.out.println(s.isStrobogrammatic("689"));
    	System.out.println(s.isStrobogrammatic("69"));
    }
}
