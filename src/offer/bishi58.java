package offer;

import java.util.LinkedList;
import java.util.Scanner;

public class bishi58 {
    // 有n个元素的正整型数组a，打印每个数组元素前面值比它小且下标最大的元素，如果没有，则打印-1。
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i=0; i<num; i++){
            arr[i] = in.nextInt();
        }

        int[] result = new int[num];
        LinkedList<Integer> mq = new LinkedList<Integer>();
        mq.addLast(-1);
        for (int i=0; i<num; i++){
            while (arr[i]<=mq.peekLast()){
                mq.pollLast();
            }
            result[i] = mq.peekLast();
            mq.addLast(arr[i]);
        }
        for (int i=0; i<num; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
