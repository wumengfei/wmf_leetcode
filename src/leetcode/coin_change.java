package leetcode;

public class coin_change {
    public static int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        int MAX = Integer.MAX_VALUE;
        if (coins.length==0 || amount<0){
            return -1;
        }
        //初始化dp数组
        for (int i=0; i<coins.length; i++){
            dp[i][0] = 0;
        }
        for (int i=1; i<=amount; i++){
            dp[0][i] = MAX;
            if (i-coins[0] >= 0 && dp[0][i-coins[0]]!=MAX){
                dp[0][i] = dp[0][i-coins[0]]+1;
            }
        }
        for (int i=1; i<coins.length; i++){
            for (int j=1; j<=amount; j++){
                int left = MAX;
                if (j-coins[i]>=0 && dp[i][j-coins[i]]!=MAX){
                    left = dp[i][j-coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[coins.length-1][amount]!=MAX ? dp[coins.length-1][amount] : -1;
    }
    
    public static void main(String[] args){
		int result = coinChange(new int[]{5,2,3}, 20);
		System.out.println(result);
	} 
}
