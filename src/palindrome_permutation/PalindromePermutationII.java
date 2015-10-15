package palindrome_permutation;

import java.util.*;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * For example:
 * 
 * Given s = "aabb", return ["abba", "baab"].
 * 
 * Given s = "abc", return [].
 * 
 * @author VictorQian
 * 
 */
public class PalindromePermutationII {
	public static void main(String[] args) {
		PalindromePermutationII p = new PalindromePermutationII();
		System.out.println(p.generatePalindromes("aaa"));
		System.out.println(p.generatePalindromes("aabb"));
		System.out.println(p.generatePalindromes("abc"));
		System.out.println(p.generatePalindromes("aabbd"));
	}
	
	public List<String> generatePalindromes(String s) {
		List<String> ret = new ArrayList<String>();
		if (s == null || s.isEmpty() )
			return ret;
		Map<Character, Integer> map = new HashMap<>();
		for(Character c: s.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		String mid = "";
		List<Character> left = new ArrayList<Character>();
		for (Character c : map.keySet()) {
			int val = map.get(c);
			if (val % 2 != 0) {
				if (!mid.equals(""))
					return ret; // not be able to generate pal.
				mid = c + "";
				val--;
			} 
			while (val!= 0) {
				left.add(c);
				val = val - 2;
			}
		}
		
		helper(ret, left, new StringBuilder(), new boolean[left.size()], mid);
		return ret;
    }
	
	private void helper(List<String> ret, List<Character> left, StringBuilder tmp, boolean[] used, String mid) {
		if (tmp.length() == left.size()) {
			StringBuilder leftPart = new StringBuilder(tmp.toString());
			StringBuilder rightPart = new StringBuilder(tmp.toString()).reverse();
			leftPart.append(mid).append(rightPart);
			ret.add(leftPart.toString());
			return;
		}

		for (int i = 0; i < left.size(); i++) {
			if (i != 0 && !used[i - 1] && left.get(i) == left.get(i - 1))
				continue;
			if (!used[i]) {
				tmp.append(left.get(i));
				used[i] = true;
				helper(ret, left, tmp, used, mid);
				tmp.deleteCharAt(tmp.length() - 1);
				used[i] = false;
			}
		}
	}
	
}
