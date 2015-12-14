package string;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the word list
 * 
 * For example,
 * 
 * Given: beginWord = "hit" 
 *        endWord   = "cog" 
 *        wordList  = ["hot","dot","dog","lot","log"]
 * 
 * Return
 * 
 * [ ["hit","hot","dot","dog","cog"], 
 *   ["hit","hot","lot","log","cog"] ]
 * 
 * Note:
 * 
 * All words have the same length. All words contain only lowercase alphabetic
 * characters.
 * 
 * @author VictorQian
 * 
 */
public class WordLadderII {
	public static void main(String[] args){
		WordLadderII w = new WordLadderII();
		String[] words =new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(words)); 
		System.out.println(w.findLadders("red","tax",wordList));
	}
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || beginWord.length() != endWord.length())
			return ret;
		Queue<String> queue = new LinkedList<>();
		Queue<List<String>> queueList = new LinkedList<>();
		Queue<List<String>> nextQueueList = new LinkedList<>();
		Queue<String> next = new LinkedList<>();
		Set<String> used = new HashSet<>(wordList.size());
		used.add(beginWord);
		queue.add(beginWord);
		queueList.add(new ArrayList<String>());
		while(!queue.isEmpty()){
			List<String> list  = queueList.poll();
			
			String str = queue.poll();
			list.add(str);
			for(int i=0;i<str.length();i++){
				for(char c = 'a';c<='z';c++){
					char[] chars = str.toCharArray();
					if(chars[i]==c) continue;
					chars[i]=c;
					String tmp = new String(chars);
					if(tmp.equals(endWord)){
						list.add(tmp);
						if(ret.size()!=0){
							if(list.size()>ret.get(0).size())
								break;
						}
						ret.add(new ArrayList<>(list));
						continue;
					}
					if(wordList.contains(tmp) && !used.contains(tmp)){
						next.add(tmp);
						List<String> nextList = new ArrayList<>(list);
						nextQueueList.add(nextList);
						used.add(tmp);
					}
				}
			}
			if(queue.isEmpty()){
				queue = new LinkedList<>(next);
				queueList = new LinkedList<>(nextQueueList);
				next.clear();
				nextQueueList.clear();
			}
		}
		return ret;
    }
}
