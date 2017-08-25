package offer;

/**
 * Created by Murphy on 2017/8/24.
 */
import java.util.Scanner;

public class q8 {
    //旋转数组的最小数字
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i=0; i<num; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(findMinNum(arr, num));
    }

    public static int findMinNum(int[] arr, int num){
        int start = 0;
        int end = num-1;
        int mid = start; // 没有旋转的情况
        while(arr[start]>=arr[end]){
            mid = (start+end)/2;
            if (start == end-1){
                mid = end;
                break;
            }
            if (arr[start]==arr[end] && arr[start]==arr[mid]){
                return minInOrder(arr, start, end);
            }
            if (arr[mid]<arr[start]){
                end = mid;
            }else if (arr[mid]>arr[start]){
                start = mid;
            }
        }
        return arr[mid];
    }

    public static int minInOrder(int[] arr, int start, int end){
        int result = arr[start];
        for (int i=start; i<=end; i++){
            if (result>arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }
}
