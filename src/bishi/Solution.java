package bishi;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] id = new int[n];
        int[] uid = new int[n];
        int[] iid = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++){
            id[i] = in.nextInt();
            uid[i] = in.nextInt();
            iid[i] = in.nextInt();
        }
        for (int i=0; i<n; i++){
            int cnt = 0;
            for (int j=0; j<n; j++){
                if (uid[j]==uid[i]){
                    continue;
                }
                if (iid[j]==iid[i]){
                    cnt++;
                }
            }
            if (map.containsKey(uid[i])){
                map.put(uid[i], map.get(uid[i])+cnt);
            }else{
                map.put(uid[i], cnt);
            }
        }
        Object[] key_arr = map.keySet().toArray();
        Arrays.sort(key_arr);
        for  (Object key : key_arr) {
            Object value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
