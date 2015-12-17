package mathandbit;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * @author VictorQian
 *
 */
public class CountPrimes {
	//sieve of Eratosthenes
	public int countPrimes(int n) {
		if (n <= 1)
			return 0;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
        
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (primes[i]) {
				for (int j = i * i; j < n; j += i) {//cross off. ie, i=2, cross off: 4, 6, 8, 10...   i=3, cross off: 9,27,81...
					primes[j] = false;
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (primes[i]) {
				ret++;
			}
		}
		return ret;
    }
	
	public static void main(String[] args){
		CountPrimes c = new CountPrimes();
		System.out.println(c.countPrimes(1000));
	}
	
}
