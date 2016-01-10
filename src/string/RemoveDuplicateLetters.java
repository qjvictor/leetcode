package string;

import java.util.Stack;

/**
 *  Given a string which contains only lowercase letters, 
 *  remove duplicate letters so that every letter appear once and only once. 
 *  You must make sure your result is the smallest in lexicographical order among all possible results.

Example:

Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb" 
 * @author VictorQian
 *
 */
public class RemoveDuplicateLetters {
	public static void main(String[] args){
		RemoveDuplicateLetters r = new RemoveDuplicateLetters();
		System.out.println(r.removeDuplicateLetters("bcabc"));
		System.out.println(r.removeDuplicateLetters("cbacdcbc"));
	}
	
	public String removeDuplicateLetters(String s) {
        if(s==null || s.length()<2) return s;
        int[] res = new int[26]; //will contain number of occurrences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = s.toCharArray();
        for(char c: ch){  //count number of occurrences of character 
            res[c-'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;
        for(char c:ch){ 
            index= c-'a';
            res[index]--;   //decrement number of characters remaining in the string to be analyzed
            if(visited[index]) //if character is already present in stack, don't bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while(!st.isEmpty() && c<st.peek() && res[st.peek()-'a']!=0){ 
                visited[st.pop()-'a']=false;
            }
            st.push(c); //add current character and mark it as visited
            visited[index]=true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}
