package array;

public class minKnums {
	// 堆排序方法，O(Nlogk);
	public static int[] getMinKNumsByHeap(int[] arr, int k){
        if(k > arr.length){
            return arr;
        }

        int[] heap = new int[k];
        for (int i=0; i<k; i++){
            heapInsert(heap, arr[i], i);
        }

        for (int i=k; i<arr.length; i++){
            if(arr[i]<heap[0]){
                heap[0] = arr[i]; // 忘记写了
                heapify(heap, 0);
            }
        }
        return heap;
	}

	// 建堆
    public static void heapInsert(int[] arr, int value, int index){
        arr[index] = value;
        while(index>0){
            int parent = (index-1)/2;
            if (arr[parent] < arr[index]){
                swap(arr, index, parent);
                index = parent;
            }else{
                break;
            }
        }

    }

    // 调整堆
    public static void heapify(int[] heap, int index){
        int N = heap.length;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        while(left<N){
            if (heap[max]<heap[left]){
                max = left;
            }
            if (right<N && heap[max]<heap[right]){
                max = right;
            }
            if(max!=index){
                swap(heap, index, max);
                index = max;
                left = 2 * index + 1;
                right = 2 * index + 2;
            }else{
                break;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args){
        int[] arr = {4,5,1,6,2,7,3,8};
        int[] result = new int[4];
        result = getMinKNumsByHeap(arr, 4);
        for (int i=0; i<4; i++){
            System.out.print(result[i]);
        }
    }
    //随机快排方法，O(N);
}
