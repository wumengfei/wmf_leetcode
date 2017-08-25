package leetcode;
import java.util.*;

public class LCS {
	public static int findLCS(String A, int n, String B, int m) {
        // write code here
		char[] chs1 = A.toCharArray();
		char[] chs2 = B.toCharArray();
		int[][] dp = new int[n][m];
		dp[0][0] = chs1[0]==chs2[0] ? 1 : 0;
		for (int i=1; i<n; i++){
			dp[i][0] = Math.max(dp[i-1][0], chs1[i]==chs2[0] ? 1 : 0);
		}
		for (int j=1; j<m; j++){
			dp[0][j] = Math.max(dp[0][j-1], chs1[0]==chs2[j] ? 1 : 0);
		}
		for (int i=1; i<n; i++){
			for (int j=1; j<m; j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if (chs1[i]==chs2[j]){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
			}
		}
		return dp[n-1][m-1];
    }
	
	public static void main(String[] args){
		System.out.println(findLCS("1A2C3D4B56",10,"B1D23CA45B6A",12));
	}
}
