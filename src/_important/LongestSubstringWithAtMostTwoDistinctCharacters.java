package _important;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = �eceba�,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author VictorQian
 * 
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s==null || s.length()==0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int left=0;
		int right=0;
		int max=Integer.MIN_VALUE;
		while(right<s.length()){
			char c = s.charAt(right);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				if (map.keySet().size() == 2) {// move the left to shrink the map.
					max = Math.max(max, right - left);
					while (map.size() == 2) {
						int count = map.get(s.charAt(left)) - 1;
						if (count == 0) {
							map.remove(s.charAt(left));
						} else {
							map.put(s.charAt(left), count);
						}
						left++;
					}
				}
				// add the right character into map.
				map.put(c, 1);
			}
			right++;
		}
		return Math.max(max, right-left);
	}
	
	public int _lengthOfLongestSubstringTwoDistinct(String s) {
		int[] count = new int[256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0)
				numDistinct++;
			count[s.charAt(j)]++;
			while (numDistinct > 2) {
				count[s.charAt(i)]--;
				if (count[s.charAt(i)] == 0)
					numDistinct--;
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("ecebacabacaab"));
		System.out.println(l._lengthOfLongestSubstringTwoDistinct("ecebacabacaab"));
	}
}
