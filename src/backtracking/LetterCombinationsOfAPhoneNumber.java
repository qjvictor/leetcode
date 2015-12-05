package backtracking;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author evicqia
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits==null || digits.length()==0)
        	return ret;
        Map<Integer, String> dict = new HashMap<>();
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        helper(ret, digits, 0, "", dict);
        return ret;
    }

	private void helper(List<String> ret, String digits, int index,  String str, Map<Integer, String> dict) {
		if (index == digits.length()) {
			ret.add(str);
			return;
		}
		int num = digits.charAt(index) - '0';
		if (!dict.containsKey(num))
			return;
		String s = dict.get(num);
		for (Character c : s.toCharArray()) {
			helper(ret, digits, index + 1, str + c, dict);
		}
	}
	
	public static void main(String[] args){
		LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
		System.out.println(l.letterCombinations("423"));
	}
}
