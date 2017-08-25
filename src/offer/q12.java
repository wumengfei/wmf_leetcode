package offer;

import java.util.Scanner;

public class q12 {
    // 打印1到最大整数n
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] nums = new char[n];
        for (int i=0; i<=9; i++){
            nums[0] = (char)(i+48);
            printNum(nums, n, 1);
        }
    }

    public static void printNum(char[] nums, int n, int index){
        if (index==n){
            System.out.println(nums);
            return;
        }
        for (int i=0; i<=9; i++){
            nums[index] = (char)(i+48);
            printNum(nums, n, index+1);
        }
    }
}
