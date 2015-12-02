package _important;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author VictorQian
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Set<Character> window = new HashSet<>();

		int left = 0;
		int max = 0;
		int right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (!window.contains(c)) {
				window.add(c);
			}else {
				max = Math.max(max, window.size());
				while (window.contains(c)) {
					window.remove(s.charAt(left++));
				}
				window.add(c);
			}
			
			right++;
		}
		return Math.max(max, window.size());
	}
	
	public int _lengthOfLongestSubstring(String s) {
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("bbccdbbb"));
	}
}
