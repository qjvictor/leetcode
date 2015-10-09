package string;

import java.util.ArrayList;
import java.util.List;

/**
 *  Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network 
 *  and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}

Machine 2 (receiver) has the function:

vector<string> decode(string s) {
  //... your code
  return strs;
}

So Machine 1 does:

string encoded_string = encode(strs);

and Machine 2 does:

vector<string> strs2 = decode(encoded_string);

strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:

    The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized 
    enough to work on any possible characters.
    Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
    Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.

 * @author VictorQian
 *
 */
public class EncodeAndDecodeStrings {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	Character SPLIT='#';
        if(strs==null || strs.size()==0) return null;
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
        	sb.append(SPLIT).append(str.length()).append(SPLIT).append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	Character SPLIT='#';
        List<String> ret = new ArrayList<>();
        if(s==null || s.length()==0) return ret;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)==SPLIT){
        		int len=0;
        		i++;
        		while(s.charAt(i)!='#'){
        			len=len*10+(s.charAt(i)-'0');
        			i++;
        		}
        		i++;
        		String str = s.substring(i, len+i);
        		ret.add(str);
        		i=len+i-1;
        	}
        }
        return ret;
    }
    
    public static void main(String[] args){
    	EncodeAndDecodeStrings e = new EncodeAndDecodeStrings();
    	List<String> strs = new ArrayList<String>();
    	strs.add("The string may contain any possible characters ");
    	strs.add("Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless. ");
    	strs.add("Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.");
    	String s1 = e.encode(strs);
    	System.out.println(s1);
    	List<String> strs1 = e.decode(s1);
    	System.out.println(strs1);
    }
}


//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.decode(codec.encode(strs));
