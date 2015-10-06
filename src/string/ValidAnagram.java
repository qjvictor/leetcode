package string;
/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * @author VictorQian
 * 
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s==null && t==null) return true;
		if(s==null || t==null) return false;
		if(s.length()!=t.length()) return false;
		
		int[] count = new int[256];
		for(int i=0;i<s.length();i++){
			count[s.charAt(i)]=count[s.charAt(i)]+1;
		}
		
		for(int i=0;i<t.length();i++){
			count[t.charAt(i)]=count[t.charAt(i)]-1;
			if(count[t.charAt(i)]<0) return false;
		}
		
		for(int i=0;i<256;i++){
			if(count[i]!=0) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		ValidAnagram v = new ValidAnagram();
		System.out.println(v.isAnagram("abc", "cba"));
		System.out.println(v.isAnagram("Anagram", "ranAgAm"));
	}
}
