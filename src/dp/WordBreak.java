package dp;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author evicqia
 * 
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length()==0) return true;
        if(wordDict==null || wordDict.isEmpty()) return false;
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=1;i<s.length()+1;i++){
        	for(int j=0;j<i;j++){
        		if(dp[j] && wordDict.contains(s.substring(j,i))){
        			dp[i]=true;
        			break;
        		}	
        	}
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args){
    	WordBreak w = new WordBreak();
    	
    	Set<String> dict= new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(w.wordBreak("leetcode", dict));
		System.out.println(w.wordBreak("leetcodes", dict));
		
		dict= new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		System.out.println(w.wordBreak("catsanddog", dict));
    }
}
