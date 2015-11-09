package datastructure.map;

/**
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = �coding�, word2 = �practice�, return 3. Given word1 = "makes",
 * word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 * 
 * @author VictorQian
 * 
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null)
			return -1;
		if (word1.equals(word2))
			return 0;
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p1 = i;
			} else if (words[i].equals(word2)) {
				p2 = i;
			}
			if (p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p1 - p2));
			}
		}
		return min;
	}
	
	public static void main(String[] args){
		ShortestWordDistance s = new ShortestWordDistance();
		System.out.println(s.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
	}
}
