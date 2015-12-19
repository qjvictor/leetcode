package mathandbit;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
 *  You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:

Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:

Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words. 
 * @author VictorQian
 *
 */
public class MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length < 2)
			return 0;
		int[] bits = new int[words.length];
		// get the bit number of each words.
		for (int i = 0; i < words.length; i++) {
			int bit = 0;
			for (int j = 0; j < words[i].length(); j++) {
				bit |= (1 << words[i].charAt(j));
			}
			bits[i] = bit;
		}
		int ret = 0;
		for (int i = 0; i < bits.length; i++) {
			for (int j = i + 1; j < bits.length; j++) {
				if ((bits[i] & bits[j]) == 0) { // ' & ' with 2 words do not have identical char returns 0.
					ret = Math.max(ret, words[i].length() * words[j].length());
				}
			}
		}
		return ret;
    }

	public static void main(String[] args){
		MaximumProductOfWordLengths m = new MaximumProductOfWordLengths();
		String[] words= new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(m.maxProduct(words));
	}
}
