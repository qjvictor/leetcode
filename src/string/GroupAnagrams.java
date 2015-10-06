package string;
import java.util.*;

/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    For the return value, each inner list's elements must follow the lexicographic order.
    All inputs will be in lower-case.

 * @author VictorQian
 *
 */
public class GroupAnagrams {
	public static void main(String[] args){
		GroupAnagrams g = new GroupAnagrams();
		List<List<String>> ret = g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println(ret);
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs.length == 0 || strs == null) {
			return res;
		}

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		// Sort the array beforehand, so the result is in lexicographic order
		Arrays.sort(strs);

		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = String.valueOf(ch);
			if (map.containsKey(s)) {
				map.get(s).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(s, list);
			}
		}

		for (List<String> value : map.values()) {
			res.add(value);
		}
		return res;
	}
	
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if(strs==null || strs.length==0) return ret;
		boolean[] used = new boolean[strs.length];
		
		for(int i=0;i<strs.length;i++){
			if(used[i]) continue;
			List<String> list = new ArrayList<String>();
			list.add(strs[i]);
			used[i]=true;
			for(int j=0;j<strs.length;j++){
				if(used[j]) continue;
				if(isAnagram(strs[j], list.get(list.size()-1))){
					list.add(strs[j]);
					used[j]=true;
				}
			}
			ret.add(list);
		}
		return ret;
	}
	
	private boolean isAnagram(String s, String t) {
		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		s = new String(c1);
		char[] c2 = t.toCharArray();
		Arrays.sort(c2);
		t = new String(c2);
		return s.equals(t);
	}
}
