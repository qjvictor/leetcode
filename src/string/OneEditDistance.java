package string;
/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 * @author VictorQian
 *
 */
public class OneEditDistance {
	public static void main(String[] args){
		OneEditDistance o = new OneEditDistance();
		System.out.println(o.isOneEditDistance("ab", "cab"));
		System.out.println(o.isOneEditDistance("a", "ab"));
		System.out.println(o.isOneEditDistance("determine If they are both one edit distance apart.", "determine if they are both one edit distance apart."));
		System.out.println(o.isOneEditDistance("determine if they are both one edit distance apart.", "determine i they are both one edit distance apart."));
		System.out.println(o.isOneEditDistance("determine if they are both one edit distance apart.", "determine they are both one edit distance apart."));
		System.out.println(o.isOneEditDistance("determine if they are both one edit distance apart.", "determine if they are both one edit distance apart."));
	}
	
	public boolean isOneEditDistance(String s, String t) {
		if (s == null && t == null || s.equals(t))
			return false;
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		int i = 0, j = 0, err = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) != t.charAt(j)) {
				err++;
				if (err > 1)
					return false;
				//if 2 strings has different size, keep the shorter string's pointer, move the longer string's pointer.
				if (s.length() > t.length()) 
					j--;
				else if (s.length() < t.length())
					i--;
			}
			i++;
			j++;
		}
		return (err == 1 || (err == 0 && t.length() != s.length())) ? true : false;
	}
	
	public boolean _isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		if (s.length() == t.length())
			return isOneModify(s, t);
		if (s.length() > t.length())
			return isOneDel(s, t);
		return isOneDel(t, s);
	}

	public boolean isOneDel(String s, String t) {
		for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
			if (s.charAt(i) != t.charAt(j)) {
				return s.substring(i + 1).equals(t.substring(j));
			}
		}
		return true;
	}

	public boolean isOneModify(String s, String t) {
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i))
				diff++;
		}
		return diff == 1;
	}
}
