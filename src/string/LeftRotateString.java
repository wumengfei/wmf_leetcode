package string;

public class LeftRotateString {
    public static String leftRotateString(String str, int n){
        char[] rlt = str.toCharArray();
        reverse(rlt, 0, n-1);
        reverse(rlt, n, rlt.length-1);
        reverse(rlt, 0, rlt.length-1);
        String result = new String(rlt);
        return result;
    }
    public static void reverse(char[] arr, int start, int end){
        while(start<end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        System.out.println(leftRotateString("abcdefg", 3));
    }
}
