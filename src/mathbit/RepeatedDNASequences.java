package mathbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author VictorQian
 * 
 */
public class RepeatedDNASequences {
	// The key to solve this problem is that each of the 4 nucleotides can be
	// stored in 2 bits. So the 10-letter-long sequence can be converted to
	// 20-bits-long integer.
	public List<String> _findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();

		int len = s.length();
		if (len < 10) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);  //00
		map.put('C', 1);  //01
		map.put('G', 2);  //10
		map.put('T', 3);  //11

		Set<Integer> temp = new HashSet<Integer>();
		Set<Integer> added = new HashSet<Integer>();

		int hash = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				// each ACGT fit 2 bits, so left shift 2
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				// make length of hash to be 20
				hash = hash & (1 << 20) - 1;
				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash); // track added
				} else {
					temp.add(hash);
				}
			}

		}

		return result;
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ret = new ArrayList<>();
		if (s == null || s.length() < 10)
			return ret;

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0); // 00
		map.put('C', 1); // 01
		map.put('G', 2); // 10
		map.put('T', 3); // 11

		Set<Integer> tmp = new HashSet<>();
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash = (hash << 2) + map.get(s.charAt(i));
			if (i >= 9) {
				hash = hash & ((1 << 20) - 1); // key
				if (!tmp.contains(hash)) {
					tmp.add(hash);
				} else {
					String sub = s.substring(i - 9, i + 1);
					if (!ret.contains(sub))
						ret.add(sub);
				}
			}
		}
		return ret;
	}
	
	
	public static void main(String[] args){
		RepeatedDNASequences r = new RepeatedDNASequences();
		System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
