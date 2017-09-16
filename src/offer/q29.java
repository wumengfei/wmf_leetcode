package offer;

import java.util.Scanner;

public class q29 {
    // 数组中出现次数超过一半的数
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = in.nextInt();
        }
        int count = 1;
        int pre = arr[0];
        for (int i=1; i<N; i++){
            if (count==0){
                pre = arr[i];
            }
            if (arr[i]!=pre){
                count--;
            }else{
                count++;
            }
        }
        System.out.println(pre);

    }
}
