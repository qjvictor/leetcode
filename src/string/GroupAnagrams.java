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
			Arrays.sort(ch);// to make the anagrams same.
			String s = String.valueOf(ch);
			if (map.containsKey(s)) {
				map.get(s).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(s, list);
				res.add(list);
			}
		}

		return res;
	}
	
}
