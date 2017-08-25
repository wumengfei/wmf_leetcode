package leetcode;
import java.util.*;

public class longest_substring {
	public static int findLongest(String A, int n, String B, int m) {
        // write code here
		char[] chs1 = A.toCharArray();
		char[] chs2 = B.toCharArray();
		int[][] dp = new int[n][m];
		
		for (int i=0; i<n; i++){
			if (chs1[i]==chs2[0]) dp[i][0] = 1;
			else dp[i][0] = 0;
		}
		for (int j=0; j<m; j++){
			if (chs1[0]==chs2[j]) dp[0][j] = 1;
			else dp[0][j] = 0;
		}
		for (int i=1; i<n; i++){
			for (int j=1; j<m; j++){
				if (chs1[i]==chs2[j]) dp[i][j]=dp[i-1][j-1] + 1;
				else dp[i][j] = 0;
			}
		}
		int max = 0;
		for(int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				if (dp[i][j]>max) max = dp[i][j];
			}
		}
		return max;
    }
	
	public static void main(String[] args){
		System.out.println(findLongest("1AB235CD",8,"12345EF",7));
	}
}
