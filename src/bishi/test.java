import sun.nio.cs.ext.IBM037;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<n; i++){
            X.add(in.nextInt());
        }
        for (int i=0; i<n; i++){
            Y.add(in.nextInt());
        }

        for (int i=0; i<n; i++){
            // 共有 i+1 个棋子共处一格
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j<n; j++){
                tmp.add(Math.abs(X.get(i)-X.get(j))+Math.abs(Y.get(i)-Y.get(j)));
            }
            result.add(tmp);
        }
        // 对每种情况的距离进行求和排序
        for (int i=0; i<n; i++){
            result.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1 < o2){
                        return -1;
                    }
                    else if(o1 == o2){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
            });
        }
        // 输出最后的结果
        for (int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            for (int j=0; j<n; j++){
                min = Math.min(min, minimun_n(result.get(j), i+1));
            }
            System.out.print(min + " ");
        }

    }

    public static int minimun_n(List<Integer> list, int n){
        int sum = 0;
        for (int i=0; i<n; i++){
            sum += list.get(i);
        }
        return sum;
    }
}