package offer;

import java.util.Scanner;

public class q10 {
    // 二进制中1的个数
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if ((num & flag) != 0){
                count++;
            }
            flag = flag<<1;
        }
        System.out.println(count);
    }
}
