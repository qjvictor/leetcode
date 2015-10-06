package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 * 
 * @author VictorQian
 * 
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if(s==null && t==null) return true;
		if(s==null || t==null || s.length()!=t.length()) return false;
		
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		
		Map<Character, Character> map = new HashMap<>();  
		for(int i=0;i<sc.length;i++){
			if(!map.containsKey(sc[i])){
				if(map.containsValue(tc[i])) return false;//key
				map.put(sc[i], tc[i]);
			} else{
				if(map.get(sc[i])!=tc[i]) 
					return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args){
		IsomorphicStrings w = new IsomorphicStrings();
		System.out.println(w.isIsomorphic("ab", "aa"));
		System.out.println(w.isIsomorphic("egg", "abb"));
		System.out.println(w.isIsomorphic("foo", "bar"));
		System.out.println(w.isIsomorphic("paper", "title"));
	}
}
