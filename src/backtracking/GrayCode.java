package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author VictorQian
 *
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<>();
		if (n < 0)
			return ret;
		ret.add(0);
		if (n == 0)
			return ret;
		ret.add(1);
		if (n == 1)
			return ret;
		for (int i = 2; i <= n; i++) {
			int size = ret.size();
			for (int j = size - 1; j >= 0; j--) {
				int v = ret.get(j) | (1 << (i - 1));
				ret.add(v);
			}
		}
		return ret;
    }
	
	public static void main(String[] args){
		GrayCode g = new GrayCode();
		System.out.println(g.grayCode(5));
	}
}
