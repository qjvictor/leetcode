package mathandbit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 * 
 * @author VictorQian
 * 
 */
public class HIndex {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);
		int len = citations.length;
		for (int i=citations.length-1;i>=0; i--) {
			if (i >= citations[i])
				return i;
		}
		return len;
    }
	
	public static void main(String[] args){
		HIndex h = new HIndex();
		System.out.println(h.hIndex(new int[]{100, 101}));
		System.out.println(h.hIndex(new int[]{0,1,2,3,4}));
		System.out.println(h.hIndex(new int[]{0,1,2,2}));
		System.out.println(h.hIndex(new int[]{11,12,13,14,15,16}));
	}
}
