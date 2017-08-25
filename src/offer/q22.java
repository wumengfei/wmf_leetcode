package offer;

import java.util.LinkedList;

public class q22 {
    // 栈的压入、弹出序列, 待优化！！
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(arr1, arr2));
    }

    public static boolean isPopOrder(int[] arr1, int[] arr2){
        LinkedList<Integer> stack = new LinkedList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 <= arr1.length){
            if (stack.isEmpty() || stack.peekLast()!=arr2[index2]){
                if(index1 == arr1.length){
                    if (index1 != index2){
                        return false;
                    }else{
                        return true;
                    }
                }else {
                    stack.addLast(arr1[index1++]);
                }
            }else{
                stack.pollLast();
                index2++;
            }
        }
        return true;
    }
}
