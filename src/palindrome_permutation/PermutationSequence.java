package palindrome_permutation;

import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * @author VictorQian
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (n > 9 && n < 1)
			return "";
		k--;  // change K from (1,n) to (0, n-1) to accord to index  
		int fact = 1;
		for (int i = 1; i < n; i++) { // fact=(n-1)!
			fact = fact * i;
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		int round = n - 1;
		while (round >= 0) {
			int index = k / fact;
			k %= fact;
			sb.append(nums.get(index));
			nums.remove(index);
			if (round != 0)
				fact = fact / round;
			round--;
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args){
		PermutationSequence  p = new PermutationSequence();
		System.out.println(p.getPermutation(8, 8590));
	}
}
