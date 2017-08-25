package array;

/**
 * Created by Murphy on 2017/7/22.
 */
public class InversePairs {
    public static int InversePairs(int[] array){
        if (array==null || array.length==0) return 0;
        int[] copy = new int[array.length];
        for (int i=0; i<array.length; i++){
            copy[i] = array[i];
        }
        int count = InversePairsCount(array, copy, 0, array.length-1);
        return count;
    }

    public static int InversePairsCount(int[] arr, int[] copy, int left, int right){
        if (left==right){
            copy[left] = arr[left];
            return 0;
        }
        int mid = (left + right)/2;
        int l = InversePairsCount(copy, arr, left, mid);
        int r = InversePairsCount(copy, arr, mid+1, right);
        int count = 0;

        int copy_index = right-1;
        while(left<=mid && mid+1<=right){
            if (arr[mid] > arr[right]){
                copy[copy_index--] = arr[mid--];
                count += right-mid;
            }else{
                copy[copy_index--] = arr[right--];
            }
        }
        while(left<=mid){
            copy[copy_index--] = arr[mid--];
        }
        while(mid+1<=right){
            copy[copy_index--] = arr[right--];
        }

        return l + r + count;
    }

    public static void main(String[] args){
        int[] test = {1,2,3,4,5,6,0};
        System.out.println(InversePairs(test));
    }
}
