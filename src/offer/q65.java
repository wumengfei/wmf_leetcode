package offer;

import java.util.LinkedList;
import java.util.Scanner;

public class q65 {
    // 滑动窗口最大值
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int win = in.nextInt(); // 滑动窗口长度
        int num = in.nextInt(); // 数组长度
        int[] arr = new int[num]; // 数组
        for (int i=0; i<num; i++){
            arr[i] = in.nextInt();
        }
        LinkedList<Integer> mq = new LinkedList<Integer>();

        for (int i=0; i<num; i++){
            while(!mq.isEmpty() && arr[mq.peekLast()]<=arr[i]){
                mq.pollLast();
            }
            mq.addLast(i);

            if (mq.peekFirst()==i-win){
                mq.pollFirst();
            }
            if (i >= win-1) {
                System.out.print(arr[mq.peekFirst()] + " ");
            }
        }
        System.out.println();
    }
}
