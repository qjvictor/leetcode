package datastructure.map;

import java.util.*;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you
 * are given the list of words and your method will be called repeatedly many
 * times with different parameters. How would you optimize it?
 * 
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
 * word2 = "coding", return 1.
 * 
 * @author VictorQian
 * 
 */
public class ShortestWordDistanceII {
	Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    public ShortestWordDistanceII(String[] words) {
        if(words==null) return;
        for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (map.containsKey(word)) {
				map.get(word).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(word, list);
			}
		}
    }

    public int shortest(String word1, String word2) {
		if (!map.containsKey(word1) || !map.containsKey(word2))
			return Integer.MAX_VALUE;
		ArrayList<Integer> list1 = map.get(word1);
		ArrayList<Integer> list2 = map.get(word2);
		int ret = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while (i < list1.size() && j < list2.size()) {
			int index1 = list1.get(i), index2 = list2.get(j);
			ret = Math.min(ret, Math.abs(index1 - index2));
			if (index1 < index2) {
				i++;
			} else {
				j++;
			}
		}
		return ret;
    }
    
    public static void main(String[] args){
		ShortestWordDistance s = new ShortestWordDistance();
		System.out.println(s.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
	}

}
