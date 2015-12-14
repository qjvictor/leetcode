package mathandbit;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * @author VictorQian
 * 
 */
public class UglyNumberII {
	
	//O(n).
	public int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;
		int p2 = 0, p3 = 0, p5 = 0;
		List<Integer> cache = new ArrayList<Integer>();
		cache.add(1);
		while (cache.size() < n) {
			int nextVal = Math.min(cache.get(p2) * 2, Math.min(cache.get(p3) * 3, cache.get(p5) * 5));
			cache.add(nextVal);
			//might be shared by 2,3,5, can't use if-else.
			if (cache.get(p2) * 2 == nextVal)
				p2++;
			if (cache.get(p3) * 3 == nextVal)
				p3++;
			if (cache.get(p5) * 5 == nextVal)
				p5++;
		}
		return cache.get(cache.size() - 1);
    }
	
	//O(nlogn)
	public int nthUglyNumber1(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add(1L);

		for (int i = 1; i < n; i++) {
			long tmp = q.poll();
			while (!q.isEmpty() && q.peek() == tmp)
				tmp = q.poll();

			q.add(tmp * 2L);
			q.add(tmp * 3L);
			q.add(tmp * 5L);
		}
		return q.poll().intValue();
	}
	
	public static void main(String[] args){
		UglyNumberII u = new UglyNumberII();
		System.out.println(u.nthUglyNumber(1407));
		System.out.println(u.nthUglyNumber1(1407));
	}
}
