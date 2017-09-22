package offer;

public class q30 {
    // 最小的k个数
    public static int partition(int[] data, int length, int start, int end){
        int l = start;
        int r = end;
        while (l<r){
            while (data[r]>=data[start] && l<r){
                r--;
            }
            while (data[l]<=data[start] && l<r){
                l++;
            }
            int tmp = data[r];
            data[r] = data[l];
            data[l] = tmp;
        }
        int tmp = data[start];
        data[start] = data[l];
        data[l] = tmp;
        return l;
    }

    public static void getLeastNums(int[] data, int k){
        int start = 0;
        int end = data.length-1;
        int index = partition(data, data.length, start, end);
        while(index != k-1){
            System.out.println("index is: " + index);
            if (index > k-1){
                end = index - 1;
                index = partition(data, data.length, start, end);
            }else{
                start = index + 1;
                index = partition(data, data.length, start, end);
            }
        }
        for (int i = 0; i < k; i++){
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args){
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;
        getLeastNums(data, k);
    }
}
