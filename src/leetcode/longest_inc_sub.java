package leetcode;

import javax.swing.text.AbstractDocument.LeafElement;

public class longest_inc_sub {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length==0 || nums==null) return 0;
        int[] dp = new int [nums.length];
        for (int i=0; i<nums.length; i++){
        	dp[i] = 1;
        	for (int j=0; j<i; j++){
        		if (nums[j]<nums[i]){
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}
        	}
        }
        int max = 0;
        for (int i=0; i<dp.length; i++){
        	if (dp[i]>max) max=dp[i];
        }
        return max;
    }
	
	public static void main(String[] args){
		System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
	}
}
