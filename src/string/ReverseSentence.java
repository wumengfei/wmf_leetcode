package string;

public class ReverseSentence {
    public static String ReverseSentence(String str) {
        char[] rlt = str.toCharArray();
        int start = 0;
        for (int i=0; i<rlt.length; i++){
            if (rlt[i]==' '){
                reverse(rlt, start, i-1);
                start = i+1;
            }
        }
        reverse(rlt, start, rlt.length-1);
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
        System.out.println(ReverseSentence("My name is Andy."));
    }
}
