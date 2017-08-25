package bishi;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int nth = (int)Math.sqrt(2*k); // 返回第几级加和
        int result = 0;
        if (nth*nth==2*k){
            nth--;
        }
        int sum = nth*(nth+1)/2;
        if (sum==k){
            result = nth;
        }else{
            result = k - sum;
        }
        System.out.print(result);
    }
}
