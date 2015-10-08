package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, 
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

Note: For the return value, each inner list's elements must follow the lexicographic order.
 * @author VictorQian
 *
 */
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (strings == null || strings.length == 0)
			return ret;
		Arrays.sort(strings);//don't forget the sort.
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strings) {
			String hash = getHash(s);
			if (map.containsKey(hash)) {
				map.get(hash).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(hash, list);
				ret.add(list);
			}
		}
		return ret;
	}

	// get the hash - if two strings have same hash, means the strings could be shifted to each other.
	private String getHash(String s) {
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(0);// base as 0.
		for (int i = 1; i < c.length; i++) {
			int offset = c[i] - c[0];// offset from first char.
			sb.append("|").append(offset >= 0 ? offset : offset + 26);// if offset is negative, +26.
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		GroupShiftedStrings g = new GroupShiftedStrings();
		System.out.println(g.groupStrings(new String[]{"fpbnsbrkbcyzdmmmoisaa",
		                                                "cpjtwqcdwbldwwrryuclcngw",
		                                                "a",
		                                                "fnuqwejouqzrif",
		                                                "js",
		                                                "qcpr",
		                                                "zghmdiaqmfelr",
		                                                "iedda",
		                                                "l",
		                                                "dgwlvcyubde",
		                                                "lpt",
		                                                "qzq",
		                                                "zkddvitlk",
		                                                "xbogegswmad",
		                                                "mkndeyrh",
		                                                "llofdjckor",
		                                                "lebzshcb",
		                                                "firomjjlidqpsdeqyn",
		                                                "dclpiqbypjpfafukqmjnjg",
		                                                "lbpabjpcmkyivbtgdwhzlxa",
		                                                "wmalmuanxvjtgmerohskwil",
		                                                "yxgkdlwtkekavapflheieb",
		                                                "oraxvssurmzybmnzhw",
		                                                "ohecvkfe",
		                                                "kknecibjnq",
		                                                "wuxnoibr",
		                                                "gkxpnpbfvjm",
		                                                "lwpphufxw",
		                                                "sbs",
		                                                "txb",
		                                                "ilbqahdzgij",
		                                                "i",
		                                                "zvuur",
		                                                "yfglchzpledkq",
		                                                "eqdf",
		                                                "nw",
		                                                "aiplrzejplumda",
		                                                "d",
		                                                "huoybvhibgqibbwwdzhqhslb",
		                                                "rbnzendwnoklpyyyauemm"}));
		
	}
}
