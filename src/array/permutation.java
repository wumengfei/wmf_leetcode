package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Murphy on 2017/7/19.
 */
public class permutation {
    static String str = new String();
    static List<Integer> list = new LinkedList<Integer>();

    public static void DFS(int k){
        for (int i=0; i<str.length(); i++){
            if (list.contains(i)){
                continue;
            }

            boolean flag = true;
            for (Integer j: list){
                if (str.charAt(j)==str.charAt(i) && j>i){
                    flag=false;
                    continue;
                }
            }
            if (!flag) continue;

            list.add(i);
            if (list.size()==str.length()){
                // 设置
                for(Integer t: list){
                    System.out.print(str.charAt(t));
                }
                System.out.println();
            }else {
                DFS(k+1);
            }
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        str = "aac";
        DFS(0);
    }
}
