package leetcode;

import java.util.Scanner;

/**
 * Created by Murphy on 2017/7/19.
 */
public class editDistance {

    public static int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int row = s1.length+1;
        int col = s2.length+1;
        int[][]dp = new int[row][col];
        dp[0][0] = 0;
        for (int i=1; i<row; i++){
            dp[i][0] = i;
        }
        for (int j=1; j<col; j++){
            dp[0][j] = j;
        }
        for (int i=1; i<row; i++){
            for (int j=1; j<col; j++){
                if (s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] result = new int [n];
        for (int i=0; i<n; i++){
            Scanner in1 = new Scanner(System.in);
            String str1 = in1.next();
            String str2 = in1.next();
            result[i] = minDistance(str1, str2);
        }
        for (int i=0; i<n; i++){
            System.out.println(result[i]);
        }
    }
}
