package mathandbit;

import java.util.*;

/**
 *  Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000. 
 * @author VictorQian
 *
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 0)
			return 0;
		if (primes == null || primes.length == 0)
			return 0;
		if (n == 1)
			return 1;

		int[] indexes = new int[primes.length];
		List<Integer> list = new ArrayList<>();
		list.add(1);

		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				min = Math.min(primes[j] * list.get(indexes[j]), min);
			}
			for (int j = 0; j < indexes.length; j++) {
				if (min == primes[j] * list.get(indexes[j])) {
					indexes[j] = indexes[j] + 1;
				}
			}
			list.add(min);
		}
		return list.get(list.size() - 1);
    }
	
	public static void main(String[] args){
		SuperUglyNumber s = new SuperUglyNumber();
		System.out.println(s.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
	}
}
