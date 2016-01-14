package dp;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @author VictorQian
 * 
 */
public class PalindromePartitioningII {
	public static void main(String[] args){
		PalindromePartitioningII p = new PalindromePartitioningII();
		System.out.println(p.minCut("abcbm"));
		System.out.println(p._minCut("abcbm"));
	}
	
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(i==j || j-i==1){
					dp[i][j]=0;
				}else{
					String str = s.substring(i, j);
					if(isParlindrome(str)){
						dp[i][j]=0;
					}else{
						int min = Integer.MAX_VALUE;
						for (int k = i; k < j; k++) {
							min = Math.min(dp[i][k] + dp[k][j] + 1, min);
						}
						dp[i][j] = min;
					}
				}
			}
		}
		return dp[0][n-1];
	}	
	
	private boolean isParlindrome(String s){
		if (s.length() <= 1)
			return true;
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public int _minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();

		// build the dp matrix to hold the palindrome information
		// dp[i][j] represents whether s[i] to s[j] can form a palindrome
		boolean[][] dp = buildMatrix(s, n);

		// res[i] represents the minimum cut needed
		// from s[0] to s[i]
		int[] res = new int[n];

		for (int j = 0; j < n; j++) {
			// by default we need j cut from s[0] to s[j]
			int cut = j;

			for (int i = 0; i <= j; i++) {
				if (dp[i][j]) {
					// s[i] to s[j] is a palindrome
					// try to update the cut with res[i - 1]
					cut = Math.min(cut, i == 0 ? 0 : res[i - 1] + 1);
				}
			}

			res[j] = cut;
		}

		return res[n - 1];
	}

	boolean[][] buildMatrix(String s, int n) {
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;   //// dp[i][j] represents whether s[i] to s[j] can form a palindrome
				}
			}
		}

		return dp;
	}
}
