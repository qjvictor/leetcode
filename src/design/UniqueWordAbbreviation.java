package design;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbreviation {
	HashMap<String, HashSet<String>> abbrs = new HashMap<>();
	
    public UniqueWordAbbreviation(String[] dictionary) {
        for(String s: dictionary){
            String abbr = toAbbr(s);
            if(!abbrs.containsKey(abbr)){
                HashSet<String> hs = new HashSet<>();
                hs.add(s);
                abbrs.put(abbr, hs);
            } else {
                abbrs.get(abbr).add(s);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        if(!abbrs.containsKey(abbr)) return true;
        if(abbrs.get(abbr).contains(word) && abbrs.get(abbr).size()==1){//only one.
        	return true;
        } else{
        	return false;
        }
    }
    
    private String toAbbr(String word){
        if(word==null || word.length()<3) return word;
        return word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
    }
}
