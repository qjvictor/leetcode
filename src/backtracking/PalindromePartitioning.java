package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author VictorQian
 * 
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return ret;
		helper(s, ret, new ArrayList<String>(), 0);
		return ret;
    }
	
	private void helper(String s, List<List<String>> ret, ArrayList<String> list, int startPos){
		if (startPos == s.length()) {
	        List<String> li = new ArrayList<>(list);
	        ret.add(li);
	        return;
	    }
	    for (int i = startPos; i < s.length(); i++) {
	        if (isParlindrome(s.substring(startPos, i+1))){
	        	list.add(s.substring(startPos, i+1));
	        	helper(s, ret, list, i+1); //the start position is i+1, not startPos+1;
	        	list.remove(list.size() - 1);
	        }
	    }
	}
	
	private boolean isParlindrome(String s){
		if(s.length()<=1) return true;
		int left=0, right=s.length()-1;
		while(left<right){
			if(s.charAt(left)!=s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args){
		PalindromePartitioning p = new PalindromePartitioning();
		System.out.println(p.partition("aab"));
	}
}
