package _important;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author VictorQian
 * 
 */
public class MinimumWindowSubstring {
	//Solution:earthworm moving. 
	//1). spread right pointer until it satisfies the constraint 
	//2). shrink left pointer to get minimum range 
	//3). keep the above steps.
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> dict = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!dict.containsKey(c))
				dict.put(c, 1);
			else
				dict.put(c, dict.get(c) + 1);
		}
		HashMap<Character, Integer> found = new HashMap<>();
		int foundCounter = 0;
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		String ret = "";
		while (right < s.length()) {
			char c = s.charAt(right);
			if (dict.containsKey(c)) {
				if (found.containsKey(c)) {
					if (found.get(c) < dict.get(c)) //important:   only increase the counter when found has less number of this char than the dict.
						foundCounter++;
					found.put(c, found.get(c) + 1);
				} else {
					found.put(c, 1);
					foundCounter++;
				}
			}
			if (foundCounter == t.length()) {// When foundCounter equals to T.length(), in other words, found all characters, now let's move the left pointer
				char sc = s.charAt(left);
				while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
					if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
						found.put(sc, found.get(sc) - 1);
					left++;
					sc = s.charAt(left);
				}
				if (right - left + 1 < min) {
					ret = s.substring(left, right + 1);
					min = right - left + 1;
				}
			}
			right++;
		}
		return ret;
	}
	
	public static void main(String[] args){
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow("ADOBECBAODEBANCBA", "ABC"));
	}
}
